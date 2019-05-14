package com.example.easylotto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPageOneActivity extends AppCompatActivity {
    private EditText EditBenutzername;
    private EditText EditPasswort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                   User actUser = new User(Benutzername, Passwort);
                    Toast.makeText(v.getContext(), "Registrierung war erfolgreich", Toast.LENGTH_SHORT).show();
                    switchToMyGames();
                }
                if (EditBenutzername.getText().toString().trim().length() == 0 || EditPasswort.getText().toString().trim().length()== 0) {
                    Toast.makeText(v.getContext(), "Registrierung war nicht erfolgreich", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }




    private void switchToMyGames() {
        Intent a = new Intent(this, MyGamesActivity.class);
        startActivity(a);
    }

}
