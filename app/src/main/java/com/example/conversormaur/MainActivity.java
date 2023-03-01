package com.example.conversormaur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button aceptar;
    RadioButton btn_temperatura,btn_longitud,btn_peso,btn_volumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_temperatura = (RadioButton)findViewById(R.id.temperatura);
        btn_longitud = (RadioButton)findViewById(R.id.longitud);
        btn_peso = (RadioButton)findViewById(R.id.peso);
        btn_volumen = (RadioButton)findViewById(R.id.volumen);

        aceptar =(Button) findViewById(R.id.btn_aceptar); aceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (btn_temperatura.isChecked()){
            Intent otro_formulario = new Intent(MainActivity.this, Temp.class);
            startActivity(otro_formulario);
        }
        if (btn_peso.isChecked()){
            Intent otro_formulario = new Intent(MainActivity.this, peso.class);
            startActivity(otro_formulario);
        }

        if (btn_volumen.isChecked()){
            Intent otro_formulario = new Intent(MainActivity.this, volumen.class);
            startActivity(otro_formulario);
        }
        if (btn_longitud.isChecked()){
            Intent otro_formulario = new Intent(MainActivity.this, longitud.class);
            startActivity(otro_formulario);
        }

    }
}