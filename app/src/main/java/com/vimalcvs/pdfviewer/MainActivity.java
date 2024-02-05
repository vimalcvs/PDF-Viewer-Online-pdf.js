package com.vimalcvs.pdfviewer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.vimalcvs.pdfviewer.databinding.ActivityMainBinding;

@SuppressLint("SetJavaScriptEnabled")

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String online_url = "https://ignou.technovimal.in/pdfviewer/web/viewer.html?file=/pdf/samples.pdf";

        String offline_url = "file:///android_asset/pdfviewer/viewer.html?file=" + "file:///android_asset/pdf/samples.pdf";

        binding.webView.loadUrl(online_url);


        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        binding.webView.getSettings().setAllowFileAccessFromFileURLs(true);
        binding.webView.getSettings().setAllowFileAccess(true);
        binding.webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        binding.webView.getSettings().setUseWideViewPort(true);
        binding.webView.getSettings().setLoadWithOverviewMode(true);
        binding.webView.getSettings().setAllowContentAccess(true);
        binding.webView.getSettings().setSupportZoom(true);

        binding.webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    binding.progressBar.setVisibility(View.GONE);
                } else {
                    binding.progressBar.setVisibility(View.VISIBLE);
                    binding.progressBar.setProgress(newProgress);
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        binding.webView.destroy();
        super.onDestroy();
    }
}