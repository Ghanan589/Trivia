package com.example.trivia;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btna1,btna2,btna3,btna4;
    private TextView tvQuestion;
    private TextView tvQuestionNumber,tvPoints,tvGameOver;
    private Collection collection;
    private Question currentQuestion;
    private int points=0;
    private LinearLayout ll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ll=findViewById(R.id.main2);


        collection = new Collection ();
        btna1=findViewById(R.id.btna1);
        btna2=findViewById(R.id.btna2);
        btna3=findViewById(R.id.btna3);
        btna4=findViewById(R.id.btna4);
        btna1.setOnClickListener(this);
        btna2.setOnClickListener(this);
        btna3.setOnClickListener(this);
        btna4.setOnClickListener(this);
        tvQuestion=findViewById(R.id.tvQuestion);
        tvQuestionNumber=findViewById(R.id.tvQuestionNumber);
        tvPoints=findViewById(R.id.tvPoints);
        tvGameOver=findViewById(R.id.tvGameOver);
        tvGameOver.setVisibility(View.INVISIBLE);
        collection.initQuestions();
        nextQuestion();

        Intent intent=getIntent();
        String str;
        str=intent.getStringExtra("color");
        if(str!=null)
        {
            setBackgroundColor(str);
        }







    }

    private void nextQuestion() {
        if(collection.isNotLastQuestion())
        {
            currentQuestion = collection.getNextQuestion();
            tvQuestion.setText(currentQuestion.getQuestion());

            btna1.setText(currentQuestion.getA1());
            btna2.setText(currentQuestion.getA2());
            btna3.setText(currentQuestion.getA3());
            btna4.setText(currentQuestion.getA4());
        }
        else {
            tvGameOver.setVisibility(View.VISIBLE);

            CustomDialog customDialog = new CustomDialog(this);
            customDialog.show();
            customDialog.setCancelable(false);



        }


    }

    @Override
    public void onClick(View v) {
    if(v==btna1)
    {
        if(currentQuestion.getCorrect()==1);
        {
            points++;
        }
    }
    if(v==btna2)
    {
        if(currentQuestion.getCorrect()==2)
        {
            points++;
        }
    }
    if(v==btna3)
    {
        if(currentQuestion.getCorrect()==3)
        {
            points++;
        }
    }
    if(v==btna4)
    {
        if(currentQuestion.getCorrect()==4)
        {
            points++;
        }
    }
    tvPoints.setText("points:  "+points);
    if(collection.isNotLastQuestion())
    {
        tvQuestionNumber.setText("Question number: "+(collection.getIndex() +1));
    }
    nextQuestion();


    }

    public void reset() {
        this.points=0;
        collection.initQuestions();
        tvPoints.setText("Points:  " + 0);
        tvQuestionNumber.setText("Question number:  " + 1);
        tvGameOver.setVisibility(View.INVISIBLE);
        this.nextQuestion();
    }
    public void setBackgroundColor(String color)
    {
        switch (color)
        {
            case "Red":
            {
                ll.setBackgroundColor(Color.argb(255,208,51,51));
                break;
            }
            case "Blue":{
                ll.setBackgroundColor(Color.argb(255,102,102,255));
                break;
            }
            case "Yellow":
            {
                ll.setBackgroundColor(Color.argb(255,249,236,51));
                break;

            }
            case "Pink":
            {
                ll.setBackgroundColor(Color.argb(255,255,102,255));
                break;
            }
            default:
                ll.setBackgroundColor(Color.WHITE);




        }

    }

}