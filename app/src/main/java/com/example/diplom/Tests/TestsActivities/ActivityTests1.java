package com.example.diplom.Tests.TestsActivities;

import androidx.appcompat.app.AppCompatActivity;

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

public class ActivityTests1 extends AppCompatActivity {             //Тест по определению развития волевых качеств. (Е.С. Климов)

    Button firstBtn, secondBtn, thirdBtn;
    ImageView image;
    int f = 0, s = 0, t = 0, counter = 0;
    TextView title, resultTextView;
    int score = 0;
    String result = "";
    JSONArray questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests1);
        firstBtn = findViewById(R.id.firstBtn);
        secondBtn = findViewById(R.id.secondBtn);
        thirdBtn = findViewById(R.id.thirdBtn);
        title = findViewById(R.id.title);
        image = findViewById(R.id.image);
        resultTextView = findViewById(R.id.resultTextView);

        try{
            questions = new JSONObject(AssetTests.getStringFromAssetFile(this,"1")).getJSONArray("questions");
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
            score += f*2 + s;
            if(score > 30){
                result = "Ваш уровень развития волевых качеств очень высокий!";
            }
            else if(score >= 20 & score <= 30){
                result = "Ваш уровень развития волевых качеств низкий";
            }
            else if(score < 20)
            {
                result = "Ваши волевые качества практически не развиты";
            }

            title.setVisibility(View.GONE);
            firstBtn.setVisibility(View.GONE);
            secondBtn.setVisibility(View.GONE);
            thirdBtn.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
            resultTextView.setText(result);
            resultTextView.setVisibility(View.VISIBLE);
        }

        counter++;
    }

}