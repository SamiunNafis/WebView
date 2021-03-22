package com.android.DROID_MJ.webview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import java.util.List;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;

@SuppressWarnings("deprecation")
public class e extends PreferenceActivity {
    private Toolbar mToolBar;
    private TextView b;
    private Typeface m;
    private int o;
    private int p;
    
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp.getBoolean("autoUpdate", false) == false) {
            setTheme(R.style.d);
        } else {
            setTheme(R.style.e);
        }
        super.onCreate(savedInstanceState);
        e1();
        e2();

    }

    private void e1() {
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        View content = root.getChildAt(0);
        LinearLayout toolbarContainer = (LinearLayout) View.inflate(this, R.layout.j, null);
        root.removeAllViews();
        toolbarContainer.addView(content);
        root.addView(toolbarContainer);
        mToolBar = (Toolbar) toolbarContainer.findViewById(R.id.b7);
        b = (TextView) toolbarContainer.findViewById(R.id.b8);
        this.m = Typeface.createFromAsset(getAssets(), "fonts/b.ttf");
        this.o = ContextCompat.getColor(getApplicationContext(),R.color.c);
        this.p = ContextCompat.getColor(getApplicationContext(),R.color.b);
        b.setTypeface(this.m); 
        b.setText("Settings");
        SharedPreferences sp1 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp1.getBoolean("autoUpdate", false) == false) {
            mToolBar.setBackgroundResource(R.color.b);
            b.setTextColor(this.o);
            mToolBar.setNavigationIcon(R.drawable.p);
        } else {
            this.b.setTextColor(this.p);
            mToolBar.setBackgroundResource(R.color.n);
            mToolBar.setNavigationIcon(R.drawable.q);
        }
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e3();
            }
        });
    }


    private void e2() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            String action = getIntent().getAction();
            if (action == null) {
                setTitle("Settings");
                addPreferencesFromResource(R.xml.b);
            } else if (action.equals("general")) {
                setTitle("General");
                addPreferencesFromResource(R.xml.c);
            } else if (action.equals("privacy")) {
                setTitle("Privacy & Security");
                addPreferencesFromResource(R.xml.g);
            } else if (action.equals("advanced")) {
                setTitle("Advanced");
                addPreferencesFromResource(R.xml.f);
            } else if (action.equals("bandwidth")) {
                setTitle("Data Saver");
                addPreferencesFromResource(R.xml.e);
            } else if (action.equals("labs")) {
                setTitle("Other");
                addPreferencesFromResource(R.xml.d);
            }
        }
    }

    private void e3() {
        finish();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onBuildHeaders(List<Header> a) {
        super.onBuildHeaders(a);
        loadHeadersFromResource(R.xml.b, a);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected boolean isValidFragment(String a) {
        return a.equals(n.class.getName());
    }
}