package com.example.latihan

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvUsername = findViewById<TextView>(R.id.tvUsername)

        val username = intent.getStringExtra("username")
        tvUsername.text = username ?: "Username"

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_home -> {
                    true
                }

                R.id.nav_event -> {
                    val username = intent.getStringExtra("username")
                    val intent = Intent(this, EventListActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }
}