package com.hyeonseungson.study07project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        val adapter = SongAdapter()
        recyclerView.adapter = adapter

        adapter.listener = object : OnSongItemClickListener {
            override fun onItemClick(holder: SongAdapter.ViewHolder?, view: View?, position: Int) {
                val name = adapter.items[position]
                showToast("아이템 선택됨 : $name")

            }
        }
        addButton.setOnClickListener {
            val title = input1.text.toString()
            Log.d("title : ", title)
            val singer = input2.text.toString()
            Log.d("singer", singer)

            adapter.items.add(Song(title, singer))
            adapter.notifyDataSetChanged()
        }
    }
    fun showToast (message : String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}