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
        super(context, "/sdcard/"+TABLE_NAME, null, 27);
        SQLiteDatabase.openOrCreateDatabase("/sdcard/"+TABLE_NAME,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " +  TABLE_NAME + "(Spielnummer INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " INTEGER, " + COL3 + " TEXT, " + COL4 + " INTEGER, " + COL5 + " INTEGER,"+ COL6 + " TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(int Volumen, String Ziehungsdatum, int Buyin, int UserAktiv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, Buyin);
        contentValues.put(COL3, Ziehungsdatum);
        contentValues.put(COL4, Volumen);
        contentValues.put(COL5, UserAktiv);
        contentValues.put(COL6, "");

        Log.d(TAG, "addData: Adding " + Volumen + Ziehungsdatum + Buyin + UserAktiv
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


    public void addInit() {
        addData(10000,"19.05.2019",100,0);
        addData(50000,"27.05.2019",50,0);
        addData(80000,"28.05.2019",80,0);
        addData(60000,"29.05.2019",100,0);
        addData(30000,"24.05.2019",30,0);
        addData(40000,"20.05.2019",50,0);


    }



      public void updateDataToUserActive(int Spielnummer){
        SQLiteDatabase db = this.getWritableDatabase();
        int active = 1;
        String query = "UPDATE " + TABLE_NAME + " SET " + COL5 + " = '"+ active +"' WHERE " + COL1 + " = '" + Spielnummer + "'";
        Log.d(TAG, "update UserActive in game" + Spielnummer);
        db.execSQL(query);
    }
    public void updateUserWonGame(int Spielnummer){
        SQLiteDatabase db = this.getWritableDatabase();
        String active = "1";
        String query = "UPDATE " + TABLE_NAME + " SET " + COL6 + " = '"+ active +"' WHERE " + COL1 + " = '" + Spielnummer + "'";
        Log.d(TAG, "update User won in game" + Spielnummer);
        db.execSQL(query);
    }
    public void updateUserLostGame(int Spielnummer){
        SQLiteDatabase db = this.getWritableDatabase();
        String active = "0";
        String query = "UPDATE " + TABLE_NAME + " SET " + COL6 + " = '"+ active +"' WHERE " + COL1 + " = '" + Spielnummer + "'";
        Log.d(TAG, "update User lost in game" + Spielnummer);
        db.execSQL(query);
    }



//l

    public void delete(Integer Spielnummer) {
       SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL1 + " = '" + Spielnummer + "'";
      db.execSQL(query);
    }

}
