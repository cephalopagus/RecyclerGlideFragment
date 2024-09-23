package com.example.geekstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = supportFragmentManager
        val fTransaction = fragment.beginTransaction().replace(
            R.id.frame_show, ListFragment()
        )
        fTransaction.commit()
    }

}