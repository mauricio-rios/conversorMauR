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

public class longitud extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener{

    Button borrar_Longitud;
    EditText Metros;
    TextView Resultado_Longitud;
    RadioButton Millas, Pulgadas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.longitud);

        Millas = (RadioButton) findViewById(R.id.rb_millas);
        Pulgadas = (RadioButton) findViewById(R.id.rg_Pulgadas);

        borrar_Longitud = (Button) findViewById(R.id.btn_BorrarLong);
        borrar_Longitud.setOnLongClickListener(this);
        borrar_Longitud.setEnabled(false);

        Resultado_Longitud = (TextView) findViewById(R.id.txt_resultLong);
        Resultado_Longitud.setOnClickListener(this);
        Resultado_Longitud.setEnabled(false);

        //aqui iran valores inhabilitados por defecto

        this.Metros = (EditText) findViewById(R.id.et_Metros);
        Metros.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals("")) {
                    borrar_Longitud.setEnabled(false);

                } else {
                    borrar_Longitud.setEnabled(true);
                }
                if (Metros.toString().equals("")) {
                    Resultado_Longitud.setEnabled(false);
                } else {
                    Resultado_Longitud.setEnabled(true);
                }

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.toString().equals("")) {
                    borrar_Longitud.setEnabled(false);
                } else {
                    borrar_Longitud.setEnabled(true);
                }
                if (editable.toString().equals("")) {
                    Resultado_Longitud.setEnabled(false);
                } else {
                    Resultado_Longitud.setEnabled(true);
                }

            }
        });

        Button Salir_Temp = findViewById(R.id.btn_SalirLong);
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
        String valor_string = Metros.getText().toString();
        double valor_int = Integer.parseInt(valor_string);

        if (Millas.isChecked() == true) {
            double resultado_millas = valor_int / 1609;
            String resultado = String.valueOf(resultado_millas);
            Resultado_Longitud.setText("La conversion es de: " + resultado + " millas");
            Metros.setEnabled(false);
        }

        if (Pulgadas.isChecked() == true) {
            double resultado_pulgadas = valor_int * 39.37;
            String resultado = String.valueOf(resultado_pulgadas);
            Resultado_Longitud.setText( "La conversion es de: " + resultado + "pulgadas");
            Metros.setEnabled(false);
        }

    }

    @Override
    public boolean onLongClick(View view) {


        switch (view.getId()) {
            case R.id.btn_BorrarLong: {
                Toast t = Toast.makeText(this, "se han borrado los valores", Toast.LENGTH_SHORT);
                t.show();

                break;
            }

        }
        Metros.setText("");
        Resultado_Longitud.setText("");
        Metros.setEnabled(true);
        return false;
    }

}

