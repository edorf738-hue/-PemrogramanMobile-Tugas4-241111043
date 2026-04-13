package com.example.latihan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val btnAllProducts = findViewById<Button>(R.id.btnAllProducts)
        val ivFeatured = findViewById<ImageView>(R.id.ivFeaturedImage)

        val username = intent.getStringExtra("username")
        tvUsername.text = username ?: "Username"

        // Set gambar featured product
        ivFeatured.setImageResource(R.drawable.img_produk1)

        // Tombol "Lihat semua produk"
        btnAllProducts.setOnClickListener {
            val intent = Intent(this, ProductListActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_product -> {
                    val intent = Intent(this, ProductListActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}