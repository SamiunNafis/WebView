package com.android.DROID_MJ.webview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceFragment;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class i extends PreferenceFragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String action = getArguments().getString("category");
        if (action != null) {
            if (action.equals("aboutWebView")) {
                addPreferencesFromResource(R.xml.i);
            } else if (action.equals("trans")) {
                addPreferencesFromResource(R.xml.j);
            } else if (action.equals("open")) {
                addPreferencesFromResource(R.xml.f);
            } 
        }
    }
}