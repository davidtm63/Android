package com.example.usuari.examen_android_dt;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends FragmentActivity implements OnMapReadyCallback  {

    public static LatLng pos;
    public static GoogleMap mMap;
    public static Double lat =  41.3818 ;
    public static Double lon =  2.1685;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);

    }

    public void iniciar(View v){
        startService(new Intent(this,MyService.class));
        Toast.makeText(MainActivity.this,"Iniciado",Toast.LENGTH_SHORT);


    }

    public void detener(View v){
        stopService(new Intent(this,MyService.class));
        Toast.makeText(MainActivity.this,"Detenido",Toast.LENGTH_SHORT);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        pos = new LatLng(lat,lon);
        mMap.addMarker(new MarkerOptions().position(pos).title("Poscion buscada"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
    }
}
