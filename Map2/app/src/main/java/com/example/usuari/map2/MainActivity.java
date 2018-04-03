package com.example.usuari.map2;


import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private EditText latitud ;
    private EditText longitud;
    private double  lat = 0;
    private double lon = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);
        latitud = (EditText) this.findViewById(R.id.etLatitud);
        longitud = (EditText) this.findViewById(R.id.etLongitud);
    }

    public void buscar(View v){
         lat = Double.parseDouble(latitud.getText().toString());
         lon = Double.parseDouble(longitud.getText().toString());
         LatLng pos;
         pos = new LatLng(lat,lon);
         mMap.addMarker(new MarkerOptions().position(pos).title("Poscion buscada"));
         mMap.moveCamera(CameraUpdateFactory.newLatLng(pos));

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera


    }
}
