package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.remote.DataPendonorRepository

class DonorListViewModel(private val dataPendonorRepository: DataPendonorRepository) : ViewModel() {
    fun getAllData() : LiveData<List<DataPendonorEntity>> = dataPendonorRepository.getAllData()
}