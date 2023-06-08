package me.sashasteblevets.colorsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class OppositeColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opposite_color);

        MaterialButton back = findViewById(R.id.back);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        MaterialButton convert = findViewById(R.id.convert);

        convert.setOnClickListener(view -> {
            TextView inputColor = findViewById(R.id.input_color);
            TextView outputColor = findViewById(R.id.output_color);

            String input = inputColor.getText().toString();

            String rgbHex = input.substring(1);

            int red = Integer.parseInt(rgbHex.substring(0, 2), 16);
            int green = Integer.parseInt(rgbHex.substring(2, 4), 16);
            int blue = Integer.parseInt(rgbHex.substring(4, 6), 16);

            int invertedRed = 255 - red;
            int invertedGreen = 255 - green;
            int invertedBlue = 255 - blue;

            String invertedHexColor = String.format("#%02X%02X%02X", invertedRed, invertedGreen, invertedBlue);

            outputColor.setText(invertedHexColor);
        });
    }
}