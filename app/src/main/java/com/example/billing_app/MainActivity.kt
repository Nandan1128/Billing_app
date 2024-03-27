package com.example.billing_app

import Dashboard
import Parties
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.billing_app.fragments.More

import com.example.billing_app.fragments.items
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainFrame, Dashboard())
                .commit()
        }

        bottomNavigation = findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_icon -> {
                    // Replace the current fragment with DashboardFragment
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.mainFrame, Dashboard())
                        .commit()
                    true
                }
                R.id.parties_icon -> {
                    // Replace the current fragment with DashboardFragment
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.mainFrame, Parties())
                        .commit()
                    true
                }
                R.id.item_icon -> {
                    // Replace the current fragment with DashboardFragment
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.mainFrame, items())
                        .commit()
                    true
                }
                R.id.icon_more -> {
                    // Replace the current fragment with DashboardFragment
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.mainFrame, More())
                        .commit()
                    true
                }
                // Handle other menu items if needed
                else -> false
            }
        }
    }
}