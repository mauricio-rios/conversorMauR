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

public class volumen extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {

    Button borrar_Volumen;
    EditText Litros;
    TextView Resultado_Volumen;
    RadioButton Galon, mililitros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volumen);

        Galon = (RadioButton) findViewById(R.id.rb_millas);
        mililitros = (RadioButton) findViewById(R.id.rg_Pulgadas);

        borrar_Volumen = (Button) findViewById(R.id.btn_BorrarLong);
        borrar_Volumen.setOnLongClickListener(this);
        borrar_Volumen.setEnabled(false);

        Resultado_Volumen = (TextView) findViewById(R.id.txt_resultLong);
        Resultado_Volumen.setOnClickListener(this);
        Resultado_Volumen.setEnabled(false);

        //aqui iran valores inhabilitados por defecto

        this.Litros = (EditText) findViewById(R.id.et_Metros);
        Litros.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals("")) {
                    borrar_Volumen.setEnabled(false);

                } else {
                    borrar_Volumen.setEnabled(true);
                }
                if (Litros.toString().equals("")) {
                    Resultado_Volumen.setEnabled(false);
                } else {
                    Resultado_Volumen.setEnabled(true);
                }

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.toString().equals("")) {
                    borrar_Volumen.setEnabled(false);
                } else {
                    borrar_Volumen.setEnabled(true);
                }
                if (editable.toString().equals("")) {
                    Resultado_Volumen.setEnabled(false);
                } else {
                    Resultado_Volumen.setEnabled(true);
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
        String valor_string = Litros.getText().toString();
        double valor_int = Integer.parseInt(valor_string);

        if (Galon.isChecked() == true) {
            double resultado_galon = valor_int / 3.785;
            String resultado = String.valueOf(resultado_galon);
            Resultado_Volumen.setText("La conversion es de: " + resultado + " galones");
            Litros.setEnabled(false);
        }

        if (mililitros.isChecked() == true) {
            double resultado_mili = valor_int * 1000;
            String resultado = String.valueOf(resultado_mili);
            Resultado_Volumen.setText( "La conversion es de: " + resultado + "mililitros");
            Litros.setEnabled(false);
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
        Litros.setText("");
        Resultado_Volumen.setText("");
        Litros.setEnabled(true);
        return false;
    }

}

