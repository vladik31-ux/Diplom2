package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.diplom.Entity.Test;
import com.example.diplom.Main.MainMenuTestsAdapter;
import com.example.diplom.Tests.AssetTests;

import java.util.ArrayList;

public class TestsList extends AppCompatActivity {


    int typeOfTest = 0;
    MainMenuTestsAdapter adapter;
    ArrayList<Test> tests = new ArrayList<>();
    RecyclerView recyclerView;
    AssetTests assetTests = new AssetTests(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests_list);
        typeOfTest = getIntent().getIntExtra("typeOfTest", 0);

        switch(typeOfTest){
            case 1:
                tests = assetTests.getAllTestByType("type1");
                break;
            case 2:
                tests.add(new Test("Тест 1","Описание", true));
                tests.add(new Test("Тест 2","Описание", true));
                tests.add(new Test("Тест 3","Описание", false));
                tests.add(new Test("Тест 4","Описание", true));
                tests.add(new Test("Тест 5","Описание", true));
                tests.add(new Test("Тест 6","Описание", false));
                tests.add(new Test("Тест 7","Описание", false));
                tests.add(new Test("Тест 8","Описание", false));
                tests.add(new Test("Тест 9","Описание", false));
                tests.add(new Test("Тест 10","Описание", true));
                break;
            case 3:
                tests = assetTests.getAllTestByType("type3");
                break;
        }
        recyclerView = findViewById(R.id.recyclerView);


        adapter = new MainMenuTestsAdapter(this, tests);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}