package com.android.DROID_MJ.webview;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.view.WindowManager;
import android.content.Intent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.Typeface;
import android.content.ActivityNotFoundException;
import android.widget.Toast;
import android.speech.RecognizerIntent;
import java.util.ArrayList;
import android.view.ViewGroup;
import java.util.Locale;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.preference.PreferenceManager;
import android.content.pm.ActivityInfo;
import android.widget.LinearLayout;
import android.graphics.Point;

public class f extends AppCompatActivity {
    private Toolbar a;
    private AutoCompleteTextView b;
    private View c;
    private String str;
    private String[] MnameList = {"google.com","youtube.com","facebook.com","baidu.com","wikipedia.org","qq.com","taobao.com","tmall.com","amazon.com","yahoo.com","twitter.com","sohu.com","jd.com","live.com","instagram.com","vk.com","weibo.com","reddit.com","sina.com.cn","yandex.ru","360.cn","login.tmall.com","netflix.com","blogspot.com","pornhub.com","twitch.tv","linkedin.com","google.com.hk","yahoo.co.jp","mail.ru","csdn.net","google.co.jp","google.co.uk","google.co.in","aliexpress.com","alipay.com","t.co","microsoft.com","google.com.br","ebay.com","bing.com","porn555.com","livejasmin.com","google.de","amazon.co.jp","office.com","imdb.com","Naver.com","xvideos.com","google.ru","github.com","msn.com","stackoverflow.com","google.fr","whatsapp.com","xhamster.com","google.it","google.es","ok.ru","pinterest.com","google.com.tr","quora.com","xnxx.com","sogou.com","samsung.com","accuweather.com","ampproject.org","sm.cn","medium.com","mediafire.com","datafilehost.com","uploadfiles.io","mp3juices.cc","fb.com","free.facebook.com","freebasics.com","messenger.com","revdl.com","en.uptodown.com","uptodown.com","internet.org","apkpure.com","apkmirror.com","apkpure.co","androidapksfree.com","apk4fun.com","dl.android.com","Android Central","android.com","duckduckgo.com","thehiddenwiki.org","drive.google.com","google.com/maps"};
    private LinearLayout ll;
 
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp.getBoolean("autoUpdate", false) == false) {
            setTheme(R.style.l);
        } else {
            setTheme(R.style.m);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e);
        this.a = (Toolbar) findViewById(R.id.o);
        this.b = (AutoCompleteTextView) findViewById(R.id.p);
        this.ll = (LinearLayout) findViewById(R.id.b10);
Point pointSize = new Point();
getWindowManager().getDefaultDisplay().getSize(pointSize);
b.setDropDownWidth(pointSize.x);
        ArrayAdapter multiadpter= new ArrayAdapter(this, R.layout.i, this.MnameList);
					this.b.setAdapter(multiadpter);
        this.b.setHint("Search or Type Url");
