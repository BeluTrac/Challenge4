package com.munidigital.bc2201.challenge4.datail

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.munidigital.bc2201.challenge4.R
import com.munidigital.bc2201.challenge4.api.Crypto
import com.bumptech.glide.request.target.Target
import com.munidigital.bc2201.challenge4.main.MainFragmentDirections


class DetailFragment : Fragment() {
    private lateinit var name : TextView
    private lateinit var abbrevation : TextView
    private lateinit var prize : TextView
    private lateinit var time : TextView
    private lateinit var img : ImageView
    private lateinit var button : Button

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)
        img = rootView.findViewById(R.id.imageView4)
        name = rootView.findViewById(R.id.name)
        prize = rootView.findViewById(R.id.prize)
        time = rootView.findViewById(R.id.textView3)
        abbrevation = rootView.findViewById(R.id.abbr)

        val crypto = args.crypto
        setCryptoData(crypto)

        return rootView
    }

    fun setCryptoData(crypto: Crypto)
    {
        Glide.with(this).load(crypto.imgUrl).listener(object: RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                img.setImageResource(R.drawable.image_not_supported)
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }

        }).error(R.drawable.image_not_supported).into(img)

        name.text = crypto.name
        abbrevation.text = crypto.abbreviation
        prize.text = crypto.prize
        time.text = crypto.time


    }

}