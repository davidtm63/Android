package com.example.usuari.sqlitequenopasehambre;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        //Creamos instancia DBLibros
        DBLibros adp = new DBLibros(this);
        //Recuperamos todos los libros
        Cursor c = adp.recuperarLibros();
        //Indicamos los nombres del TextView
        String[] columnas = new String[]{"titulo", "autor", "precio"};
        //Indicamos las columnas de la tabla que queremos mostrar
        //list_controls.xml
        int[] vistas = new int[] {R.id.tvTitulo, R.id.tvAutor, R.id.tvPrecio};
        SimpleCursorAdapter sc = new SimpleCursorAdapter(
                this, // Contexto : this
                R.layout.list_controls, // plantilla utilizada para mostrar las filas
                c, // Cursoor, es decir los datos
                columnas, // el nombre de las columnas de la BD
                vistas, // el nombre d3e los campos en la plantilla
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER // este no se toca :)
        );
        ListView lista = (ListView) findViewById(R.id.lvView);
        lista.setAdapter(sc);
        adp.close();
    }
    public void volver(View v){
        this.finish();
    }
}
