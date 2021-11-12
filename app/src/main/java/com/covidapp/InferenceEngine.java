package com.covidapp;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import smile.Network;

public class InferenceEngine {
    private Context context;

    public InferenceEngine(Context context) {
        this.context = context;
    }

    public double getProbability(ArrayList<String> selectedItems) {

        Network net = new Network();

        try {
            InputStream is = context.getAssets().open("Covid.xdsl");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            for (String line; (line = br.readLine()) != null; ) {
                sb.append(line).append('\n');
            }
            net.readString(sb.toString());
        } catch (IOException e) {
            Log.e("IOExceptionError", e.toString(), e.getCause());
        }

        for(String selectedItem : selectedItems) {
            net.setEvidence(selectedItem, "True");
        }

        net.updateBeliefs();
        double[] beliefs = net.getNodeValue("Covid");
        return beliefs[0];
    }
}
