package com.example.testpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMelodies;
    MelodiesAdapter melodiesAdapter;
    List<Melody> melodyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        melodyList = new ArrayList<>();
        for(int i = 0; i<10; i++){
            Melody melody = new Melody("Title " + i, "Artist " + i);
            melodyList.add(melody);
        }

        rvMelodies = findViewById(R.id.rvMelodies);
        melodiesAdapter = new MelodiesAdapter(melodyList);
        rvMelodies.setAdapter(melodiesAdapter);
        rvMelodies.setLayoutManager(new LinearLayoutManager(this));
    }

    // 1. List Recycler View
    //    - Add the recycler view Layout
    //    - Create the Item Layout
    //    - Create the Model Class
    //    - Create the the Custom Adapter
    //    - Init Recycler View in Main Activity & stuff
    // 2. Pass data with intents
    // 3. Get the item image with API call
}