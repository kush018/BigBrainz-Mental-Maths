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
        Button buttonDivide = findViewById(R.id.buttonDivide);

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                Intent intent = new Intent(getApplicationContext(), LearnMaths.class);
                intent.putExtra(OPERATION, btn.getText().toString());
                startActivity(intent);
            }
        };

        buttonPlus.setOnClickListener(btnListener);
        buttonMinus.setOnClickListener(btnListener);
        buttonMultiply.setOnClickListener(btnListener);
        buttonDivide.setOnClickListener(btnListener);

        Button backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
            }
        });
    }
}
