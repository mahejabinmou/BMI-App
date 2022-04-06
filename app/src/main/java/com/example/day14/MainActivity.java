package com.example.day14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText kg,meter;
    private Button calculate;
    public static int result=0;
    public static double dresult=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kg=findViewById(R.id.weightET);
        meter=findViewById(R.id.heightET);
        calculate=findViewById(R.id.calButton);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kgString=kg.getText().toString();
                String meterString=meter.getText().toString();
                if(kgString.isEmpty()){
                    kg.setError("please provide a valid number");
                    return;
                }
                if(meterString.isEmpty()){
                    meter.setError("please provide a valid number");
                    return;
                }

                double n=Double.parseDouble(kg.getText().toString());
                double m=Double.parseDouble(meter.getText().toString());
                dresult=BmiCalculate.bmiResult(n,m);
                result=(int)dresult;
                Intent intent=new Intent(MainActivity.this,ScoreActivity.class);
                startActivity(intent);


            }
        });
    }
}