package com.example.usuari.ejercicio2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sumar(View v){
        EditText aux1 = (EditText) this.findViewById(R.id.numero1);
        EditText aux2 = (EditText) this.findViewById(R.id.numero2);
        int num1 = Integer.parseInt(aux1.getText().toString());
        int num2 = Integer.parseInt(aux2.getText().toString());
        int tot = 0;
        tot = num1 + num2;

        //Intent intent = new Intent(this, Main2Activity.class);
        //intent.putExtra("result",tot);
        //this.startActivity(intent);
        Toast.makeText(this, "Resultado: "+tot, Toast.LENGTH_LONG).show();
    }
    public  void restar(View v){
        EditText aux1 = (EditText) this.findViewById(R.id.numero1);
        EditText aux2 = (EditText) this.findViewById(R.id.numero2);
        int num1 = Integer.parseInt(aux1.getText().toString());
        int num2 = Integer.parseInt(aux2.getText().toString());
        int tot = 0;
        tot = num1 - num2;
        //Intent intent = new Intent(this, Main2Activity.class);
        //intent.putExtra("result",tot);
        //this.startActivity(intent);
        Toast.makeText(this, "Resultado: "+tot, Toast.LENGTH_SHORT).show();
    }
    public void multi(View v){
        EditText aux1 = (EditText) this.findViewById(R.id.numero1);
        EditText aux2 = (EditText) this.findViewById(R.id.numero2);
        int num1 = Integer.parseInt(aux1.getText().toString());
        int num2 = Integer.parseInt(aux2.getText().toString());
        int tot = 0;
        tot = num1 * num2;
        //Intent intent = new Intent(this, Main2Activity.class);
        //intent.putExtra("result",tot);
        //this.startActivity(intent);
        AlertDialog.Builder multi = new AlertDialog.Builder(this);
        multi.setMessage("El resultado es:"+tot);
        multi.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                });
        multi.setNegativeButton(android.R.string.no,null);
        multi.show();
    }
    public void div(View v){
        EditText aux1 = (EditText) this.findViewById(R.id.numero1);
        EditText aux2 = (EditText) this.findViewById(R.id.numero2);
        int num1 = Integer.parseInt(aux1.getText().toString());
        int num2 = Integer.parseInt(aux2.getText().toString());
        int tot = 0;
        tot = num1/num2;
        //Intent intent = new Intent(this, Main2Activity.class);
        //intent.putExtra("result",tot);
        //this.startActivity(intent);
        AlertDialog.Builder multi = new AlertDialog.Builder(this);
        multi.setMessage("El resultado es: "+tot);
        multi.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                });
        multi.setNegativeButton(android.R.string.no,null);
        multi.show();
    }
}
