package com.example.simple_calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class BaseConverter extends AppCompatActivity {

    private String currentBase = "";
    private String input="";
    private String output ="";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_converter);

        //change status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        int colorCodeDark = Color.parseColor("#63939c");
        window.setStatusBarColor(colorCodeDark);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.decimal_base:
                if (checked)
                    currentBase="decimal";
                    break;
            case R.id.binary_base:
                if (checked)
                    currentBase="binary";
                    break;
            case R.id.hex_base:
                if (checked)
                    currentBase="hex";
                break;
            case R.id.octal_base:
                if (checked)
                    currentBase="octal";
                break;
        }
        Log.d("check base", currentBase);
    }

    public void calculateClick(View view) {
        //stores input from user
        EditText input = findViewById(R.id.input);
        String userInput = input.getText().toString();
        //declare the textviews which will display the outputs
        TextView decimal_calc = findViewById(R.id.decimal_calc);
        TextView binary_calc = findViewById(R.id.binary_calc);
        TextView hex_calc = findViewById(R.id.hex_calc);
        TextView octal_calc = findViewById(R.id.octal_calc);

        //sets the outputs in their appropriate textboxes
        decimal_calc.setText(convertToDecimal(userInput));
        binary_calc.setText(convertToBinary(userInput));
        hex_calc.setText(convertToHex(userInput.toUpperCase()));
        octal_calc.setText(convertToOctal(userInput));

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
        );
    }

    public void calculatorClick(View view) {
        Intent intent1;
        intent1 = new Intent(BaseConverter.this, MainActivity.class);
        startActivity(intent1);
    }

    public String convertToDecimal(String input){
        // Check which radio button was clicked, the current base of the input
        switch(currentBase) {
            case ("decimal"):
                Log.d("new output", (input));
                return (input);
            case ("binary"):
                output = String.valueOf(Integer.parseInt(input,2));
                Log.d("new output", (output));
                return (output);
            case ("hex"):
                output = String.valueOf(Integer.parseInt(input,16));
                Log.d("new output", (output));
                return (output);
            case ("octal"):
                output = String.valueOf(Integer.parseInt(input,8));
                Log.d("new output", (output));
                return (output);
        }
        return input;
    }


    public String convertToBinary(String input){
        // Check which radio button was clicked, the current base of the input
        switch(currentBase) {
            case ("decimal"):
                output = Integer.toBinaryString(Integer.parseInt(input));
                Log.d("new output", (output));
                return (output);
            case ("binary"):
                Log.d("new output",(input));
                return (input);
            case ("hex"):
                output = Integer.toBinaryString(Integer.parseInt(input, 16));
                Log.d("new output", (output));
                return (output);
            case ("octal"):
                output = Integer.toBinaryString(Integer.parseInt(input, 8));
                Log.d("new output",(output));
                return (output);
        }
        return input;
    }


    public String convertToHex(String input){
        // Check which radio button was clicked, the current base of the input
        switch(currentBase) {
            case ("decimal"):
                output = Integer.toHexString(Integer.parseInt(input));
                Log.d("new output", (output));
                return (output);
            case ("binary"):
                output = Integer.toHexString(Integer.parseInt(input, 2));
                Log.d("new output", (output));
                return (output);
            case ("hex"):
                Log.d("new output", (input));
                return (input);
            case ("octal"):
                output = Integer.toHexString(Integer.parseInt(input, 8));
                Log.d("new output",(output));
                return (output);
        }
        return input;
    }


    public String convertToOctal(String input){
        // Check which radio button was clicked, the current base of the input
        switch(currentBase) {
            case ("decimal"):
                output = Integer.toOctalString(Integer.parseInt(input));
                Log.d("new output", (output));
                return (output);
            case ("binary"):
                output = Integer.toOctalString(Integer.parseInt(input, 2));
                Log.d("new output", String.valueOf(output));
                return (output);
            case ("hex"):
                output = Integer.toOctalString(Integer.parseInt(input, 16));
                Log.d("new output", (output));
                return (output);
            case ("octal"):
                Log.d("new output",(input));
                return (input);
        }
        return input;
    }

}