this.b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View b, int c, long d) {
                f1();
            }
        });
        this.c = (View) findViewById(R.id.b2);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        setSupportActionBar(this.a);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        int d = ContextCompat.getColor(getApplicationContext(),R.color.c);
        int e = ContextCompat.getColor(getApplicationContext(),R.color.b);
        int f = ContextCompat.getColor(getApplicationContext(),R.color.j);
        int g = ContextCompat.getColor(getApplicationContext(),R.color.k);
        SharedPreferences sp2 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp2.getBoolean("hori", false) == false) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        SharedPreferences sp3 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp3.getBoolean("hide", false) == false) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); 
        } else {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); 
        }
        Typeface j = Typeface.createFromAsset(getAssets(), "fonts/b.ttf");
        this.b.setTypeface(j);
        SharedPreferences sp1 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp1.getBoolean("autoUpdate", false) == false) {
            this.a.setBackgroundResource(R.color.b);
            this.c.setBackgroundResource(R.color.p);
            this.ll.setBackgroundResource(R.drawable.s);
            this.b.setTextColor(d);
            this.b.setHintTextColor(f);
            this.a.setNavigationIcon(R.drawable.r);
        } else {
            this.a.setBackgroundResource(R.color.n);
            this.c.setBackgroundResource(R.color.n);
            this.ll.setBackgroundResource(R.drawable.t);
            this.b.setTextColor(e);
            this.b.setHintTextColor(g);
            this.a.setNavigationIcon(R.drawable.b);
        }
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
        this.b.addTextChangedListener(new TextWatcher() {   
            public void afterTextChanged(Editable a) {
                invalidateOptionsMenu();
            }

            public void beforeTextChanged(CharSequence a, int b, int c, int d) {
                invalidateOptionsMenu();
            }

            public void onTextChanged(CharSequence a, int b, int c, int d) {
                invalidateOptionsMenu();
            }
        });
        this.a.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        this.b.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                String query = f.this.b.getText().toString();
                if (query.startsWith("webview://search")) {
						          Intent a = new Intent();
						          a.putExtra("result", "file:///android_asset/com/android/DROID_MJ/webview/noname(26).html");
				             setResult(AppCompatActivity.RESULT_OK,a); 
                handled = true;
            } else if (query.startsWith("webview://webflash")) {
						          Intent a = new Intent();
						          a.putExtra("result", "file:///android_asset/com/android/DROID_MJ/webflash/a.html");
				                   setResult(AppCompatActivity.RESULT_OK,a);
                     handled = true;
                } else if (query.startsWith("webview://cars")) {
						           Intent a = new Intent();
						           a.putExtra("result", "file:///android_asset/com/android/DROID_MJ/webview/c.html");
				                 setResult(AppCompatActivity.RESULT_OK,a);

                    handled = true;
                } else if (query.startsWith("webview://test")) {
						              Intent a = new Intent();
						              a.putExtra("result", "file:///android_asset/com/android/DROID_MJ/webview/b.html");
				                 setResult(AppCompatActivity.RESULT_OK,a);

                    handled = true;
                } else if (query.contains(".")) {
                    if (query.startsWith("www.")) {

											          Intent a = new Intent();
										         	  a.putExtra("result", "http://" + query);
				                      setResult(AppCompatActivity.RESULT_OK,a);

                        handled = true;
                    } else if (!query.startsWith("https://") && !query.startsWith("http://") && !query.startsWith("file://") ) {
        
											          Intent a = new Intent();
											          a.putExtra("result", "http://" + query);
				                      setResult(AppCompatActivity.RESULT_OK,a);
         
                        handled = true;
                    } else {
             
											          Intent a = new Intent();
								          			a.putExtra("result", query);
				                      setResult(AppCompatActivity.RESULT_OK,a);
         
                        handled = true;
                   }
              } else {
           
                       Intent a = new Intent();
											     a.putExtra("result", "https://www.google.com/search?q="+query);
				                 setResult(AppCompatActivity.RESULT_OK,a);
         
                   handled = true;
               }
     
                   finish();
              
              return handled;
            }
        });
        SharedPreferences h = getApplicationContext().getSharedPreferences("search", 0);
        String i = h.getString("search", str);
        if (i != null) {
           if (!i.startsWith("file://")) {
        this.b.setText(h.getString("search", str));
           }
        } 
    }

     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
            if (resultCode == RESULT_OK && null != data) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String speechText = result.get(0);
                f.this.b.setText(speechText);
            }
            break;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.c, menu);
        MenuItem a = menu.findItem(R.id.d15);
        MenuItem b = menu.findItem(R.id.a19);
        if (this.b.getText().toString().length() == 0) {
            invalidateOptionsMenu();
            a.setVisible(false);
            b.setVisible(true);
        } else {
            a.setVisible(true);
            b.setVisible(false);
        }
        SharedPreferences sp5 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp5.getBoolean("autoUpdate", false) == false) {
            a.setIcon(ContextCompat.getDrawable(this, R.drawable.d)); 
            b.setIcon(ContextCompat.getDrawable(this, R.drawable.f)); 
        } else {
           a.setIcon(ContextCompat.getDrawable(this, R.drawable.c)); 
            b.setIcon(ContextCompat.getDrawable(this, R.drawable.e)); 
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.d15:
                f2();
                return true;
            case R.id.a19:
                f3();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
         }
    }

    private void f1() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        String query = f.this.b.getText().toString();
                if (query.startsWith("webview://search")) {
						              Intent a = new Intent();
						              a.putExtra("result", "file:///android_asset/com/android/DROID_MJ/webview/noname(26).html");
				                 setResult(AppCompatActivity.RESULT_OK,a);
 
  
         

                } else if (query.startsWith("webview://webflash")) {
 
						              Intent a = new Intent();
						              a.putExtra("result", "file:///android_asset/com/android/DROID_MJ/webflash/a.html");
				                       setResult(AppCompatActivity.RESULT_OK,a);
     
 
                } else if (query.startsWith("webview://cars")) {
      
						              Intent a = new Intent();
						              a.putExtra("result", "file:///android_asset/com/android/DROID_MJ/webview/c.html");
				                 setResult(AppCompatActivity.RESULT_OK,a);
          

                } else if (query.startsWith("webview://test")) {
       
						              Intent a = new Intent();
						              a.putExtra("result", "file:///android_asset/com/android/DROID_MJ/webview/b.html");
				                 setResult(AppCompatActivity.RESULT_OK,a);
     

                } else if (query.contains(".")) {
                    if (query.startsWith("www.")) {

											          Intent a = new Intent();
										         	  a.putExtra("result", "http://" + query);
				                      setResult(AppCompatActivity.RESULT_OK,a);
         
 
                    } else if (!query.startsWith("https://") && !query.startsWith("http://") && !query.startsWith("file://") ) {
                 Intent a = new Intent();
											          a.putExtra("result", "http://" + query);
				                      setResult(AppCompatActivity.RESULT_OK,a);
            

                    } else {
                
											          Intent a = new Intent();
								          			a.putExtra("result", query);
				                      setResult(AppCompatActivity.RESULT_OK,a);
               

                   }
              } else {
            
                       Intent a = new Intent();
											     a.putExtra("result", "https://www.google.com/search?q="+query);
				                 setResult(AppCompatActivity.RESULT_OK,a);
           


               }
      
                   finish();
              


    }

    private void f2() {
        this.b.getText().clear();
        invalidateOptionsMenu();
    }

    private void f3() {
        Intent a = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        a.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        a.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        a.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say Hi to DROID_MJ");
        try {
            startActivityForResult(a, 100);
            this.b.getText().clear();
        } catch (ActivityNotFoundException b) {
            f4();
        }
    }

    private void f4() {
        View a = getLayoutInflater().inflate(R.layout.g, (ViewGroup) findViewById(R.id.b11));
        ((TextView) a.findViewById(R.id.b12)).setText("Sorry! Your device doesn't support speech input");
        Toast b = new Toast(getApplicationContext());
        b.setDuration(0);
        b.setView(a);
        b.show();
    }

}
