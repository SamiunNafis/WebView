package com.android.DROID_MJ.webview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.content.pm.PackageManager;
import android.content.SharedPreferences; 
import android.support.v7.widget.Toolbar;
import android.graphics.Typeface;
import android.widget.PopupMenu;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.graphics.BitmapFactory;
import android.webkit.JsResult;
import android.webkit.GeolocationPermissions;
import android.view.ContextMenu;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebSettings.RenderPriority;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.content.pm.ActivityInfo;
import android.webkit.WebResourceError;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.hardware.Camera.Parameters;
import android.webkit.DownloadListener;
import android.preference.PreferenceManager;
import android.widget.LinearLayout;


@SuppressWarnings("deprecation")
public class c extends AppCompatActivity {
    private ValueCallback<Uri[]> b;
    private static c instance;
    private String d;
    private String f;
    private ProgressBar g;
    public WebView h;
    private boolean i;
    private Request j;
    private SharedPreferences k;
    private SwipeRefreshLayout l;
    private String m;
    private String n;
    private Toolbar o;
    private SharedPreferences.Editor p;
    private View s;
    private TextView u;
    private int v;
    private int w;
    private WebChromeClient.CustomViewCallback x;
    private Intent y;
    private String z;
    private Uri[] a1;
    private String a2;
    private int a7;
    private int a8;
    private int a9;
    private Typeface a10;
    private final int a17 = 100;
    private WebSettings a18;
    private SharedPreferences a19;
    private String a20;
    private String b1 = "file:///android_asset/com/android/DROID_MJ/webview/noname(26).html";
    private Uri b9;
    private String b10;
    private String b11;
    private AlertDialog.Builder b12;
    private AlertDialog.Builder b13;
    private File b14;
    private View b15;
    private Toast b16;
    private View b17;
    private Toast b18;
    private Intent b19;
    private String c1;
    private String c2;
    private AlertDialog.Builder c3;
    private View c4;
    private Toast c5;
    private String c6;
    private Intent c7;
    private Intent c8;
    private Intent c9;
    private String c10;
    private String c11;
    private View c12;
    private Toast c13;
    private WebSettings c14;
    private String c15;
    private Intent c16;
    private SharedPreferences c17;
    private String c18;
    private SharedPreferences.Editor c19;
    private PopupMenu c20;
    private long c21;
    private ClipboardManager clipboard;
    private ClipData myClip;
    private CameraManager c111;
    private Camera d111;
    private Parameters a111;
    private LinearLayout ll;

    BroadcastReceiver a6 = new BroadcastReceiver() {
          public void onReceive(Context a, Intent b) {
          c.this.f = b.getAction();
          if (c.this.f.equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
          c19();
          }
          if (c.this.f.equals(DownloadManager.ACTION_NOTIFICATION_CLICKED)) {
          c9();
          }
       }
    };

    public class a extends WebViewClient {
        a() {
        }

    public void onReceivedError(WebView a, WebResourceRequest b, WebResourceError c) {
        if (!a.getUrl().toString().startsWith("file://")) {
        a.loadUrl("file:///android_asset/com/android/DROID_MJ/webview/a.html");
        }
        c.this.u.setText(a.getTitle());
        super.onReceivedError(a, b, c);
    }

