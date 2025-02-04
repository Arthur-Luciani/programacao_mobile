package com.example.listagem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    Button btnList;
    Button btnRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnList = findViewById(R.id.btnList);
        btnRecycler = findViewById(R.id.btnRec);

        setupButton(btnList, List.class);
        setupButton(btnRecycler, RecyclerView.Recycler.class);

    }

    private void setupButton(Button btn, Class<?> clazz) {
        btn.setOnClickListener(v -> startActivity(new Intent(this.getApplicationContext(), clazz)));
    }
}