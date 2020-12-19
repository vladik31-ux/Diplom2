package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText login, password;
    private Drawable img, img2;
    private String P, L;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);

        img = this.getResources().getDrawable(R.drawable.iconmail);
        img.setBounds(0, 0, 60, 60);
        login.setCompoundDrawables(img, null, null, null);

        img2 = this.getResources().getDrawable(R.drawable.key);
        img2.setBounds(0, 0, 60, 60);
        password.setCompoundDrawables(img2, null, null, null);
    }

    public void enter(View view) {
        P = login.toString();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void registr(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}