package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityBloodDonorsListBinding

class BloodDonorListActivity : AppCompatActivity() {
    private lateinit var donorsListBinding: ActivityBloodDonorsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        donorsListBinding = ActivityBloodDonorsListBinding.inflate(layoutInflater)
        setContentView(donorsListBinding.root)
    }
}