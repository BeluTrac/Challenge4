package com.munidigital.bc2201.challenge4.main

import android.util.Log
import androidx.lifecycle.*
import com.munidigital.bc2201.challenge4.api.ApiResponseStatus
import com.munidigital.bc2201.challenge4.api.Crypto
import com.munidigital.bc2201.challenge4.api.MainRepository
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import java.util.logging.Handler

class MainViewModel() : ViewModel() {

   private var repository = MainRepository()

   private var _cryptoList = MutableLiveData<MutableList<Crypto>>()
    val cryptoList : LiveData<MutableList<Crypto>>
        get() = _cryptoList

    private val _status= MutableLiveData<ApiResponseStatus>()
    val status:LiveData<ApiResponseStatus>
    get() = _status

    init {
        viewModelScope.launch {
            try {
                _status.value=ApiResponseStatus.LOADING
                _cryptoList.value = repository.fetchCrypto()
                _status.value=ApiResponseStatus.DONE
            }
            catch (e: UnknownHostException){
                _status.value=ApiResponseStatus.ERROR
            }
        }
    }


}