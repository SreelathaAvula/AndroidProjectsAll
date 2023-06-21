package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
     var nameList:ArrayList<String> = ArrayList()
    lateinit var  nameEditText:EditText
    lateinit var button: Button
    private lateinit var nameAdapter: RecycleItemAdaper
    lateinit var   recycleId:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //reference we are updating names to recycleview
        recycleId= findViewById(R.id.recycle_id)
        nameEditText=findViewById(  R.id.write_Details)
        button=findViewById(  R.id.submit_button)
//        nameList= arrayListOf()
        button.setOnClickListener {
            var names:String=nameEditText.text.toString()
            nameList.add(names)
            recycleId.adapter?.notifyDataSetChanged()
            nameEditText.text.clear()
        }
        //binding data from the nameList to the views in the RecyclerView.
        nameAdapter=RecycleItemAdaper(nameList)
        //data to be displayed in the RecyclerView.
        recycleId.adapter = nameAdapter
        //items in the RecyclerView are displayed.vertically in linearlayout
        recycleId.layoutManager = LinearLayoutManager(this)

    }
/*    fun deleteEvent(position:Int){
        var element:String=nameList.get(position)
        nameList.remove(element)
        recycleId.adapter?.notifyItemRemoved(position)
    }*/
}