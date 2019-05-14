package com.example.easylotto;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//ALLGAMES == My GAMES
public class FragmentAllGames extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Spiel> lstSpiel;
    DatabaseHelper mDataBaseHelper;


    public FragmentAllGames() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.allgames_fragment, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.allgames_recyclerview);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), lstSpiel);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBaseHelper = new DatabaseHelper(getActivity());
        lstSpiel = new ArrayList<>();

        //Beispiel um Dateien in DB hinzuzufügen
        //
        //
       // mDataBaseHelper.addData(500000,"22.01.2019",55, 1,0);
        //

        //Use this if DB is empty
        // mDataBaseHelper.addInit();


        Cursor data = mDataBaseHelper.getData();




        while (data.moveToNext()) {
            String tempForMethod=data.getString(2);
            if(data.getInt(4) == 1 && !GameFunctions.getValid(tempForMethod)){
                Log.d("Boolean ", Boolean.toString(GameFunctions.getValid(tempForMethod)));
                lstSpiel.add(new Spiel(data.getString(0), data.getInt(1), data.getString(2), data.getInt(3)));
            Log.i("TEST", data.getString(1));
            }
        }
    }
}
