package me.sashasteblevets.colorsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class ConverterRGBAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_rgba);

        MaterialButton back = findViewById(R.id.back);

        back.setOnClickListener(view -> {
            finish();
        });

        SeekBar red = findViewById(R.id.red);
        SeekBar green = findViewById(R.id.green);
        SeekBar blue = findViewById(R.id.blue);
        SeekBar alpha = findViewById(R.id.alpha);

        TextView redTextView = findViewById(R.id.red_text);
        TextView greenTextView = findViewById(R.id.green_text);
        TextView blueTextView = findViewById(R.id.blue_text);
        TextView alphaTextView = findViewById(R.id.alpha_text);

        View color = findViewById(R.id.color);

        TextView result = findViewById(R.id.result);

        redTextView.setText(String.format("%s [%d]", getString(R.string.red), red.getProgress()));
        greenTextView.setText(String.format("%s [%d]", getString(R.string.green), green.getProgress()));
        blueTextView.setText(String.format("%s [%d]", getString(R.string.blue), blue.getProgress()));
        alphaTextView.setText(String.format("%s [%.2f]", getString(R.string.alpha), alpha.getProgress() / 100.0));

        int redColor = red.getProgress();
        int blueColor = blue.getProgress();
        int greenColor = green.getProgress();
        long alphaColor = Math.round((alpha.getProgress() / 100.0) * 255);

        String hexColor = String.format("#%02X%02X%02X%02X", redColor, greenColor, blueColor, alphaColor);
        result.setText(hexColor);
        color.setBackgroundColor(Color.parseColor(hexColor));

        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                redTextView.setText(String.format("%s [%d]", getString(R.string.red), red.getProgress()));
                greenTextView.setText(String.format("%s [%d]", getString(R.string.green), green.getProgress()));
                blueTextView.setText(String.format("%s [%d]", getString(R.string.blue), blue.getProgress()));
                alphaTextView.setText(String.format("%s [%.2f]", getString(R.string.alpha), alpha.getProgress() / 100.0));

                int redColor = red.getProgress();
                int blueColor = blue.getProgress();
                int greenColor = green.getProgress();
                long alphaColor = Math.round((alpha.getProgress() / 100.0) * 255);

                String hexColor = String.format("#%02X%02X%02X%02X", redColor, greenColor, blueColor, alphaColor);
                result.setText(hexColor);
                color.setBackgroundColor(Color.parseColor(hexColor));

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
        alpha.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

}