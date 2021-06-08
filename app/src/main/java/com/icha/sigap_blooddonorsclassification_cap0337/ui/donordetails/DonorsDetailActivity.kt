package com.icha.sigap_blooddonorsclassification_cap0337.ui.donordetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityDonorsDetailBinding
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityLoginBinding
import com.icha.sigap_blooddonorsclassification_cap0337.viewModel.ViewModelFactory

class DonorsDetailActivity : AppCompatActivity() {

    private lateinit var donorsDetailBinding: ActivityDonorsDetailBinding
    private lateinit var dataPendonorEntity: DataPendonorEntity
    private lateinit var viewModel: DonorDetailsViewModel

    companion object {
        var EXTRA_NIK = "extra_nik"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        donorsDetailBinding = ActivityDonorsDetailBinding.inflate(layoutInflater)
        setContentView(donorsDetailBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(applicationContext)
        viewModel = ViewModelProvider(this, factory)[DonorDetailsViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val nik = extras.getString(EXTRA_NIK)
            if (nik != null) {
                viewModel.setSelectedDonor(nik)
                donorsDetailBinding.progressBar.visibility = View.VISIBLE
                viewModel.getDonorDetails(nik).observe(this, { dataDetails ->
                    if (dataDetails != null) {
                        donorsDetailBinding.progressBar.visibility = View.GONE
                        setData(dataDetails)
                        dataPendonorEntity = dataDetails
                    }
                })
            }
        }

    }

    private fun setData(dataDonor : DataPendonorEntity)
    {
        with (donorsDetailBinding)
        {
            txtNama.text = dataDonor.nama
            txtNik.text = dataDonor.nik
            txtJk.text = dataDonor.jenisKelamin
            txtGoldarah.text = "${dataDonor.golonganDarah} ${dataDonor.rhesus}"
            txtStatus.text = dataDonor.labelPrediksi
            txtRecencyDetail.text = dataDonor.recency.toString()
            txtFrequencyDetail.text = dataDonor.frequency.toString()
            txtMonetaryDetail.text = dataDonor.monetary.toString()
            txtTimeDetail.text = dataDonor.time.toString()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}