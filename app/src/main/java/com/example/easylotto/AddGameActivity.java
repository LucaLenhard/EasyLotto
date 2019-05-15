package com.example.easylotto;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AddGameActivity extends AppCompatActivity {


    private SQLiteDatabase mDatabase;
    private EditText mEditTextName;
    private TextView mTextViewAmount;
    private int mAmount = 0;
    DatabaseHelper mDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);

        //nicht sicher ob ich die toolbar noch brauche
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



            mEditTextName = findViewById(R.id.edittext_name);
            mTextViewAmount = findViewById(R.id.textview_amount);

            Button buttonIncrease = findViewById(R.id.button_increase);
            Button buttonDecrease = findViewById(R.id.button_decrease);
            Button buttonAdd = findViewById(R.id.button_add);

            buttonIncrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    increase();
                }
            });

            buttonDecrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    decrease();
                }
            });

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mDataBaseHelper = new DatabaseHelper(v.getContext());
                 if (mEditTextName.getText().toString().trim().length() == 0 || mAmount == 0) {
                     Toast.makeText(v.getContext(), "Hinzufügen nicht erfolgreich", Toast.LENGTH_SHORT).show();

                 }
                 if (mEditTextName.getText().toString().trim().length()!= 0 || mAmount != 0) {



                        Integer temp = (int)(Math.random()*100);
                        Integer temp2 = temp * mAmount;
                      mDataBaseHelper.addData(temp2,mEditTextName.getText().toString(),mAmount, 0,0);
                    finish();
                     Intent returnIntent = new Intent();
                     returnIntent.putExtra("result",temp2);
                    // addNotification();
                     setResult(Activity.RESULT_OK,returnIntent);
                    Toast.makeText(v.getContext(), "Hinzufügen erfolgreich", Toast.LENGTH_SHORT).show();

                 }
                }
            });
        }

        private void increase() {
            mAmount = mAmount + 5;
            mTextViewAmount.setText(String.valueOf(mAmount));
        }

        private void decrease() {
            if (mAmount > 5) {
                mAmount =mAmount-5;
                mTextViewAmount.setText(String.valueOf(mAmount));
            }
        }



    /*private void addNotification() {
        // Builds your notification

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,1)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Neues Spiel wurde hinzugefügt")
                .setContentText("Schau schnell nach!");

        // Creates the intent needed to show the notification
        Intent notificationIntent = new Intent(this, MyGamesActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
*/
    }


