package com.example.conversormaur;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class peso extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {

    Button borrar_Peso, salir_Peso;
    EditText kilogramos;
    TextView Resultado_Peso;
    RadioButton libras, onzas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peso);

        libras = (RadioButton) findViewById(R.id.rb_libras);
        onzas = (RadioButton) findViewById(R.id.rb_onzas);

        borrar_Peso = (Button) findViewById(R.id.btnborrarPeso);
        borrar_Peso.setOnLongClickListener(this);
        borrar_Peso.setEnabled(false);

        Resultado_Peso = (TextView) findViewById(R.id.txt_resulPeso);
        Resultado_Peso.setOnClickListener(this);
        Resultado_Peso.setEnabled(false);

        //aqui iran valores inhabilitados por defecto

        this.kilogramos = (EditText) findViewById(R.id.et_peso);
        kilogramos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals("")) {
                    borrar_Peso.setEnabled(false);

                } else {
                    borrar_Peso.setEnabled(true);
                }
                if (kilogramos.toString().equals("")) {
                    Resultado_Peso.setEnabled(false);
                } else {
                    Resultado_Peso.setEnabled(true);
                }

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.toString().equals("")) {
                    borrar_Peso.setEnabled(false);
                } else {
                    borrar_Peso.setEnabled(true);
                }
                if (editable.toString().equals("")) {
                    Resultado_Peso.setEnabled(false);
                } else {
                    Resultado_Peso.setEnabled(true);
                }

            }
        });

        Button Salir_Temp = findViewById(R.id.btn_salirPeso);
        Salir_Temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente_ventana = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(siguiente_ventana,0);
            }
        });
    }


    @Override
    public void onClick(View view) {
        String valor_string = kilogramos.getText().toString();
        double valor_int = Integer.parseInt(valor_string);

        if (libras.isChecked() == true) {
            double resultado_libras = valor_int * 2.205;
            String resultado = String.valueOf(resultado_libras);
            Resultado_Peso.setText("La conversion es de: " + resultado + "libra");
            kilogramos.setEnabled(false);
        }

        if (onzas.isChecked() == true) {
            double resultado_onzas = valor_int * 35.274 ;
            String resultado = String.valueOf(resultado_onzas);
            Resultado_Peso.setText( "La conversion es de: " + resultado + "onzas");
            kilogramos.setEnabled(false);
        }

    }

    @Override
    public boolean onLongClick(View view) {


        switch (view.getId()) {
            case R.id.btnborrarPeso: {
                Toast t = Toast.makeText(this, "se han borrado los valores", Toast.LENGTH_SHORT);
                t.show();

                break;
            }

        }
        kilogramos.setText("");
        Resultado_Peso.setText("");
        kilogramos.setEnabled(true);
        return false;
    }

}
