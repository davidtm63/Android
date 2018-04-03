package com.example.usuari.agenda_bbdd;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    LocationManager lm;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);


    }

    public void guardar(View v) {
        Intent guardar = new Intent(this, Registrar.class);
        this.startActivity(guardar);
    }

    public void todos(View v) {
        Intent todo = new Intent(this, Main2Activity.class);
        this.startActivity(todo);
    }

    public void buscar(View v) {
        Intent bus = new Intent(this, Buscar.class);
        this.startActivity(bus);
    }

    public void localizar(View v) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        Location loc = lm.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        String datos = "Longitud: " + loc.getLongitude() + "\nLatitud: " + loc.getLatitude();
        Toast.makeText(MainActivity.this, datos,Toast.LENGTH_LONG).show();
    }
}
