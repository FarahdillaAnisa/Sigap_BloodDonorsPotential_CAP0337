package com.icha.sigap_blooddonorsclassification_cap0337.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(mainLooper).postDelayed({
            val splashIntent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
            startActivity(splashIntent)
            finish()
        }, 2000)
    }
}

// logo source : https://pmi.or.id/wp-content/uploads/elementor/thumbs/logo2021-p33eakyr9yio66oq10g56o3rtpwkjcv08uf8dbz08e.png