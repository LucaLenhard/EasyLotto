package com.example.easylotto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;




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

                Intent a = new Intent(view.getContext(), AddGameActivity.class);
                startActivityForResult(a,1);

            }
        });

        tablayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewpager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentMyGames(), "Alle Spiele");
        adapter.AddFragment(new FragmentAllGames(), "Meine Spiele");
        adapter.AddFragment(new FragmentWonGames(), "Gewonnen");
        adapter.AddFragment(new FragmentLostGames(), "Verloren");


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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Log.d("Erfolgreich", "hinzugefügt");
                finish();
                startActivity(getIntent());

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.d("Auch Erfolgreich", "hoffe ich");
                finish();
                startActivity(getIntent());


            }
        }
    }//onActivityResult

}
