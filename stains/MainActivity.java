package com.example.stains;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button Calculator;
    public Button Calender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiates two buttons, one brings user to calculator, other to calender
        Calender = (Button)findViewById(R.id.Calender);
        Calculator = (Button)findViewById(R.id.Calculator);

        Calender.setOnClickListener(this);
        Calculator.setOnClickListener(this);


    }


    @Override
    public  void onClick(View v) {

        switch (v.getId()){
            case R.id.Calender:
                openMain2Activity();
                break;
            case R.id.Calculator:
                openCalculator();
                break;

        }
    }

    public void openMain2Activity(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void openCalculator(){
        Intent intentTwo = new Intent(this, Calculator.class);
        startActivity(intentTwo);
    }

}
