package com.example.diplom.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.diplom.R;
import com.example.diplom.TestsList;


public class MainActivity extends AppCompatActivity {

    ConstraintLayout psyBtn, iqBtn, profBtn;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        psyBtn = findViewById(R.id.psyBtn);
        iqBtn = findViewById(R.id.iqBtn);
        profBtn = findViewById(R.id.profBtn);

        psyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, TestsList.class);
                intent.putExtra("typeOfTest", 1);
                startActivity(intent);
            }
        });

        iqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, TestsList.class);
                intent.putExtra("typeOfTest", 2);
                startActivity(intent);
            }
        });

        profBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, TestsList.class);
                intent.putExtra("typeOfTest", 3);
                startActivity(intent);
            }
        });

    }
}