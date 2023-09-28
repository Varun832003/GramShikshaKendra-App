package com.example.kanyakavach.activities

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kanyakavach.Profile
import com.example.kanyakavach.R
import com.example.kanyakavach.Settings
import com.example.kanyakavach.Support
import com.example.kanyakavach.databinding.ActivityLandingBinding
import kotlinx.android.synthetic.main.activity_landing.btn1
import kotlinx.android.synthetic.main.activity_landing.btn2
import kotlinx.android.synthetic.main.activity_landing.btn5

class LandingActivity : BaseActivity(){
    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
//        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_landing)

//        binding.bottomNavigationView.setOnItemSelectedListener {
//            when(it.itemId){
//                R.id.profile -> replaceFragment(Profile())
//                R.id.support -> replaceFragment(Support())
//                R.id.settings -> replaceFragment(Settings())
//
//                else -> {
//
//                }
//            }
//            true
//        }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        btn1.setOnClickListener {
            val intent = Intent(this@LandingActivity, StudyMaterialActivity::class.java)
            startActivity(intent)
        }

    }
//    private fun replaceFragment(fragment: Fragment){
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frame_layout,fragment)
//        fragmentTransaction.commit()
//    }

}