    public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(c.this);
        String message = "Unknown certificate error.";
            switch (error.getPrimaryError()) {
                case SslError.SSL_UNTRUSTED:
                    message = "This certificate isn't from a trusted authority.";
                    break;
                case SslError.SSL_EXPIRED:
                    message = "The certificate has expired.";
                    break;
                case SslError.SSL_IDMISMATCH:
                    message = "The name of the site doesn't match the name on the certificate.";
                    break;
                case SslError.SSL_NOTYETVALID:
                    message = "This certificate isn't valid yet.";
                case SslError.SSL_DATE_INVALID:
                    message = "This certificate has an invalid date.";
                case SslError.SSL_INVALID:
                    message = "This certificate is invalid.";
            }
            builder.setTitle("There are problems with the security certificate for this site.");
            builder.setMessage(message);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    handler.proceed();
                }
            });
            builder.setNegativeButton("Go Back", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    c.this.h.goBack();
                }
            });
            final AlertDialog dialog = builder.create();
            dialog.show();
        }

        public void onPageFinished(WebView a, String b) {
            super.onPageFinished(a, b);
            c.this.l.setRefreshing(false);
            c.this.g.setVisibility(View.GONE);
            c.this.k = getApplicationContext().getSharedPreferences("MyURL", 0);
            c.this.m = b;
            c.this.p = c.this.k.edit();
            c.this.p.putString("MyURL", b);
            c.this.p.commit();
            c.this.n = a.getTitle().toString();
            if (!a.getUrl().toString().startsWith("file://")) {
            c.this.u.setText(b);
            } else {
            c.this.u.setText(a.getTitle());
            }
            if (b.startsWith("file:///android_asset/com/android/DROID_MJ/webflash/b.html")) {
                a26();
            } else if (b.startsWith("file:///android_asset/com/android/DROID_MJ/webflash/a.html")) {
                try {
                    a27();
                } catch (Exception e) {
                    a27();
                }
            } 
        }

        public void onPageStarted(WebView a, String b, Bitmap c) {
            super.onPageStarted(a, b, c);
            c.this.g.setVisibility(View.VISIBLE);
            c.this.n = a.getTitle().toString();
            if (!a.getUrl().toString().startsWith("file://")) {
            c.this.u.setText(b);
            } else {
            c.this.u.setText(a.getTitle());
            }
            if (b.startsWith("file:///android_asset/com/android/DROID_MJ/webflash/b.html")) {
                a26();
            } else if (b.startsWith("file:///android_asset/com/android/DROID_MJ/webflash/a.html")) {
                try {
                    a27();
                } catch (Exception e) {
                    a27();
                }
            } 
        }

        public boolean shouldOverrideUrlLoading(WebView a, String b) {
            if (b.startsWith("intent")) {
                a.loadUrl(b);
            } else {
                a.loadUrl(b);
            }  
            return false;
        }

        @TargetApi(Build.VERSION_CODES.N)
        public boolean shouldOverrideUrlLoading(WebView a, WebResourceRequest b) {
            return false;
        }
    }

    public class b extends WebChromeClient {
        public b() {
        }

        public Bitmap getDefaultVideoPoster() {

            return BitmapFactory.decodeResource(c.this.getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView() {
            ((FrameLayout)c.this.getWindow().getDecorView()).removeView(c.this.s);
            c.this.s = null;
            c.this.getWindow().getDecorView().setSystemUiVisibility(c.this.w);
            c.this.setRequestedOrientation(c.this.v);
            c.this.x.onCustomViewHidden();
            c.this.x = null;
        }

        public void onShowCustomView(View a, WebChromeClient.CustomViewCallback b) {
            if (c.this.s != null) {
                onHideCustomView();
                return;
        }
        c.this.s = a;
        c.this.w = c.this.getWindow().getDecorView().getSystemUiVisibility();
        c.this.v = c.this.getRequestedOrientation();
        c.this.x = b;
        ((FrameLayout)c.this.getWindow().getDecorView()).addView(c.this.s, new FrameLayout.LayoutParams(-1, -1));
        c.this.getWindow().getDecorView().setSystemUiVisibility(3846);
        }

        public boolean onShowFileChooser(WebView a, ValueCallback<Uri[]> b, WebChromeClient.FileChooserParams c) {
            c.this.b = b;
            c.this.y = new Intent(Intent.ACTION_GET_CONTENT);
            c.this.y.addCategory(Intent.CATEGORY_OPENABLE);
            c.this.y.setType("*/*");
            startActivityForResult(Intent.createChooser(c.this.y, "Choose action"), 2);
            return true;
        }

        public void onProgressChanged(WebView a, int b) {
            c.this.l.setRefreshing(false);
            c.this.g.setProgress(b);
            if (b == 100) {
                c.this.g.setVisibility(View.GONE);
            }
        }

        public boolean onJsAlert(WebView a, String b, String c, final JsResult d) {  
            new AlertDialog.Builder(c.this).setCancelable(true).setTitle("The page at " + a.getTitle() + " says:").setMessage(c).setPositiveButton("Ok", new AlertDialog.OnClickListener() {  
                public void onClick(DialogInterface dialog, int which) {  
                     d.confirm();  
                }  
            }).create().show();  
            return true;  
        };  

        public boolean onJsConfirm(WebView a, String b, String c, final JsResult d) {
             new AlertDialog.Builder(c.this).setCancelable(true).setTitle("The page at " + a.getTitle() + " says:").setMessage(c).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface a, int b) {
                     d.confirm();
                 }
             }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface a, int b) {
                      d.cancel();
                 }
             }).create().show();
             return true;
         };

         public void onGeolocationPermissionsShowPrompt(final String origin, final GeolocationPermissions.Callback callback) {
             final boolean remember = false;
             AlertDialog.Builder builder = new AlertDialog.Builder(c.this);
             builder.setMessage(c.this.h.getTitle() + " want's to know your location").setCancelable(true).setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int id) {
                     callback.invoke(origin, true, remember);
                 }
             }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int id) {
                     callback.invoke(origin, false, remember);
                 }
             });
             AlertDialog alert = builder.create();
             alert.show();
         }
    }
    

    protected void onActivityResult(int a, int b, Intent c) {
        super.onActivityResult(a, b, c);
	         if (a == 911) {
						    if(b == AppCompatActivity.RESULT_OK) {
						    		this.z = c.getStringExtra("result");
							     this.h.loadUrl(this.z);
              }
				    }
        if (Build.VERSION.SDK_INT >= 21) {
            if (a != 2 || this.b == null) {
                super.onActivityResult(a, b, c);
                return;
            }
            this.a1 = null;
            if (b == AppCompatActivity.RESULT_OK) {
                this.a2 = c.getDataString();
                if (this.a2 != null) {
                this.a1 = new Uri[]{Uri.parse(this.a2)};
                }
            }
            this.b.onReceiveValue(this.a1);
            this.b = null;
        }
    }

    public static c getInstance() {
        return instance;
    }

    
    protected void onCreate(Bundle a) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp.getBoolean("autoUpdate", false) == false) {
            setTheme(R.style.d);
        } else {
            setTheme(R.style.e);
        }
        super.onCreate(a);
        setContentView(R.layout.c);
        instance = this;
        this.o = (Toolbar) findViewById(R.id.f);
        this.g = (ProgressBar) findViewById(R.id.h);
        this.h = (WebView) findViewById(R.id.j);
        this.l = (SwipeRefreshLayout) findViewById(R.id.i);
        this.ll = (LinearLayout) findViewById(R.id.b9);
        clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        registerForContextMenu(this.h);
        this.u = (TextView) findViewById(R.id.g);
        setSupportActionBar(this.o);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.a7 = ContextCompat.getColor(getApplicationContext(),R.color.c);
        this.a8 = ContextCompat.getColor(getApplicationContext(),R.color.b);
        this.a9 = ContextCompat.getColor(getApplicationContext(),R.color.a);
        this.a10 = Typeface.createFromAsset(getAssets(), "fonts/b.ttf");
        c6();
        this.u.setOnClickListener(new View.OnClickListener() {
            public void onClick(View a) {
                c22();
            }
        });
        this.u.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View a) {
                c24();
                return false;
            }
        });
        this.ll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View a) {
                c22();
            }
        });
        this.ll.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View a) {
                c24();
                return false;
            }
        });
        this.l.setColorSchemeColors(this.a9);
        this.l.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                c18();
            }
        });
