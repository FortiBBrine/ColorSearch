package me.sashasteblevets.colorsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton util1 = findViewById(R.id.util1);
        MaterialButton util2 = findViewById(R.id.util2);

        util1.setOnClickListener(view -> {
            Intent intent = new Intent(this, OppositeColorActivity.class);
            startActivity(intent);
        });

        util2.setOnClickListener(view -> {
            Intent intent = new Intent(this, ConverterActivity.class);
            startActivity(intent);
        });
    }
}