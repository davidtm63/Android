package com.example.usuari.agenda_bbdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Buscar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }
    public void buscar(View v){
        String nombre = ((EditText) findViewById(R.id.edtBuscar)).getText().toString();
        persona db = new persona(this);
        persona nomb = db.recuperarNombre(nombre);
        String s="";
        if (nomb!=null){
            s+= "Nombre: "+ persona.getNombre()+"\nEmail: "+ persona.getEmail()+"\nEdad: "+persona.getEdad();
        }
        ((TextView) findViewById(R.id.tvMostrar)).setText(s);
        db.cerrar();
    }
    public void volver(View v){
        this.finish();
    }
}
