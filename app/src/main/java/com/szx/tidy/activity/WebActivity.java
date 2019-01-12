package com.szx.tidy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.szx.tidy.R;

public class WebActivity extends Activity {
    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = (WebView) findViewById(R.id.webview);
        initWebView();
    }
    public void initWebView(){
        //加载网页链接
        webView.loadUrl("http://keithxiaoy.com");
//加载本地assets目录下的网页
        webView.loadUrl("file:///android_asset/keithxiaoy.html");
//加载手机本地的html页面
        webView.loadUrl("content://com.android.htmlfileprovider/sdcard/keithxiaoy.html");
//加载 HTML 页面的一小段内容。参数1：需要截取展示的内容、参数2：展示内容的类型、参数3：字节码
//        webView.loadData(String data, String mimeType, String encoding);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
