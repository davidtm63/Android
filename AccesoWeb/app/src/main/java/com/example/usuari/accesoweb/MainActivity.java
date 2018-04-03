package com.example.usuari.accesoweb;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    TextView tvPagina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvPagina = (TextView) findViewById(R.id.tvPagina);

    }
    //Metodo de respuesta del boton
    public void cargar(View v){
        //Iniciamos la tarea asincrona
        ComunicacionTask ct = new ComunicacionTask();
        //Ejecutamos tarea
        ct.execute("http://www.google.es");
    }
    //Parametro1: String : los que le pasamos al background
    //Parametro2: Void : Lo que devuelve si consultamos al esteado antes de acabar la tarea
    //Parametro3: String : Lo que devuelve la tarea, en este caso una pagina
    private class ComunicacionTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String resultado = "";
            try {
                //Creamos elobjeto URL y su Conexion
                URL url = new URL(strings[0]);
                URLConnection con = url.openConnection();
                //Recuperar la pagina
                String s;
                InputStream is = con.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));
                while ((s=bf.readLine()) != null){
                     resultado+=s;
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resultado;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvPagina.setText(s);
        }
    }
}
