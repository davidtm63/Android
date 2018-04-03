package com.example.usuari.ejercicio2;

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
        TextView result = (TextView) this.findViewById(R.id.textView3);
        Intent intent = this.getIntent();
        int resultado = intent.getIntExtra("result",0);
        result.setText("Resultado: "+resultado);
    }
    public void volver(View v){
        this.finish();
    }
}
