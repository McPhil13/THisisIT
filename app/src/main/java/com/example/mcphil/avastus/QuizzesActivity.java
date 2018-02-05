package com.example.mcphil.avastus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mcphil.avastus.quizzes.Quiz1Activity;

public class QuizzesActivity extends AppCompatActivity {

    private Button btnQuizzes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes);

        btnQuizzes= (Button) findViewById(R.id.btnQuizzes);

        btnQuizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizzesActivity.this, Quiz1Activity.class));
            }
        });
    }
}
