package com.example.usuari.agenda_bbdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class personadb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mundo";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE_MUNDO =
            "create table mundo (_id integer primary key autoincrement,"+"nombre text not null, email text not null, edad int not null)";
    private static final String DATABASE_DELETE_MUNDO = "drop table if exists personas";
    public personadb(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        deleteTables(db);
        createTables(db);
    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_MUNDO);
    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL(DATABASE_DELETE_MUNDO);
    }

}
