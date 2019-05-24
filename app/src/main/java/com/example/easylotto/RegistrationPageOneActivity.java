package com.example.easylotto;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPageOneActivity extends AppCompatActivity {
    private EditText EditBenutzername;
    private EditText EditPasswort;

    public int counter =0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null)
        {
            counter = savedInstanceState.getInt("counter");
        }

        setContentView(R.layout.activity_registration_page_one);

        Button registration_btn = findViewById(R.id.btn_next);
        registration_btn.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View v) {

                EditBenutzername = findViewById(R.id.edittext_benutzernameLogin);
                EditPasswort = findViewById(R.id.edittext_passwort);
                String Benutzername = String.valueOf(EditBenutzername.getText());
                String Passwort = String.valueOf(EditPasswort.getText());

                if (EditBenutzername.getText().toString().trim().length()!= 0 || EditPasswort.getText().toString().trim().length()!= 0) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("TaskerPrefs", 0);
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putString("benutzername", Benutzername);
                    editor.putString("passwort", Passwort);
                    editor.putString("onCreatePassword", Passwort);

                    editor.putInt("guthaben", 1000);

                    editor.commit();

                    Toast.makeText(v.getContext(), "Herzlich Willkommen " + Benutzername, Toast.LENGTH_SHORT).show();
                    Log.d("Registrierung", "Registrierung erfolgreich");
                    switchToMyGames();
                    finish();
                }
                if (Benutzername == null || Passwort == null) {
                    Toast.makeText(v.getContext(), "Registrierung war nicht erfolgreich", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }

    private void switchToMyGames() {
        Intent a = new Intent(this, MyGamesActivity.class);
        startActivity(a);
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
