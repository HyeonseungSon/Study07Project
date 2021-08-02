package com.hyeonseungson.study07project

import android.view.View

interface OnSongItemClickListener {

    fun onItemClick (holder : SongAdapter.ViewHolder?, view : View?, position : Int)
}