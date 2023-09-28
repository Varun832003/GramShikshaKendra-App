package com.example.kanyakavach.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Toast
import com.example.kanyakavach.R
import com.example.kanyakavach.firebase.FireStoreClass
import com.example.kanyakavach.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setUpActionBar()
        btn_sign_up.setOnClickListener {
            registerUser() }

        }


    fun userRegisteredSuccess(){
        Toast.makeText(this@SignUpActivity, "you have successfully registered the email address", Toast.LENGTH_LONG).show()
        hideProgressDialog()
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this@SignUpActivity, LandingActivity::class.java))
        finish()

    }

    private fun setUpActionBar()
    {
        setSupportActionBar(toolbar_sign_up_activity)

        val actionBar= supportActionBar
        if(actionBar!= null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_black_color_back_24dp)

        }

        toolbar_sign_up_activity.setNavigationOnClickListener{ onBackPressed()}
    }

    private fun registerUser(){
        val name: String= et_name.text.toString().trim { it <= ' '}
        val mobileNumber: String = et_mobile_number.text.toString().trim { it <= ' '}
        val email: String= et_email.text.toString().trim { it <= ' '}
        val password: String= et_password.text.toString().trim { it <= ' '}

        if(validateForm(name, mobileNumber, email, password))
        {
            showProgressDialog(resources.getString(R.string.please_wait))
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    task ->

                if(task.isSuccessful)
                {
                    val fireBaseUser: FirebaseUser = task.result!!.user!!
                    val registeredEmail= fireBaseUser.email!!

                    val user= User(fireBaseUser.uid, name, registeredEmail, "", mobileNumber.toLong())
                    FireStoreClass().registerUser(this, user)
                }
                else{
                    Toast.makeText(this@SignUpActivity, "Registration failed.", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun validateForm(name: String, mobileNumber: String, email: String, password: String): Boolean{
        return when{
            TextUtils.isEmpty(name) ->{
                showSnackBar("Please enter a name.")
                false
            }

            TextUtils.isEmpty(mobileNumber) ->{
                showSnackBar("Please enter your Mobile Number.")
                false
            }

            TextUtils.isEmpty(email) ->{
                showSnackBar("Please enter an email address.")
                false
            }

            TextUtils.isEmpty(password) ->{
                showSnackBar("Please enter a password.")
                false
            }

            else ->{
                true
            }
        }
    }
}
