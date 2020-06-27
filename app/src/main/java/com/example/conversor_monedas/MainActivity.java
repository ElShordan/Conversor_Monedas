package com.example.conversor_monedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Pesos, resultado;
    RadioButton Dolar, Euro, Real;
    Button convertir, reiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pesos = findViewById(R.id.editTextNumber);
        resultado = findViewById(R.id.editTextNumber2);
        Dolar = findViewById(R.id.radioButton);
        Euro = findViewById(R.id.radioButton2);
        Real = findViewById(R.id.radioButton3);
        convertir = findViewById(R.id.button);
        reiniciar = findViewById(R.id.button2);

        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(Pesos.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Ingresa un monto", Toast.LENGTH_LONG).show();
                }

                if(Dolar.isChecked()) {
                    String textoPesos = Pesos.getText().toString();
                    Double numeroPesos = Double.parseDouble(textoPesos);

                    Double numeroDolar = numeroPesos * 0.014;
                    String textoDolar = String.valueOf(numeroDolar);

                    resultado.setText(textoDolar);
                }

                if(Euro.isChecked()) {
                    String textoPesos = Pesos.getText().toString();
                    Double numeroPesos = Double.parseDouble(textoPesos);

                    Double numeroEuro = numeroPesos * 0.013;
                    String textoEuro = String.valueOf(numeroEuro);

                    resultado.setText(textoEuro);
                }

                if(Real.isChecked()) {
                    String textoPesos = Pesos.getText().toString();
                    Double numeroPesos = Double.parseDouble(textoPesos);

                    Double numeroReal = numeroPesos * 0.078;
                    String textoReal = String.valueOf(numeroReal);

                    resultado.setText(textoReal);
                }
            }
        });

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pesos.setText("");
                Dolar.setChecked(true);
            }
        });
    }
}