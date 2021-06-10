package com.example.hybridlec01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView webView = null;
    Button btnReload, btnPage1, btnPage2, btnPage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        btnReload = findViewById(R.id.btn_reload);
        btnPage1 = findViewById(R.id.btn_page1);
        btnPage2 = findViewById(R.id.btn_page2);
        btnPage3 = findViewById(R.id.btn_page3);

        btnReload.setOnClickListener(onClickListener);
        btnPage1.setOnClickListener(onClickListener);
        btnPage2.setOnClickListener(onClickListener);
        btnPage3.setOnClickListener(onClickListener);

        //web setting
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //js useable
        webSettings.setBuiltInZoomControls(true); // zoom in-out useable
        webSettings.setDisplayZoomControls(false); //돋보기 사용 안함

        //link시 다른 brower 안보이게
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                btnReload.setText("로딩 중...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                btnReload.setText(webView.getTitle());
            }
        });
        webView.loadUrl("https//www.naver.com");

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_page1:
                    btnPage1Click();
                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if(webView.canGoBack()){
            webView.goBack();
        } else {
            finish();
        }
    }

    public void btnPage1Click(){
        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<html><head>"+
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                "<head><body>";
        String content = "<H1>Hello world</H1>";
        String bottom = "</body></html>";

        String html = header + content + bottom;

        webView.loadData(html, "text/html; charset=utf-8", "UTF-8");
    }
    public void btnPage2Click(){
        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<html><head>"+
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                "<head><body>";
        String content = "<img src =\"http://170.30.1.1:8080/test/dog.jpg\"";
        String bottom = "</body></html>";

        String html = header + content + bottom;
        webView.loadData(html, "text/html; charset=utf-8", "UTF-8");
    }

    public void btnPage3Click(){
        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<html><head>"+
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                "<head><body>";
        String content = "<img src =\"http://170.30.1.1:8080/test/dog.jpg\" style=\"width:100%; height:auto;\"";
        String bottom = "</body></html>";

        String html = header + content + bottom;
        webView.loadData(html, "text/html; charset=utf-8", "UTF-8");
    }

}