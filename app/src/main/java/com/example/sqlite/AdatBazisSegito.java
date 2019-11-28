package com.example.sqlite;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdatBazisSegito extends SQLiteOpenHelper {

    //Adatbázis felépítés
    public static final String DATABASE_NAME = "Tanulo.db";
    public static final String TABLE_NAME = "Tanulo";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "KERESZTNEV";
    public static final String COL_3 = "VEZETEKNEV";
    public static final String COL_4 = "JEGY";

    //Konstruktor

    public AdatBazisSegito(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, KERESZTNEV TEXT, VEZETEKNEV TEXT, JEGY INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //Adat felvetel

    public boolean adatRogzites(String keresztnev, String vezeteknev, String jegy){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, keresztnev);
        contentValues.put(COL_3, vezeteknev);
        contentValues.put(COL_4, jegy);
        long eredmeny = database.insert(TABLE_NAME, null, contentValues);
        if (eredmeny == -1)
            return false;
        else
            return true;
    }

    //Adat lekerdezes
    public Cursor adatLekerdezes(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor eredmeny = database.rawQuery("SELECT * from " + TABLE_NAME, null);
        return eredmeny;
    }

    public long adatTorles(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_NAME, COL_1 + " = ?", new String[] {String.valueOf(id)});
    }

    public long adatModosit(String id, String keresztnev, String vezeteknev, String jegy){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, keresztnev);
        values.put(COL_3, vezeteknev);
        values.put(COL_4, jegy);
        return database.update(TABLE_NAME, values, COL_1 + " = ? ", new String[]{id});
    }
}
