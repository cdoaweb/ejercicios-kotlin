    package com.pmdm.peliculas_con_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            if (validateLogin(usernameEditText.text.toString(), passwordEditText.text.toString())) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {

            }
        }
    }

    private fun validateLogin(username: String, password: String): Boolean {
        return username.equals(getString(R.string.valid_username)) && password.equals(getString(R.string.valid_password))
    }
}