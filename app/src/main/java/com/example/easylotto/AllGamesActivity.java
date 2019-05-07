package com.example.easylotto;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.easylotto.dummy.DummyContent;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;


public class AllGamesActivity extends AppCompatActivity {

    private static final Logger
            log= LoggerFactory.getLogger(AllGamesActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_games);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_all_games);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<DummyContent.DummyItem> items=new ArrayList<>();
        items.add(new DummyContent.DummyItem("1","c1","d1"));
        items.add(new DummyContent.DummyItem("2","c2","d2"));
        items.add(new DummyContent.DummyItem("3","c3","d3"));
        items.add(new DummyContent.DummyItem("4","c4","d4"));
        items.add(new DummyContent.DummyItem("5","c5","d5"));
        items.add(new DummyContent.DummyItem("6","c6","d6"));
        items.add(new DummyContent.DummyItem("7","c7","d7"));

        log.info("Yo we got"+items.size()+"items");

        SpieleFragment.OnListFragmentInteractionListener listener=new SpieleFragment.OnListFragmentInteractionListener() {
            @Override
            public void onListFragmentInteraction(DummyContent.DummyItem item) {
                Toast.makeText(AllGamesActivity.this, "Item clicked"+item.details, Toast.LENGTH_LONG).show();

            }
        };
        recyclerView.setAdapter(new MySpieleRecyclerViewAdapter(items, listener));



    }

}
