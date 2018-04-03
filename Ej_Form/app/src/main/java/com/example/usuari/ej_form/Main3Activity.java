package com.example.usuari.ej_form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ListView lvResult = (ListView) this.findViewById(R.id.resultado);
        ArrayAdapter<persona> arPersona = new ArrayAdapter<persona>(this,
                android.R.layout.simple_list_item_1, MainActivity.mundo);
        lvResult.setAdapter(arPersona);
        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                persona p = MainActivity.mundo.get(i);
                String mensage = p.getNombre()+" "+p.getEmail()+" "+p.getEdad();
                Toast.makeText(Main3Activity.this, mensage, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void volver(View v){
        this.finish();
    }
}
