package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String FINAL_RESULT="token";
    public static final int [] FINAL_ANSWERS={};
    public static int index=0;
    public static int score=0;
    public static int idx;
    private TextView textView;
    private Button clear;
    private Button next;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton op1;
    private RadioButton op2;
    private RadioButton op3;
    private RadioButton op4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView5);
        clear=findViewById(R.id.button2);
        next=findViewById(R.id.button);
        radioGroup=findViewById(R.id.radiog);
        op1=findViewById(R.id.radioButton);
        op2=findViewById(R.id.radioButton2);
        op3=findViewById(R.id.radioButton3);
        op4=findViewById(R.id.radioButton4);
        radioGroup.clearCheck();
        String [] question={"this is question 1","this is something long unneccessory typed question about something which i dont know and it comes randomly to my mind and peacefully.","this is questin 3","this is a question 4","this is a quesiton 5"};
        String [] option1={"A","A","A","A","A"};
        String [] option2={"B","B","B","B","B"};
        String [] option3={"C","C","C","C","C"};
        String [] option4={"D","D","D","D","D"};
        int [] answer={1,4,2,4,3};
        Intent intent=new Intent(this,MainActivity2.class);
        textView.setText("Q"+ (index+1) + ". " + question[index]);
        op1.setText(option1[index]);
        op2.setText(option2[index]);
        op3.setText(option3[index]);
        op4.setText(option4[index]);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1.isChecked())
                {
                    idx=0;
                }
                if(op2.isChecked())
                {
                    idx=1;
                }
                if(op3.isChecked())
                {
                    idx=2;
                }
                if(op4.isChecked())
                {
                    idx=3;
                }
                if(idx==answer[index]-1)
                {
                    score+=4;
                }
                if(idx!=answer[index]-1)
                {
                    score--;
                }
                if(index<4)
                {
                    radioGroup.clearCheck();
                    textView.setText("Q"+ (++index+1) + ". " + question[index]);
                    op1.setText(option1[index]);
                    op2.setText(option2[index]);
                    op3.setText(option3[index]);
                    op4.setText(option4[index]);
                }
                else{
                    intent.putExtra("FINAL_RESULT",String.valueOf(score));
                    intent.putExtra("FINAL_ANSWERS",answer);
                    startActivity(intent);
                    index=0;
                    idx=0;
                    score=0;
                    radioGroup.clearCheck();
                    textView.setText(question[index]);
                    op1.setText(option1[index]);
                    op2.setText(option2[index]);
                    op3.setText(option3[index]);
                    op4.setText(option4[index]);
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.clearCheck();
            }
        });
    }
}