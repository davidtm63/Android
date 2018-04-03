package com.example.usuari.ej_temperaturas;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collection;
import java.util.Map;

public class Temperaturas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperaturas);
        mostrar();
    }
    public void mostrar(){
        SharedPreferences sp = this.getSharedPreferences("temperatura",MODE_PRIVATE);
        Map<String,?> todasTemp = sp.getAll();
        Collection<?> valores = todasTemp.values();
        Integer[] arTemp;
        arTemp = valores.toArray(new Integer[0]);
        ListView lvTemp = (ListView) this.findViewById(R.id.lvTemperaturas);
        ArrayAdapter<Integer> adp = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1, arTemp);
        lvTemp.setAdapter(adp);
    }
    public void cerrar(View v){
        this.finish();
    }
}
