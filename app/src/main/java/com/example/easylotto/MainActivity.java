package com.example.easylotto;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

     //   DatabaseHelper mDataBaseHelper = new DatabaseHelper(this);
       //Cursor data = mDataBaseHelper.getData();
       //Integer n = 0;
        //while (data.moveToNext()) {
         //   n = n+1;
        //}

        //mDataBaseHelper.deleteWrongShit(n);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Button add_btn = findViewById(R.id.buttonAdd);

        add_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchToAddGame();
            }
        });
        Button games_btn = findViewById(R.id.buttonAllGames);

        games_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchTogames();
            }
        });
        Button mygames_btn = findViewById(R.id.buttonMyGames);

        mygames_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchToMyGames();
            }
        });
        Button login_btn = findViewById(R.id.buttonLogin);

        login_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchToLogin();
            }
        });
        Button Register_btn = findViewById(R.id.buttonRegister);

        Register_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchToRegister();
            }
        });
    }

    private void switchToAddGame(){
        Intent a = new Intent(this,AddGameActivity.class);
        startActivity(a);
    }
    private void switchTogames(){
        Intent a = new Intent(this,AllGamesActivity.class);
        startActivity(a);
    }
    private void switchToMyGames(){
        Intent a = new Intent(this,MyGamesActivity.class);
        startActivity(a);
    }
    private void switchToLogin(){
        Intent a = new Intent(this,LoginActivity.class);
        startActivity(a);
    }
    private void switchToRegister(){
        Intent a = new Intent(this,RegisterActivity.class);
        startActivity(a);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    protected void onStart(Bundle savedInstanceState) {
        super.onStart();
       Log.i("started", "MainActivity");
    }
    protected void onPause(Bundle savedInstanceState) {
        super.onPause();
        Log.i("paused", "MainActivity");
    }
    protected void onDestroy(Bundle savedInstanceState) {
        super.onDestroy();
        Log.i("destroyed", "MainActivity");
    }
    protected void onRestart(Bundle savedInstanceState) {
        super.onRestart();
        Log.i("restarted", "MainActivity");
    }
    protected void onStop(Bundle savedInstanceState) {
        super.onStop();
        Log.i("stop", "MainActivity");
    }}  
