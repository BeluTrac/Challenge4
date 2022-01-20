package com.munidigital.bc2201.challenge4

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.munidigital.bc2201.challenge4.api.Crypto
import com.munidigital.bc2201.challenge4.api.MainRepository
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
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