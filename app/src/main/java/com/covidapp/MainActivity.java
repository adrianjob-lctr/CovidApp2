package com.covidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton startButton, learnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.main_act_start_btn);
        learnButton = findViewById(R.id.main_act_learn_btn);

        new smile.License(
                "SMILE LICENSE 4554387b 09cabaa1 36cc2297 " +
                        "THIS IS AN EVALUATION LICENSE THAT " +
                        "CANNOT BE USED FOR COMMERCIAL PURPOSES. " +
                        "Serial #: b6jwij3ilw7d7w9xljvsiwsq2 " +
                        "Valid until: 2021-11-19 " +
                        "Issued for: Mark (mrobrigado03@gmail.com) " +
                        "Organization: Polytechnic University of the Philippines " +
                        "Issued by BayesFusion activation server",
                new byte[]{
                        -66, 47, 118, -42, -72, 52, -93, 59, 51, 86, 99, 63, 40, -111, 109, -93,
                        49, 117, 107, -120, 24, -15, 48, 16, -10, 67, -59, -6, -107, 21, -78, -5,
                        39, 36, 21, 81, 29, 65, -65, 36, 27, 31, -81, -90, -43, 83, -68, -125,
                        59, 113, 2, -46, 126, 78, 116, 127, -70, 16, 99, 18, -44, -104, -82, -101
                }
        );

        startButton.setOnClickListener(view -> {
            Intent demographics = new Intent(this, DemographicActivity.class);
            startActivity(demographics);
        });

        learnButton.setOnClickListener(view -> {
            Intent learn = new Intent(this, LearnMoreActivity.class);
            startActivity(learn);
        });
    }


}