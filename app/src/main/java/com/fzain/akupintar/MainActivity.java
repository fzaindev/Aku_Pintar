package com.fzain.akupintar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvList;

    private Database db;
    private UniversitasAdapter adapter;
    private List<UniversitasModel> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database(this);

        rvList = findViewById(R.id.rv_univ);

        adapter = new UniversitasAdapter(this);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.HORIZONTAL, false
        );
        rvList.setLayoutManager(layoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        getNotes();
    }

    private void getNotes() {
        notes = db.getNotes();
        adapter.setUniver(notes);
    }
}
