package com.framblestd.loonatheapp.models.discography


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.framblestd.loonatheapp.MusicLinkService

import com.framblestd.loonatheapp.R
import com.framblestd.loonatheapp.activities.SongDetailsActivity

/**
 * A simple [Fragment] subclass.
 */
class SongListPageFragment : Fragment(), SongListItemAdapter.EventListener {

    private lateinit var recyclerView: RecyclerView
    private val songs = SongRepository.all()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song_list_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById<RecyclerView>(R.id.rv_songs).apply {
            setHasFixedSize(true)
        }

        setupRecyclerView()
    }

    override fun onItemClick(song: Song) {
        activity.apply {
            val intent = Intent(this, SongDetailsActivity::class.java).apply {
                putExtra(SongDetailsActivity.EXTRA_SONG_ID, song.id)
            }
            startActivity(intent)
        }
    }

    override fun onMusicLinkButtonClick(musicLink: String) {
        MusicLinkService.open(activity as Activity, musicLink)
    }

    private fun setupRecyclerView() {
        val songListAdapter = SongListItemAdapter(songs).also {
            it.setEventListener(this)
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = songListAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SongListPageFragment.
         */
        @JvmStatic
        fun newInstance() =
            SongListPageFragment()
    }


}
