package com.icha.sigap_blooddonorsclassification_cap0337.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityRegisterBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var registerBinding: ActivityRegisterBinding

    private lateinit var registerPName : String
    private lateinit var registerPEmail : String
    private lateinit var registerPPhone : String
    private lateinit var registerPPassword : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Register")
        supportActionBar?.elevation = 0f

        registerBinding.btnGotoRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_goto_register)
        {
            with (registerBinding)
            {
                registerPName = registerName.text.toString()
                registerPEmail = registerEmail.text.toString()
                registerPPhone = registerPhone.text.toString()
                registerPPassword = registerPassword.text.toString()
            }

            if (registerPName.isEmpty() && registerPEmail.isEmpty() && registerPPhone.isEmpty() && registerPPassword.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Field can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (registerPName.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Name can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (registerPEmail.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Email can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (registerPPhone.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Phone number can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (registerPPassword.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Password can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (!(registerPName.isEmpty() && registerPEmail.isEmpty() && registerPPhone.isEmpty() && registerPPassword.isEmpty()))
            {       // save data to server
                val registerDt = RegisterData(registerPName, registerPEmail,
                    registerPPhone, registerPPassword)

                val registerIntent = Intent(this@RegisterActivity, LoginActivity::class.java)
                registerIntent.putExtra("REGISTER_DATA", registerDt)
                startActivity(registerIntent)
                finish()
            }
        }
    }
}