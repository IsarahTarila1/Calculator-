package com.lilranime.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String  operator = "+";
    TextView resultTextView, solutionTextView;
    MaterialButton buttonDecimal, buttonDelete, buttonCancel;
    MaterialButton buttonNumber1, buttonNumber2, buttonNumber3, buttonNumber4, buttonNumber5, buttonNumber6, buttonNumber7, buttonNumber8, buttonNumber9, buttonNumber0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.result_textview);
        solutionTextView = findViewById(R.id.solution_textview);

        assignId(buttonCancel, R.id.button_cancel);
        assignId(buttonDecimal, R.id.button_decimal);
        assignId(buttonDelete, R.id.button_delete);
        assignId(buttonNumber0, R.id.button_0);
        assignId(buttonNumber1, R.id.button_1);
        assignId(buttonNumber2, R.id.button_2);
        assignId(buttonNumber3, R.id.button_3);
        assignId(buttonNumber4, R.id.button_4);
        assignId(buttonNumber5, R.id.button_5);
        assignId(buttonNumber6, R.id.button_6);
        assignId(buttonNumber7, R.id.button_7);
        assignId(buttonNumber8, R.id.button_8);
        assignId(buttonNumber9, R.id.button_9);
    }

    void assignId(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataTocalculate =  solutionTextView.getText().toString();

        if (buttonText.equals("AC")){
            solutionTextView.setText("");
            resultTextView.setText("0");
            return;
        }else if (buttonText.equals("C")){
            dataTocalculate = dataTocalculate.substring(0, dataTocalculate.length()-1);
        }else{
            dataTocalculate = dataTocalculate+buttonText;
        }
        solutionTextView.setText(dataTocalculate);
        

    }

    public void equalEvent(View view) {
        String oldNumber = solutionTextView.getText().toString();
        String newNumber = solutionTextView.getText().toString();
        double result=0.0;
        MaterialButton button = (MaterialButton) view;
        switch (operator){
            case "+":
                result = Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
            case "%":
                result = Double.parseDouble(oldNumber)%Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
        }
        resultTextView.setText(result+"");
    }

    public void operatorEvent(View view) {
        switch (view.getId()){
            case R.id.button_division: operator ="/";
            break;
            case R.id.button_multiplication: operator = "*";
            break;
            case R.id.button_subtraction: operator = "-";
            break;
            case R.id.button_modulus: operator = "%";
            break;
            case R.id.button_raiseToPower: operator = "^";
            break;
            case R.id.button_addition: operator = "+";


        }
    }
}