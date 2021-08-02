package com.hyeonseungson.study07project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.song.view.*

class SongAdapter : RecyclerView.Adapter<SongAdapter.ViewHolder>(){

    // items 라는 이름의 ArrayList 생성 (단, 해당 ArrayList 는 SongItem Class 형의 객체가 들어갑니다.
    var items = ArrayList<Song>()

    // Interface 생성
    lateinit var listener : OnSongItemClickListener

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.song, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                listener?.onItemClick(this, itemView, adapterPosition)
            }
        }
        fun setItem (item: Song) {
            itemView.titleTextView.text = item.title
            itemView.singerTextView.text = item.singer
        }
    }
}