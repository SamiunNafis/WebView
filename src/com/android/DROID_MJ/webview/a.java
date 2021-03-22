package com.android.DROID_MJ.webview;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.graphics.Typeface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class a extends AppCompatActivity {
    private TextView a;
    private Timer c;
    private int d = 0;
    private Typeface e;
    private int f;
    private SharedPreferences g;
    private String h = "firstRun";
    private String i;
  
    protected void onCreate(Bundle a) {
        setTheme(R.style.f);
        super.onCreate(a);
        setContentView(R.layout.b);
        this.a = (TextView) findViewById(R.id.e);
        this.e = Typeface.createFromAsset(getAssets(), "fonts/a.ttf");
        this.f = ContextCompat.getColor(getApplicationContext(), R.color.b);
        this.a.setText("WebView");
        this.a.setTypeface(this.e);
        this.a.setTextColor(this.f);
        this.c = new Timer();
        this.c.schedule(new TimerTask() {
            public void run() {
                if (a.this.d < 30){
                    runOnUiThread(new Runnable() {
                        public void run() {
                        }
                    });
                    a.this.d++;
                } else {
                    a.this.c.cancel();
                    a.this.g = getApplicationContext().getSharedPreferences("MyFirstRun", 0);
                    a.this.i = a.this.g.getString("MyFirstRun", a.this.h);
                    if (i.startsWith(a.this.h)) {
                        a2();
                    } else {
                        a1();
                    }
                    finish();
                }
            }
        }, 0, 30);
    }

    private void a1() {
        startActivity(new Intent(this, c.class));
    }

    private void a2() {
        startActivity(new Intent(this, b.class));
    }
}
