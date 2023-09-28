package com.example.kanyakavach.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kanyakavach.BooksAdaptor
import com.example.kanyakavach.BooksModel
import com.example.kanyakavach.R
import com.example.kanyakavach.databinding.ActivityStudyMaterialBinding
import kotlinx.android.synthetic.main.activity_details.imageView

class StudyMaterialActivity : AppCompatActivity() {
    lateinit var binding: ActivityStudyMaterialBinding
    val activity = this
    val list: ArrayList<BooksModel> = ArrayList()
    val adapter = BooksAdaptor(list, activity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudyMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            mrecyclerViewHome.adapter  = adapter

            list.add(BooksModel(R.drawable.english,"English","bookpdf.pdf"))
            list.add(BooksModel(R.drawable.maths_v,"Maths","bookpdf.pdf"))
            list.add(BooksModel(R.drawable.history,"History","bookpdf.pdf"))
            list.add(BooksModel(R.drawable.science,"Science","bookpdf.pdf"))
            list.add(BooksModel(R.drawable.vigyan,"Vigyan","bookpdf.pdf"))
        }

    }
}

