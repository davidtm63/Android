package com.example.usuari.accesoxml;

import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    TextView tvDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDatos = (TextView) findViewById(R.id.tvXML);
    }
    public void recogerDatos(View v){
        ComunicacionTask ct = new ComunicacionTask();
        ct.execute("http://www.aemet.es/xml/municipios/localidad_28079.xml");
    }

    private class ComunicacionTask extends AsyncTask<String, Void, String>{



        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            try {
                //Creamos la URL y la Conection
                URL url = new URL(strings[0]);
                URLConnection con = url.openConnection();
                InputStream is = con.getInputStream();
                Document doc;
                //Creamos un objeto DocumentReader que analizara el XML
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dbuilder;
                dbuilder = factory.newDocumentBuilder();
                doc = dbuilder.parse(is);

                NodeList listaNombre = doc.getElementsByTagName("nombre");
                result+="Localidad: "+listaNombre.item(0).getTextContent()+"\n";

                NodeList listaPrecipitaciones = doc.getElementsByTagName("prob_precipitacion");
                double media = 0;
                for (int i = 0; i <listaPrecipitaciones.getLength() ; i++) {
                    String valor = listaPrecipitaciones.item(i).getTextContent();
                    if(valor == null || valor.equals("")) valor="0";

                    media += Double.parseDouble(valor);
                          x
                }
                media = media / listaPrecipitaciones.getLength();
                result += "Media prob.precipitacion : "+media;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvDatos.setText(s);
        }

    }
}
