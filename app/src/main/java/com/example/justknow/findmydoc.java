package com.example.justknow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class findmydoc extends AppCompatActivity {
    CardView physician , dentist , cardiologist , dietitian, surgeon , back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findmydoc);
        physician = findViewById(R.id.Physician);
        dentist = findViewById(R.id.dentist);
        cardiologist = findViewById(R.id.cardiologist);
        dietitian = findViewById(R.id.dietition);
        surgeon= findViewById(R.id.surgeon);
        back= findViewById(R.id.back);

        physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findmydoc.this,doctors_details.class);
                intent.putExtra("title","PHYSICIAN");
                startActivity(intent);
            }
        });

        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findmydoc.this,doctors_details.class);
                intent.putExtra("title","DENTIST");
                startActivity(intent);
            }
        });

        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findmydoc.this,doctors_details.class);
                intent.putExtra("title","SURGEON");
                startActivity(intent);
            }
        });

        dietitian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findmydoc.this,doctors_details.class);
                intent.putExtra("title","DIETITIAN");
                startActivity(intent);
            }
        });

        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findmydoc.this,doctors_details.class);
                intent.putExtra("title","CARDIOLOGIST");
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(findmydoc.this,MainActivity.class));
            }
        });

    }
}
