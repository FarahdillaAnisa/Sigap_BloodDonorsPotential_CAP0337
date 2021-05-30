package com.icha.sigap_blooddonorsclassification_cap0337.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.icha.sigap_blooddonorsclassification_cap0337.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}