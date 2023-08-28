package com.example.homework_3m_6_audio_player


import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment() {

    private lateinit var songs: ArrayList<Song>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        recyclerView = view.findViewById(R.id.rv_songs)
        val layoutManger = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManger
        val adapter = ListSongsAdapter(songs)
        recyclerView.adapter = adapter
    }

   private fun loadData(){
       songs= ArrayList()
       songs.add(Song("Blank Space", "Taylor Swift", "3:49", R.raw.taylor_swift_blank_space))
       songs.add(Song("Nutshell", "Alice In Chains", "3:49", R.raw.nutshell))
       songs.add(Song("Numb", "Linkin Park", "3:49", R.raw.numb))
       songs.add(Song("Mockingbird", "Eminem", "3:49", R.raw.mockingbird))
       songs.add(Song("Take a lk arnd", "Limp Bizkit", "3:49", R.raw.takealookaround))


    }
}