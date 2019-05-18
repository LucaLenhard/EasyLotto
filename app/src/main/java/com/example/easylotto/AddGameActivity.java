package com.example.easylotto;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.util.Log;
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
    private TextView mTextViewGuthaben;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        SharedPreferences sp = getSharedPreferences("TaskerPrefs", 0);
        int guthaben = sp.getInt("guthaben", 0);
            Log.d("Guthaben: ", Integer.toString(guthaben));

            mEditTextName = findViewById(R.id.edittext_name);
            mTextViewAmount = findViewById(R.id.textview_amount);
            mTextViewGuthaben = findViewById(R.id.guthaben_textview);

            mTextViewGuthaben.setText(Integer.toString(guthaben));


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
                      mDataBaseHelper.addData(temp2,mEditTextName.getText().toString(),mAmount, 0);
                    finish();

                     Intent returnIntent = new Intent();
                    testAlarm();
                     returnIntent.putExtra("result",temp2);


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


        private void testAlarm() {

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(this, AlertReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
            alarmManager.set(AlarmManager.RTC_WAKEUP, 100, pendingIntent);
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

}


