package com.example.calculadora_imc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etPeso = findViewById(R.id.introducirPeso);
        EditText etAltura = findViewById(R.id.introducirAltura);
        Button calcular = findViewById(R.id.calcular);
        TextView resultado = findViewById(R.id.resultado);

        calcular.setOnClickListener(v -> {
            double peso = Double.parseDouble(etPeso.getText().toString());
            double altura = Double.parseDouble(etAltura.getText().toString());

            double IMC = calcularIMC(peso, altura);
            resultado.setText(String.format("Tu IMC es: %.2f", IMC));
        });
    }

    public double calcularIMC (double peso, double alturaCm) {
        double alturaM = alturaCm / 100;
        return peso / (alturaM * alturaM);
    }
}