package me.sashasteblevets.colorsearch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RevertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revert);

        MaterialButton back = findViewById(R.id.back);
        MaterialButton convert = findViewById(R.id.convert);
        TextView inputColor = findViewById(R.id.input_color);

        TextView redText = findViewById(R.id.red_text);
        TextView greenText = findViewById(R.id.green_text);
        TextView blueText = findViewById(R.id.blue_text);
        TextView alphaText = findViewById(R.id.alpha_text);

        SeekBar redSeekBar = findViewById(R.id.red);
        SeekBar greenSeekBar = findViewById(R.id.green);
        SeekBar blueSeekBar = findViewById(R.id.blue);
        SeekBar alphaSeekBar = findViewById(R.id.alpha);

        back.setOnClickListener(view -> {
            finish();
        });

        convert.setOnClickListener(view -> {
            String color = inputColor.getText().toString();

            if (!(isValidHexColor(color) || isValidHexColor(color))) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RevertActivity.this);
                builder.setTitle("Помилка")
                        .setMessage("Ваш колір не відповідає формату")
                        .setCancelable(false)
                        .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                return;
            }

            if (isValidHexColor(color)) {
                int hex = Color.parseColor(color);

                int red = (hex & 0xFF0000) >> 16;
                int green = (hex & 0xFF00) >> 8;
                int blue = (hex & 0xFF);

                alphaText.setVisibility(View.INVISIBLE);
                alphaSeekBar.setVisibility(View.INVISIBLE);

                redSeekBar.setProgress(red);
                greenSeekBar.setProgress(green);
                blueSeekBar.setProgress(blue);

                redText.setText(String.format("%s [%d]", getString(R.string.red), red));
                greenText.setText(String.format("%s [%d]", getString(R.string.green), green));
                blueText.setText(String.format("%s [%d]", getString(R.string.blue), blue));

            }

            if (isValidHexColorWithAlpha(color)) {
                int hex = Color.parseColor(color);
                int red = (hex & 0xFF000000) >>> 24;
                int green = (hex & 0x00FF0000) >> 16;
                int blue = (hex & 0x0000FF00) >> 8;
                int alpha = hex & 0x000000FF;

                alphaText.setVisibility(View.VISIBLE);
                alphaSeekBar.setVisibility(View.VISIBLE);

                redSeekBar.setProgress(red);
                greenSeekBar.setProgress(green);
                blueSeekBar.setProgress(blue);
                alphaSeekBar.setProgress(alpha);

                redText.setText(String.format("%s [%d]", getString(R.string.red), red));
                greenText.setText(String.format("%s [%d]", getString(R.string.green), green));
                blueText.setText(String.format("%s [%d]", getString(R.string.blue), blue));
                alphaText.setText(String.format("%s [%.2f]", getString(R.string.alpha), alpha / 255.0));

            }
        });
    }

    public static boolean isValidHexColor(String text) {
        String hexColorPattern = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
        Pattern pattern = Pattern.compile(hexColorPattern);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean isValidHexColorWithAlpha(String text) {
        String hexColorPattern = "^#([A-Fa-f0-9]{8})$";
        Pattern pattern = Pattern.compile(hexColorPattern);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}