package com.mydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.magical.view.MagicalBtnView;

public class SecondActivity extends AppCompatActivity {

    private MagicalBtnView btn1;
    private MagicalBtnView btn2;
    private MagicalBtnView btn3;
    private MagicalBtnView btn4;
    private MagicalBtnView btn5;
    private MagicalBtnView btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn1 = (MagicalBtnView) findViewById(R.id.btn1);
        btn2 = (MagicalBtnView) findViewById(R.id.btn2);
        btn3 = (MagicalBtnView) findViewById(R.id.btn3);
        btn4 = (MagicalBtnView) findViewById(R.id.btn4);
        btn5 = (MagicalBtnView) findViewById(R.id.btn5);
        btn6 = (MagicalBtnView) findViewById(R.id.btn6);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
