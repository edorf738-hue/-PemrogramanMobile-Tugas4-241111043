package com.example.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.Intent

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val rvProducts = findViewById<RecyclerView>(R.id.rvProducts)

        rvProducts.layoutManager = LinearLayoutManager(this)

        val productList = listOf(
            Product(1, "Nike Air Max 90", "Sepatu · Ukuran 42", 1500000, R.drawable.img_produk1),
            Product(2, "Kaos Polos Hitam", "Baju · Size L", 89000, R.drawable.img_produk2),
            Product(3, "Headphone Bluetooth", "Elektronik · Wireless", 350000, R.drawable.img_produk3),
            Product(4, "Tas Ransel", "Aksesoris · 25L", 275000, R.drawable.img_produk4),
            Product(5, "Sticker Pack", "Aksesoris", 0, R.drawable.img_produk1)
        )

        rvProducts.adapter = ProductAdapter(productList)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.selectedItemId = R.id.nav_product

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val username = intent.getStringExtra("username")
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    true
                }
                R.id.nav_product -> true
                else -> false
            }
        }
    }
}