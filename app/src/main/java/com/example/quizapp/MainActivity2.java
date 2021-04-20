package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static String s1="";
    private Button button;
    private Button button1;
    private TextView textView;
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String score=intent.getStringExtra("FINAL_RESULT");
        int [] answers=intent.getIntArrayExtra("FINAL_ANSWERS");
        textView=findViewById(R.id.textView3);
        button=findViewById(R.id.button3);
        textView.setText(score);
        textView2=findViewById(R.id.textView6);
        if(!s1.equals(""))
        {
            s1="";
        }
        for(int i=0;i<answers.length;i++)
        {
            s1+=String.valueOf(answers[i])+", ";
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(s1);
            }
        });
        button1=findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}