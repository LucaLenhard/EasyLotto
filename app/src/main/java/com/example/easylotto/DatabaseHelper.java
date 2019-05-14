package com.example.easylotto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "spiele_tabelle";
    private static final String COL1 = "Spielnummer";
    private static final String COL2 = "Volumen";
    private static final String COL3 = "Ziehungsdatum";
    private static final String COL4 = "Buyin";
    private static final String COL5 = "UserAktiv";
    private static final String COL6 = "UserGewonnen";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " +  TABLE_NAME + "(Spielnummer INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " INTEGER, " + COL3 + " TEXT, " + COL4 + " INTEGER, " + COL5 + " INTEGER,"+ COL6 + " INTEGER)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(int Volumen, String Ziehungsdatum, int Buyin, int UserAktiv, int UserGewonnen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, Buyin);
        contentValues.put(COL3, Ziehungsdatum);
        contentValues.put(COL4, Volumen);
        contentValues.put(COL5, UserAktiv);
        contentValues.put(COL6, UserGewonnen);

        Log.d(TAG, "addData: Adding " + Volumen + Ziehungsdatum + Buyin + UserAktiv + UserGewonnen
        +" to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME,     null, contentValues);

        if(result== -1) {
            return false;
        }else{
            return true;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
    //only use this if DB is empty
    public void addInit() {
        addData(10000,"31.05.2019",100, 0,0);
        addData(5000,"21.06.2019",50, 0,0);
        addData(80000,"09.09.2019",80, 0,0);
        addData(100000,"14.07.2019",1000, 0,0);
        addData(1000,"22.09.2019",10, 0,0);

    }

    //funktioniert !!



      public void updateDataToUserActive(Integer Spielnummer){
        SQLiteDatabase db = this.getWritableDatabase();
        Integer active = 1;
        String query = "UPDATE " + TABLE_NAME + " SET " + COL5 + " = '"+ active +"' WHERE " + COL1 + " = '" + Spielnummer + "'";
        Log.d(TAG, "update UserActive in game" + Spielnummer);
        db.execSQL(query);
    }


    //public void deleteWrongShit(Integer Spielnummer) {
    //    SQLiteDatabase db = this.getWritableDatabase();
   //     String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL1 + " = '" + Spielnummer + "'";
     //   db.execSQL(query);
   // }

}
