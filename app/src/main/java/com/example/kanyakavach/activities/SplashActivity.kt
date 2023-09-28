package com.example.kanyakavach.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.kanyakavach.R
import com.example.kanyakavach.firebase.FireStoreClass
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        var typeface1: Typeface = Typeface.createFromAsset(assets, "Maleantes Tres-d.ttf")
        tv_app_name.typeface= typeface1

        Handler().postDelayed({
            val currentUserID= FireStoreClass().getCurrentUserID()
            val currentUser= FirebaseAuth.getInstance().currentUser
            if(currentUser!= null)
            {
                startActivity(Intent(this, LandingActivity::class.java))
            }else{
                startActivity(Intent(this, IntroActivity::class.java))
            }
            finish()
        }, 1500)
    }
}