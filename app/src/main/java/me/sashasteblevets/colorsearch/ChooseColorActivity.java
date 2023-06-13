package me.sashasteblevets.colorsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

import yuku.ambilwarna.AmbilWarnaDialog;

public class ChooseColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_color);

        MaterialButton back = findViewById(R.id.back);

        back.setOnClickListener(view -> {
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
            finish();
        });

        MaterialButton choose = findViewById(R.id.choose);

        choose.setOnClickListener(view -> {
            AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, Color.BLACK, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                @Override
                public void onCancel(AmbilWarnaDialog dialog) {

                }

                @Override
                public void onOk(AmbilWarnaDialog dialog, int color) {

                }
            });
            dialog.show();
        });

    }
}