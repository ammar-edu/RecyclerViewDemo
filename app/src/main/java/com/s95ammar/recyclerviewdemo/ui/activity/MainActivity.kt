package com.s95ammar.recyclerviewdemo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.s95ammar.recyclerviewdemo.R
import com.s95ammar.recyclerviewdemo.ui.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.fragments.isEmpty()) {
            addHomeFragment()
        }
    }

    private fun addHomeFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commit()
    }
}