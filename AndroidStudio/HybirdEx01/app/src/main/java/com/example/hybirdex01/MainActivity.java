package com.example.hybirdex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
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
        webView.loadUrl("http://170.30.1.1:8080/test/Arithmetic.jsp");
    }
}