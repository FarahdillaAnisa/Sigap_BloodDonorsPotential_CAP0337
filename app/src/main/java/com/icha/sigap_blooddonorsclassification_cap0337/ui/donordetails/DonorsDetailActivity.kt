package com.icha.sigap_blooddonorsclassification_cap0337.ui.donordetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityDonorsDetailBinding
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityLoginBinding

class DonorsDetailActivity : AppCompatActivity() {

    private lateinit var donorsDetailBinding: ActivityDonorsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_donors_detail)

        donorsDetailBinding = ActivityDonorsDetailBinding.inflate(layoutInflater)
        setContentView(donorsDetailBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setData()
    }

    private fun setData()
    {
        with (donorsDetailBinding)
        {
            Glide.with(this@DonorsDetailActivity).load("").into(imgProfile)
            txtNama.text
            txtNik.text
            txtJk.text
            txtGoldarah.text
            txtStatus.text
            txtRecencyDetail.text
            txtFrequencyDetail.text
            txtMonetaryDetail.text
            txtTimeDetail.text
        }
    }
}