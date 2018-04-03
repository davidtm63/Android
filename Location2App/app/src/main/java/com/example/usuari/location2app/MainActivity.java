package com.example.usuari.location2app;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LocationManager lm;
    LocationListener escuchador = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
        Long lbloc = new Long(MainActivity.this);
        lbloc.altaLong(location.getLatitude(),location.getLongitude());
        Cursor c = lbloc.recuperar();
        lbloc.close();
            SimpleCursorAdapter adp = new SimpleCursorAdapter(MainActivity.this, R.layout.lista,c,
                    new String[]{"laltitud","longitud"},new int[]{R.id.idLatitud,R.id.idLongitud});


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
    protected void onPause() {
        super.onPause();
        lm.removeUpdates(escuchador);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 10, escuchador);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        ListView lv = (ListView) this.findViewById(R.id.lvDatos);

    }
}
