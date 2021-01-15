package com.example.diplom.Tests.TestsActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
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

public class ActivityTests9 extends AppCompatActivity { // Методика оценки агрессивности в отношениях А. Ассингера

    Button firstBtn, secondBtn, thirdBtn;
    ImageView image;
    int f = 0, s = 0, t = 0, counter = 0;
    TextView title, resultTextView;
    int score = 0;
    String result = "", testId = "0";
    JSONArray questions;
    SharedPreferences sp;
    ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests9);

        firstBtn = findViewById(R.id.firstBtn);
        secondBtn = findViewById(R.id.secondBtn);
        thirdBtn = findViewById(R.id.thirdBtn);
        title = findViewById(R.id.title);
        image = findViewById(R.id.image);
        resultTextView = findViewById(R.id.resultTextView);

        scroll = findViewById(R.id.scroll);

        sp = getSharedPreferences("passList",MODE_PRIVATE);

        try{
            questions = new JSONObject(AssetTests.getStringFromAssetFile(this,"9")).getJSONArray("questions");
            testId =  new JSONObject(AssetTests.getStringFromAssetFile(this,"9")).getString("id");
            fillData();
        }
        catch (Exception e){
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

    private void  fillData()
    {
        try {

            title.setText(questions.getJSONObject(counter).getString("title"));
            firstBtn.setText(questions.getJSONObject(counter).getString("key1"));
            secondBtn.setText(questions.getJSONObject(counter).getString("key2"));
            thirdBtn.setText(questions.getJSONObject(counter).getString("key3"));
        }
        catch (Exception e){
            score += f + s*2 + t*3;
            if(score > 44){
                result = "     Вы излишне агрессивны, при этом нередко бываете неуравновешенным и жестоким по отношению к другим. Вы надеетесь добраться до управленческих «верхов», рассчитывая на собственные методы, добиться успеха, жертвуя интересами окружающих. Поэтому Вас не удивляет неприязнь сослуживцев, но при малейшей возможности Вы стараетесь их за это наказать.";
            }
            else if(score >= 36 & score <= 44){
                result = "     Вы умеренно агрессивны, но вполне успешно идете по жизни, поскольку в Вас достаточно здорового честолюбия и самоуверенности.";
            }
            else if(score < 36)
            {
                result = "     Вы чрезмерно миролюбивы, что обусловлено недостаточной уверенностью в собственных силах и возможностях. Это отнюдь не значит, что Вы как травинка гнетесь под любым ветерком. И все же больше решительности Вам не помешает!";
            }

            title.setVisibility(View.GONE);
            firstBtn.setVisibility(View.GONE);
            secondBtn.setVisibility(View.GONE);
            thirdBtn.setVisibility(View.GONE);
            scroll.setVisibility(View.VISIBLE);
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