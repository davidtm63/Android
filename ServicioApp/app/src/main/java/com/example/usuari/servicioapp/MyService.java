package com.example.usuari.servicioapp;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"El servicio se esta destruyendo. . . .", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //iNICIAMOS TAREA ASINCROMA
        new CalculoTask().execute(new Void[]{null});
        return START_STICKY;
    }

    private class CalculoTask extends AsyncTask<Void,Integer,Long>{

        @Override
        protected Long doInBackground(Void... voids) {
            //simulamos una tarea que tarde un rato
            long result = 0;
            for (int i = 0; i <=100 ; i++) {
                result+=i;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //este metodo provoca que se inicie la funcion onProgress
                publishProgress(i);
            }
            return result;
        }
        @Override
        protected void onPostExecute(Long aLong) {
            Toast.makeText(getBaseContext(),"Calculado",Toast.LENGTH_LONG).show();
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            MainActivity.manejador.obtainMessage(0,values[0],0,null).sendToTarget();

        }

    }

}
