package com.example.usuari.gestorpedidos;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {

    Timer timer;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String product = MainActivity.etProducto.getText().toString();
        int unida = Integer.parseInt(MainActivity.etUnidades.getText().toString());
        new Post().execute(product, String.valueOf(unida));
        iniciarServicio();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    private class Post extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... strings) {
            MainActivity.db.altaPedido(strings[0],Integer.parseInt(strings[1]));
            MainActivity.db.close();
            return null;
        }
    }
    private void iniciarServicio(){
        timer = new Timer();
        timer.schedule(new iniciarLv(),0,5000);
    }

    private class iniciarLv extends TimerTask{

        @Override
        public void run() {
            Cursor c = MainActivity.db.recuperar();
            String[] columnas = new String[] {"producto","unidades"};
            int[] vistas = new int[]{R.id.idProduct,R.id.idUni};
            SimpleCursorAdapter sc = new SimpleCursorAdapter(getBaseContext(),R.layout.lvlayout,c,columnas
                    ,vistas, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
            MainActivity.lvPedidos.setAdapter(sc);
        }
    }
}
