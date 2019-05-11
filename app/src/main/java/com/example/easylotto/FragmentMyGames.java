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

import java.util.ArrayList;
import java.util.List;

public class FragmentMyGames extends Fragment {


    View v;
    private RecyclerView myrecyclerview;
    private List<Spiel> lstSpiel;
    DatabaseHelper mDataBaseHelper;


    public FragmentMyGames() {

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



        //Beispiel um Status zu ändern
       // mDataBaseHelper.updateDataToUserActive(2);

        //Beispiel um Dateien in DB hinzuzufüg

        //Use this if DB is empty
        // mDataBaseHelper.addInit();
        //
        // Beispiel für aktives Spiel
        // mDataBaseHelper.addData(20500,"22.09.2019",200, 1,0);
        Cursor data = mDataBaseHelper.getData();




        while(data.moveToNext()) {

            lstSpiel.add(new Spiel(data.getString(0), data.getInt(1), data.getString(2), data.getInt(3)));
            Log.i("TEST", data.getString(1));
        }

}



}
