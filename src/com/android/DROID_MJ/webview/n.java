package com.android.DROID_MJ.webview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceFragment;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class n extends PreferenceFragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String action = getArguments().getString("category");
        if (action != null) {
            if (action.equals("general")) {
                addPreferencesFromResource(R.xml.c);
            } else if (action.equals("privacy")) {
                addPreferencesFromResource(R.xml.g);
            } else if (action.equals("advanced")) {
                addPreferencesFromResource(R.xml.f);
            } else if (action.equals("bandwidth")) {
                addPreferencesFromResource(R.xml.e);
            } else if (action.equals("labs")) {
                addPreferencesFromResource(R.xml.d);
            }
        }
    }
}