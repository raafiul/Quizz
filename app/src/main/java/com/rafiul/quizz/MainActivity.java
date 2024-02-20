package com.rafiul.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String[] questions = {"Java was created by James Gosling?", "Java was released in 1996?", "Java supports OPP?","Java can build web App?","Java is great?"};
    private final boolean[] answers = {true,false,true,true,true};
    private int index = 0;
    private int score = 0;


    private Button yes;
    private Button no;
    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<= questions.length -1) {
                    if (answers[index]) {
                        score++;
                    }
                    index ++;
                    if (index <= questions.length-1){
                        question.setText(questions[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your Score is " + score, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "RESTART phone to continue the Quizz", Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<= questions.length-1) {
                    if (!answers[index]) {
                        score++;
                    }
                    index ++;
                    if (index <= questions.length -1){
                        question.setText(questions[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your score is " + score, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "RESTART phone to continue the Quizz", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}