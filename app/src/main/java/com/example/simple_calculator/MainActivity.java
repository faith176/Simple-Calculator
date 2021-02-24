package com.example.simple_calculator;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private enum Operator {none, add, minus, multiply, divide}
    private double data1 = 0, data2 = 0;
    private Operator optr = Operator.none;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn00Click(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText(eText.getText() + "0");
    }

    public void btn01Click(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText(eText.getText() + "1");
    }

    public void btn02Click(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText(eText.getText() + "2");
    }

    public void btn03Click(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText(eText.getText() + "3");
    }

    public void btn04Click(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText(eText.getText() + "4");
    }

    public void btn05Click(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText(eText.getText() + "5");
    }

    public void btn06Click(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText(eText.getText() + "6");
    }

    public void btn07Click(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText(eText.getText() + "7");
    }

    public void btn08Click(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText(eText.getText() + "8");
    }

    public void btn09Click(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText(eText.getText() + "9");
    }

    public void btnAddClick(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        optr = Operator.add;
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMinusClick(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        optr = Operator.minus;
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMultiplyClick(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        optr = Operator.multiply;
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnDivideClick(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        optr = Operator.divide;
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnClearClick(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText("");
    }

    public void btnDotClick(View view) {
        EditText eText = (EditText)findViewById(R.id.resultText);
        eText.setText(eText.getText() + ".");
    }

    public void btnResultsClick(View view) {
        if (optr != Operator.none) {
            EditText eText = (EditText)findViewById(R.id.resultText);
            data2 = Double.parseDouble(eText.getText().toString());
            double res = 0;
            switch (optr) {
                case add:
                    res = data1 + data2;
                    break;
                case minus:
                    res = data1 - data2;
                    break;
                case multiply:
                    res = data1 * data2;
                    break;
                case divide:
                    res = data1 / data2;
                    break;
            }
            optr = Operator.none;
            data1 = res;
            if (res - (int)res != 0) eText.setText(String.valueOf(res));
            else eText.setText(String.valueOf((int)res));
        }
    }
}
