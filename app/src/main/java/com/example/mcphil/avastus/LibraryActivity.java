package com.example.mcphil.avastus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LibraryActivity extends AppCompatActivity {

    private Button btnQuiz,btnDocu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        btnQuiz = (Button) findViewById(R.id.btnLibquizzes);
        btnDocu = (Button) findViewById(R.id.btnLibDocu);

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryActivity.this, QuizzesActivity.class));
            }
        });
        btnDocu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryActivity.this, DocumentActivity.class));
            }
        });
    }
}
