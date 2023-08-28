package com.example.homework_3m_6_audio_player

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ListSongsAdapter(private val songs: ArrayList<Song>) :
    Adapter<ListSongsAdapter.ViewHolder>() {
    private lateinit var context: Context
    private var songCounter = 0


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val songName: TextView = itemView.findViewById(R.id.tv_song_name)
        val singerName: TextView = itemView.findViewById(R.id.tv_singer_name)
        val songDuration: TextView = itemView.findViewById(R.id.tv_song_duration)
        val tvSongCounter: TextView = itemView.findViewById(R.id.tv_song_counter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_song, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = songs[position]
        holder.songName.text = song.songName
        holder.singerName.text = song.singerName
        holder.songDuration.text = song.songDuration
        songCounter++
        holder.tvSongCounter.text = songCounter.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(context, PlayerActivity::class.java)
            intent.putExtra("songName", song.songName)
            intent.putExtra("artistName", song.singerName)
            intent.putExtra("songId", song.songUri)
            context.startActivity(intent)
        }
    }
}