package com.lalan.android_learning.webview

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R

class WebViewLearning : AppCompatActivity() {

    private lateinit var topWebview: WebView
    private lateinit var bottomWebview: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view_learning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        topWebview = findViewById(R.id.topWebview)
        bottomWebview = findViewById(R.id.bottomWebview)

        topWebview.loadData("<html><body><center> <h1>Lalan Desai</h1> </center></body></html", "text/html", "UTF-8")

        bottomWebview.settings.javaScriptEnabled = true
        bottomWebview.loadUrl("https://www.lalandesai.dev")
    }
}