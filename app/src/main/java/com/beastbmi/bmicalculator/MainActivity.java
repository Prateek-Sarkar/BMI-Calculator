package com.beastbmi.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightInch;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightInch = findViewById(R.id.edtHeightInch);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtresult);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightInch.getText().toString());

                // SI unit of BMI is KG/M
                int totalIn = ft*12 + in; // Feet to Inch
                double totalCm = totalIn*2.54; // Inch to Cm
                double totalM = totalCm/100; // Cm to M  ----> The Final Height

                // Formula of BMI
                double bmi = wt/(totalM*totalM);    // ---> weight divided by square of its height

                if (bmi>25){
                    txtResult.setText("You are Overweight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.red));
                } else if (bmi<18) {
                    txtResult.setText("You are Underweight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Yellow));
                }else {
                    txtResult.setText("You are Healthy!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.green));
                }

            }
        });
    }
}