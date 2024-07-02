package com.example.justknow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetUp extends AppCompatActivity {

    private CircleImageView circleImageView;
    private EditText name;
    private Button savedata;
    private FirebaseAuth auth;
    private Uri imageUri, i2, downloadUri=null;
    public static final int IMAGE_CODE = 1;
    private String uid;
    private FirebaseFirestore firestore;
    private StorageReference storageReference;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);


        circleImageView = findViewById(R.id.pro_pic);
        name = findViewById(R.id.pro_name);
        savedata = findViewById(R.id.save);
        auth = FirebaseAuth.getInstance();



        storageReference = FirebaseStorage.getInstance().getReference();
        firestore = FirebaseFirestore.getInstance();
        uid = auth.getCurrentUser().getUid();

        firestore.collection("Users").document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        String namea = task.getResult().getString("name");
                        String imageUrl = task.getResult().getString("image");
                        name.setText(namea);
                        Glide.with(SetUp.this).load(imageUrl).into(circleImageView);
                    }
                }
            }
        });

        pbar = findViewById(R.id.progressBar2);
        pbar.setVisibility(View.INVISIBLE);
        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pbar.setVisibility(View.VISIBLE);
                String nname = name.getText().toString();
                if(!nname.isEmpty() && imageUri != null){
                    StorageReference srf = storageReference.child("Profile_Pic").child(uid + ".jpg");
                    srf.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if(task.isSuccessful()){
                                saveToFireStore(task, nname, srf);
                            }
                            else{
                                pbar.setVisibility(View.INVISIBLE);
                                Toast.makeText(SetUp.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    //pbar.setVisibility(View.INVISIBLE);
                    Toast.makeText(SetUp.this,"Please Select Profile Pic and Write your name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ContextCompat.checkSelfPermission(SetUp.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(SetUp.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                    }
                    else {
                        CropImage.activity()
                                .setGuidelines(CropImageView.Guidelines.ON)
                                .setAspectRatio(1,1)
                                .start(SetUp.this);
//                        Intent intent = new Intent();
//                        intent.setType("image/*");
//                        intent.setAction(Intent.ACTION_GET_CONTENT);
//                        startActivityForResult(intent, IMAGE_CODE);
                    }
                }
            }
        });
    }

    private void saveToFireStore(Task<UploadTask.TaskSnapshot> task, String nname, StorageReference srf) {
        srf.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                downloadUri = uri;
                HashMap<String,Object>map = new HashMap<>();
                map.put("name", nname);
                map.put("image", downloadUri.toString());

                firestore.collection("Users").document(uid).set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            pbar.setVisibility(View.INVISIBLE);
                            Toast.makeText(SetUp.this,"photo gotten",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SetUp.this,MainActivity.class));
                            finish();
                        }
                        else{
                            pbar.setVisibility(View.INVISIBLE);
                            Toast.makeText(SetUp.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode == RESULT_OK){
                imageUri = result.getUri();
                circleImageView.setImageURI(imageUri);
                Toast.makeText(this,"photo Taken", Toast.LENGTH_SHORT).show();
            }
            else if(resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Toast.makeText(this,result.getError().getMessage(), Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"photo not Taken", Toast.LENGTH_SHORT).show();
            }
        }
    }
}