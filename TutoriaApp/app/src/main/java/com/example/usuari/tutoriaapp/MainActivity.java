package com.example.usuari.tutoriaapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    ListView lvAleatorios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvAleatorios = (ListView) this.findViewById(R.id.lvAleatorio);
    }

    public void enviar(View v){

        EditText edtNum = (EditText) this.findViewById(R.id.edtNumero);
        String numero = edtNum.getText().toString();

        ComunicacionServidor com = new ComunicacionServidor();
        com.execute("10.0.2.2","9990",numero);
    }

    //Clase AsyncTask
    private class ComunicacionServidor extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            Socket sk = null;
            String res = "";
            try {

                sk = new Socket(strings[0],Integer.parseInt(strings[1]));
                PrintStream ps = new PrintStream(sk.getOutputStream());
                ps.println(strings[2]);
                ps.flush();

                InputStream is = sk.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));
                res = bf.readLine();
                bf.close();

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(sk != null){
                    try {
                        sk.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            //creamos un JSONArray con la cadena
            try {
                JSONArray jarray = new JSONArray(s);
                Double[] aleatorios = new Double[jarray.length()];
                for (int i = 0; i < jarray.length() ; i++) {
                    aleatorios[i] = jarray.getDouble(i);
                }
                ArrayAdapter<Double> adp = new ArrayAdapter<Double>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        aleatorios
                );
                lvAleatorios.setAdapter(adp);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
