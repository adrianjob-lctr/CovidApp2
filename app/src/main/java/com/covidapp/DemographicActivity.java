

package com.covidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class DemographicActivity extends AppCompatActivity {

    private MaterialButton continueButton;
    private AutoCompleteTextView ageAutoComplete, regionAutoComplete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_demographic);

        continueButton = findViewById(R.id.dem_act_cont_btn);
        ageAutoComplete = findViewById(R.id.dem_act_age_actv);
        regionAutoComplete = findViewById(R.id.dem_act_region_actv);

        // TODO gender radio buttons

        String[] ageGroupItems = {
                "below 10", "11 to 18", "19 to 39", "40 to 59", "60 and above"};
        ArrayAdapter<String> ageGroupAdapter = new ArrayAdapter<>(this, R.layout.list_item, ageGroupItems);
        ageAutoComplete.setAdapter(ageGroupAdapter);

        String[] regionGroupItems = {
                "I: Ilocos Region", "II: Cagayan Valley", "III: Central Luzon", "IV‑A: CALABARZON",
                "IV‑B: MIMAROPA", "V: Bicol Region", "VI: Western Visayas", "VII: Central Visayas",
                "VIII: Eastern Visayas", "IX: Zamboanga Peninsula", "X: Northern Mindanao",
                "XI: Davao Region", "XII: SOCCSKSARGEN", "XIII: Caraga", "NCR", "CAR", "BARMM"};
        ArrayAdapter<String> regionGroupAdapter = new ArrayAdapter<>(this, R.layout.list_item, regionGroupItems);
        regionAutoComplete.setAdapter(regionGroupAdapter);

/**        continueButton.setOnClickListener(view -> {
                    Intent diagnose = new Intent(this, DiagnoseActivity.class);
                    startActivity(diagnose);
        }
 **/
        /***
         * <summary>
         *     Debug where it needs to display error if incomplete information.
         * </summary>
         */       continueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                if(ageGroupAdapter != null || regionAutoComplete != null){
                    goToDiagnoseActivity();
                }
                else{
                    warningDialog();
                }
            }
        });
    }

    // A button direct to the next page, WITH COMPLETE INPUT INFORMATION

    public void goToDiagnoseActivity(){
        Intent diagnose = new Intent(this, DiagnoseActivity.class);
        startActivity(diagnose);
    }
    public void warningDialog(){
        WarningDialog warningDialog = new WarningDialog();
        warningDialog.show(getSupportFragmentManager(), "");
    }


}

