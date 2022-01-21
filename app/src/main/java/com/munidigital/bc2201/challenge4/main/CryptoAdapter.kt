package com.munidigital.bc2201.challenge4.main

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.munidigital.bc2201.challenge4.api.Crypto
import com.munidigital.bc2201.challenge4.databinding.CryptoListItemBinding

class CryptoAdapter(val activity: Activity): ListAdapter<Crypto, CryptoAdapter.ViewHolder>(
    DiffCallback
) {

    companion object DiffCallback : DiffUtil.ItemCallback<Crypto>() {
        override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem.id == newItem.id
        }
    }

    lateinit var onItemClickListener: (Crypto)->Unit
    lateinit var chargeImage: (Crypto)->Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CryptoListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crypto = getItem(position)
        holder.bind(crypto)
    }

    inner class ViewHolder(private val binding: CryptoListItemBinding):

        RecyclerView.ViewHolder(binding.root) {
        fun bind(crypto: Crypto) {
            binding.tvNameCrypto.text = crypto.name
            binding.tvNameAbbreviationCrypto.text = crypto.name
            val img=binding.imgCrypto
            Glide.with(activity).load(crypto.imgUrl).into(img)

            binding.root.setOnClickListener {
                if (::onItemClickListener.isInitialized) {
                    onItemClickListener(crypto)
                }

            }
        }
    }
}