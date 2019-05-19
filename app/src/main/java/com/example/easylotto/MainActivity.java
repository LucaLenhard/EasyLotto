package com.example.easylotto;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText EditBenutzernameLogin;
    private EditText EditPasswortLogin;

    public int counter =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null)
        {
            counter = savedInstanceState.getInt("counter");
        }

        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE }, 1);

        // Import first start
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);

        if (firstStart) {
            DatabaseHelper mDataBaseHelper = new DatabaseHelper(this);
            mDataBaseHelper.addInit();
            startRegistration();
        }

        Button login_btn = findViewById(R.id.btn_nextLogin);
        login_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                login();
            }
        });

    }
    private void startRegistration() {

        Intent i = new Intent(this, RegistrationPageOneActivity.class);
        startActivity(i);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

    private void switchToMyGames() {
        Intent a = new Intent(this, MyGamesActivity.class);
        startActivity(a);
    }

    public void login() {

        EditBenutzernameLogin = findViewById(R.id.edittext_benutzernameLogin);
        EditPasswortLogin = findViewById(R.id.edittext_passwortLogin);
        String Benutzername = String.valueOf(EditBenutzernameLogin.getText());
        String Passwort = String.valueOf(EditPasswortLogin.getText());

        SharedPreferences pref = getApplicationContext().getSharedPreferences("TaskerPrefs", 0);


            if (pref.getString("benutzername", "").equals(Benutzername) && pref.getString("passwort", "").equals(Passwort)) {
                Log.d("Login", "Login Erfolgreich");
                switchToMyGames();
                finish();
            } else {
                Toast.makeText(this, "Benutzername und/oder Passwort falsch", Toast.LENGTH_SHORT).show();
            }
    }

    protected void onStart(Bundle savedInstanceState) {
        super.onStart();
        Log.d("started",getClass().getName());
    }

    protected void onPause(Bundle savedInstanceState) {
        super.onPause();
        Log.d("paused", getClass().getName());
    }

    protected void onDestroy(Bundle savedInstanceState) {
        super.onDestroy();
        Log.d("destroyed", getClass().getName());
    }

    protected void onRestart(Bundle savedInstanceState) {
        super.onRestart();
        Log.d("restarted", getClass().getName());
    }

    protected void onStop(Bundle savedInstanceState) {
        super.onStop();
        Log.d("stop", getClass().getName());
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        outState.putInt("counter", counter);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        counter = savedInstanceState.getInt("counter");
    }



}
