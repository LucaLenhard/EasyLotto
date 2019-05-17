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


//MYGAMES == All Games


public class FragmentWonGames extends Fragment {


    View v;
    private RecyclerView myrecyclerview;
    private List<Spiel> lstSpiel;
    DatabaseHelper mDataBaseHelper;

    public FragmentWonGames() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.wongames_fragment, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.wongames_recyclerview);
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
      // mDataBaseHelper.updateDataToUserActive(3);

        //Beispiel um Dateien in DB hinzuzufüg

        //Use this if DB is empty
        // mDataBaseHelper.addInit();
        //
        // Beispiel für aktives Spiel
        // mDataBaseHelper.addData(20500,"22.09.2019",200, 1,0);
        Cursor data = mDataBaseHelper.getData();

        while(data.moveToNext()) {
            String tempForMethod=data.getString(2);
            GameFunctions.getWinner(data, getContext());
            if(Integer.parseInt(data.getString(4))==1 && data.getString(5).equals("1")) {
                lstSpiel.add(new Spiel(data.getString(0), data.getInt(1), data.getString(2), data.getInt(3), data.getInt(4), data.getString(5)));


            }}

}



}
