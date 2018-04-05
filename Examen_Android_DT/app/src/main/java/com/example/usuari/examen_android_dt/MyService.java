package com.example.usuari.examen_android_dt;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    //String num = "http://10.0.2.2/JSON/";
    Timer timer;
    ArrayList<String> list;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        iniciarServicio();
        list = new ArrayList<String>();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    private void iniciarServicio() {
        timer = new Timer();
        timer.schedule(new iniciarMaps(),0,1000);
    }

    private class iniciarMaps extends TimerTask{

        @Override
        public void run() {
        ComunicacionServidor com = new ComunicacionServidor();
        com.execute();
        }
    }

    private class ComunicacionServidor extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... voids) {
            Socket sk = null;
            String res = "";
            try {
                sk = new Socket("10.0.2.2", 9999);
                InputStream is = sk.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));
                res = bf.readLine();
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }


        @Override
        protected void onPostExecute(String s) {
            try {
                JSONArray jarray = new JSONArray(s);
                String[] posicionArray = new String[jarray.length()];
                for (int i = 0; i < jarray.length() ; i++) {
                    posicionArray[i] = jarray.getString(i);
                }

                MainActivity.lat = Double.parseDouble(posicionArray[0]);
                MainActivity.lon = Double.parseDouble(posicionArray[1]);

                Boolean romper = false;
                for (int i = 0; i < list.size(); i++) {
                    if (s == list.get(i)) {
                        romper = true;
                    }
                }
                if (romper != true){
                    list.add(s);
                    MainActivity.pos = new LatLng(MainActivity.lat,MainActivity.lon);
                    MainActivity.mMap.addMarker(new MarkerOptions().position(MainActivity.pos).title("Pa tu"));
                    MainActivity.mMap.moveCamera(CameraUpdateFactory.newLatLng(MainActivity.pos));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }




}
