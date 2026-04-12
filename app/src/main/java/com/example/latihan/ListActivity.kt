package com.example.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView = findViewById<RecyclerView>(R.id.rvItems)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemList = listOf(
            Item(1, "Laptop Asus", "Laptop untuk programming"),
            Item(2, "Mouse Logitech", "Mouse wireless gaming"),
            Item(3, "Keyboard Mechanical", "Keyboard RGB"),
            Item(4, "Monitor Samsung", "Monitor 24 inch Full HD"),
            Item(5, "Headset Gaming", "Headset dengan mic")
        )

        val adapter = ItemAdapter(itemList)

        recyclerView.adapter = adapter
    }
}