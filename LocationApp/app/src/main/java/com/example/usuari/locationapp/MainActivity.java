package com.example.usuari.locationapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    //Creamos variabe location manager
    LocationManager lm;
    //Creamos escuchador de posiciones cada vez que cambia nos avisara
    LocationListener escuchador = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            //Obtenemos posicion exacta que nos ha enviado el proveedor
            String datos = "Altitud: " + location.getAltitude() + "|Longitud: " + location.getLongitude() + "|Latitud: " + location.getLatitude();
            //Mostramos ls datos en un toast
            Toast.makeText(MainActivity.this, datos, Toast.LENGTH_LONG).show();
            //Cremos un objetop de la clase AsyncTask para mandar de manera asincroma los datos
            ComunicacionTask ctask = new ComunicacionTask();
            //Ejecutamos tarea indicando servidor,puerto,datos
            ctask.execute("10.0.2.2", "9005", datos);
        }


        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
        }

        @Override
        public void onProviderEnabled(String s) {
        }

        @Override
        public void onProviderDisabled(String s) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //eliminamos la vinculacion con el escuchador cuando la actividad no esta activada
        lm.removeUpdates(escuchador);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Vinculamos el location manager y el escuchador
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 10, escuchador);

    }

    //Creamos nuestra clase de comunicacion con el servidor
    private class ComunicacionTask extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... strings) {
            Socket sc = null;
            try {
                sc = new Socket(strings[0],Integer.parseInt(strings[1]));
                PrintStream ps = new PrintStream(sc.getOutputStream());
                ps.println(strings[2]);
                ps.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                    if (sc!=null){
                        try {
                            sc.close();
                        }catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }

            return null;
        }
    }
}
