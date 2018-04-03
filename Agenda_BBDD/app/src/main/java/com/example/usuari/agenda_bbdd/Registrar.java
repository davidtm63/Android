package com.example.usuari.agenda_bbdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
    }

    public void guardar(View v){
        String nombre = ((EditText) findViewById(R.id.etNombre)).getText().toString();
        String email = ((EditText) findViewById(R.id.etEmail)).getText().toString();
        String edad = ((EditText) findViewById(R.id.etEdad)).getText().toString();
        int dbledad = Integer.parseInt(edad);
        persona adp = new persona(this);
        adp.registrar(nombre,email,dbledad);
        adp.cerrar();
        this.finish();
    }
}
