package com.icha.sigap_blooddonorsclassification_cap0337.data.source.local

import androidx.lifecycle.LiveData
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.room.PendonorDao

class LocalDataSource private constructor(private val mPendonorDao: PendonorDao){
    companion object {
        private var INSTANCE: LocalDataSource? = null
        fun getInstance(pendonorDao: PendonorDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(pendonorDao)
    }

    fun getDataPotensial() : LiveData<List<DataPendonorEntity>> = mPendonorDao.getDataPotensial()
    fun getDataNon() : LiveData<List<DataPendonorEntity>> = mPendonorDao.getDataNon()
    fun getDataByNik(nik: String): LiveData<DataPendonorEntity> = mPendonorDao.getDataByNik(nik)
    suspend fun insertData(data: DataPendonorEntity) = mPendonorDao.insertData(data)
    fun getIntPotensial() : Int = mPendonorDao.getIntPotensial()
    fun getIntNon() :  Int = mPendonorDao.getIntNon()
}