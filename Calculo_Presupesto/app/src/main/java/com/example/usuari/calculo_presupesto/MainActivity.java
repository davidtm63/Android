package com.example.usuari.calculo_presupesto;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public  String date ;
    public  int cosa = 500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void fecha(View v){
        new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date = i+"/"+(i1+1)+"/"+i2;
                    }
                },2018,3,14
        ).show();
    }
    public void presupuesto(View v){

          RadioButton r8 = (RadioButton) this.findViewById(R.id.Radio1);
          RadioButton r16 = (RadioButton) this.findViewById(R.id.Radio2);
          RadioButton r32 = (RadioButton) this.findViewById(R.id.Radio3);
          CheckBox cImp = (CheckBox) this.findViewById(R.id.impresora);
          CheckBox cMon = (CheckBox) this.findViewById(R.id.ordenata);
          TextView topo = (TextView) this.findViewById(R.id.result);
        int ocho = 50;
        int diezseis = 100;
        int treinta = 150;
        int impres = 200;
        int moni = 150;

        if(r8.isChecked()== true) cosa += ocho;
        if (r16.isChecked() == true) cosa += diezseis;
        if(r32.isChecked() == true) cosa += treinta;

        if(cImp.isChecked() == true) cosa += impres;
        if (cMon.isChecked() == true) cosa += moni;
        topo.setText("Precio: "+cosa+", fecha de entrega"+date);
    }
}
