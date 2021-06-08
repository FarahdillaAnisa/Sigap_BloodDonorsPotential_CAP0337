package com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity

@Database(entities = [DataPendonorEntity::class],
version = 1,
exportSchema = false)
abstract class PendonorDatabase: RoomDatabase() {
    abstract fun pendonorDao() : PendonorDao
    companion object {
        @Volatile
        private var INSTANCE: PendonorDatabase? = null

        fun getInstance(context: Context): PendonorDatabase =
            INSTANCE?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    PendonorDatabase::class.java,
                    "pendonor.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}