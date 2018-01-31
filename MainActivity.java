/*
Created as part of a Udemy video tutorial series by Morteza Kordi

Still has a bug: Crashes if no number entered BEFORE operator on start and after clear.
 */


package com.example.agwittian.udemybasiccalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    private enum OPERATOR {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUALS
    }

    TextView txtCalculations;
    TextView txtResults;

    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationsResult;
    private String calculationsDisplayString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationsResult = 0;
        calculationsDisplayString = "";
        txtCalculations = findViewById(R.id.txtCalculations);
        txtResults = findViewById(R.id.txtResults);

        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnEquals).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSubtract).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnAdd).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnZero).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnOne).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnTwo).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnThree).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnFour).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnFive).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSix).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSeven).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnEight).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnNine).setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                operatorIsTapped(OPERATOR.ADD);
                calculationsDisplayString += " + ";
                break;
            case R.id.btnSubtract:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationsDisplayString += " - ";
                break;
            case R.id.btnMultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationsDisplayString += " * ";
                break;
            case R.id.btnDivide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationsDisplayString += " / ";
                break;
            case R.id.btnEquals:
                operatorIsTapped(OPERATOR.EQUALS);
                break;
            case R.id.btnClear:
                clearTapped();
                break;
            case R.id.btnOne:
                numberIsTapped(1);
                break;
            case R.id.btnTwo:
                numberIsTapped(2);
                break;
            case R.id.btnThree:
                numberIsTapped(3);
                break;
            case R.id.btnFour:
                numberIsTapped(4);
                break;
            case R.id.btnFive:
                numberIsTapped(5);
                break;
            case R.id.btnSix:
                numberIsTapped(6);
                break;
            case R.id.btnSeven:
                numberIsTapped(7);
                break;
            case R.id.btnEight:
                numberIsTapped(8);
                break;
            case R.id.btnNine:
                numberIsTapped(9);
                break;
            case R.id.btnZero:
                numberIsTapped(0);
                break;
        } //end of switch
        txtCalculations.setText(calculationsDisplayString);

    }
    private void clearTapped(){
        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        calculationsResult = 0;
        currentNumber = "";
        currentOperator = null;
        txtResults.setText("0");
        calculationsDisplayString = "0";
    }
    private void numberIsTapped(int tappedNumber){
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtResults.setText(currentNumber);

        //displays number entered for calculations
        calculationsDisplayString = currentNumber;
        txtCalculations.setText(calculationsDisplayString);
    }
    private void operatorIsTapped(OPERATOR tappedOperator){
        if ((currentOperator != null)){
            if (currentNumber != "") {
                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {
                    case ADD:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft)
                                            + Integer.parseInt(stringNumberAtRight);
                        break;
                    case SUBTRACT:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft)
                                            - Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft)
                                            * Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        calculationsResult = Integer.parseInt(stringNumberAtLeft)
                                            / Integer.parseInt(stringNumberAtRight);
                        break;
                } //end of switch

                stringNumberAtLeft = String.valueOf(calculationsResult);
                txtResults.setText(stringNumberAtLeft);
                //displays operator used in calculations
                calculationsDisplayString = stringNumberAtLeft;
            }
        } else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }

        currentOperator = tappedOperator;
    }
}//end of MainActivity
