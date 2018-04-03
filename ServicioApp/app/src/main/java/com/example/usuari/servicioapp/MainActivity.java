package com.example.usuari.servicioapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static ProgressBar pbProgreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbProgreso = (ProgressBar) this.findViewById(R.id.pbProgress);
        pbProgreso.setMax(100);
    }

    public void iniciar(View v){
        startService(new Intent(this,MyService.class));
    }

    public void auxiliar(View v){
        Toast.makeText(this,"La UI sigue funcionando",Toast.LENGTH_LONG).show();
    }

    //FALTA EL MANEJADOR
    public static Handler manejador = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //Recogemos el valor del servece
            int valor = msg.arg1;
            pbProgreso.setProgress(valor);
        }
    };



}
