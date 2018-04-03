package com.example.usuari.sqlitequenopasehambre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void altaLibro(View v){
        Intent intent = new Intent(this, AltaActivity.class);
        this.startActivity(intent);
}
    public void mostrarLibro(View v){
        Intent intent = new Intent(this, ListadoActivity.class);
        this.startActivity(intent);
    }
}
