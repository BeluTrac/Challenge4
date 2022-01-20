package com.munidigital.bc2201.challenge4.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.munidigital.bc2201.challenge4.databinding.FragmentMainBinding

class FragmentMain : Fragment() {
    private lateinit var viewModel:MainViewModel
    private lateinit var binding:FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater)
        val recycler=binding.cryptoRecycler

        viewModel= ViewModelProvider(this,MainViewModelFactory(requireActivity().application)).get(MainViewModel::class.java)

        recycler.layoutManager= LinearLayoutManager(requireActivity())

        val adapter=CryptoAdapter(requireContext())
        recycler.adapter=adapter

        viewModel.cryptoList.observe(viewLifecycleOwner) {
            adapter.submitList(it)

        }

        return binding.root
    }

}