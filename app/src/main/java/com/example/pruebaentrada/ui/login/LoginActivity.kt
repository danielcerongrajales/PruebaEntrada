package com.example.pruebaentrada.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.activity.viewModels
import com.example.pruebaentrada.ui.main.MainActivity
import com.example.pruebaentrada.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewmodel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
        setObservers()

    }

    private fun setListeners() {
        binding.button.setOnClickListener {
            val user = binding.editTextTextPersonName.text.toString()
            val password = binding.editTextTextPersonName2.text.toString()
            if (checkValues(user, password)) {
                viewmodel.getLogin(user, password)
            } else {
                Toast.makeText(this, "usuario o contraseña vacios", LENGTH_LONG).show()
            }
        }
    }

    private fun setObservers() {
        viewmodel.userData.observe(this) {
            startActivity(Intent(this, MainActivity::class.java).putExtra("as", it.userToken,))
            finish()
        }
    }

    private fun checkValues(user: String, password: String): Boolean {

        if (user.isNotEmpty() && password.isNotEmpty()) {
            return true
        }
        return false

    }
}