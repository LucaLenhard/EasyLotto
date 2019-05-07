package com.example.easylotto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


  Context mContext;
  List<Spiel> mData;

    public RecyclerViewAdapter(Context mContext, List<Spiel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_gamefinal, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(v);
    return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_volumen.setText(Integer.toString(mData.get(i).getVolumen()));
        myViewHolder.tv_spieleranzahl.setText(Integer.toString(mData.get(i).getSpieleranzahl()));
        myViewHolder.tv_ziehungsdatum.setText(mData.get(i).getZiehungsdatum());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView tv_volumen;
        private TextView tv_spieleranzahl;
        private TextView tv_ziehungsdatum;

        public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        tv_volumen = (TextView) itemView.findViewById(R.id.Volumen_groesse);
        tv_spieleranzahl = (TextView) itemView.findViewById(R.id.Spieler_anzahl);
        tv_ziehungsdatum = (TextView) itemView.findViewById(R.id.Ziehungs_datum);

    }
}
}
