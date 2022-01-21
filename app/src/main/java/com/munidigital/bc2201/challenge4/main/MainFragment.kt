package com.munidigital.bc2201.challenge4.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.munidigital.bc2201.challenge4.R
import com.munidigital.bc2201.challenge4.api.ApiResponseStatus
import com.munidigital.bc2201.challenge4.api.Crypto
import java.lang.ClassCastException

class MainFragment : Fragment() {
    interface CryptoSelectListener{
        fun onCryptoSelected(crypto : Crypto)
    }

    private lateinit var cryptoSelectListener: CryptoSelectListener

    override fun onAttach (context : Context){
        super.onAttach(context)
        cryptoSelectListener = try{
            context as CryptoSelectListener
        }catch (e: ClassCastException){
            throw ClassCastException("$context must implement CryptoSelectListener")
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val recycler = view.findViewById<RecyclerView>(R.id.cryptoRecycler)

        recycler.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = CryptoAdapter(requireActivity())
        recycler.adapter = adapter

        adapter.onItemClickListener = {
            Log.d("prueba",it.toString())
            cryptoSelectListener.onCryptoSelected(it)
        }

        val viewModel= ViewModelProvider(this).get(MainViewModel::class.java)
            viewModel.cryptoList.observe(requireActivity(), Observer {
                crypto ->
                adapter.submitList(crypto)
            })


        val emptyView = view.findViewById<TextView>(R.id.cryptoEmptyView)
        viewModel.status.observe(requireActivity()){
            when{(it== ApiResponseStatus.LOADING)->emptyView.visibility = View.VISIBLE

                (it== ApiResponseStatus.DONE)->emptyView.visibility= View.GONE

                (it== ApiResponseStatus.ERROR)->emptyView.visibility= View.GONE

            }
        }



        return view
    }

}