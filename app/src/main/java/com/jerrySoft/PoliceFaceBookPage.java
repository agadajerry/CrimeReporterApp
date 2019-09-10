package com.jerrySoft;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PoliceFaceBookPage extends AppCompatActivity {

    WebView webView;
    WebSettings webSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_face_book_page);
        webView = (WebView)findViewById(R.id.webview);
        webSetting = webView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setAppCacheEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        //***********************************************************************
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setBuiltInZoomControls(true);

        //webSetting.setDomStorageEnabled(true); //it store web data at client side
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setUseWideViewPort(true);
        webView.loadUrl("https://web.facebook.com/benuepolice/");
        checkInternetConnection();//test for network availability


    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onReceivedError(WebView view, int errorCode, String discription, String failUrl) {

            Toast toast = Toast.makeText(getBaseContext(), "Check your internet connection", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
            toast.show();


        }


    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }

    }
    private boolean checkInternetConnection() {
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null) {

            Toast.makeText(PoliceFaceBookPage.this, "Your are currently Offline", Toast.LENGTH_LONG).show();


            return false;
        } else {

            return true;
        }

    }
}
