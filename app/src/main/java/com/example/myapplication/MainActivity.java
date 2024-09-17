package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private int cont = 0;

    private Button btn2, btn3;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edText);

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(intentActivity(MainActivity2.class, editText.getText().toString()));

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(intentActivity(MainActivity3.class));

    }

    private View.OnClickListener intentActivity(Class<? extends Activity> targetActivity) {
        return view -> startActivity(new Intent(getApplicationContext(), targetActivity));
    }

    private View.OnClickListener intentActivity(Class<? extends Activity> targetActivity, String msg) {
        return view -> startActivity(new Intent(getApplicationContext(), targetActivity).putExtra("msg", msg));
    }


}