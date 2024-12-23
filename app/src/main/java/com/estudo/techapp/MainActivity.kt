package com.estudo.techapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.estudo.techapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    fun initView() {
        binding.btnLogin.setOnClickListener {
            showLoading()
            CoroutineScope.launch {
                login(binding.etUsername.text.toString(), binding.etPassword.text.toString())
            }
        }
    }

    fun login(username: String, password: String) {
        hideLoading()
        var responseCode = EnumResponseCode.FAILURE
        if (password == "123") responseCode = EnumResponseCode.SUCCESS
        when (responseCode) {
            EnumResponseCode.SUCCESS -> {
                Toast.makeText(this, "Login successful", Toast.LENGTH_LONG)
            }
            EnumResponseCode.FAILURE -> {
                Toast.makeText(this, "Wrong password!", Toast.LENGTH_LONG)
            }
        }
    }

    fun showLoading() {
        binding.pbLoading.visibility = View.VISIBLE
    }

    fun hideLoading() {
        binding.pbLoading.visibility = View.GONE
    }
}