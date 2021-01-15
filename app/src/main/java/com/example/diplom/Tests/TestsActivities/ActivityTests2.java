package com.example.diplom.Tests.TestsActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diplom.Entity.Test;
import com.example.diplom.R;
import com.example.diplom.Tests.AssetTests;

import org.json.JSONArray;
import org.json.JSONObject;

public class ActivityTests2 extends AppCompatActivity {             //АНКЕТА НА ВЫЯВЛЕНИЕ ДОМИНИРУЮЩЕЙ МОДАЛЬНОСТИ

    Button firstBtn, secondBtn, thirdBtn;
    int f = 0, s = 0, t = 0, counter = 0;
    ImageView image;
    TextView title, textResult;
    JSONArray questions;
    String result, testId = "0";;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests2);
        firstBtn = findViewById(R.id.firstBtn);
        secondBtn = findViewById(R.id.secondBtn);
        thirdBtn = findViewById(R.id.thirdBtn);
        title = findViewById(R.id.title);
        textResult = findViewById(R.id.title2);
        image = findViewById(R.id.imageView4);

        sp = getSharedPreferences("passList", MODE_PRIVATE);

        try {
            questions = new JSONObject(AssetTests.getStringFromAssetFile(this, "2")).getJSONArray("questions");
            testId =  new JSONObject(AssetTests.getStringFromAssetFile(this,"2")).getString("id");
            fillData();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f++;
                fillData();
            }
        });

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s++;
                fillData();
            }
        });

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t++;
                fillData();
            }
        });
    }

    private void fillData() {
        try {
            title.setText(questions.getJSONObject(counter).getString("title"));
            firstBtn.setText(questions.getJSONObject(counter).getString("key1"));
            secondBtn.setText(questions.getJSONObject(counter).getString("key2"));
            thirdBtn.setText(questions.getJSONObject(counter).getString("key3"));
        } catch (Exception e) {
            if (f > s && f > t) {
                result = "вы визуал (усваиваете материал через зрительное восприятие)";
            } else if (s > f && s > t) {
                result = "вы аудиал (на слух)";
            } else {
                result = "вы кинестетический - (с хорошо развитой моторной памятью; получая информацию касаетесь руками)";
            }

            title.setVisibility(View.GONE);
            firstBtn.setVisibility(View.GONE);
            secondBtn.setVisibility(View.GONE);
            thirdBtn.setVisibility(View.GONE);

            textResult.setVisibility(View.VISIBLE);
            textResult.setText(String.format("Ваш результат: %s", result));
            image.setVisibility(View.VISIBLE);

            String passList = sp.getString("testsPassed", "");
            if(!passList.isEmpty())
                passList+=" ";
            sp.edit().putString("testsPassed", passList + testId).apply();

        }
        counter++;

    }

}