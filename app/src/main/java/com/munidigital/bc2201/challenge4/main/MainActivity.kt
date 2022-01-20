package com.munidigital.bc2201.challenge4.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.munidigital.bc2201.challenge4.R
import com.munidigital.bc2201.challenge4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}