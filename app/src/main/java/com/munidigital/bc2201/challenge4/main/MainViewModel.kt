package com.munidigital.bc2201.challenge4.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.munidigital.bc2201.challenge4.api.Crypto
import com.munidigital.bc2201.challenge4.api.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

   private var repository = MainRepository()

   private var _cryptoList = MutableLiveData<MutableList<Crypto>>()
    val cryptoList : LiveData<MutableList<Crypto>>
        get() = _cryptoList

    fun reloadCryptos(){
        viewModelScope.launch {

            _cryptoList.value =  repository.fetchCrypto()
            Log.d("PRUEBA", _cryptoList.value.toString())
        }
    }
}