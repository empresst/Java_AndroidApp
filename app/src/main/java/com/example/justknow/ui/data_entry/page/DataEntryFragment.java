package com.example.justknow.ui.data_entry.page;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.fragment.app.Fragment;

import com.example.justknow.R;
import com.example.justknow.databinding.FragmentDataEntryBinding;
import com.example.justknow.ui.data_entry.utils.DataEntryConstants;

import java.util.ArrayList;
import java.util.HashSet;

public class DataEntryFragment extends Fragment {

    private FragmentDataEntryBinding binding;

    private final HashSet<String> symptoms = new HashSet<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDataEntryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        updateBottomBar();
        binding.previousPage.setOnClickListener(this::onPreviousPageButtonClicked);
        binding.nextPage.setOnClickListener(this::onNextPageButtonClicked);

        setListenersForSymptoms();
    }

    private void onPreviousPageButtonClicked(View view) {
        binding.formFlipper.showPrevious();
        updateBottomBar();
    }

    private void onNextPageButtonClicked(View view) {
        if (binding.formFlipper.getDisplayedChild() == binding.formFlipper.getChildCount() - 1) {
            onSubmitButtonClicked();
            return;
        }
        binding.formFlipper.showNext();
        updateBottomBar();
    }

    public void updateBottomBar() {
        int currentChild = binding.formFlipper.getDisplayedChild();
        binding.previousPage.setEnabled(currentChild > 0);
        binding.nextPage.setText(currentChild == binding.formFlipper.getChildCount() - 1
                ? R.string.submit
                : R.string.next);
    }

    public void onSubmitButtonClicked() {
        Intent intent = new Intent(requireContext(), ShowDiseaseActivity.class);
        intent.putStringArrayListExtra("symptoms", new ArrayList<>(symptoms));
        if (!binding.questionSetView2.heightInput.getText().toString().isEmpty()) {
            intent.putExtra("height",
                    Double.parseDouble(binding.questionSetView2.heightInput.getText().toString()));
        }
        if (!binding.questionSetView2.weightInput.getText().toString().isEmpty()) {
            intent.putExtra("weight",
                    Double.parseDouble(binding.questionSetView2.weightInput.getText().toString()));
        }
        if (!binding.questionSetView2.bloodPressureHighInput.getText().toString().isEmpty()) {
            intent.putExtra("blood-pressure-high",
                    Double.parseDouble(
                            binding.questionSetView2.bloodPressureHighInput.getText().toString()));
        }
        if (!binding.questionSetView2.bloodPressureLowInput.getText().toString().isEmpty()) {
            intent.putExtra("blood-pressure-low",
                    Double.parseDouble(
                            binding.questionSetView2.bloodPressureLowInput.getText().toString()));
        }
        startActivity(intent);
    }

    private void setListenersForSymptoms() {
        // Fatigue
        setListenerForSingleQuestion(binding.questionSetView1.fatigue,
                binding.questionSetView1.fatigueCheckbox,
                binding.questionSetView1.fatigueText, DataEntryConstants.FATIGUE);

        // Weak
        setListenerForSingleQuestion(binding.questionSetView1.weak,
                binding.questionSetView1.weakCheckbox,
                binding.questionSetView1.weakText, DataEntryConstants.WEAK);

        // Pale Skin
        setListenerForSingleQuestion(binding.questionSetView1.paleSkin,
                binding.questionSetView1.paleSkinCheckbox,
                binding.questionSetView1.paleSkinText, DataEntryConstants.PALE_SKIN);

        // Dizzy
        setListenerForSingleQuestion(binding.questionSetView1.dizzy,
                binding.questionSetView1.dizzyCheckbox,
                binding.questionSetView1.dizzyText, DataEntryConstants.DIZZY);

        // Shortness Breath
        setListenerForSingleQuestion(binding.questionSetView1.shortnessBreath,
                binding.questionSetView1.shortnessBreathCheckbox,
                binding.questionSetView1.shortnessBreathText, DataEntryConstants.SHORTNESS_BREATH);

        // Thirst Increased
        setListenerForSingleQuestion(binding.questionSetView1.thirstIncreased,
                binding.questionSetView1.thirstIncreasedCheckbox,
                binding.questionSetView1.thirstIncreasedText, DataEntryConstants.THIRST_INCREASED);

        // Frequent Urination
        setListenerForSingleQuestion(binding.questionSetView1.frequentUrination,
                binding.questionSetView1.frequentUrinationCheckbox,
                binding.questionSetView1.frequentUrinationText,
                DataEntryConstants.FREQUENT_URINATION);

        // Sweating
        setListenerForSingleQuestion(binding.questionSetView2.sweating,
                binding.questionSetView2.sweatingCheckbox,
                binding.questionSetView2.sweatingText, DataEntryConstants.SWEATING);

        // Pelvic Pain
        setListenerForSingleQuestion(binding.questionSetView2.pelvicPain,
                binding.questionSetView2.pelvicPainCheckbox,
                binding.questionSetView2.pelvicPainText, DataEntryConstants.PELVIC_PAIN);

        // Burning Urinating
        setListenerForSingleQuestion(binding.questionSetView2.burningUrinating,
                binding.questionSetView2.burningUrinatingCheckbox,
                binding.questionSetView2.burningUrinatingText,
                DataEntryConstants.BURNING_URINATING);

        // Unusual Urine
        setListenerForSingleQuestion(binding.questionSetView2.unusualUrine,
                binding.questionSetView2.unusualUrineCheckbox,
                binding.questionSetView2.unusualUrineText, DataEntryConstants.UNUSUAL_URINE);

        // Swollen Gums
        setListenerForSingleQuestion(binding.questionSetView3.swollenGums,
                binding.questionSetView3.swollenGumsCheckbox,
                binding.questionSetView3.swollenGumsText, DataEntryConstants.SWOLLEN_GUMS);

        // Dark Gums
        setListenerForSingleQuestion(binding.questionSetView3.darkGums,
                binding.questionSetView3.darkGumsCheckbox,
                binding.questionSetView3.darkGumsText, DataEntryConstants.DARK_GUMS);

        // Gum Inflammation
        setListenerForSingleQuestion(binding.questionSetView3.gumInflammation,
                binding.questionSetView3.gumInflammationCheckbox,
                binding.questionSetView3.gumInflammationText, DataEntryConstants.GUM_INFLAMMATION);

        // Tender Gums
        setListenerForSingleQuestion(binding.questionSetView3.tenderGums,
                binding.questionSetView3.tenderGumsCheckbox,
                binding.questionSetView3.tenderGumsText, DataEntryConstants.TENDER_GUMS);

        // Gums Bleed
        setListenerForSingleQuestion(binding.questionSetView3.gumsBleed,
                binding.questionSetView3.gumsBleedCheckbox,
                binding.questionSetView3.gumsBleedText, DataEntryConstants.GUMS_BLEED);
    }

    private void setListenerForSingleQuestion(LinearLayout question,
                                              AppCompatCheckBox questionCheckbox,
                                              TextView questionText, String key) {
        question.setOnClickListener(v -> {
            questionCheckbox.setChecked(!questionCheckbox.isChecked());
            setTextViewViaCheck(questionText, questionCheckbox.isChecked(), key);
        });
        questionCheckbox.setOnCheckedChangeListener((v, checked) ->
                setTextViewViaCheck(questionText, checked, key));
        questionText.setOnClickListener(v -> {
            questionCheckbox.setChecked(!questionCheckbox.isChecked());
            setTextViewViaCheck(questionText, questionCheckbox.isChecked(), key);
        });
    }

    private void setTextViewViaCheck(TextView text, boolean checked, String key) {
        text.setTypeface(null, checked ? Typeface.BOLD : Typeface.NORMAL);
        if (checked) {
            symptoms.add(key);
        } else {
            symptoms.remove(key);
        }
    }
}
