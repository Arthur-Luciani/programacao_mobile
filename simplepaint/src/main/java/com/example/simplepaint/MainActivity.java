package com.example.simplepaint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {

    Button button;
    SimplePaint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paint = findViewById(R.id.simplepaint);
        button = findViewById(R.id.btncolorpicker);

        button.setOnClickListener(v -> colorListener());
    }

    public void colorListener() {
         new ColorPickerDialog.Builder(this)
                .setTitle("ColorPicker Dialog")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton("Confirmar", (ColorEnvelopeListener) (envelope, fromUser) -> paint.setColor(envelope.getColor()))
                .setNegativeButton("Cancelar", (dialogInterface, i) -> dialogInterface.dismiss())
                .attachAlphaSlideBar(true) // the default value is true.
                .attachBrightnessSlideBar(true)  // the default value is true.
                .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                .show();
    }

}