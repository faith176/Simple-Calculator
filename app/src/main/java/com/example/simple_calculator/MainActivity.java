package com.example.simple_calculator;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private double data1 = 0;
    private String current="";
    private double result=0;
    private String operation="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn00Click(View view) {
        EditText eText = findViewById(R.id.resultText);
        eText.setText(eText.getText() + "0");
    }

    public void btn01Click(View view) {
        EditText eText = findViewById(R.id.resultText);
        eText.setText(eText.getText() + "1");
    }

    public void btn02Click(View view) {
        EditText eText = findViewById(R.id.resultText);
        eText.setText(eText.getText() + "2");
    }

    public void btn03Click(View view) {
        EditText eText = findViewById(R.id.resultText);
        eText.setText(eText.getText() + "3");
    }

    public void btn04Click(View view) {
        EditText eText = findViewById(R.id.resultText);
        eText.setText(eText.getText() + "4");
    }

    public void btn05Click(View view) {
        EditText eText = findViewById(R.id.resultText);
        eText.setText(eText.getText() + "5");
    }

    public void btn06Click(View view) {
        EditText eText = findViewById(R.id.resultText);
        eText.setText(eText.getText() + "6");
    }

    public void btn07Click(View view) {
        EditText eText = findViewById(R.id.resultText);
        eText.setText(eText.getText() + "7");
    }

    public void btn08Click(View view) {
        EditText eText = findViewById(R.id.resultText);
        eText.setText(eText.getText() + "8");
    }

    public void btn09Click(View view) {
        EditText eText = findViewById(R.id.resultText);
        eText.setText(eText.getText() + "9");
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
            current= ("(" + data1 + " / " + ")" );
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

    public void btnDotClick(View view) {
        EditText eText = findViewById(R.id.resultText);
        current= (eText.getText()+".");
        eText.setText(current);
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
        eText.setText(String.valueOf(result));
        }
    }
