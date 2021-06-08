package com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity

@Dao
interface PendonorDao {
    @Query("SELECT * FROM datapendonortbl")
    fun getAllData(): LiveData<List<DataPendonorEntity>>

    @Transaction
    @Query("SELECT * FROM datapendonortbl WHERE nik = :nik ")
    fun getDataByNik(nik: String): LiveData<DataPendonorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: DataPendonorEntity)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertDataDetail(dataDetail : DataPendonorEntity)

}