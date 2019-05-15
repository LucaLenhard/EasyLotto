package com.example.easylotto;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.ActionBar;

import java.util.List;



public class MyGamesActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpager;
    private ViewPagerAdapter adapter;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_games);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent a = new Intent(view.getContext(), AddGameActivity.class);
                startActivity(a);
            }
        });

        tablayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewpager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentMyGames(), "All Games");
        adapter.AddFragment(new FragmentAllGames(), "My Games");

        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);


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





}
