package com.example.calculadora_imc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etPeso = findViewById(R.id.introducirPeso);
        EditText etAltura = findViewById(R.id.introducirAltura);
        RadioButton rbEspanol = findViewById(R.id.rbEspanol);
        Button calcular = findViewById(R.id.calcular);
        TextView resultado = findViewById(R.id.resultado);

        calcular.setOnClickListener(v -> {
            String textoPeso = etPeso.getText().toString().trim();
            String textoAltura = etAltura.getText().toString().trim();

            if (textoPeso.isEmpty()) {
                etPeso.setError("Introduce tu peso");
                return;
            }
            if (textoAltura.isEmpty()) {
                etAltura.setError("Introduce tu altura");
                return;
            }

            double peso;
            double altura;
            try {
                peso = Double.parseDouble(textoPeso);
                altura = Double.parseDouble(textoAltura);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Introduce un número válido", Toast.LENGTH_SHORT).show();
                return;
            }

            if (peso <= 0) {
                etPeso.setError("El peso debe ser mayor que 0");
                return;
            }
            if (altura <= 0) {
                etAltura.setError("La altura debe ser mayor que 0");
                return;
            }

            if (!rbEspanol.isChecked()) {
                peso = peso * 0.453592;
                altura = altura * 2.54;
            }

            double imc = calcularIMC(peso, altura);
            resultado.setText(String.format("Tu IMC es: %.2f", imc));
        });
    }

    public double calcularIMC(double peso, double alturaCm) {
        double alturaM = alturaCm / 100;
        return peso / (alturaM * alturaM);
    }
}