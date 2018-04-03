package com.example.usuari.ej_temperaturas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void guardar(View v){
        //Creamos el objeto ShearedPreferences y a su editor
        SharedPreferences sp = this.getSharedPreferences("temperatura",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        //Recojemos los campos de texto y sus variables
        EditText edMes = (EditText) this.findViewById(R.id.edMes);
        EditText edTemp = (EditText) this.findViewById(R.id.edTemp);
        String valorMes = edMes.getText().toString();
        int valorTemp = Integer.parseInt(edTemp.getText().toString());
        //Las guardamos en el SharedPreferences por Clave-Valor
        editor.putInt(valorMes,valorTemp);
        editor.commit(); // Guarda los cambios de manera sincroma
//        editor.apply(); Los guarda de manera asincrona, es decir continua el programa y los guarda en el background
    }
    public void mostrar(View v){
        Intent i = new Intent(this, Temperaturas.class);
        this.startActivity(i);
    }
    public void clear(View v){
        SharedPreferences sp = this.getSharedPreferences("temperatura",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }
}
