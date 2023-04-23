package com.example.projetocalculaimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class CalculaIMC extends AppCompatActivity {

    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;

    private ImageView imageView;

    private Button button;

    private Button voltar;

    String[] mensagens2 = {"Preencha todos os campos"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_imc);

        textResultado = findViewById(R.id.resultado_imc);
        editPeso = findViewById(R.id.edit_peso);
        editAltura = findViewById(R.id.edit_altura);
        getSupportActionBar().hide();
        IniciarComponentes();

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculaIMC.this, TelaPrincipal.class);
                startActivity(intent);
                finish();
            }
        });

        }


            public void calcularImc(View view) {

                double peso = Double.parseDouble(editPeso.getText().toString());
                double altura = Double.parseDouble(editAltura.getText().toString());
                double resultado = peso / (altura * altura);
                String pesoString = editPeso.getText().toString();
                String alturaString = editAltura.getText().toString();

                 if (resultado < 18.5) {
                    textResultado.setText(String.format("Abaixo do peso - IMC %.0f", resultado));


                } else if (resultado <= 18.5 || resultado < 24.9) {

                    textResultado.setText(String.format("Peso normal - IMC %.0f", resultado));

                } else if (resultado <= 25 || resultado < 29.9) {

                    textResultado.setText(String.format("Sobrepeso - IMC %.0f", resultado));

                } else if (resultado <= 30 || resultado < 35) {

                    textResultado.setText(String.format("Obesidade tipo I - IMC %.0f", resultado));

                } else if (resultado >= 35) {

                     textResultado.setText(String.format("Obesidade tipo II - IMC %.0f", resultado));

                }
            }
    private void IniciarComponentes(){
        imageView = findViewById(R.id.fisico);
        button = findViewById(R.id.bt_calc_imc);
        voltar = findViewById(R.id.bt_voltar);

    }


}