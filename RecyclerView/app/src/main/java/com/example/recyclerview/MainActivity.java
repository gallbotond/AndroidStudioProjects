package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    RecyclerView recyclerView;
    DataModel[] myListData;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        myListData = new DataModel[]{
                new DataModel("Email", R.drawable.boss),
                new DataModel("Info", R.drawable.fat),
                new DataModel("Delete", R.drawable.im2),
                new DataModel("Dialer", R.drawable.heckler),
                new DataModel("Amogus", R.drawable.gigachad),
                new DataModel("Sus", R.drawable.im1),
                new DataModel("Baky", R.drawable.im2),
                new DataModel("Download", R.drawable.im3),
                new DataModel("Sussy", R.drawable.fb),
                new DataModel("Imposter", R.drawable.im3),
                new DataModel("Wented", R.drawable.fat),
                new DataModel("Sigma", R.drawable.gas),
        };

        adapter = new CustomAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(this, "You clicked " + myListData[position].getName(), Toast.LENGTH_SHORT).show();
    }
}