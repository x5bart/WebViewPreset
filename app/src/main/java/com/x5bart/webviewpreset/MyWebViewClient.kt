package com.x5bart.webviewpreset

import android.net.http.SslError
import android.webkit.*


class MyWebViewClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        view?.loadUrl(request?.url.toString())
        return true
    }

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        view?.loadUrl(url)
        return true
    }

    override fun onReceivedSslError(
        view: WebView?,
        handler: SslErrorHandler,
        error: SslError?
    ) {
        handler.proceed()
    }
    }