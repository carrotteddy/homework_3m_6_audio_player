package com.example.homework_3m_6_audio_player

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_3m_6_audio_player.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerBinding
    private var mediaPlayer: MediaPlayer? = null
    private var isPaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val songName = intent.getStringExtra("songName")
        val artistName = intent.getStringExtra("artistName")
        val songUri = intent.getIntExtra("songId", 0)
        binding.tvSongName.text = songName
        binding.tvArtistName.text = artistName
        mediaPlayer = MediaPlayer.create(this, songUri)
        mediaPlayer?.start()
        onClickListeners()

    }

    private fun onClickListeners() {
        binding.btnPause.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
                isPaused = true
            }
        }
        binding.btnPlay.setOnClickListener {
            if (isPaused) {
                mediaPlayer?.start()
                isPaused = false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}