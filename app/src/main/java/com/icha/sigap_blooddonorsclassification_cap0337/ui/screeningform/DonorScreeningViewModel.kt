package com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.remote.DataPendonorRepository
import kotlinx.coroutines.launch

class DonorScreeningViewModel(private val dataPendonorRepository: DataPendonorRepository): ViewModel() {
    fun insertData(data: DataPendonorEntity) = viewModelScope.launch {
        dataPendonorRepository.insertData(data)
    }
}