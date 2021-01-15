package com.example.diplom.Tests.TestsActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diplom.R;
import com.example.diplom.Tests.AssetTests;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class ActivityTests8 extends AppCompatActivity { //Торонтская алекситимическая шкала

    Button firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn;
    ImageView image;
    int f = 0, s = 0, t = 0, counter = 0;
    TextView title, resultTextView;
    int score = 0;
    String result = "", testId = "0";
    JSONArray questions;
    SharedPreferences sp;


    int[] answers = new int[27];

    int[] right = {2, 3, 4, 7, 8, 10, 14, 16, 17, 18, 19, 20, 22, 23, 25, 26};
    int[] reverse = {1, 5, 6, 9, 11, 12, 13, 15, 21, 24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests8);

        firstBtn = findViewById(R.id.firstBtn);
        secondBtn = findViewById(R.id.secondBtn);
        thirdBtn = findViewById(R.id.thirdBtn);
        fourthBtn = findViewById(R.id.fourthBtn);
        fifthBtn = findViewById(R.id.fifthBtn);


        title = findViewById(R.id.title);
        image = findViewById(R.id.image);
        resultTextView = findViewById(R.id.resultTextView);


        firstBtn.setText("Совершенно не согласен");
        secondBtn.setText("Скорее не согласен");
        thirdBtn.setText("Ни то, ни другое");
        fourthBtn.setText("Скорее согласен");
        fifthBtn.setText("Совершенно согласен");
        sp = getSharedPreferences("passList",MODE_PRIVATE);

        try{
            questions = new JSONObject(AssetTests.getStringFromAssetFile(this,"8")).getJSONArray("questions");
            testId =  new JSONObject(AssetTests.getStringFromAssetFile(this,"8")).getString("id");
            fillData();
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    answers[counter] = 1;
                fillData();
            }
        });

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    answers[counter] = 2;
                fillData();
            }
        });

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    answers[counter] = 3;
                fillData();
            }
        });
        fourthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    answers[counter] = 4;
                fillData();
            }
        });

        fifthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    answers[counter] = 5;
                fillData();
            }
        });

    }

    private void  fillData()
    {
        try {
            title.setText(questions.getJSONObject(counter).getString("title"));
        }
        catch (Exception e){

            for(int i =0; i< right.length; i++){
                score += answers[right[i] ];
            }

            for(int i =0; i< reverse.length; i++){
                switch (answers[reverse[i] ]){
                    case 1:
                        score += 5;
                        break;
                    case 2:
                        score += 4;
                        break;
                    case 3:
                        score += 3;
                        break;
                    case 4:
                        score += 2;
                        break;
                    case 5:
                        score += 1;
                        break;
                }
            }

            if(score > 73)
                result = "Ваш тип личности: алекситимический";
            else result = "Ваш тип личности: неаликситимический";
            title.setVisibility(View.GONE);
            firstBtn.setVisibility(View.GONE);
            secondBtn.setVisibility(View.GONE);
            thirdBtn.setVisibility(View.GONE);
            fourthBtn.setVisibility(View.GONE);
            fifthBtn.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
            resultTextView.setText(result);
            resultTextView.setVisibility(View.VISIBLE);
            String passList = sp.getString("testsPassed", "");
            if(!passList.isEmpty())
                passList+=" ";
            sp.edit().putString("testsPassed", passList + testId).apply();
        }

        counter++;
    }
}