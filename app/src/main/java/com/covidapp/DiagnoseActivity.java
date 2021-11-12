package com.covidapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class DiagnoseActivity extends AppCompatActivity {

    // Variable declaration
    private MaterialCardView feverCardView, coughCardView, fatigueCardView,
                             acheCardView, runny_noseCardView, sore_throatCardView,
                             diff_breathCardView, diarrheaCardView, headacheCardView,
                             loss_taste_smellCardView,contactView, travelView, frontlineView;
    private MaterialButton submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_diagnose);

        // Initialization of variables
        feverCardView = findViewById(R.id.dia_act_fvr_cv);
        coughCardView = findViewById(R.id.dia_act_cough_cv);
        fatigueCardView = findViewById(R.id.dia_act_ftg_cv);
        acheCardView = findViewById(R.id.dia_act_ache_cv);
        //runny_noseCardView = findViewById(R.id.dia_act_rn_cv);
        sore_throatCardView = findViewById(R.id.dia_act_st_cv);
        diff_breathCardView = findViewById(R.id.dia_act_db_cv);
        diarrheaCardView = findViewById(R.id.dia_act_diar_cv);
        headacheCardView = findViewById(R.id.dia_act_hdache_cv);
        loss_taste_smellCardView = findViewById(R.id.dia_act_lts_cv);
        contactView     = findViewById(R.id.dia2_act_contact_cv);
        travelView      = findViewById(R.id.dia2_act_travel_cv);
        frontlineView   = findViewById(R.id.dia2_act_frontliner_cv);
        submitButton    = findViewById(R.id.dia_act_sbmt_btn);

        // Set onClickListener() to variables
        feverCardView.setOnClickListener(view -> feverCardView.toggle());
        coughCardView.setOnClickListener(view -> coughCardView.toggle());
        coughCardView.setOnClickListener(view -> coughCardView.toggle());
        fatigueCardView.setOnClickListener(view -> fatigueCardView.toggle());
        acheCardView.setOnClickListener(view -> acheCardView.toggle());
        //runny_noseCardView.setOnClickListener(view -> runny_noseCardView.toggle());
        sore_throatCardView.setOnClickListener(view -> sore_throatCardView.toggle());
        diff_breathCardView.setOnClickListener(view -> diff_breathCardView.toggle());
        diarrheaCardView.setOnClickListener(view -> diarrheaCardView.toggle());
        headacheCardView.setOnClickListener(view -> headacheCardView.toggle());
        loss_taste_smellCardView.setOnClickListener(view -> loss_taste_smellCardView.toggle());
        contactView.setOnClickListener(view -> contactView.toggle());
        travelView.setOnClickListener(view -> travelView.toggle());
        frontlineView.setOnClickListener(view -> frontlineView.toggle());

        submitButton.setOnClickListener(view -> {

            ArrayList<String> selectedItems = new ArrayList<>();

            if(feverCardView.isChecked()) selectedItems.add("Fever");
            if(coughCardView.isChecked()) selectedItems.add("Cough");
            if(fatigueCardView.isChecked()) selectedItems.add("Fatigue");
            if(acheCardView.isChecked()) selectedItems.add("Myalgia");
            if(sore_throatCardView.isChecked()) selectedItems.add("SoreThroat");
            if(diff_breathCardView.isChecked()) selectedItems.add("Dyspnea");
            if(headacheCardView.isChecked()) selectedItems.add("Headache");
            if(loss_taste_smellCardView.isChecked()) selectedItems.add("Aguesia_Anosmia");
            if(travelView.isChecked()) selectedItems.add("TravelledOutside");
            if(contactView.isChecked()) selectedItems.add("CloseContact");
            if(frontlineView.isChecked()) selectedItems.add("Frontliner");

            Context context = DiagnoseActivity.this;
            InferenceEngine inferenceEngine = new InferenceEngine(context);
            double res = inferenceEngine.getProbability(selectedItems) * 100;

            Intent result = new Intent(this, ResultActivity.class);
            result.putExtra("result", res);
            startActivity(result);
            finish();
        });
    }
}
