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

    private lateinit var registerName : String
    private lateinit var registerEmail : String
    private lateinit var registerPhone : String
    private lateinit var registerPassword : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_register)

        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Register")
        //supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#F6F6F6")))
        supportActionBar?.elevation = 0f

        registerBinding.btnGotoRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_goto_register)
        {
            registerName = registerBinding.registerName.text.toString()
            registerEmail = registerBinding.registerEmail.text.toString()
            registerPhone = registerBinding.registerPhone.text.toString()
            registerPassword = registerBinding.registerPassword.text.toString()

            if (registerName.isEmpty() && registerEmail.isEmpty() && registerPhone.isEmpty() && registerPassword.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Field can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (registerName.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Name can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (registerEmail.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Email can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (registerPhone.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Phone number can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (registerPassword.isEmpty())
            {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Password can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (!registerName.isEmpty() && !registerEmail.isEmpty() && !registerPhone.isEmpty() && !registerPassword.isEmpty())
            {       // save data to server
                val registerDt = RegisterData(registerName, registerEmail,
                    registerPhone, registerPassword)

                val registerIntent = Intent(this@RegisterActivity, LoginActivity::class.java)
                registerIntent.putExtra("REGISTER_DATA", registerDt)
                startActivity(registerIntent)
                finish()
            }
        }
    }
}