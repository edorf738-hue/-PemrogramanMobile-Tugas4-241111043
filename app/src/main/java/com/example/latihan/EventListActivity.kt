package com.example.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.Intent

class EventListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)

        val rvEvents = findViewById<RecyclerView>(R.id.rvEvents)

        rvEvents.layoutManager = LinearLayoutManager(this)

        val eventList = listOf(
            Event(1, "Seminar AI & Masa Depan", "15 Mei 2026", "Hotel Grand Slipi", 50000),
            Event(2, "Workshop Kotlin Android", "20 Mei 2026", "Kampus Teknik", 75000),
            Event(3, "Web Developer Gathering", "25 Mei 2026", "Co-working Space", 0),
            Event(4, "UI/UX Design Bootcamp", "1 Juni 2026", "Online (Zoom)", 100000),
            Event(5, "Tech Career Fair 2026", "10 Juni 2026", "Convention Center", 0)
        )

        val adapter = EventAdapter(eventList)

        rvEvents.adapter = adapter

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.selectedItemId = R.id.nav_event

        bottomNav.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_home -> {
                    val username = intent.getStringExtra("username")
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    true
                }

                R.id.nav_event -> {
                    true
                }

                else -> false
            }
        }
    }
}