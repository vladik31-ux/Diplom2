package com.example.diplom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diplom.Main.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText login, password;
    private Drawable img, img2;
    private String P, L;
    private FirebaseAuth mAuth;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

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
        L = login.getText().toString();
        P = password.getText().toString();
        if(!L.isEmpty() && !P.isEmpty()) {
            mAuth.signInWithEmailAndPassword(L, P)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(LoginActivity.this, "Неправильный логин или пароль!",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
        } else {
            Toast.makeText(LoginActivity.this, "Заполните пожалуйста все поля",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void registr(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }


}