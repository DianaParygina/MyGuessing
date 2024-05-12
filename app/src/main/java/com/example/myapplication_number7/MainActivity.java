package com.example.myapplication_number7;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button guessBtn;
    private Button guessProgrammBtn;
    UserGuess userGuess;
    ProgrammGuess programmGuess;
    private EditText editTextGuess;
    private TextView textViewResult;
    private TextView textViewResult2;
    private Button moreBtn;
    private Button lessBtn;
    private Button RightBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        guessBtn = findViewById(R.id.button_txt);
        moreBtn = findViewById(R.id.buttonYes);
        lessBtn = findViewById(R.id.buttonNo);
        RightBtn = findViewById(R.id.buttonRight);
        guessProgrammBtn = findViewById(R.id.buttonGu);
        editTextGuess = findViewById(R.id.editTextGuess);
        textViewResult = findViewById(R.id.AnswerOutputTxt);
        textViewResult2 = findViewById(R.id.AnswerOutputTxtForProgram);

        programmGuess = new ProgrammGuess();
        userGuess = new UserGuess();

        guessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int guess = Integer.parseInt(editTextGuess.getText().toString());
                    String result = userGuess.checkGuess(guess);
                    textViewResult.setText(result);
                } catch (NumberFormatException e) {
                    textViewResult.setText("Введите число!");
                }
            }
        });

        guessProgrammBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = programmGuess.makeGuess();
                textViewResult2.setText(result);
                moreBtn.setVisibility(View.VISIBLE);
                lessBtn.setVisibility(View.VISIBLE);
                RightBtn.setVisibility(View.VISIBLE);
            }
        });

        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                programmGuess.higher();
                String result = programmGuess.makeGuess();
                textViewResult2.setText(result);
            }
        });

        lessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                programmGuess.lower();
                String result = programmGuess.makeGuess();
                textViewResult2.setText(result);
            }
        });

        RightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResult2.setText("Ура! Я угадал!");
                moreBtn.setEnabled(false);
                lessBtn.setEnabled(false);
                RightBtn.setEnabled(false);
            }
        });
    }
}