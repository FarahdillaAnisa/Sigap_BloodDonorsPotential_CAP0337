package com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "datapendonortbl")
data class DataPendonorEntity(
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "nik")
    var nik : String,

    @ColumnInfo(name = "nama")
    var nama : String? = null,

    @ColumnInfo(name = "jeniskelamin")
    var jenisKelamin : String? = null,

    @ColumnInfo(name = "golongandarah")
    var golonganDarah : String? = null,

    @ColumnInfo(name = "rhesus")
    var rhesus : String? = null,

    @ColumnInfo(name = "recency")
    var recency : Int? = null,

    @ColumnInfo(name = "frequency")
    var frequency : Int? = null,

    @ColumnInfo(name = "monetary")
    var monetary : Int? = null,

    @ColumnInfo(name = "time")
    var time : Int? = null,

    @ColumnInfo(name = "labelprediksi")
    var labelPrediksi : String? = null
)
