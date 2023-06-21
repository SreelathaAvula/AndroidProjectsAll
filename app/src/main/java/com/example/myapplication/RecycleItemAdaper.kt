package com.example.myapplication

import android.hardware.biometrics.BiometricManager.Strings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecycleItemAdaper(val names: List<String>) : Adapter<RecycleItemAdaper.DetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_view, parent, false)
        return DetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val user:String = names[position]
        holder.item.text = user

        //set click
    }
    class DetailViewHolder(itemview: View) : ViewHolder(itemview) {
        var item = itemview.findViewById<TextView>(R.id.item)
    }
}

