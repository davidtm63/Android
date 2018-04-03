package com.example.usuari.agenda_bbdd;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        persona adp = new persona(this);
        Cursor c = adp.recuperar();
        String[] columnas = new String[]{"nombre","email","edad"};
        int[] vistas = new int[] {R.id.tvNombre, R.id.tvEmail, R.id.tvEdad};
        SimpleCursorAdapter sc = new SimpleCursorAdapter(this, R.layout.list_persona,c,columnas,vistas,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        ListView lista = (ListView) findViewById(R.id.lvView);
        lista.setAdapter(sc);
        adp.cerrar();
    }
    public void volver(View v){
        this.finish();
    }
}
