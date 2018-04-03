package com.example.usuari.sqlitequenopasehambre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AltaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);
    }
    public void guardar(View v){
        String titulo = ((EditText) findViewById(R.id.edtTitulo)).getText().toString();
        String autor = ((EditText) findViewById(R.id.edtAutor)).getText().toString();
        String precio = ((EditText) findViewById(R.id.edtPrecio)).getText().toString();
        Double dbLprecio = Double.parseDouble(precio);
        //Double precio = Double.parseDouble(((EditText) findViewById(R.id.edtPrecio)).getText().toString());
        DBLibros adp = new DBLibros(this);
        adp.altaLibro(titulo, autor,dbLprecio);
        adp.close();
        this.finish();
    }
}
