package com.example.justknow.ui.disease;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.justknow.databinding.SolutionToDiseaseBinding;

public class diseaseDescription extends Fragment {
    private SolutionToDiseaseBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = SolutionToDiseaseBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }



}
