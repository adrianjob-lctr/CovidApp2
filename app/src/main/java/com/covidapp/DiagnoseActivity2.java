/*package com.covidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class DiagnoseActivity2 extends AppCompatActivity {
    private MaterialCardView contactView, travelView, frontlineView;

    private MaterialButton submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_diagnose2);

        contactView     = findViewById(R.id.dia2_act_contact_cv);
        travelView      = findViewById(R.id.dia2_act_travel_cv);
        frontlineView   = findViewById(R.id.dia2_act_frontliner_cv);
        submitButton    = findViewById(R.id.dia_act_sbmt_btn);

        contactView.setOnClickListener(view -> contactView.toggle());
        travelView.setOnClickListener(view -> travelView.toggle());
        frontlineView.setOnClickListener(view -> frontlineView.toggle());

        submitButton.setOnClickListener(view -> {

            ArrayList<String> selectedItems = new ArrayList<String>();
/*
            if(feverCardView.isChecked()) selectedItems.add("Fever");
            if(coughCardView.isChecked()) selectedItems.add("Cough");
            if(fatigueCardView.isChecked()) selectedItems.add("Fatigue");
            if(acheCardView.isChecked()) selectedItems.add("Myalgia");
            if(soreThroatCardView.isChecked()) selectedItems.add("SoreThroat");
            if(diffBreathCardView.isChecked()) selectedItems.add("Dyspnea");
            if(headacheCardView.isChecked()) selectedItems.add("Headache");
            if(ltsCardView.isChecked()) selectedItems.add("Aguesia_Anosmia");
            if(travelOutsideCardView.isChecked()) selectedItems.add("TravelledOutside");
            if(closeContactCardView.isChecked()) selectedItems.add("CloseContact");
            if(frontlinerCardView.isChecked()) selectedItems.add("Frontliner");

            Context context = DiagnoseActivity.this;
            InferenceEngine inferenceEngine = new InferenceEngine(context);
            double res = inferenceEngine.getProbability(selectedItems) * 100;


            Intent result = new Intent(this, ResultActivity.class);

            startActivity(result);
        });

    }
}
*/