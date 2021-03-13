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
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class BaseConverter extends AppCompatActivity {

    private String currentBase = "";

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

    public void calculatorClick(View view) {
        Intent intent1;
        intent1 = new Intent(BaseConverter.this, MainActivity.class);
        startActivity(intent1);
    }

}