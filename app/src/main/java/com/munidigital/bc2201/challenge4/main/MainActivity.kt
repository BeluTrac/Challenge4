package com.munidigital.bc2201.challenge4.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.munidigital.bc2201.challenge4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val SPLASH_DURATION:Long=3000
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val run= Runnable {
            binding.cryptoRecycler.layoutManager= LinearLayoutManager(this)
            val adapter=CryptoAdapter()
            binding.cryptoRecycler.adapter=adapter
            viewModel= ViewModelProvider(this).get(MainViewModel::class.java)

            viewModel.cryptoList.observe(this){
                adapter.submitList(it)
            }
        }

        Handler(Looper.getMainLooper()).postDelayed(run, SPLASH_DURATION)
    }
}