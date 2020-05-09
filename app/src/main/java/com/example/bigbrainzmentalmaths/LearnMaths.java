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
    private String op;

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

        op = getIntent().getStringExtra(SelectOperation.OPERATION);
        switch (op) {
            case "+":
                operation.setText("+");
                ans = Integer.parseInt(operand1.getText().toString()) + Integer.parseInt(operand2.getText().toString());
                break;
            case "-":
                operation.setText("-");
                ans = Integer.parseInt(operand1.getText().toString()) - Integer.parseInt(operand2.getText().toString());
                break;
            case "*":
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
                            intent.putExtra(SelectOperation.OPERATION, op);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(getApplicationContext(), WrongAnswer.class);
                            intent.putExtra(ANS, Integer.toString(ans));
                            intent.putExtra(USER_CHOICE, userInput.getText().toString());
                            intent.putExtra(SelectOperation.OPERATION, op);
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

        Button backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
            }
        });

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        Button buttonNeg = findViewById(R.id.buttonNeg);

        Button buttonClear = findViewById(R.id.buttonClear);

        View.OnClickListener numListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                String buttonText = btn.getText().toString();
                userInput.append(buttonText);
            }
        };

        View.OnClickListener negListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userInput.getText().toString().length() == 0) {
                    userInput.append("-");
                }
                else {
                    try {
                        int value = Integer.parseInt(userInput.getText().toString());
                        value *= -1;
                        userInput.setText(Integer.toString(value));
                    }
                    catch (NumberFormatException ignored) { }
                }
            }
        };

        View.OnClickListener clearListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.setText("");
            }
        };

        button0.setOnClickListener(numListener);
        button1.setOnClickListener(numListener);
        button2.setOnClickListener(numListener);
        button3.setOnClickListener(numListener);
        button4.setOnClickListener(numListener);
        button5.setOnClickListener(numListener);
        button6.setOnClickListener(numListener);
        button7.setOnClickListener(numListener);
        button8.setOnClickListener(numListener);
        button9.setOnClickListener(numListener);

        buttonNeg.setOnClickListener(negListener);

        buttonClear.setOnClickListener(clearListener);
    }
}
