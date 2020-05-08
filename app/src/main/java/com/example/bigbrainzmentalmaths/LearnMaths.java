package com.example.bigbrainzmentalmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LearnMaths extends AppCompatActivity {

    private EditText operand1;
    private EditText operand2;
    private EditText userInput;
    private TextView operation;
    private int ans;

    public static final String ANS = "com.example.bigbrainzmentalmaths.ANS";
    public static final String USER_CHOICE = "com.example.bigbrainzmentalmaths.USER_CHOICE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_maths);

        operand1 = findViewById(R.id.operand1);
        operand2 = findViewById(R.id.operand2);
        userInput = findViewById(R.id.userInput);
        operation = findViewById(R.id.operation);

        operand1.setText(Integer.toString(new Random().nextInt(100)));
        operand2.setText(Integer.toString(new Random().nextInt(100)));

        int op;
        op = new Random().nextInt(3);
        switch (op) {
            case 0:
                operation.setText("+");
                ans = Integer.parseInt(operand1.getText().toString()) + Integer.parseInt(operand2.getText().toString());
                break;
            case 1:
                operation.setText("-");
                ans = Integer.parseInt(operand1.getText().toString()) - Integer.parseInt(operand2.getText().toString());
                break;
            case 2:
                operation.setText("*");
                ans = Integer.parseInt(operand1.getText().toString()) * Integer.parseInt(operand2.getText().toString());
                break;
        }

        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!userInput.getText().toString().equals("")) {
                    try {
                        if (Integer.parseInt(userInput.getText().toString()) == ans) {
                            Intent intent = new Intent(getApplicationContext(), CorrectAnswer.class);
                            intent.putExtra(ANS, Integer.toString(ans));
                            intent.putExtra(USER_CHOICE, userInput.getText().toString());
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(getApplicationContext(), WrongAnswer.class);
                            intent.putExtra(ANS, Integer.toString(ans));
                            intent.putExtra(USER_CHOICE, userInput.getText().toString());
                            startActivity(intent);
                        }
                    }
                    catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Invalid Number", Toast.LENGTH_SHORT).show();
                        userInput.setText("");
                    }
                }
            }
        });

        Button skipButton = findViewById(R.id.skipButton);

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LearnMaths.class);
                startActivity(intent);
            }
        });
    }
}
