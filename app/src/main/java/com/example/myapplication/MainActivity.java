package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button butao = findViewById(R.id.butao);

        TextView texto = findViewById(R.id.texto);
        texto.setText("Total cliques " + cont);

        butao.setOnClickListener(view -> texto.setText("Total cliques " + ++cont));

    }


}