package com.xanadu.skipwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.view.Gravity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Simple programmatic UI for our alpha test
        val textView = TextView(this)
        textView.text = "SKIP WORK\n[Alpha Build]"
        textView.textSize = 32f
        textView.gravity = Gravity.CENTER
        
        setContentView(textView)
    }
}
