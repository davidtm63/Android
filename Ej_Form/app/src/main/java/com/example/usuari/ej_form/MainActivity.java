package com.example.usuari.ej_form;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<persona> mundo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void añadir(View v) {
        Intent intent = new Intent(this, Main2Activity.class);
        this.startActivity(intent);
    }

    public void buscar(View v) {

        EditText nomb = (EditText) this.findViewById(R.id.nomb);
        TextView result = (TextView) this.findViewById(R.id.textView);
        int i = 0;
        FileInputStream fis = null;
        BufferedReader bf = null;
        String s;
        try {
            fis = this.openFileInput("nombre");
            bf = new BufferedReader(new InputStreamReader(fis));
            while ((s=bf.readLine())!=null){
                String[] s2 = s.split(" ");
                persona p = new persona();
                    p.setNombre(s2[0]);
                    p.setEmail(s2[1]);
                    p.setEdad(Integer.parseInt(s2[2]));

                    if (p.getNombre().toLowerCase().contains(nomb.getText().toString().toLowerCase())) {
                        result.setText("Nombre: " + p.getNombre() + "\nEmail: " + p.getEmail() + "\nEdad: " + p.getEdad());
                        i++;


                    }
                    if (i == 0){
                        result.setText("");
                        Toast.makeText(this, "El nombre no esta registrado", Toast.LENGTH_SHORT).show();
                    }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void todo(View v) {
        TextView result = (TextView) this.findViewById(R.id.textView);
        FileInputStream fis = null;
        BufferedReader bf = null;
        String s;
//        int i = 0;
        try {
            fis = this.openFileInput("nombre");
            bf = new BufferedReader(new InputStreamReader(fis));

            String z = "";
            while ((s=bf.readLine())!=null){
                String[] s2 = s.split(" ");
                persona p = new persona();
                p.setNombre(s2[0]);
                p.setEmail(s2[1]);
                p.setEdad(Integer.parseInt(s2[2]));

                z+="\nNombre: " + p.getNombre() + "\nEmail: " + p.getEmail() + "\nEdad: " + p.getEdad();

        }
            result.setText(z);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void limpiar(View v) {
        try {
            this.openFileOutput("nombre", Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  void todo2(View v){
        Intent intent2 = new Intent(this,Main3Activity.class );
        this.startActivity(intent2);
    }


}