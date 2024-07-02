package com.example.justknow.ui.data_entry.utils;

import java.util.HashMap;
import java.util.Map;

public class DataEntryConstants {

    public static String FATIGUE = "fatigue";
    public static String WEAK = "weak";
    public static String PALE_SKIN = "pale_skin";
    public static String DIZZY = "dizzy";
    public static String SHORTNESS_BREATH = "shortness_breath";
    public static String THIRST_INCREASED = "thirst_increased";
    public static String FREQUENT_URINATION = "frequent_urination";
    public static String SWEATING = "sweating";
    public static String PELVIC_PAIN = "pelvic_pain";
    public static String BURNING_URINATING = "burning_urinating";
    public static String UNUSUAL_URINE = "unusual_urine";
    public static String SWOLLEN_GUMS = "swollen_gums";
    public static String DARK_GUMS = "dark_gums";
    public static String GUM_INFLAMMATION = "gum_inflammation";
    public static String TENDER_GUMS = "tender_gums";
    public static String GUMS_BLEED = "gums_bleed";
    public static String OVERWEIGHT = "overweight";
    public static String HIGH_BLOOD_PRESSURE = "High Blood Pressure";
    public static String ANEMIA = "Anemia";
    public static String GINGIVITIS = "Gingivitis";
    public static String URINARY_TRACT_INFECTIONS = "Urinary Tract Infections";
    public static String GESTATIONAL_DIABETES = "Gestational Diabetes";

    public static Map<String, String[]> DISEASE_LIST = new HashMap<String, String[]>() {{
        put(ANEMIA, new String[]{FATIGUE, WEAK, PALE_SKIN, DIZZY});
        put(GESTATIONAL_DIABETES, new String[]{
                THIRST_INCREASED, FREQUENT_URINATION, SWEATING, OVERWEIGHT, FATIGUE});
        put(HIGH_BLOOD_PRESSURE, new String[]{
                DIZZY, HIGH_BLOOD_PRESSURE, FATIGUE, SHORTNESS_BREATH});
        put(URINARY_TRACT_INFECTIONS, new String[]{
                FREQUENT_URINATION, BURNING_URINATING, UNUSUAL_URINE, PELVIC_PAIN});
        put(GINGIVITIS, new String[]{
                SWOLLEN_GUMS, DARK_GUMS, GUM_INFLAMMATION, TENDER_GUMS, GUMS_BLEED});
    }};
}
