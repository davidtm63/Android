package com.example.usuari.leercontactos;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarContactos();
    }

    public void cargarContactos(){
        //Obtenemos un ContentResolver para acceder a los proveedores de datos
        ContentResolver resolver = this.getContentResolver();
        //Recuperar todos los contactos de tipo telefono
        Cursor cursor = resolver.query(
                ContactsContract.Data.CONTENT_URI,
                null,
                ContactsContract.Data.MIMETYPE+"='"+
                        ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE+
                        "'",
                null, null) ;
        //Array con los nombres de las columnas a mostrar
        String[] nombres = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER};
        //Array con los nombres de los recursos del layout para mostrar
        //en este caso utilizamos controles estandards
        int[] ids = {android.R.id.text1, android.R.id.text2};
        //Creamos el adapter
        SimpleCursorAdapter sc = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                cursor,
                nombres,
                ids,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        //Recuperamos la ListView como variable
        ListView lvContactos = (ListView) findViewById(R.id.lvContactos);
        lvContactos.setAdapter(sc);
    }
}
