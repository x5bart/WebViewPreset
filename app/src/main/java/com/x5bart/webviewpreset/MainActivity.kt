package com.x5bart.webviewpreset

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preference = MyPreference(this)
        val url = preference.getLastUrl()
        loadUrlInWebView(url!!)
    }

    override fun onPause() {
        super.onPause()
        savedLastUrl()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun loadUrlInWebView(url: String) {
        webView.settings.javaScriptEnabled = true
        webView.apply {
            isVerticalScrollBarEnabled = true
            isHorizontalScrollBarEnabled = true
            webViewClient = MyWebViewClient()
            loadUrl(url)
        }
    }

    private fun savedLastUrl() {
        val preference = MyPreference(this)
        val lastUrl = webView.url
        preference.setLastUrl(lastUrl)

    }

    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack()
        else Toast.makeText(this, "No History Available", Toast.LENGTH_SHORT).show()

    }


}

