package com.air.ademocalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener {
    private EditText editTextOperand1;
    private EditText editTextOperand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gatherControls();
        setupButtons();
    }

    private void setupButtons() {
        Button button;
        button = (Button)findViewById(R.id.bOperatorPlus);
        button.setOnClickListener(this);
        button = (Button)findViewById(R.id.bOperatorMinus);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.bOperatorMultiply);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.bOperatorDivide);
        button.setOnClickListener(this);
    }

    private void gatherControls() {
        editTextOperand1 = (EditText)findViewById(R.id.etOperandOne);
        editTextOperand2 = (EditText)findViewById(R.id.etOperandTwo);
        editTextOperand1.requestFocus();
    }

    @Override
    public void onClick(View v) {
        String stringOperand1 = editTextOperand1.getText().toString();
        String stringOperand2 = editTextOperand2.getText().toString();
        double num1 = getDouble(stringOperand1);
        double num2 = getDouble(stringOperand2);

        Button buttonOperator = (Button)v;

        double result = calculate(num1,num2,buttonOperator);
        editTextOperand1.setText(Double.toString(result));
    }

    private double calculate(double num1, double num2, Button buttonOperator) {
        switch (buttonOperator.getId()) {
            case R.id.bOperatorPlus:
                return plus(num1,num2);
            case R.id.bOperatorMinus:
                return minus(num1,num2);
            case R.id.bOperatorMultiply:
                return multiply(num1,num2);
            case R.id.bOperatorDivide:
                return divide(num1,num2);
        }
        return 0;
    }

    private double divide(double num1, double num2) {
        return num1/num2;
    }

    private double multiply(double num1, double num2) {
        return num1*num2;
    }

    private double minus(double num1, double num2) {
        return num1-num2;
    }

    private double plus(double num1, double num2) {
        return num1+num2;
    }

    private double getDouble(String stringOperand) {
        if(validString(stringOperand)){
            return Double.valueOf(stringOperand);
        }
        return 0;
    }

    private boolean validString(String stringOperand) {
        if(stringOperand == null){
            return false;
        }
        if(stringOperand.trim().equalsIgnoreCase("")){
            return false;
        }
        return true;
    }
    private boolean invalidString(String string){
        return !validString(string);
    }
}
