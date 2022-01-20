package com.munidigital.bc2201.challenge4.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface CryptoApiService {
    @GET("MD_BC2201_Cryptos")
    suspend fun getCryptos(): CryptoJsonResponse
}

private var retrofit = Retrofit.Builder()
    .baseUrl("https://o-informatica.com/cms/api/collections/get/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

var service: CryptoApiService = retrofit.create(CryptoApiService::class.java)