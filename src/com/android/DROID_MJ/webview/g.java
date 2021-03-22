package com.android.DROID_MJ.webview;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;

public class g extends DialogPreference {

    public g(Context a, AttributeSet b) {
        super(a, b);
    }

    protected void onDialogClosed(boolean a) {
        super.onDialogClosed(a);
        persistBoolean(a);
    }
}