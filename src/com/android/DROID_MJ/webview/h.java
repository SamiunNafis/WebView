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
public class h extends PreferenceActivity {
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
        b.setText("About WebView");
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
                setTitle("About WebView");
                addPreferencesFromResource(R.xml.h);
            } else if (action.equals("aboutWebView")) {
                setTitle("DROID_MJ");
                addPreferencesFromResource(R.xml.i);
            } else if (action.equals("trans")) {
                setTitle("Translations");
                addPreferencesFromResource(R.xml.j);
            } else if (action.equals("open")) {
                setTitle("Open Sources Licenses");
                addPreferencesFromResource(R.xml.f);
            } 
        }
    }

    private void e3() {
        finish();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onBuildHeaders(List<Header> a) {
        super.onBuildHeaders(a);
        loadHeadersFromResource(R.xml.h, a);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected boolean isValidFragment(String a) {
        return a.equals(i.class.getName());
    }
}