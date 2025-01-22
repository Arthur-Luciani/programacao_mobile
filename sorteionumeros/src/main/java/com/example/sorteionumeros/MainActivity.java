package com.example.sorteionumeros;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        btn = findViewById(R.id.btn);

        txt.setText("-");
        btn.setOnClickListener(v -> {
            int sorteio = (int) (Math.random() * 10) + 1;
            txt.setText(String.valueOf(sorteio));
        });
    }
}