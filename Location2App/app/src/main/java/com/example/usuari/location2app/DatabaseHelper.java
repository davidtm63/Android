package com.example.usuari.location2app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Localizaciones";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context ctx){
        super(ctx,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     createTables(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        deleteTables(sqLiteDatabase);
        createTables(sqLiteDatabase);
    }


    private void createTables(SQLiteDatabase db) {
    db.execSQL("create table long ( id integer primary key autoincrement,"+
    "altitud double not null , longitud double not null , latitud double not null)");
    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL("drop table if exists long");
    }

}
