package com.example.easylotto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentMyGames extends Fragment {


    View v;
    private RecyclerView myrecyclerview;
    private List<Spiel> lstSpiel;


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

        lstSpiel = new ArrayList<>();
        lstSpiel.add(new Spiel("1",10,"31.05.2019",800));
        lstSpiel.add(new Spiel("2",100,"31.05.2019",1800));
        lstSpiel.add(new Spiel("3",5,"31.05.2019",200));
        lstSpiel.add(new Spiel("4",20,"31.05.2019",5000));
}

}
