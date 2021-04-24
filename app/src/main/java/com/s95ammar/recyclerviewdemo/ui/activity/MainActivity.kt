package com.s95ammar.recyclerviewdemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.s95ammar.recyclerviewdemo.R
import com.s95ammar.recyclerviewdemo.ui.list.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.fragments.isEmpty()) {
            addListFragment()
        }
    }

    private fun addListFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment.newInstance())
                .commit()
    }
}