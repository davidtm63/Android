package com.example.usuari.gestorpedidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static EditText etProducto;
    public static EditText etUnidades;
    public static DBPedidos db;
    public static ListView lvPedidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etProducto  = (EditText) this.findViewById(R.id.etProducto);
        etUnidades = (EditText) this.findViewById(R.id.etUnidades);
        db = new DBPedidos(this);
        lvPedidos = (ListView) this.findViewById(R.id.lvPedidos);
    }

    public void registrar(View v){
        startService(new Intent(this,MyService.class));
        Toast.makeText(this,"Registrado",Toast.LENGTH_SHORT).show();
    }
}