if (Build.VERSION.SDK_INT >=  21) {
        this.u.setTypeface(this.a10);
}
        this.g.setMax(this.a17);
        this.a18 = this.h.getSettings();
        this.a19 = getApplicationContext().getSharedPreferences("MyURL", 0);
        this.a20 = this.a19.getString("MyURL", this.m);
        if (this.a20 != null) {
            this.h.loadUrl(this.a20);
        } else {
            this.h.loadUrl(this.b1);
        }
        this.a18.setSupportZoom(true);
        this.a18.setBuiltInZoomControls(true);

        this.a18.setAllowFileAccess(true);
        this.a18.setAllowFileAccessFromFileURLs(true);
        this.a18.setAllowUniversalAccessFromFileURLs(true);
        this.a18.setDatabaseEnabled(true);
        this.a18.setDomStorageEnabled(true);
        this.a18.setAllowContentAccess(true);
        if (Build.VERSION.SDK_INT <= 18) {
            this.a18.setRenderPriority(RenderPriority.HIGH);
        }
        this.a18.setPluginState(WebSettings.PluginState.ON);
        this.h.setFocusable(true);
        this.h.setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 19) {
            this.h.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
           this.h.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        this.h.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        this.a18.setJavaScriptCanOpenWindowsAutomatically(true);
        this.h.setWebChromeClient(new b());
        this.h.setWebViewClient(new a());
        this.h.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                c.this.c21 = j;
                c.this.d = URLUtil.guessFileName(str, str3, str4);
                c.this.j = new Request(Uri.parse(str));
                c.this.j.setMimeType(str4);
                c.this.j.addRequestHeader("cookie", CookieManager.getInstance().getCookie(str));
                c.this.j.addRequestHeader("User-Agent", str2);  
                c.this.j.setTitle(URLUtil.guessFileName(str, str3, str4));
                c.this.j.allowScanningByMediaScanner();
                c.this.j.setNotificationVisibility(1);
                c.this.j.setDestinationInExternalPublicDir(new StringBuilder(String.valueOf("WebView")).append("/").append("Downloads").toString(), URLUtil.guessFileName(str, str3, str4));
                c11();
                registerReceiver(a6, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
            }
        });
    }

    protected void onResume() {
        super.onResume();
        this.b9 = getIntent().getData();
        if (this.b9 != null) {
            this.h.loadUrl(this.b9.toString());
        }
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
        SharedPreferences sp1 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp1.getBoolean("autoUpdate", false) == false) {
            this.o.setBackgroundResource(R.color.b);
            this.ll.setBackgroundResource(R.drawable.s);
            this.u.setTextColor(this.a7);
this.l.setProgressBackgroundColorSchemeResource(R.color.b);
        } else {
            this.o.setBackgroundResource(R.color.n);
            this.ll.setBackgroundResource(R.drawable.t);
            this.u.setTextColor(this.a8);
this.l.setProgressBackgroundColorSchemeResource(R.color.d);
        }
        SharedPreferences sp5 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp5.getBoolean("java", true) == true) {
            this.a18.setJavaScriptEnabled(true);
        } 
        SharedPreferences sp10 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp10.getBoolean("open", true) == true) {
        this.a18.setUseWideViewPort(true);
        }
        SharedPreferences sp9 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp9.getBoolean("cookies", true) == true) {
        if (Build.VERSION.SDK_INT <= 21) {
            CookieManager.getInstance().setAcceptCookie(true);
}
        if (Build.VERSION.SDK_INT >= 21) {   
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.h, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }
        }
        SharedPreferences sp7 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp7.getBoolean("form", true) == true) {
        this.a18.setSaveFormData(true);
        }
        SharedPreferences sp6 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp6.getBoolean("passwords", true) == true) {
        this.a18.setSavePassword(true);
        }
        SharedPreferences sp8 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp8.getBoolean("location", true) == true) {
        this.a18.setGeolocationEnabled(true);
        this.a18.setGeolocationDatabasePath(getFilesDir().getPath());
        }
        SharedPreferences sp4 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp4.getBoolean("block", false) == false) {
            this.a18.setBlockNetworkImage(false);
            this.a18.setLoadsImagesAutomatically(true);
            } else {
            this.a18.setBlockNetworkImage(true);
            this.a18.setLoadsImagesAutomatically(false);
        }
        SharedPreferences sp11 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp11.getBoolean("zoom", false) == false) {
        this.a18.setDisplayZoomControls(false);
        } else {
        this.a18.setDisplayZoomControls(true);
        }
        SharedPreferences sp12 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp12.getBoolean("auto", false) == false) {
            this.a18.setMediaPlaybackRequiresUserGesture(false);
        } else {
            this.a18.setMediaPlaybackRequiresUserGesture(true);
        }
        SharedPreferences sp15 = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp15.getBoolean("keep", false) == false) {
getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
} else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    public void c1() {
        this.b10 = "Address:";
        String test = this.h.getUrl().toString();
        if (test.startsWith("file:///android_asset/com/android/DROID_MJ/webview/noname(26).html")) {
            this.b11 = "webview://search";
        } else if (test.startsWith("file:///android_asset/com/android/DROID_MJ/webflash/a.html")) {
            this.b11 = "webview://test";
        } else if (test.startsWith("file:///android_asset/com/android/DROID_MJ/webflash/b.html")) {
            this.b11 = "webview://test";
        } else if (test.startsWith("file:///android_asset/com/android/DROID_MJ/webview/c.html")) {
            this.b11 = "webview://cars";
        } else if (test.startsWith("file:///android_asset/com/android/DROID_MJ/webview/b.html")) {
            this.b11 = "webview://test";
        } else {
            this.b11 = test;
        }
        this.b12 =  new AlertDialog.Builder(this);
        this.b12.setCancelable(true); 
        this.b12.setTitle("Page Info"); 
        this.b12.setMessage(this.n + "\n\n" + this.b10 + "\n\n" + this.b11); 
        this.b12.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface a, int b) { 
                a.dismiss(); 
            } 
   	     });
        this.b12.setNegativeButton("View Certificate", new DialogInterface.OnClickListener() { 
               public void onClick(DialogInterface a, int b) { 
                   c3(); 
  	                } 
  	            }); 
        this.b12.create().show();
    } 

    public void c2() {
        if (this.h.canGoForward()) {
            this.h.goForward();
        } else {
            c7();
        }
    }

    public void c3() {
        final AlertDialog.Builder a =  new AlertDialog.Builder(this);
        a.setCancelable(true); 
        a.setTitle("Alert"); 
        a.setMessage("This feature arent available for now."); 
        a.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) { 
                dialog.dismiss(); 
                } 
   	        });
        a.create().show();
    } 

    public void c4() {
        System.exit(0);
    }

    public void c5() {
        this.b13 =  new AlertDialog.Builder(this);
        this.b13.setCancelable(true); 
        this.b13.setMessage("Do you want to exit?"); 
        this.b13.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface a, int b) { 
                c4();
            } 
   	     });
        this.b13.setNegativeButton("No", new DialogInterface.OnClickListener() { 
            public void onClick(DialogInterface a, int b) { 
                a.dismiss(); 
  	        } 
  	    }); 
       this.b13.create().show();
    } 

    public void c6() {
        this.b14 = new File(Environment.getExternalStorageDirectory() + "/" + "WebView", "Downloads");
        this.b14 = new File("/sdcard/WebView/" + "Saved");
        if (!this.b14.exists()) {
            this.b14.mkdirs();
        }
    }

    public void c7() {
        this.b15 = getLayoutInflater().inflate(R.layout.g, (ViewGroup) findViewById(R.id.b11));
        ((TextView) this.b15.findViewById(R.id.b12)).setText("Can't go forward");
        this.b16 = new Toast(getApplicationContext());
        this.b16.setDuration(0);
        this.b16.setView(this.b15);
        this.b16.show();
    }

    public void c8() {
        this.b17 = getLayoutInflater().inflate(R.layout.h, (ViewGroup) findViewById(R.id.b13));
        ((TextView) this.b17.findViewById(R.id.b14)).setText("Starting Download...");
        this.b18 = new Toast(getApplicationContext());
        this.b18.setDuration(0);
        this.b18.setView(this.b17);
        this.b18.show();
    }

    public void c9() {
        this.b19 = getPackageManager().getLaunchIntentForPackage("com.android.providers.downloads.ui");
        if (this.b19 != null) {
            startActivity(this.b19);
        }
    }

    public void c10() {
        if (!h.getUrl().toString().startsWith("file://")) {
            myClip = ClipData.newPlainText("text", this.m);
            clipboard.setPrimaryClip(myClip);
            c12();
        }
    }

    public void c11() { 
        this.c1 = this.d.toString(); 
        this.c2 = "/storage/emulated/0/WebView/Downloads/" + this.c1;
        this.c3 =  new AlertDialog.Builder(this);
        this.c3.setCancelable(true); 
        this.c3.setTitle(this.d); 
        this.c3.setMessage("File Size:  " + this.c21 +"bytes" + "\n\n" + "Link:  " + this.c1 + "\n\n" + "Path:  " + this.c2); 
        this.c3.setPositiveButton("Start", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface a, int b) { 
                try {
                    ((DownloadManager) c.this.getSystemService("download")).enqueue(c.this.j);
                    c8();
                } catch (Exception c) {
                    c21();
                }
               } 
   	        });
           this.c3.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { 
               public void onClick(DialogInterface a, int b) { 
                    a.dismiss(); 
  	                } 
  	            }); 
        this.c3.create().show();
    } 

    public void c12() {
        this.c4 = getLayoutInflater().inflate(R.layout.h, (ViewGroup) findViewById(R.id.b13));
        ((TextView) this.c4.findViewById(R.id.b14)).setText("Link Copied.");
        this.c5 = new Toast(getApplicationContext());
        this.c5.setDuration(0);
        this.c5.setView(this.c4);
        this.c5.show();
    }

    public void c14() {
        if (!h.getUrl().toString().startsWith("file://")) {
            this.c6 = this.h.getUrl().toString();
            this.c7 = new Intent(getApplicationContext(), d.class);
			       this.c7.putExtra("value", this.c6);
					    startActivity(this.c7);
        }
    }

    public void c15() {
        this.c8 = new Intent(Intent.ACTION_MAIN);
        this.c8.setClassName("com.android.settings", "com.android.settings.TestingSettings");
        startActivity(this.c8);
    }

    public void c16() {
        if (!h.getUrl().toString().startsWith("file://")) {
            this.c9 = new Intent("android.intent.action.SEND");
            this.c9.setType("text/plain");
            this.c9.putExtra("android.intent.extra.TEXT", this.h.getUrl());
            startActivity(this.c9);
        }
    }

    public void c17() {
        if (!h.getUrl().toString().startsWith("file://")) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.h.getUrl().toString())));
        }
    }

    public void c18() {
        if (!h.getUrl().toString().startsWith("file:///android_asset/com/android/DROID_MJ/webview/a.html")) {
            this.h.reload();
        } else {
            this.h.goBack();
            this.h.reload();
        }
    }

    public void c19() {
        this.c10 = this.d.toString(); 
        this.c11 = "/storage/emulated/0/WebView/Downloads/" + this.c10;
        this.c12 = getLayoutInflater().inflate(R.layout.h, (ViewGroup) findViewById(R.id.b13));
        ((TextView) this.c12.findViewById(R.id.b14)).setText(this.c11);
        this.c13 = new Toast(getApplicationContext());
        this.c13.setDuration(0);
        this.c13.setView(this.c12);
        this.c13.show();
    }

    public void c20(final boolean a) {
        this.c14 = this.h.getSettings();
        if (a) {
            this.c15 = this.c14.getUserAgentString().replace("Mobile", "eliboM").replace("Android", "diordnA");
        } else {
            this.c15 = this.c14.getUserAgentString().replace("eliboM", "Mobile").replace("diordnA", "Android");
    }
    this.c14.setUserAgentString(this.c15);
    this.c14.setUseWideViewPort(a);
    this.c14.setLoadWithOverviewMode(a);
    this.c14.setSupportZoom(a);
    this.c14.setBuiltInZoomControls(a);
    this.h.reload();
    }

    public boolean c21() {
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

    public void c22() {
        this.c16 = new Intent(getApplicationContext(), f.class);
			  startActivityForResult(this.c16, 911);
        this.c17 = getApplicationContext().getSharedPreferences("search", 0);
        this.c18 = this.h.getUrl().toString();
        this.c19 = this.c17.edit(); 
        this.c19.putString("search", this.c18);
        this.c19.commit();
    }

    private void c24() {
        this.c20 = new PopupMenu(c.this, this.u);
        this.c20.getMenuInflater().inflate(R.menu.d, this.c20.getMenu());
        this.c20.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem a) {
                switch (a.getItemId()) { 
                    case R.id.b4:
                       c10();
                       break;
                    case R.id.b5:
                       c16();
                       break;
                    case R.id.b6:
                       c17();
                       break;
  	              } 
  	              return true;
             } 
  	     }); 
  	     this.c20.show(); 
    }

    public void c25() {
        this.h.clearHistory();
    }

    public void a26() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.c111 == null) {
                this.c111 = (CameraManager) getSystemService("camera");
            } try {
                this.c111.setTorchMode(this.c111.getCameraIdList()[0], true);
                return;
            } catch (Exception a) {
                a28(a);
                return;
            }
        } try {
            if (getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                this.d111 = Camera.open();
                this.a111 = this.d111.getParameters();
                this.a111.setFlashMode("torch");
                this.d111.setParameters(this.a111);
                this.d111.startPreview();
            }
        } catch (Exception e2) {
            a28(e2);
        }
    }

    public void a27() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                this.c111.setTorchMode(this.c111.getCameraIdList()[0], false);
                return;
            } catch (Exception a) {
                a28(a);
                return;
            }
        } try {
            if (getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                this.d111.stopPreview();
                this.d111.release();
                this.d111 = null;
            }
        } catch (Exception b) {
            a28(b);
        }
    }

    public void a28(Exception a) {
        Toast.makeText(this, "Error: " + a.getMessage(), 0).show();
    }

    public void c29(final boolean a) {
        this.c14 = this.h.getSettings();
        if (a) {
            CookieManager.getInstance().setAcceptCookie(false);
    this.c14.setCacheMode(WebSettings.LOAD_NO_CACHE); this.c14.setAppCacheEnabled(false);   this.h.clearHistory(); this.c14.setSavePassword(false); this.c14.setSaveFormData(false); 
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
    this.c14.setCacheMode(WebSettings.LOAD_NORMAL); this.c14.setAppCacheEnabled(true);   this.c14.setSavePassword(true);   this.c14.setSaveFormData(true); 
    }
    this.c14.setUseWideViewPort(a);
    this.c14.setLoadWithOverviewMode(a);
    this.c14.setSupportZoom(a);
    this.c14.setBuiltInZoomControls(a);
    this.h.reload();
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) { super.onCreateContextMenu(menu, v, menuInfo); 
        final HitTestResult result = this.h.getHitTestResult();
        MenuItem.OnMenuItemClickListener handler = new MenuItem.OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem a) {
            String t = result.getExtra().toString();
            switch (a.getItemId()) { 
                case 1:
                    String DownloadImageURL = result.getExtra();
             if(URLUtil.isValidUrl(DownloadImageURL)){
                    DownloadManager.Request mRequest = new DownloadManager.Request(Uri.parse(DownloadImageURL));
               mRequest.allowScanningByMediaScanner();
mRequest.setDestinationInExternalPublicDir(new StringBuilder(String.valueOf("WebView")).append("/").append("Downloads").toString(), URLUtil.guessFileName(t,t,t));
                                mRequest.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                DownloadManager mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                                mDownloadManager.enqueue(mRequest);

                                Toast.makeText(c.this,"Image Downloaded Successfully...",Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(c.this,"Sorry.. Something Went Wrong...",Toast.LENGTH_LONG).show();
                            }
                            
                       break;
                    case 2:
                       String DownloadImageURL2 = result.getExtra();
 c.this.h.loadUrl(DownloadImageURL2);
                       break;
                    case 3:
                    c3();
                       break;
  	              case 4:
                       Intent intent = new Intent("android.intent.action.SEND");
       intent.setType("text/plain");
       intent.putExtra("android.intent.extra.TEXT", t);
        startActivity(intent);
                       break;
                    case 5:

                       c.this.h.loadUrl(t);
                       break;
                    case 6:
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(t)));
                       break;
  	          
    case 7:
                    c.this.myClip = ClipData.newPlainText("text", t);
c.this.clipboard.setPrimaryClip(c.this.myClip);
             c12();
        
                       break;
                    case 8:
                                   Intent intent4 = new Intent("android.intent.action.SEND");
       intent4.setType("text/plain");
       intent4.putExtra("android.intent.extra.TEXT", t);
        startActivity(intent4);
                       break;
        
  	          
             
case 9:
     
        Intent intent5 = new Intent(getApplicationContext(), d.class);
			  intent5.putExtra("value", t);
					startActivity(intent5);
break;
}
               return true;
        }
    };

    if (result.getType() == HitTestResult.IMAGE_TYPE ||
            result.getType() == HitTestResult.SRC_IMAGE_ANCHOR_TYPE) {
        menu.setHeaderTitle(result.getExtra());
        menu.add(0, 1, 0, "Save Image").setOnMenuItemClickListener(handler);
        menu.add(0, 2, 0, "View Image").setOnMenuItemClickListener(handler);
        menu.add(0, 3, 0, "Set as Wallpaper").setOnMenuItemClickListener(handler);
        menu.add(0, 4, 0, "Share").setOnMenuItemClickListener(handler);
    } else if (result.getType() == HitTestResult.ANCHOR_TYPE ||
            result.getType() == HitTestResult.SRC_ANCHOR_TYPE) {
        menu.setHeaderTitle(result.getExtra());
        menu.add(0, 5, 0, "Open").setOnMenuItemClickListener(handler);
        menu.add(0, 6, 0, "Open in").setOnMenuItemClickListener(handler);
        menu.add(0, 7, 0, "Copy").setOnMenuItemClickListener(handler);
        menu.add(0, 8, 0, "Share").setOnMenuItemClickListener(handler);
menu.add(0,9,0 ,"Source Code").setOnMenuItemClickListener(handler);
    }
}

    public void onRequestPermissionsResult(int a, String[] b, int[] c) {
        super.onRequestPermissionsResult(a, b, c);
        if (c[0]== PackageManager.PERMISSION_GRANTED){
        }
    }

    public boolean onKeyUp(int a, KeyEvent b) {
        if (a == 4 && b.isTracking() && !b.isCanceled()) {
            if (this.i || !this.h.canGoBack()) {
                onBackPressed();
            } else {
                this.h.goBack();
            }
            this.i = false;
            return true;
        }
        if (a == 4) {
            this.i = false;
        }
        return super.onKeyUp(a, b);
    }

    public boolean onKeyLongPress(int a, KeyEvent b) {
        if (a == 4 && !b.isCanceled()) {
            c5();
            this.i = true;
        }
        return false;
    }

	  public boolean onCreateOptionsMenu(Menu a) { 
	      getMenuInflater().inflate(R.menu.a, a);
        MenuItem.OnMenuItemClickListener handler = new MenuItem.OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem b) {
            switch (b.getItemId()) { 
                case 1:
                    c5();
                break;
            }
return true;
        }
        };
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if (!sp.getBoolean("exit", false) == false) {
            a.add(6, 1, 0, "Exit").setOnMenuItemClickListener(handler);
        }
        return super.onCreateOptionsMenu(a);
    }

    public boolean onOptionsItemSelected(MenuItem a) {
        switch (a.getItemId()) {
            case R.id.s:
                c2();
                return true;
            case R.id.d:
                if (a.isChecked()) {
                    a.setChecked(false);
                    c29(false);
                } else {
                    a.setChecked(true);
                    c29(true);
                }
                return true;
            case R.id.a11:
                c14();
                return true;
            case R.id.q:
                this.h.stopLoading();
                return true;
            case R.id.v:
                this.h.loadUrl(this.b1);
                return true;
            case R.id.w:
                c16();
                return true;
            case R.id.r:
                c18();
                return true;
            case R.id.x:
                c17();
                return true;
            case R.id.a7:
                if (a.isChecked()) {
                    a.setChecked(false);
                    c20(false);
                } else {
                    a.setChecked(true);
                    c20(true);
                }
                return true;
            case R.id.u:
                c9();
                return true;
            case R.id.a8:
                c10();
                return true;
            case R.id.a9:
         this.h.loadUrl(getResources().getString(R.string.q2));
                return true;
            case R.id.a10:
                c15();
                return true;
            case R.id.y:
                this.h.loadUrl(getResources().getString(R.string.c9));
                return true;
            case R.id.z:
                this.h.loadUrl(getResources().getString(R.string.c10));
                return true;
            case R.id.a1:
                this.h.loadUrl(getResources().getString(R.string.c11));
                return true;
            case R.id.a2:
                this.h.loadUrl(getResources().getString(R.string.c12));
                return true;
            case R.id.a3:
                this.h.loadUrl(getResources().getString(R.string.c13));
                return true;
            case R.id.a4:
                this.h.loadUrl(getResources().getString(R.string.c14));
                return true;
            case R.id.a5:
                this.h.loadUrl(getResources().getString(R.string.c15));
                return true;
            case R.id.a6:
                this.h.loadUrl(getResources().getString(R.string.c16));
                return true;
            case R.id.a13:
                startActivity(new Intent(this, e.class));

                return true;
            case R.id.a12:
                c1();
                return true;
            default:
                return super.onOptionsItemSelected(a);
        }
    }
}
