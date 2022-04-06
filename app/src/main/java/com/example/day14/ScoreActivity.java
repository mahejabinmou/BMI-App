package com.example.day14;

import static com.example.day14.MainActivity.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    private Button showRefer ;
    private TextView score;
    private TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        showRefer=findViewById(R.id.valueButton);
        score=findViewById(R.id.scoreTV);
        showResult=findViewById(R.id.resultTv);


        score.setText(""+result);
        if(result<18.5)
        {
            showResult.setText("Underweight");
        }
        else if(result>=18.5 && result<=24.9)
        {
            showResult.setText("Normal");
        }
        else if(result>=25 && result<=29.9)
        {
            showResult.setText("overweight");
        }
        else
        {
            showResult.setText("overweight");
        }


        showRefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ScoreActivity.this,ActivityReference2.class);
                startActivity(intent);
            }
        });
    }
}