package com.example.usuari.location2app;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Long {
    private SQLiteDatabase db = null;
    private  DatabaseHelper dbhelper = null;
    Context context;

    public Long(Context ctx){
        this.context = ctx;
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getReadableDatabase();
    }

    public void close(){dbhelper.close();}

    public long altaLong(double longitud, double latitud){
        ContentValues initial = new ContentValues();
        initial.put("longitud",longitud);
        initial.put("latitud",latitud);
        return db.insert("long",null,initial);
    }

    public Cursor recuperar(){
        return db.query("long",new String[]{"_id","longitud","latitud"},
                null,null,null,null,null);
    }
}
