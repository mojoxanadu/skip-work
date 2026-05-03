package com.xanadu.skipwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState: Bundle?)
        // Hide the action bar for that clean "Zelda III" title screen
        supportActionBar?.hide() 
        setContentView(R.layout.activity_main)
    }
}
