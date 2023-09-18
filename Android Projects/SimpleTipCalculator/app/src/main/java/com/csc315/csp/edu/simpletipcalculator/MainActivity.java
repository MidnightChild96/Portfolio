package com.csc315.csp.edu.simpletipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculate = (Button)findViewById(R.id.calculateButton);
        calculate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView tv = (TextView) findViewById(R.id.billInput);
                Double bill = Double.parseDouble(tv.getText().toString());
                tv = (TextView) findViewById(R.id.tipInput);
                Double tipPercent = Double.parseDouble(tv.getText().toString());
                tv = (TextView) findViewById(R.id.splitInput);
                double split = Double.parseDouble(tv.getText().toString());
                double tipOutput = tipPercent/100 * bill;
                double totalOutput = bill + tipOutput;
                double splitOutput = totalOutput/split;
                tv = (TextView) findViewById(R.id.tipOutput);
                tv.setText(Double.toString(tipOutput));
                tv = (TextView) findViewById(R.id.totalOutput);
                tv.setText(Double.toString(totalOutput));
                tv = (TextView) findViewById(R.id.splitOutput);
                tv.setText(Double.toString(splitOutput));
            }
        }
        );
    }
}