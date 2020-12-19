package com.example.diplom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {

    private EditText login, password, name, password2;
    private Drawable img, img2;
    private String P, P2, N, L;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        password2 = findViewById(R.id.password2);

        mAuth = FirebaseAuth.getInstance();

        img = this.getResources().getDrawable(R.drawable.iconmail);
        img.setBounds(0, 0, 60, 60);
        login.setCompoundDrawables(img, null, null, null);
        name .setCompoundDrawables(img, null, null, null);

        img2 = this.getResources().getDrawable(R.drawable.key);
        img2.setBounds(0, 0, 60, 60);
        password.setCompoundDrawables(img2, null, null, null);
        password2.setCompoundDrawables(img2, null, null, null);
    }

    public void registr(View view) {
        L = login.getText().toString();
        P = password.getText().toString();
        N = name.getText().toString();
        P2 = password2.getText().toString();

        if(!L.isEmpty() && !P.isEmpty() && !N.isEmpty() && !P2.isEmpty()) {
            if (isEmailValid(L)) {
                if(P.equals(P2)) {
                    mAuth.createUserWithEmailAndPassword(L, P)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                                        startActivity(intent);

                                    } else {
                                        if(P.length() < 4 && P2.length() < 4) {
                                            Toast.makeText(RegistrationActivity.this, "Слишком короткий пароль",
                                                    Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(RegistrationActivity.this, "Ошибка регистрации, попробуйте еще раз",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            });
                } else {
                    Toast.makeText(RegistrationActivity.this, "Пароли не совпадают",
                            Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(RegistrationActivity.this, "Введен некорректный email",
                    Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(RegistrationActivity.this, "Заполните пожалуйста все поля",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isEmailValid(String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}