package com.example.bigbrainzmentalmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CorrectAnswer extends AppCompatActivity {

    private TextView yourAnswer;
    private TextView correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer);

        yourAnswer = findViewById(R.id.yourAnswer);
        correctAnswer = findViewById(R.id.correctAnswer);

        Intent intent = getIntent();
        String ans = intent.getStringExtra(LearnMaths.ANS);
        String userInput = intent.getStringExtra(LearnMaths.USER_CHOICE);
        String message = "Your answer: " + userInput;
        yourAnswer.setText(message);
        message = "Correct answer: " + ans;
        correctAnswer.setText(message);

        Button nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LearnMaths.class);
                startActivity(intent);
            }
        });
    }
}
