package com.example.usuari.prueba1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tvResultado = (TextView) this.findViewById(R.id.tvResultado);
        //Obtenemos el intent asociado
        Intent intent = this.getIntent();
        //recuperamos el dato enviado por la actividad pricipal
        int resultado = intent.getIntExtra("resultado",0);
        tvResultado.setText("Resultado: "+resultado);
    }
    public void volver(View v ){
        //para volver a la actividad anterior
        //finalizamos la actividad
        this.finish();
    }
}
