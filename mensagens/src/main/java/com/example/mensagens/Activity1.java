package com.example.mensagens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        findViewById(R.id.btn).setOnClickListener(v -> {
            String msg = ((EditText) findViewById(R.id.edTxt)).getText().toString();
            Intent intent = new Intent(this.getApplicationContext(), Activity2.class).putExtra("msg", msg);
            startActivity(intent);
        });

    }
}