package com.munidigital.bc2201.challenge4.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MainRepository() {

    suspend fun fetchCrypto() : MutableList<Crypto>{
        return withContext(Dispatchers.IO){
            val cryptoJsonResponse = service.getCryptos()
            parseCryptoResult(cryptoJsonResponse)
        }
    }

    private fun parseCryptoResult(cryptoJsonResponse: CryptoJsonResponse): MutableList<Crypto> {
        val cryptoList = mutableListOf<Crypto>()
        val entriesList = cryptoJsonResponse.entries
        var id=1
        for (entry in entriesList)
        {
            val name = entry.nombre
            val time = entry.fecha_creacion
            val imgUrl = entry.imagen.path
            val prize = entry.precio
            val abbreviation = entry.abreviatura
            id++
            cryptoList.add(Crypto(id,name,time,imgUrl,prize,abbreviation))
        }
        return cryptoList
    }
}