package com.example.bigbrainzmentalmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectOperation extends AppCompatActivity {

    public static final String OPERATION = "com.example.bigbrainzmentalmaths.OPERATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_operation);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                Intent intent = new Intent(getApplicationContext(), SelectDifficulty.class);
                intent.putExtra(OPERATION, btn.getText().toString());
                intent.putExtra(MainMenu.TEST, getIntent().getStringExtra(MainMenu.TEST));
                startActivity(intent);
            }
        };

        buttonPlus.setOnClickListener(btnListener);
        buttonMinus.setOnClickListener(btnListener);
        buttonMultiply.setOnClickListener(btnListener);
    }
}
