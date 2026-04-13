package com.example.latihan

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Int,
    val imageRes: Int = 0
) {
    fun getFormattedPrice(): String {
        return if (price == 0) "Gratis" else "Rp $price"
    }
}