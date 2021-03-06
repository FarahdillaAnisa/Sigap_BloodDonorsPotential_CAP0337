package com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity

@Dao
interface PendonorDao {
    @Query("SELECT * FROM datapendonortbl WHERE nomorprediksi = 1")
    fun getDataPotensial(): LiveData<List<DataPendonorEntity>>

    @Query("SELECT * FROM datapendonortbl WHERE nomorprediksi = 0")
    fun getDataNon(): LiveData<List<DataPendonorEntity>>

    @Transaction
    @Query("SELECT * FROM datapendonortbl WHERE nik = :nik ")
    fun getDataByNik(nik: String): LiveData<DataPendonorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: DataPendonorEntity)

    @Query("SELECT COUNT(nik) FROM datapendonortbl WHERE nomorprediksi = 1")
    fun getIntPotensial(): Int

    @Query("SELECT COUNT(nik) FROM datapendonortbl WHERE nomorprediksi = 0")
    fun getIntNon(): Int

}