package com.android.DROID_MJ.webview;

import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.content.ClipData;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;

import android.support.v7.widget.Toolbar;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.TextView.OnEditorActionListener;
import android.view.inputmethod.EditorInfo;
import android.content.SharedPreferences;
import android.widget.LinearLayout;
import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import android.content.ClipboardManager;
import android.preference.PreferenceManager;


public class d extends AppCompatActivity {
    private int a;
    private WebView b;
    private ProgressBar c;
    private TextView d;
    private String e;
    private String f;
    private Toolbar i;
    private String j;
    private TextView k;
    private Typeface m;
    private LinearLayout n;
    private int o;
    private int p;
    private final int t = 100;
    private View y;
    private Toast z;
    private Intent a1;
    private File a2;
    private FileOutputStream a3;
    private OutputStreamWriter a4;
    private AlertDialog.Builder a5;
    private LayoutInflater a6;
    private View a7;
    private AppCompatEditText a8;
    private String a9;
    private String a10;
    private View a11;
    private Toast a12;
    private View a13;
    private Toast a14;
    private int a15;
    private int a16;
    private ClipboardManager clipboard;
    private ClipData myClip;

    public class a extends WebViewClient {
        public void onPageFinished(WebView a, String b) {
            d.this.b.getSettings().setJavaScriptEnabled(true);
        d.this.b.loadUrl("javascript:this.document.location.href = 'source://' + encodeURI(document.documentElement.outerHTML);");
            d.this.d.setVisibility(View.VISIBLE);
  
            d.this.b.setVisibility(View.GONE);   
 
            d.this.c.setVisibility(View.GONE);
            d.this.f = a.getTitle().toString();
            d.this.k.setText(d.this.f + " - " + "Source Code");

        }

        public boolean shouldOverrideUrlLoading(WebView a, String b) {
            if (!b.startsWith("source://")) {
                return false;
            }
            try {
                d.this.e = URLDecoder.decode(b, "UTF-8").substring(9);
                d.this.d.setText(d.this.e);
            } catch (Throwable c) {
                d2();
                finish();
            }
            d.this.b.getSettings().setJavaScriptEnabled(false);
            return true;
        }

        @TargetApi(Build.VERSION_CODES.N)
        public boolean shouldOverrideUrlLoading(WebView a, WebResourceRequest b) {
            return true;
        }
    }

    public class b extends WebChromeClient {
        public void onProgressChanged(WebView a, int b) {      
            d.this.c.setProgress(b);
            if (b == 100) {
                d.this.c.setVisibility(View.GONE);
            }
        }
    }

    protected void onCreate(Bundle a) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp.getBoolean("autoUpdate", false) == false) {
            setTheme(R.style.d);
        } else {
            setTheme(R.style.e);
        }
        super.onCreate(a);
        setContentView(R.layout.d);
        this.b = (WebView)findViewById(R.id.a20);
        this.c = (ProgressBar) findViewById(R.id.m);
        this.d = (TextView) findViewById(R.id.b1);
clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        this.k = (TextView) findViewById(R.id.l);
        this.i = (Toolbar) findViewById(R.id.k);
        this.n = (LinearLayout) findViewById(R.id.n);
        this.m = Typeface.createFromAsset(getAssets(), "fonts/b.ttf");
        this.o = ContextCompat.getColor(getApplicationContext(),R.color.c);
        this.p = ContextCompat.getColor(getApplicationContext(),R.color.b);
        this.a = ContextCompat.getColor(getApplicationContext(),R.color.n);
        this.k.setTypeface(this.m);
        this.d.setTypeface(this.m);
        this.d.setText("Loading...");
        SharedPreferences sp1 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp1.getBoolean("autoUpdate", false) == false) {
            this.i.setBackgroundResource(R.color.b);
            this.d.setTextColor(this.o);
            this.k.setTextColor(this.o);
            this.n.setBackgroundColor(this.p);
            this.i.setNavigationIcon(R.drawable.p);
        } else {
            this.d.setTextColor(this.p);
            this.i.setBackgroundResource(R.color.n);
            this.k.setTextColor(this.p);
            this.n.setBackgroundColor(this.a);
            this.i.setNavigationIcon(R.drawable.q);
        }
        setSupportActionBar(this.i);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.i.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        this.c.setMax(this.t);
        if (getIntent().getExtras().getString("value") != null) {
        this.b.loadUrl(getIntent().getExtras().getString("value"));
        }
        this.b.addJavascriptInterface(this, "HTMLOUT");
        this.b.setWebViewClient(new a());
        this.b.setWebChromeClient(new b());
    }

    public boolean onCreateOptionsMenu(Menu a) {
        getMenuInflater().inflate(R.menu.b, a);
        MenuItem b = a.findItem(R.id.a15);
        MenuItem c = a.findItem(R.id.a14);
        MenuItem d = a.findItem(R.id.a18);
        MenuItem e = a.findItem(R.id.a17);
        MenuItem f = a.findItem(R.id.a16);
        if (this.d.getText().toString().length() == 0) {
            invalidateOptionsMenu();
            b.setVisible(false);
            c.setVisible(false);
            d.setVisible(false);
            e.setVisible(false);
            f.setVisible(false);
        } else {
            b.setVisible(true);
            c.setVisible(true);
            d.setVisible(true);
            e.setVisible(true);
            f.setVisible(true);
        }
        SharedPreferences sp5 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp5.getBoolean("autoUpdate", false) == false) {
            b.setIcon(ContextCompat.getDrawable(this, R.drawable.i)); 
            c.setIcon(ContextCompat.getDrawable(this, R.drawable.g)); 
        } else {
           b.setIcon(ContextCompat.getDrawable(this, R.drawable.j)); 
            c.setIcon(ContextCompat.getDrawable(this, R.drawable.h)); 
        }
        return super.onCreateOptionsMenu(a);
    }

    public boolean onOptionsItemSelected(MenuItem a) {
        switch (a.getItemId()) {
            case R.id.a16:
                d1();
                return true;
            case R.id.a17:
                d3();
                return true;
            case R.id.a18:
                finish();
                return true;
            case R.id.a14:
                d5();
                return true;
            case R.id.a15:
                d7();
                return true;
            default:
                return super.onOptionsItemSelected(a);
         }
    }

    public boolean onKeyDown(int a, KeyEvent b) {
        if (b.getAction() == 0) {
            switch (a) {
                case 4:
                    if (this.b.canGoBack()) {
                        this.b.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(a, b);
    }

    public void d1() {
     
   
myClip = ClipData.newPlainText("text", this.e);
clipboard.setPrimaryClip(myClip);
           d8();
        
    }

    public void d2() {
        this.y = getLayoutInflater().inflate(R.layout.g, (ViewGroup) findViewById(R.id.b11));
        ((TextView) this.y.findViewById(R.id.b12)).setText("Cant get source code.");
        this.z = new Toast(getApplicationContext());
        this.z.setDuration(0);
        this.z.setView(this.y);
        this.z.show();
    }

    public void d3() {
        this.a1 = new Intent("android.intent.action.SEND");
        this.a1.setType("text/plain");
        this.a1.putExtra("android.intent.extra.TEXT", this.e);
        startActivity(this.a1);
    }

    public void d4() {
        try {
             this.a2 = new File("/sdcard/WebView/Saved/" + this.j);
             this.a2.createNewFile();
             this.a3 = new FileOutputStream(this.a2);
             this.a4 = new OutputStreamWriter(this.a3);
             this.a4.append(this.e);
             this.a4.close();
             this.a3.close();
             d6();
        } catch (FileNotFoundException a) {
             d9();
        } catch (IOException b) {
        }
    }

    public void d5() {
        this.a5 = new AlertDialog.Builder(d.this);
        this.a6 = getLayoutInflater();
        this.a7 = this.a6.inflate(R.layout.f, null);
        this.a5.setCancelable(true); 
        this.a5.setTitle("Filename");
        this.a5.setView(this.a7);
        this.a8 = (AppCompatEditText) this.a7.findViewById(R.id.b3);
        this.a9 = this.b.getTitle().toString();
        this.a10 = this.a9 + ".html";
        this.a15 = ContextCompat.getColor(getApplicationContext(),R.color.c);
        this.a16 = ContextCompat.getColor(getApplicationContext(),R.color.b);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp.getBoolean("autoUpdate", false) == false) {
            this.a8.setTextColor(this.a15);
        } else {
            this.a8.setTextColor(this.a16);
        }
        this.a8.setText(this.a10);
        this.j = this.a8.getText().toString();
        this.a8.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(android.widget.TextView a, int b, KeyEvent c) {
                boolean d = false;
                if (b == EditorInfo.IME_ACTION_DONE) { 
                    d.this.j = d.this.a8.getText().toString();
                    d4();
                    d = true;
                }
                return d;
            }
        });
        this.a5.setPositiveButton("Save", new DialogInterface.OnClickListener() { 
            public void onClick(DialogInterface a, int b) { 
                d.this.j = d.this.a8.getText().toString();
                d4();
                a.dismiss();
  	         } 
  	     }); 
        this.a5.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { 
            public void onClick(DialogInterface a, int b) { 
                a.dismiss();
  	         } 
  	     }); 
        this.a5.create().show();   
    }

    public void d6() {
        this.a11 = getLayoutInflater().inflate(R.layout.h, (ViewGroup) findViewById(R.id.b13));
        ((TextView) this.a11.findViewById(R.id.b14)).setText(this.j + " | File saved.");
        this.a12 = new Toast(getApplicationContext());
        this.a12.setDuration(0);
        this.a12.setView(this.a11);
        this.a12.show();
    }

    public void d7() {
        this.a13 = getLayoutInflater().inflate(R.layout.g, (ViewGroup) findViewById(R.id.b11));
        ((TextView) this.a13.findViewById(R.id.b12)).setText("HTML Editor Pro not found.");
        this.a14 = new Toast(getApplicationContext());
        this.a14.setDuration(0);
        this.a14.setView(this.a13);
        this.a14.show();
    }

    public void d8() {
        this.a13 = getLayoutInflater().inflate(R.layout.h, (ViewGroup) findViewById(R.id.b13));
        ((TextView) this.a13.findViewById(R.id.b14)).setText("Source Code Copied!");
        this.a14 = new Toast(getApplicationContext());
        this.a14.setDuration(0);
        this.a14.setView(this.a13);
        this.a14.show();
    }

    public boolean d9() {
        if (VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return false;
        }
    } else { 
        return true;
        }
    }

    

    public void onRequestPermissionsResult(int a, String[] b, int[] c) {
        super.onRequestPermissionsResult(a, b, c);
        if (c[0]== PackageManager.PERMISSION_GRANTED){
        }
    }
}
