package com.mydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.magical.view.MagicalBtnLayout;
import com.magical.view.MagicalBtnView;

public class FourActivity extends AppCompatActivity {

    private MagicalBtnLayout layout1;
    private MagicalBtnLayout layout2;
    private MagicalBtnLayout layout3;
    private MagicalBtnLayout layout4;
    private MagicalBtnLayout layout5;
    private MagicalBtnLayout layout6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        layout1 = (MagicalBtnLayout) findViewById(R.id.layout1);
        layout2 = (MagicalBtnLayout) findViewById(R.id.layout2);
        layout3 = (MagicalBtnLayout) findViewById(R.id.layout3);
        layout4 = (MagicalBtnLayout) findViewById(R.id.layout4);
        layout5 = (MagicalBtnLayout) findViewById(R.id.layout5);
        layout6 = (MagicalBtnLayout) findViewById(R.id.layout6);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        layout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
