package com.proyekt.narodnieproyekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.proyekt.narodnieproyekt.databinding.ActivityMainBinding
import com.proyekt.narodnieproyekt.kesh.MySharedPreferences

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}