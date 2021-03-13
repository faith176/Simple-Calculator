package com.example.simple_calculator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class MainActivity extends Activity {

    private double data1 = 0;
    private String current="";
    private String currentInt;
    private double result=0;
    private String operation="";


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        int colorCodeDark = Color.parseColor("#63939c");
        window.setStatusBarColor(colorCodeDark);
    }

    //switches to BaseConverter
    public void baseConvertClick(View view) {
        Intent intent;
        intent = new Intent(MainActivity.this, BaseConverter.class);
        startActivity(intent);
    }

    public void numericButtonClicked(View view) {
        EditText eText = findViewById(R.id.resultText);
        int numID = view.getId();
        switch (numID){
            case(R.id.btn00):
                currentInt= (eText.getText()+"0");
                break;
            case(R.id.btn01):
                currentInt= (eText.getText()+"1");
                break;
            case(R.id.btn02):
                currentInt= (eText.getText()+"2");
                break;
            case(R.id.btn03):
                currentInt= (eText.getText()+"3");
                break;
            case(R.id.btn04):
                currentInt= (eText.getText()+"4");
                break;
            case(R.id.btn05):
                currentInt= (eText.getText()+"5");
                break;
            case(R.id.btn06):
                currentInt= (eText.getText()+"6");
                break;
            case(R.id.btn07):
                currentInt= (eText.getText()+"7");
                break;
            case(R.id.btn08):
                currentInt= (eText.getText()+"8");
                break;
            case(R.id.btn09):
                currentInt= (eText.getText()+"9");
                break;
            case(R.id.btnDot):
                currentInt= (eText.getText()+".");
                break;
        }
        eText.setText(currentInt);
    }

    public void btnAddClick(View view) {
        EditText eText = findViewById(R.id.resultText);
        TextView eView = findViewById(R.id.equationTextView);

        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
        //get current equation and add onto it
        current = eView.getText().toString();
        if (current.equals("")){
            current= (data1 + " + ");
            eView.setText(current);
            result= data1;
        }
        else{
            evaluate(operation);
            current= (current + data1 + " + ");
            eView.setText(current);
        }
        operation = ("add");
    }

    public void btnMinusClick(View view) {
        EditText eText = findViewById(R.id.resultText);
        TextView eView = findViewById(R.id.equationTextView);

        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
        if (current.equals("")){
            current= (data1 + " - ");
            eView.setText(current);
            result= data1;
        }
        else{
            evaluate(operation);
            current= (current + data1 + " - ");
            eView.setText(current);
        }
        operation = ("minus");
    }

    public void btnMultiplyClick(View view) {
        EditText eText = findViewById(R.id.resultText);
        TextView eView = findViewById(R.id.equationTextView);

        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
        if (current.equals("")){
            current=( data1 + " * ");
            eView.setText(current);
            result= data1;
        }
        else{
            evaluate(operation);
            current= ("(" + current + data1 + ")" + " * ");
            eView.setText(current);
        }
        operation = ("multiply");
    }

    public void btnDivideClick(View view) {
        EditText eText = findViewById(R.id.resultText);
        TextView eView = findViewById(R.id.equationTextView);

        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
        if (current.equals("")){
            current= (data1 + " / ");
            eView.setText(current);
            result= data1;
        }
        else{
            evaluate(operation);
            current= ("(" + current + data1 + ")" +  " / ");
            eView.setText(current);
        }
        operation = ("divide");
    }

    public void btnClearClick(View view) {
        EditText eText = findViewById(R.id.resultText);
        TextView eView = findViewById(R.id.equationTextView);
        eText.setText("");
        eView.setText("");
        current="";
        result=0;
    }

    public void evaluate(String operation){
        String e1 = String.valueOf(result);
        String e2 = String.valueOf(data1);
        String y = null;
        switch(operation) {
            case ("add"):
                y = (e1 + " + " + e2);
                result = result + data1;
                break;
            case ("minus"):
                y = (e1 + " - " + e2);
                result = result - data1;
                break;
            case ("multiply"):
                y = (e1 + " * " + e2);
                result = result * data1;
                break;
            case ("divide"):
                y = (e1 + " / " + e2);
                result = result / data1;
                break;
        }
        String hold = String.valueOf(result);
        Log.d("equation", y);
        Log.d("result", hold);
    }

    public void btnResultsClick(View view) {
        TextView eView = findViewById(R.id.equationTextView);
        EditText eText = findViewById(R.id.resultText);
        data1 = Double.parseDouble(eText.getText().toString());

        current= (current + data1);
        eView.setText(current);
        evaluate(operation);
        eText.setText("= " + result);
        }
    }
