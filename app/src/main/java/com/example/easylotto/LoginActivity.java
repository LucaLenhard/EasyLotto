package com.example.easylotto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button home_btn = findViewById(R.id.loginButton);

        home_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchToHome();
            }
        });
        Button anmelden_btn = findViewById(R.id.buttonNeuAnmelden);

        anmelden_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchToRegister();
            }
        });
    }

    private void switchToHome(){
        Intent a = new Intent(this,MyGamesActivity.class);
        startActivity(a);
    }
    private void switchToRegister(){
        Intent a = new Intent(this,RegisterActivity.class);
        startActivity(a);
    }
    }


