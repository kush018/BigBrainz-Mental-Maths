package com.example.bigbrainzmentalmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectDifficulty extends AppCompatActivity {

    int difficulty;

    public static final String DIFFICULTY = "com.example.bigbrainzmentalmaths.DIFFICULTY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);

        Button difficulty1 = findViewById(R.id.difficulty1);
        Button difficulty2 = findViewById(R.id.difficulty2);
        Button difficulty3 = findViewById(R.id.difficulty3);
        Button difficulty4 = findViewById(R.id.difficulty4);
        Button difficulty5 = findViewById(R.id.difficulty5);
        Button difficulty6 = findViewById(R.id.difficulty6);

        View.OnClickListener diffListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                int buttonId = btn.getId();
                switch (buttonId) {
                    case R.id.difficulty1:
                        difficulty = 1;
                        break;
                    case R.id.difficulty2:
                        difficulty = 2;
                        break;
                    case R.id.difficulty3:
                        difficulty = 3;
                        break;
                    case R.id.difficulty4:
                        difficulty = 4;
                        break;
                    case R.id.difficulty5:
                        difficulty = 5;
                        break;
                    default:
                        difficulty = 6;
                }
                Intent intent = new Intent(getApplicationContext(), LearnMaths.class);
                intent.putExtra(DIFFICULTY, Integer.toString(difficulty));
                intent.putExtra(SelectOperation.OPERATION, getIntent().getStringExtra(SelectOperation.OPERATION));
                intent.putExtra(MainMenu.TEST, getIntent().getStringExtra(MainMenu.TEST));
                startActivity(intent);
            }
        };

        difficulty1.setOnClickListener(diffListener);
        difficulty2.setOnClickListener(diffListener);
        difficulty3.setOnClickListener(diffListener);
        difficulty4.setOnClickListener(diffListener);
        difficulty5.setOnClickListener(diffListener);
        difficulty6.setOnClickListener(diffListener);
    }
}
