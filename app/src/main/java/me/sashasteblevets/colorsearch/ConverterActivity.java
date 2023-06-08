package me.sashasteblevets.colorsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class ConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        MaterialButton back = findViewById(R.id.back);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        MaterialButton convert = findViewById(R.id.convert);

        convert.setOnClickListener(view -> {
            SeekBar red = findViewById(R.id.red);
            SeekBar green = findViewById(R.id.green);
            SeekBar blue = findViewById(R.id.blue);

            int redColor = red.getProgress();
            int blueColor = blue.getProgress();
            int greenColor = green.getProgress();

            String hexColor = String.format("#%02X%02X%02X", redColor, greenColor, blueColor);

            TextView result = findViewById(R.id.result);

            result.setText(hexColor);
        });
    }
}