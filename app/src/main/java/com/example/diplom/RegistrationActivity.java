package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    private EditText login, password, name, password2;
    private Drawable img, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        password2 = findViewById(R.id.password2);

        img = this.getResources().getDrawable(R.drawable.iconmail);
        img.setBounds(0, 0, 60, 60);
        login.setCompoundDrawables(img, null, null, null);
        password.setCompoundDrawables(img, null, null, null);

        img2 = this.getResources().getDrawable(R.drawable.key);
        img2.setBounds(0, 0, 60, 60);
        password.setCompoundDrawables(img2, null, null, null);
        password.setCompoundDrawables(img2, null, null, null);
    }
}