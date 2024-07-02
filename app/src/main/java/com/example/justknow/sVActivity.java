package com.example.justknow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.ListView;

import com.example.justknow.Adapter.PostAdapter;
import com.example.justknow.Model.Post;

import java.util.List;

public class sVActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<ClipData.Item>itemList;
    private ListView listView;
    String[] country;
    private PostAdapter adapter;
    private List<Post> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svactivity);

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }
}