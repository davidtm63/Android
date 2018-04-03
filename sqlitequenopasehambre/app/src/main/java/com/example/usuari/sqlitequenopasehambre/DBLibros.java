package com.example.usuari.sqlitequenopasehambre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class DBLibros {

    //Atributos
    private SQLiteDatabase db = null;
    private DatabaseHelper dbhelper = null;

    //Contexto
    Context context;

    public DBLibros(Context ctx){
        this.context = ctx;
        //Creamos una instancia de helper
        dbhelper = new DatabaseHelper(context);
        //Creamos un objeto sqlitedatabase para operar contra la db
        db = dbhelper.getReadableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public long altaLibro(String titulo, String autor, double precio){
        ContentValues initialValues = new ContentValues();
        initialValues.put("titulo", titulo);
        initialValues.put("autor", autor);
        initialValues.put("precio", precio);
        return db.insert("libros", null, initialValues);
    }

    public Cursor recuperarLibros(){
        return db.query("libros", new String[]{"_id","titulo","precio", "autor"},
                null, null, null, null, null);
    }
}
