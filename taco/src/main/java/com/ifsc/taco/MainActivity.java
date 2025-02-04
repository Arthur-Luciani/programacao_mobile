package com.ifsc.taco;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "taco_converted.sqlite";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void copyDatabase() {
        try {
            InputStream inputStream = getAssets().open(DATABASE_NAME);
            File outFile = getDatabasePath(DATABASE_NAME);

            OutputStream outputStream = Files.newOutputStream(outFile.toPath());

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            Log.e("MainActivity", "Error copying database", e);
        }
    }

    private void listAllFoods(SQLiteDatabase db) {
        Cursor cursor = db.rawQuery("SELECT * FROM foods", null);
        if (cursor.moveToFirst()) {
            do {
                int columnIndex = cursor.getColumnIndex("name");
                if (columnIndex == -1) {
                    Log.e("MainActivity", "Column 'name' not found");
                    return;
                }
                String foodName = cursor.getString(columnIndex);
                Log.d("MainActivity", "Food: " + foodName);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}