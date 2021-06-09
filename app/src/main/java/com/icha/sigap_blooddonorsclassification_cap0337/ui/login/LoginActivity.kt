package com.icha.sigap_blooddonorsclassification_cap0337.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityLoginBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.home.HomeActivity
import com.icha.sigap_blooddonorsclassification_cap0337.ui.register.RegisterActivity
import com.icha.sigap_blooddonorsclassification_cap0337.ui.register.RegisterData

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var loginBinding: ActivityLoginBinding

    private lateinit var loginEmail : String
    private lateinit var loginPassword : String
    private lateinit var getRData : RegisterData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.btnLogin.setOnClickListener(this)
        loginBinding.btnGotoRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_login)
        {
            loginEmail = loginBinding.loginEmail.text.toString()
            loginPassword = loginBinding.loginPassword.text.toString()

            if (loginEmail.isEmpty() && loginPassword.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Email and Password can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (loginEmail.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Email can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (loginPassword.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Password can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (!loginEmail.isEmpty() && !loginPassword.isEmpty())
            {       // check input with data from server
                getRData = intent.getParcelableExtra<RegisterData>("REGISTER_DATA") as RegisterData
                //Log.d("TAG login", getRData.toString())

                if (getRData.rEmail.toString().equals(loginEmail) && getRData.rPassword.toString().equals(loginPassword))
                {
                    val loginDt = RegisterData(getRData.rName.toString(), getRData.rEmail.toString(),
                            getRData.rPhone.toString(), getRData.rPassword.toString())
                    //Log.d("TAG data", loginDt.toString())

                    val loginIntent = Intent(this@LoginActivity, HomeActivity::class.java)
                    loginIntent.putExtra("LOGIN_DATA", loginDt)
                    startActivity(loginIntent)
                    finish()
                }
            }
        }
        else if (v?.id == R.id.btn_goto_register)
        {
            val loginIntent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(loginIntent)
        }
    }
}