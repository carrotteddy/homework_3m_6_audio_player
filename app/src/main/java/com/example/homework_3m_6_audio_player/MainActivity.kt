package com.example.homework_3m_6_audio_player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.homework_3m_6_audio_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentStart()

    }
    private fun fragmentStart(){
        val fragmentManager:FragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragmentMain = MainFragment()
        fragmentTransaction.replace(R.id.container, fragmentMain)
        val  fragmentList = ListFragment()
        fragmentTransaction.replace(R.id.container_2, fragmentList)
        fragmentTransaction.commit()
    }
}