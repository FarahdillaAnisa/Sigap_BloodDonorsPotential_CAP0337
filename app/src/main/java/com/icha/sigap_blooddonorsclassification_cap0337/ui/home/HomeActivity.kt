package com.icha.sigap_blooddonorsclassification_cap0337.ui.home

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityHomeBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.register.RegisterData

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding
    lateinit var getHData : RegisterData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_donor_list, R.id.navigation_screening_form)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //getUserData()
    }

    private fun getUserData()
    {   // data for details
        getHData = intent.getParcelableExtra<RegisterData>("LOGIN_DATA") as RegisterData
        Log.d("TAG home data", getHData.toString())
    }
}