package com.icha.sigap_blooddonorsclassification_cap0337.data.source.remote

import androidx.lifecycle.LiveData
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.LocalDataSource
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity

class DataPendonorRepository private constructor(
    private val localDataSource: LocalDataSource
) : DataPendonorDataSource {

    companion object {
        @Volatile
        private var instance : DataPendonorRepository? = null

        fun getInstance(localDataSource: LocalDataSource) : DataPendonorRepository =
            instance ?: synchronized(this) {
                instance ?: DataPendonorRepository(localDataSource).apply {
                    instance = this
                }
            }
    }

    override fun getDataPotensial(): LiveData<List<DataPendonorEntity>> {
        return localDataSource.getDataPotensial()
    }

    override fun getDataNon(): LiveData<List<DataPendonorEntity>> {
        return localDataSource.getDataNon()
    }

    override fun getDataFromNik(nik: String): LiveData<DataPendonorEntity> {
        return localDataSource.getDataByNik(nik)
    }

    override suspend fun insertData(data: DataPendonorEntity) {
        val dataDonor = DataPendonorEntity (
            data.nik,
            data.nama,
            data.jenisKelamin,
            data.golonganDarah,
            data.rhesus,
            data.recency,
            data.frequency,
            data.monetary,
            data.time,
            data.labelPrediksi,
            data.nomorPrediksi
        )
        return localDataSource.insertData(dataDonor)
    }

    override fun getIntPotensial(): Int {
        return localDataSource.getIntPotensial()
    }

    override fun getIntNon(): Int {
        return localDataSource.getIntNon()
    }

}
