package com.icha.sigap_blooddonorsclassification_cap0337.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.remote.DataPendonorRepository
import kotlinx.coroutines.runBlocking

class HomeViewModel(private val dataPendonorRepository: DataPendonorRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getIntPotensial() : Int = runBlocking {
        dataPendonorRepository.getIntPotensial()
    }

    fun getIntNon() : Int = runBlocking {
        dataPendonorRepository.getIntNon()
    }
}