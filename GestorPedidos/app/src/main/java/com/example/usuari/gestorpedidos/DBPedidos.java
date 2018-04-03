package com.example.usuari.gestorpedidos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DBPedidos {
    private SQLiteDatabase db = null;
    private DatabaseHelper dbhelper = null;
    Context context;

    public DBPedidos(Context ctx){
        this.context = ctx;
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public long altaPedido(String producto, int unidades){
        ContentValues initial = new ContentValues();
        initial.put("producto",producto);
        initial.put("unidades",unidades);
        return db.insert("Pedidos",null,initial);
    }

    public Cursor recuperar(){
        return db.query("Pedidos",new String[]{"_id","producto","unidades"},
        null,null,null,null,null);
    }
}
