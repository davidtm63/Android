package com.example.usuari.ej_form;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void guardar(View v) {
        persona p = new persona();
        EditText nomb = (EditText) this.findViewById(R.id.nombre);
        EditText email = (EditText) this.findViewById(R.id.email);
        EditText edad = (EditText) this.findViewById(R.id.edad);
        int ed = Integer.parseInt(edad.getText().toString());
//        p.setNombre(nomb.getText().toString());
//        p.setEmail(email.getText().toString());
//        p.setEdad(ed);


        FileOutputStream fos = null;
        PrintStream out = null;
        try{
            fos = this.openFileOutput("nombre", Context.MODE_APPEND);
            out = new PrintStream(fos);
            out.println(nomb.getText().toString()+" "+email.getText().toString()+" "+ed);
            out.flush();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out!=null) out.close();
        }

//        MainActivity.mundo.add(p);
        Toast.makeText(this, "Persona guardada", Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
