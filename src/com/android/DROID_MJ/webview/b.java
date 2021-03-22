package com.android.DROID_MJ.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.widget.TextView;

public class b extends AppCompatActivity {
    private AppCompatButton a;
    private TextView b;
    private TextView c;
    private Typeface d;
    private Typeface e;
    private SharedPreferences f;
    private String g;
    private SharedPreferences.Editor h;

    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.g);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a);
        this.a = (AppCompatButton) findViewById(R.id.c);
        this.b = (TextView) findViewById(R.id.a);
        this.c = (TextView) findViewById(R.id.b);
        this.d = Typeface.createFromAsset(getAssets(), "fonts/b.ttf");
        this.e = Typeface.createFromAsset(getAssets(), "fonts/c.ttf");
        this.b.setTypeface(this.e);
        this.c.setTypeface(this.d);
        this.a.setTypeface(this.d);
        this.a.setText("Continue");
        this.b.setText("Welcome to WebView");
        this.c.setText("I Developed For The Future");
        this.a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b1();
                b.this.f = getApplicationContext().getSharedPreferences("MyFirstRun", 0);
                b.this.g = "welcome";
                b.this.h = b.this.f.edit();
                b.this.h.putString("MyFirstRun", b.this.g);
                b.this.h.commit();
                finish();
            }
        });
    }
  
    private void b1() {
       startActivity(new Intent(this, c.class));
    }
}