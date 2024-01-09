package com.example.testpractice;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMelodies;
    MelodiesAdapter melodiesAdapter;
    static List<Melody> melodyList = new ArrayList<Melody>();
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            int resultCode = result.getResultCode();
            if(resultCode == RESULT_OK){
                Intent data = result.getData();
                Melody melody = data.getParcelableExtra("newMelody");
              melodyList.add(melody);
                int indexOf = melodyList.indexOf(melody);
                melodiesAdapter.notifyItemInserted(indexOf);
            }
        });

        rvMelodies = findViewById(R.id.rvMelodies);
        melodiesAdapter = new MelodiesAdapter(melodyList);
        rvMelodies.setAdapter(melodiesAdapter);
        rvMelodies.setLayoutManager(new LinearLayoutManager(this));
    }

    public void openAddMelodyActivity (View v) {
        Intent intent = new Intent(this, NewMelodyActivity.class);
        activityResultLauncher.launch(intent);
    }

    // 1. List Recycler View
    //    - Add the recycler view Layout
    //    - Create the Item Layout
    //    - Create the Model Class
    //    - Create the the Custom Adapter
    //    - Init Recycler View in Main Activity & stuff
    // 2. Pass data with intents
    //    - Create add Item Activity
    //    - Add a "New Melody" button in MainActivity & onClick => set the intent ("2 way contract")
    //    - Model class implements Parcelable (autocomplete + write and read from parcel impl.)
    //    - send the melody from the NewMelodyActivity via intent
    //    - get the new melody via registerForActivityResult + adapter.notifyInserted(indexOf)
    // 3. Get the item image with API call
    //    - add the image field to the Model class
}