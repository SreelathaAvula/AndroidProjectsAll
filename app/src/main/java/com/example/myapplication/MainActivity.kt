package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val names: List<String> = listOf("sree", "latha", "app", "scrip","revathi","bhanu","megha","pavani","mahesh","mouni","bharath","satheesh","savi","rani","mehu")
        val  recycleId:RecyclerView = findViewById(R.id.recycle_id);
        recycleId.adapter = RecycleItemAdaper(names)
        recycleId.layoutManager = LinearLayoutManager(this)

    }
}