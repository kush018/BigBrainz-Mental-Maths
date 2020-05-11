package com.example.bigbrainzmentalmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WrongAnswer extends AppCompatActivity {

    private TextView yourAnswer;
    private TextView correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_answer);

        yourAnswer = findViewById(R.id.yourAnswer);
        correctAnswer = findViewById(R.id.correctAnswer);
        TextView questionText = findViewById(R.id.question);

        Intent intent = getIntent();
        String ans = intent.getStringExtra(LearnMaths.ANS);
        String userInput = intent.getStringExtra(LearnMaths.USER_CHOICE);
        String message = "Your answer: " + userInput;
        yourAnswer.setText(message);
        message = "Correct answer: " + ans;
        correctAnswer.setText(message);
        String question = "Question: " + getIntent().getStringExtra(LearnMaths.SUM);
        questionText.setText(question);

        Button nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LearnMaths.class);
                intent.putExtra(SelectOperation.OPERATION, getIntent().getStringExtra(SelectOperation.OPERATION));
                intent.putExtra(MainMenu.TEST, getIntent().getStringExtra(MainMenu.TEST));
                intent.putExtra(LearnMaths.SCORE, getIntent().getStringExtra(LearnMaths.SCORE));
                intent.putExtra(LearnMaths.QUESTION, getIntent().getStringExtra(LearnMaths.QUESTION));
                intent.putExtra(SelectDifficulty.DIFFICULTY, getIntent().getStringExtra(SelectDifficulty.DIFFICULTY));
                int question;
                question = Integer.parseInt(getIntent().getStringExtra(LearnMaths.QUESTION));
                if (getIntent().getStringExtra(MainMenu.TEST).equals("false")) {
                    startActivity(intent);
                }
                else if (question == 11) {
                    Intent scoreCard = new Intent(getApplicationContext(), ScoreCard.class);
                    scoreCard.putExtra(LearnMaths.SCORE, getIntent().getStringExtra(LearnMaths.SCORE));
                    startActivity(scoreCard);
                }
                else {
                    startActivity(intent);
                }
            }
        });
    }
}
