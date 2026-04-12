package com.example.latihan

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        val etRegisterUsername = findViewById<EditText>(R.id.etRegisterUsername)
        val etRegisterEmail = findViewById<EditText>(R.id.etRegisterEmail)
        val etRegisterPhone = findViewById<EditText>(R.id.etRegisterPhone)
        val etRegisterPassword = findViewById<EditText>(R.id.etRegisterPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val btnSaveRegister = findViewById<Button>(R.id.btnSaveRegister)

        btnSaveRegister.setOnClickListener {
            val username = etRegisterUsername.text.toString().trim()
            val email = etRegisterEmail.text.toString().trim()
            val phone = etRegisterPhone.text.toString().trim()
            val password = etRegisterPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Password dan Konfirmasi Password harus sama", Toast.LENGTH_SHORT).show()
            } else if (rgGender.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Pilih jenis kelamin", Toast.LENGTH_SHORT).show()
            } else {
                val editor = sharedPreferences.edit()
                editor.putString("username", username)
                editor.putString("password", password)
                editor.putString("email", email)
                editor.putString("phone", phone)
                editor.apply()

                Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("registered_username", username)
                startActivity(intent)
                finish()
            }
        }
    }
}