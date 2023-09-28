package com.example.kanyakavach

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.kanyakavach.databinding.ActivityDetailsBinding

import android.content.Context
import android.media.Image
import android.widget.ImageView

class BooksAdaptor(val list: ArrayList<BooksModel>, val context: Context): RecyclerView.Adapter<BooksAdaptor.ViewHolder>() {

    class ViewHolder(val binding: ActivityDetailsBinding): RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksAdaptor.ViewHolder {
       return ViewHolder(ActivityDetailsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        holder.binding.apply {
            imageView.setImageResource(model.image)
        }
    }

    override fun getItemCount() = list.size
}