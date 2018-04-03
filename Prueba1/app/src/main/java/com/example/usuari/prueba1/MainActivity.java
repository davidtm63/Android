package com.example.usuari.prueba1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Saludar(View view){
        //Obtenemos referencia del control para el campo de texto
        EditText nombre = (EditText) this.findViewById(R.id.editText);
        //Obtenemos la referencia del control para el TextView
        TextView saludo = (TextView) this.findViewById(R.id.textView2);
        //Recogemos el valor que tenga el camopo del texto
        //le concatenamos un saludo i imprimimos
        String texto = "Hola " + nombre.getText();
        //Mostamos el texto en el TextView
        saludo.setText(texto);
    }
    public void calcular(View v){
        EditText edtNumero = (EditText) this.findViewById(R.id.edtNumero);
        TextView tvResutado = (TextView) this.findViewById(R.id.tvResultado);
        //Convertimos el valor del texto a numero
        int num = Integer.parseInt(edtNumero.getText().toString());
        int res = 1;
        //calculamos el factorial i lo mostramos
        for (int i = 1 ; i<=num; i++){
            res*=i;
        }
        //Creacion del objeto intent asociado a la nueva actividad
        Intent intent = new Intent(this, Main2Activity.class);
        //guardamos el resultado de la operacion
        intent.putExtra("resultado",res);
        //lanzamiento de la actividad
        this.startActivity(intent);
    }

}
