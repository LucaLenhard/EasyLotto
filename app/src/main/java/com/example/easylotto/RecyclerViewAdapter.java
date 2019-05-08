package com.example.easylotto;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


  Context mContext;
  List<Spiel> mData;
  Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<Spiel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_gamefinal, viewGroup, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        vHolder.item_gamefinal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "Test Click" + String.valueOf(vHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });

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

        private LinearLayout item_gamefinal;
        private TextView tv_volumen;
        private TextView tv_spieleranzahl;
        private TextView tv_ziehungsdatum;

        public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        item_gamefinal = (LinearLayout) itemView.findViewById(R.id.spiel_item_id);
        tv_volumen = (TextView) itemView.findViewById(R.id.Volumen_groesse);
        tv_spieleranzahl = (TextView) itemView.findViewById(R.id.Spieler_anzahl);
        tv_ziehungsdatum = (TextView) itemView.findViewById(R.id.Ziehungs_datum);

    }
}
}
