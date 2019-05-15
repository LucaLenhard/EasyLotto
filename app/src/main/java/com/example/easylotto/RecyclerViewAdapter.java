package com.example.easylotto;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


  Context mContext;
  List<Spiel> mData;
  Dialog myDialog;
  Button btnDialog;
  Button btnDialogLoeschen;
  DatabaseHelper mDataBaseHelper;


    public RecyclerViewAdapter(Context mContext, List<Spiel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_gamefinal, viewGroup, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        //Dialog init

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_spiel);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        vHolder.item_gamefinal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView dialog_volumen_tv = (TextView) myDialog.findViewById(R.id.dialog_volumen_id);
                TextView dialog_buyin_tv = (TextView) myDialog.findViewById(R.id.dialog_buyin_id);
                TextView dialog_datum_tv = (TextView) myDialog.findViewById(R.id.dialog_datum_id);
                dialog_volumen_tv.setText(Integer.toString(mData.get(vHolder.getAdapterPosition()).getVolumen()));
                dialog_buyin_tv.setText(Integer.toString(mData.get(vHolder.getAdapterPosition()).getSpieleranzahl()));
                dialog_datum_tv.setText(mData.get(vHolder.getAdapterPosition()).getZiehungsdatum());
                final String Spielnummer_temp = mData.get(vHolder.getAdapterPosition()).getSpielnummer();
                Toast.makeText(mContext, "Spiel " + Spielnummer_temp + " ausgewählt", Toast.LENGTH_SHORT).show();

                btnDialog = (Button) myDialog.findViewById(R.id.dialog_btn_mitspielen);
                btnDialog.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {





                        //Intent a = new Intent(mContext, MyGamesActivity.class);
                       // mContext.startActivity(a);
                        mDataBaseHelper = new DatabaseHelper(mContext);
                        Integer temp = Integer.valueOf(Spielnummer_temp);
                        mDataBaseHelper.updateDataToUserActive(temp);
                        Log.d("test", String.valueOf(temp));

                        myDialog.dismiss();
                    }
                });
                btnDialogLoeschen = (Button) myDialog.findViewById(R.id.dialog_btn_loeschen);
                btnDialogLoeschen.setOnClickListener(new View.OnClickListener() {
                   @Override
                    public void onClick(View v) {
                       mDataBaseHelper = new DatabaseHelper(mContext);
                       Integer temp2 = Integer.valueOf(Spielnummer_temp);
                       mDataBaseHelper.delete(temp2);
                       Log.d("Deleted Item", String.valueOf(temp2));
                       notifyDataSetChanged();
                       myDialog.dismiss();
                   }

                });
                myDialog.show();
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
