package com.icha.sigap_blooddonorsclassification_cap0337.data.source.remote

import androidx.lifecycle.LiveData
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity

interface DataPendonorDataSource {
    //local
    fun getDataPotensial(): LiveData<List<DataPendonorEntity>>
    fun getDataNon(): LiveData<List<DataPendonorEntity>>
    fun getDataFromNik(nik: String) : LiveData<DataPendonorEntity>
    suspend fun insertData(data : DataPendonorEntity)
    fun getIntPotensial() : Int
    fun getIntNon() : Int
}