package com.example.usuari.agenda_bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.CursorAdapter;

/**
 * Created by usuari on 15/03/2018.
 */

public class persona {
    private SQLiteDatabase db = null;
    private personadb dbhelper = null;
    private static String nombre;
    private static String email;
    private static int edad;

    public static String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    Context context;

    public persona(Context ctx){
        this.context = ctx;
        dbhelper = new personadb(context);
        db = dbhelper.getReadableDatabase();
    }

    public persona(int anInt, String nombre, String email, String edad) {
        this.setNombre(nombre);
        this.setEmail(email);
        this.setEdad(Integer.parseInt(edad));
    }

    public void cerrar(){
        dbhelper.close();
    }

    public long registrar(String nombre, String email, int edad){
        ContentValues initialValues = new ContentValues();
        initialValues.put("nombre", nombre);
        initialValues.put("email", email);
        initialValues.put("edad", edad);
        return db.insert("mundo", null, initialValues);
    }

    public Cursor recuperar(){
        return db.query("mundo", new String[]{"_id","nombre","email","edad"},
                null, null, null, null, null);
    }
    
    public persona recuperarNombre(String nombre){
        persona p = null;
        Cursor c = db.query("mundo", new String[]{"_id","nombre", "email", "edad"},"nombre=?",new String[]{nombre},null,null,null);
        if(c.moveToNext()){
            p = new persona(c.getInt(0),c.getString(1),c.getString(2),c.getString(3));
        }
        return p;
    }
}

