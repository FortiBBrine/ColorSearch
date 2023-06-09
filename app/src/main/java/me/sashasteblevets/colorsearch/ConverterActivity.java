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

        SeekBar red = findViewById(R.id.red);
        SeekBar green = findViewById(R.id.green);
        SeekBar blue = findViewById(R.id.blue);

        TextView redTextView = findViewById(R.id.red_text);
        TextView greenTextView = findViewById(R.id.green_text);
        TextView blueTextView = findViewById(R.id.blue_text);

        redTextView.setText(String.format("%s [%d]", getString(R.string.red), red.getProgress()));
        greenTextView.setText(String.format("%s [%d]", getString(R.string.green), green.getProgress()));
        blueTextView.setText(String.format("%s [%d]", getString(R.string.blue), blue.getProgress()));

        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                redTextView.setText(String.format("%s [%d]", getString(R.string.red), red.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                greenTextView.setText(String.format("%s [%d]", getString(R.string.green), green.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                blueTextView.setText(String.format("%s [%d]", getString(R.string.blue), blue.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        convert.setOnClickListener(view -> {

            int redColor = red.getProgress();
            int blueColor = blue.getProgress();
            int greenColor = green.getProgress();

            String hexColor = String.format("#%02X%02X%02X", redColor, greenColor, blueColor);

            TextView result = findViewById(R.id.result);

            result.setText(hexColor);
        });
    }
}