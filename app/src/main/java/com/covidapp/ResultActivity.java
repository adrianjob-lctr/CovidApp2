package com.covidapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.ramijemli.percentagechartview.PercentageChartView;

public class ResultActivity extends AppCompatActivity {

    private PercentageChartView resultPcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultPcv = findViewById(R.id.res_act_result_pcv);

        double result = getIntent().getDoubleExtra("result", 0);

        resultPcv.setProgress((float)result, true);
        resultPcv.setTextFormatter(progress -> String.format("%.2f", result));
    }
}

