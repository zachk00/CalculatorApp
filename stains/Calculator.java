package com.example.stains;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Calculator extends AppCompatActivity  {


    private List<Button> calcButtons = new ArrayList();
    private String[] resourceNumbers;
    private TextView work;
    private TextView result;
    public double operandOne = Double.NaN, operandTwo, answer;
    private final char addition = '+', subtraction = '-', multiplication = '*', division = '/', equals = '0';
    private char Operation;
    private String resultText, workText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // sets up two texts view for display full results and current number being entered
        work = findViewById(R.id.work);
        result = findViewById(R.id.result);
        resourceNumbers = getResources().getStringArray(R.array.Numbers);
        //calls to functions which 1. initaite all buttons, then adding the buttons to an array list
        //2. sets the text from a string array resource
        initButtons();
        setButtonText();
        // each number button concatenates current number with newly entered number
        calcButtons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workText = work.getText().toString() + "0";
                work.setText(workText);
            }
        });

        calcButtons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workText = work.getText().toString() + "1";
                work.setText(workText);
            }
        });

        calcButtons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workText = work.getText().toString() + "2";
                work.setText(workText);
            }
        });

        calcButtons.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workText = work.getText().toString() + "3";
                work.setText(workText);
            }
        });

        calcButtons.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workText = work.getText().toString() + "4";
                work.setText(workText);
            }
        });

        calcButtons.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workText = work.getText().toString() + "5";
                work.setText(workText);
            }
        });

        calcButtons.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workText = work.getText().toString() + "6";
                work.setText(workText);
            }
        });

        calcButtons.get(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workText = work.getText().toString() + "7";
                work.setText(workText);
            }
        });

        calcButtons.get(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workText = work.getText().toString() + "8";
                work.setText(workText);
            }
        });

        calcButtons.get(9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workText = work.getText().toString() + "9";
                work.setText(workText);
            }
        });

        // each operation button sends first number and operation to result text box,
        // while then calling the calculation function, clearing the text from the work area
        calcButtons.get(10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculations();
                Operation = addition;
                resultText = operandOne + "+";
                result.setText(resultText);
                work.setText(null);
            }
        });
        calcButtons.get(11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculations();
                Operation = subtraction;
                resultText = operandOne + "-";
                result.setText(resultText);
                work.setText(null);
            }
        });
        calcButtons.get(12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculations();
                Operation = multiplication;
                resultText = operandOne + "*";
                result.setText(resultText);
                work.setText(null);
            }
        });

        calcButtons.get(13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculations();
                Operation = division;
                resultText = operandOne + "/";
                result.setText(resultText);
                work.setText(null);
            }
        });

        calcButtons.get(14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculations();
                Operation = equals;
                resultText = result.getText().toString() + operandTwo + "=" + answer;
                result.setText(resultText);
                work.setText(null);
            }
        });
        // decimal button functions in the same manner as number buttons
        calcButtons.get(15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workText = work.getText() + ".";
                work.setText(workText);
            }
        });
        // clear buttons resets calculator
        calcButtons.get(16).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work.setText(null);
                result.setText(null);
                operandOne = Double.NaN;
                operandTwo = 0;
            }
        });



    }


    // function initiates and adds button to an array list
    private void initButtons(){
        calcButtons.add((Button)findViewById(R.id.zero));
        calcButtons.add((Button)findViewById(R.id.one));
        calcButtons.add((Button)findViewById(R.id.two));
        calcButtons.add((Button)findViewById(R.id.three));
        calcButtons.add((Button)findViewById(R.id.four));
        calcButtons.add((Button)findViewById(R.id.five));
        calcButtons.add((Button)findViewById(R.id.six));
        calcButtons.add((Button)findViewById(R.id.seven));
        calcButtons.add((Button)findViewById(R.id.eight));
        calcButtons.add((Button)findViewById(R.id.nine));

        calcButtons.add((Button)findViewById(R.id.plus));
        calcButtons.add((Button)findViewById(R.id.minus));
        calcButtons.add((Button)findViewById(R.id.multi));
        calcButtons.add((Button)findViewById(R.id.div));
        calcButtons.add((Button)findViewById(R.id.equals));
        calcButtons.add((Button)findViewById(R.id.decimal));
        calcButtons.add((Button)findViewById(R.id.Clear));

    }
    // uses string array resource to set text for buttons
    private void setButtonText(){
        for (int j = 0; j < calcButtons.size(); j++){
            calcButtons.get(j).setText(resourceNumbers[j]);
        }
    }



    //performs calculations by determining if operandOne has been set, once
    // operand one is set, then operand 2 will be set, then performing the correct operation
    private void calculations(){
        if (!Double.isNaN(operandOne)){
            operandTwo = Double.parseDouble(work.getText().toString());
            switch (Operation){
                case addition:
                    answer = operandOne + operandTwo;
                    break;
                case subtraction:
                    answer = operandOne - operandTwo;

                    break;
                case multiplication:
                    answer = operandOne * operandTwo;
                    break;
                case division:
                    answer = operandOne / operandTwo;

                    break;
                case equals:
                    break;
            }
        }
        else {
            operandOne = Double.parseDouble(work.getText().toString());
        }

    }




}
