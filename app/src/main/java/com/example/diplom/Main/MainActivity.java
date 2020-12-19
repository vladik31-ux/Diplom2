package com.example.diplom.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.diplom.Entity.Test;
import com.example.diplom.Main.MainMenuTestsAdapter;
import com.example.diplom.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MainMenuTestsAdapter adapter;
    ArrayList<Test> tests = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

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

        adapter = new MainMenuTestsAdapter(this, tests);
        recyclerView.setAdapter(adapter);

    }
}