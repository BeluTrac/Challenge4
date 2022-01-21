package com.munidigital.bc2201.challenge4.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.munidigital.bc2201.challenge4.R
import com.munidigital.bc2201.challenge4.api.ApiResponseStatus
import com.munidigital.bc2201.challenge4.api.Crypto
import com.munidigital.bc2201.challenge4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val SPLASH_DURATION:Long=3000
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.cryptoRecycler.layoutManager= LinearLayoutManager(this)
        val adapter=CryptoAdapter(this)
        binding.cryptoRecycler.adapter=adapter
        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.cryptoList.observe(this) {
            adapter.submitList(it)
        }
        viewModel.status.observe(this){
              when{(it== ApiResponseStatus.LOADING)->binding.cryptoEmptyView.visibility = View.VISIBLE

                  (it==ApiResponseStatus.DONE)->binding.cryptoEmptyView.visibility= View.GONE

                  (it==ApiResponseStatus.ERROR)->binding.cryptoEmptyView.visibility= View.GONE

                   }
              }


    }




}
