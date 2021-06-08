package com.icha.sigap_blooddonorsclassification_cap0337.di

import android.content.Context
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.LocalDataSource
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.room.PendonorDatabase
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.remote.DataPendonorRepository

object Injection {
    fun provideRepository(context: Context): DataPendonorRepository {
        val database = PendonorDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(database.pendonorDao())

        return DataPendonorRepository.getInstance(localDataSource)
    }
}