package com.icha.sigap_blooddonorsclassification_cap0337.ui.donordetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.remote.DataPendonorRepository

class DonorDetailsViewModel(private val dataPendonorRepository: DataPendonorRepository) : ViewModel() {
    val donorNik = MutableLiveData<String>()

    //set Id
    fun setSelectedDonor(nik : String) {
        this.donorNik.value = nik
    }

    fun getDonorDetails(nik : String) : LiveData<DataPendonorEntity> {
        return dataPendonorRepository.getDataFromNik(nik)
    }
}