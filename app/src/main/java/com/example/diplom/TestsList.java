package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

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
    SharedPreferences sp;
    String[] passed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests_list);
        typeOfTest = getIntent().getIntExtra("typeOfTest", 0);

        loadList();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        loadList();
    }

    private void loadList()
    {

        sp = getSharedPreferences("passList",MODE_PRIVATE);

        String testsPassed = sp.getString("testsPassed","");
        if(!testsPassed.isEmpty()){
            passed = testsPassed.split(" ");
        }

        switch(typeOfTest){
            case 1:
                tests = assetTests.getAllTestByType("type1");
                break;
            case 2:
                tests = assetTests.getAllTestByType("type2");
                break;
            case 3:
                tests = assetTests.getAllTestByType("type3");
                break;
        }
        recyclerView = findViewById(R.id.recyclerView);


        adapter = new MainMenuTestsAdapter(this, tests, passed);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}