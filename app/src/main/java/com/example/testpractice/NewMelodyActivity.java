package com.example.testpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewMelodyActivity extends AppCompatActivity {

    EditText etArtist;
    EditText etTitle;
    EditText etCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_melody);

        etArtist = findViewById(R.id.etArtist);
        etTitle = findViewById(R.id.etTitle);
        etCover = findViewById(R.id.etCover);
    }

    public void addMelody (View v) {
        Melody melody = new Melody(etTitle.getText().toString(), etArtist.getText().toString(), etCover.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("newMelody", melody);
        setResult(RESULT_OK, intent);
        finish();
    }
}