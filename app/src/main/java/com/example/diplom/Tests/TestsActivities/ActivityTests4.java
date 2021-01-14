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

public class ActivityTests4 extends AppCompatActivity {             //Тест по выявлению способности к общению

    Button firstBtn, secondBtn;
    int f = 0, s = 0, counter = 0;
    ImageView image;
    TextView title, textResult;
    JSONArray questions;
    String result, testId = "0";;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests4);
        firstBtn = findViewById(R.id.firstBtn);
        secondBtn = findViewById(R.id.secondBtn);
        title = findViewById(R.id.title);
        textResult = findViewById(R.id.title2);
        image = findViewById(R.id.imageView4);

        sp = getSharedPreferences("passList",MODE_PRIVATE);

        try {
            questions = new JSONObject(AssetTests.getStringFromAssetFile(this, "4")).getJSONArray("questions");
            testId =  new JSONObject(AssetTests.getStringFromAssetFile(this,"4")).getString("id");
            fillData();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = counter + 1;
                res %= 2;
                if(res != 0) {
                    f++;
                }
                fillData();
            }
        });

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = counter + 1;
                res %= 2;
                if(res == 0) {
                    s++;
                }
                fillData();
            }
        });

    }

    private void fillData() {
        try {
            title.setText(questions.getJSONObject(counter).getString("title"));
            firstBtn.setText(questions.getJSONObject(counter).getString("key1"));
            secondBtn.setText(questions.getJSONObject(counter).getString("key2"));
        } catch (Exception e) {

            int res = f + s;
            if (res < 10 ) {
                result = "Уровень развития у вас коммуникативных способностей низкий, вы скорее всего замкнутый, необщительный человек, с трудом знакомитесь с людьми и не стремитесь к этому.";
            } else if (res >= 10 && res <= 13) {
                result = "Средний уровень";
            } else {
                result = "Высокий уровень. В таком случае для вас одна из радостей в жизни - общение, окружающие ценят в вас энергию, способность вести диалог и др.";
            }

            title.setVisibility(View.GONE);
            firstBtn.setVisibility(View.GONE);
            secondBtn.setVisibility(View.GONE);

            textResult.setVisibility(View.VISIBLE);
            textResult.setText(String.format("Ваш результат: %s", result));

            String passList = sp.getString("testsPassed", "");
            if(!passList.isEmpty())
                passList+=" ";
            sp.edit().putString("testsPassed", passList + testId).apply();

        }
        counter++;

    }

}