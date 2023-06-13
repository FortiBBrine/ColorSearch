package me.sashasteblevets.colorsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
            finish();
        });

        SeekBar red = findViewById(R.id.red);
        SeekBar green = findViewById(R.id.green);
        SeekBar blue = findViewById(R.id.blue);

        TextView redTextView = findViewById(R.id.red_text);
        TextView greenTextView = findViewById(R.id.green_text);
        TextView blueTextView = findViewById(R.id.blue_text);

        View color = findViewById(R.id.color);

        TextView result = findViewById(R.id.result);

        redTextView.setText(String.format("%s [%d]", getString(R.string.red), red.getProgress()));
        greenTextView.setText(String.format("%s [%d]", getString(R.string.green), green.getProgress()));
        blueTextView.setText(String.format("%s [%d]", getString(R.string.blue), blue.getProgress()));
        int redColor = red.getProgress();
        int blueColor = blue.getProgress();
        int greenColor = green.getProgress();

        String hexColor = String.format("#%02X%02X%02X", redColor, greenColor, blueColor);
        color.setBackgroundColor(Color.parseColor(hexColor));

        result.setText(hexColor);

        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                redTextView.setText(String.format("%s [%d]", getString(R.string.red), red.getProgress()));
                greenTextView.setText(String.format("%s [%d]", getString(R.string.green), green.getProgress()));
                blueTextView.setText(String.format("%s [%d]", getString(R.string.blue), blue.getProgress()));
                int redColor = red.getProgress();
                int blueColor = blue.getProgress();
                int greenColor = green.getProgress();

                String hexColor = String.format("#%02X%02X%02X", redColor, greenColor, blueColor);
                color.setBackgroundColor(Color.parseColor(hexColor));

                result.setText(hexColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        red.setOnSeekBarChangeListener(onSeekBarChangeListener);
        green.setOnSeekBarChangeListener(onSeekBarChangeListener);
        blue.setOnSeekBarChangeListener(onSeekBarChangeListener);

    }
}