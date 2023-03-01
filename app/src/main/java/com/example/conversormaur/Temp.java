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

public class Temp extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {

    Button borra_Temperatura;
    EditText centigrados;
    TextView Resultado_Temperatura;
    RadioButton FahrenheitB, kelvinB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperatura);

        FahrenheitB = (RadioButton) findViewById(R.id.rb_millas);
        kelvinB = (RadioButton) findViewById(R.id.rb_Pines);

        borra_Temperatura = (Button) findViewById(R.id.btnborrarTemp);
        borra_Temperatura.setOnLongClickListener(this);
        borra_Temperatura.setEnabled(false);

        Resultado_Temperatura = (TextView) findViewById(R.id.txt_resultLong);
        Resultado_Temperatura.setOnClickListener(this);
        Resultado_Temperatura.setEnabled(false);

        //aqui iran valores inhabilitados por defecto

        this.centigrados = (EditText) findViewById(R.id.et_Metros);
        centigrados.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals("")) {
                    borra_Temperatura.setEnabled(false);

                } else {
                    borra_Temperatura.setEnabled(true);
                }
                if (centigrados.toString().equals("")) {
                    Resultado_Temperatura.setEnabled(false);
                } else {
                    Resultado_Temperatura.setEnabled(true);
                }

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.toString().equals("")) {
                    borra_Temperatura.setEnabled(false);
                } else {
                    borra_Temperatura.setEnabled(true);
                }
                if (editable.toString().equals("")) {
                    Resultado_Temperatura.setEnabled(false);
                } else {
                    Resultado_Temperatura.setEnabled(true);
                }

            }
        });

        Button Salir_Temp = findViewById(R.id.btn_salirTemp);
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
        String valor_string = centigrados.getText().toString();
        double valor_int = Integer.parseInt(valor_string);

        if (kelvinB.isChecked() == true) {
            double resultado_kelvin = valor_int + 273.15;
            String resultado = String.valueOf(resultado_kelvin);
            Resultado_Temperatura.setText("La temperatura es de: " + resultado + "K");
            centigrados.setEnabled(false);
        }

        if (FahrenheitB.isChecked() == true) {
            double resultado_fahrenheit =(valor_int * 1.8 )+ 32;
            String resultado = String.valueOf(resultado_fahrenheit);
            Resultado_Temperatura.setText("La temperatura es de: " + resultado + "F");
            centigrados.setEnabled(false);
        }

    }

    @Override
    public boolean onLongClick(View view) {


        switch (view.getId()) {
            case R.id.btnborrarTemp: {
                Toast t = Toast.makeText(this, "se han borrado los valores", Toast.LENGTH_SHORT);
                t.show();

                break;
            }

        }
        centigrados.setText("");
        Resultado_Temperatura.setText("");
        centigrados.setEnabled(true);
        return false;
    }

    }

