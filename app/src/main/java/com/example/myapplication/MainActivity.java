package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int nInicial = 10;
    int nFInal = 100;

    EditText textInicial, textFinal;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInicial = findViewById(R.id.nInicial);
        textFinal = findViewById(R.id.nFinal);

        TextView texto = findViewById(R.id.texto);
        texto.setText("Número aleatório " + new Random().nextInt(100));

        Button butao = findViewById(R.id.butao);
        butao.setText("Click here");
        butao.setOnClickListener(view -> {
            nInicial = Integer.parseInt(textInicial.getText().toString());
            nFInal = Integer.parseInt(textFinal.getText().toString());
            texto.setText("Número aleatório " + new Random().nextInt((nFInal - nInicial + 1) + nInicial));
        });
    }


}