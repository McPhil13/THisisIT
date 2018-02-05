package com.example.mcphil.avastus.quizzes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mcphil.avastus.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Quiz1Activity extends AppCompatActivity {

    private TextView mScoreView, mQuestion;
    private Button mButtonChoice1, mButtonChoice2, mButtonChoice3, mButtonChoice4;

    private int mScore = 0;
    private int mQuestionNumber = 0;
    private String mAnswer;

    DatabaseReference rootRef, studentRef;

    private Firebase mQuestionRef, mChoice1Ref, mChoice2Ref, mChoice3Ref, mChoice4Ref, mAnswerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestion = (TextView)findViewById(R.id.question);

        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);

        updateQuestion();

        //Button 1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice1.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                }else {
                    updateQuestion();
                }

                //for username
                //database reference pointing to root of database
                rootRef = FirebaseDatabase.getInstance().getReference();

                //database reference pointing to demo node
                studentRef = rootRef.child("Students Data");

                //push creates a unique id in database
                studentRef.push().setValue(mScore);
                //end of username
            }
        });
        //end of btn1


        //Button 2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice2.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                }else {
                    updateQuestion();
                }

            }
        });
        //end of btn2

        //Button 3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice3.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                }else {
                    updateQuestion();
                }

            }
        });
        //end of btn3

        //Button 4
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice4.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                }else {
                    updateQuestion();
                }

            }
        });
        //end of btn4
    }


    private void updateScore(int score){
        mScoreView.setText("" + mScore);
    }

    public void updateQuestion(){

        Firebase.setAndroidContext(this);

        mQuestionRef = new Firebase("https://avastus-mcphil.firebaseio.com/"+ mQuestionNumber +"/question");

        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                mQuestion.setText(question);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice1Ref = new Firebase("https://avastus-mcphil.firebaseio.com/"+ mQuestionNumber +"/choice1");
        mChoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice1.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice2Ref = new Firebase("https://avastus-mcphil.firebaseio.com/"+ mQuestionNumber +"/choice2");
        mChoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice2.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice3Ref = new Firebase("https://avastus-mcphil.firebaseio.com/"+ mQuestionNumber +"/choice3");
        mChoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice3.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice4Ref = new Firebase("https://avastus-mcphil.firebaseio.com/"+ mQuestionNumber +"/choice4");
        mChoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice4.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mAnswerRef = new Firebase ("https://avastus-mcphil.firebaseio.com/"+ mQuestionNumber +"/answer");
        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mQuestionNumber++;

    }
}
