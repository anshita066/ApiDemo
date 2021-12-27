package com.example.apidemo


import Creator
import Question
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration

import com.example.apidemo.interfaces.SearchRepoImp
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apidemo.adapter.RecyclerAdapter

class MainActivity : AppCompatActivity() {

    private var titleList = ArrayList<Question> ()

    private lateinit var myAdapter : RecyclerAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)

        myAdapter = RecyclerAdapter(titleList)
        val recyclerview = findViewById<RecyclerView>(R.id.rv_title)

        recyclerview.layoutManager  = layoutManager

         recyclerview.adapter = myAdapter

//        var itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
//        getDrawable(R.drawable.recyclerview_divider)?.let { itemDecoration.setDrawable(it) }
//
//       recyclerview.addItemDecoration(itemDecoration)


        val searchRepoImp = SearchRepoImp()

        searchRepoImp.fetchSearchHarkList(0, 20, "don", "playlist")
            .observe(this, Observer {
                // Logic for UI

                Log.d("MAIN ACTIVITY","get title")

                titleList = it as ArrayList<Question>
                myAdapter.setItems(titleList)
                myAdapter.notifyDataSetChanged()

            })

    }
}

