package com.icha.sigap_blooddonorsclassification_cap0337.data.source.remote

import androidx.lifecycle.LiveData
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity
import com.icha.sigap_blooddonorsclassification_cap0337.vo.Resource

interface DataPendonorDataSource {
    //local
    fun getDataPotensial(): LiveData<Resource<List<DataPendonorEntity>>>
    fun getDataNon(): LiveData<Resource<List<DataPendonorEntity>>>
    fun getDataFromNik(nik: String) : LiveData<DataPendonorEntity>
    suspend fun insertData(data : DataPendonorEntity)
}