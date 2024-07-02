package com.example.justknow.ui.data_entry.page;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.justknow.databinding.ActivityShowDiseaseBinding;
import com.example.justknow.ui.data_entry.utils.DataEntryConstants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShowDiseaseActivity extends AppCompatActivity {

    private ActivityShowDiseaseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShowDiseaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        detectDisease();
    }

    private void detectDisease() {
        ArrayList<String> symptoms = getIntent().getStringArrayListExtra("symptoms");
        if (symptoms == null) return;
        if (isOverweight()) {
            symptoms.add(DataEntryConstants.OVERWEIGHT);
        }
        if (isHighBloodPressure()) {
            symptoms.add(DataEntryConstants.HIGH_BLOOD_PRESSURE);
        }
        setDescriptionText(new HashSet<>(symptoms));
    }

    private void setDescriptionText(Set<String> symptoms) {
        ArrayList<String> diseases = new ArrayList<>();
        for (Map.Entry<String, String[]> entry : DataEntryConstants.DISEASE_LIST.entrySet()) {
            boolean check = true;
            for (String s : entry.getValue()) {
                if (!symptoms.contains(s)) {
                    check = false;
                    break;
                }
            }
            if (check) diseases.add(entry.getKey());
        }
        binding.desc.setText(getDiseaseDescription(diseases));
    }

    private String getDiseaseDescription(ArrayList<String> diseases) {
        StringBuilder builder = new StringBuilder();
        int ind = 1;
        if (diseases.isEmpty()) {
            builder.append("You have nothing to worry about");
        } else {
            builder.append("You are possible affected by:").append("\n");
        }
        for (String disease : diseases) {
            builder.append(ind++).append(". ").append(disease).append("\n");
        }
        return builder.toString();
    }

    private boolean isOverweight() {
        return getBMI() >= 25;
    }

    private double getBMI() {
        double weight = getIntent().getDoubleExtra("weight", -1);
        double height = getIntent().getDoubleExtra("height", -1);
        if (weight <= 0 || height <= 0) return -1;
        height *= 0.0254;
        return weight / (height * height);
    }

    private boolean isHighBloodPressure() {
        return getIntent().getDoubleExtra("blood-pressure-high", -1) > 120 ||
                getIntent().getDoubleExtra("blood-pressure-low", -1) > 80;
    }
}