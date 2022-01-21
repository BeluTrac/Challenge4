package com.munidigital.bc2201.challenge4.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.munidigital.bc2201.challenge4.R
import com.munidigital.bc2201.challenge4.api.ApiResponseStatus
import com.munidigital.bc2201.challenge4.api.Crypto
import com.munidigital.bc2201.challenge4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainFragment.CryptoSelectListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }


    override fun onCryptoSelected(crypto : Crypto){
        Log.d("PRUEBA",crypto.toString())
        findNavController(R.id.main_navigation_container).navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(crypto))
    }




}
