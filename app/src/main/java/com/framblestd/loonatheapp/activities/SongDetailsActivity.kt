package com.framblestd.loonatheapp.activities

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updateLayoutParams
import com.bumptech.glide.Glide
import com.framblestd.loonatheapp.MusicLinkService
import com.framblestd.loonatheapp.R
import com.framblestd.loonatheapp.models.discography.Song
import com.framblestd.loonatheapp.models.discography.SongRepository
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.activity_song_details.*
import kotlin.math.floor

class SongDetailsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbarLayout: CollapsingToolbarLayout
    private lateinit var tvArtists: TextView
    private lateinit var tvAlbum: TextView
    private lateinit var tvGenres: TextView
    private lateinit var tvLyricists: TextView
    private lateinit var tvComposers: TextView
    private lateinit var tvArrangers: TextView
    private lateinit var tvLength: TextView
    private lateinit var tvDescription: TextView
    private lateinit var song: Song

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_details)
        setSupportActionBar(toolbar)
        fab.setOnClickListener(this)

        toolbarLayout = findViewById(R.id.toolbar_layout)
        tvArtists = findViewById(R.id.tv_artists)
        tvAlbum = findViewById(R.id.tv_album)
        tvGenres = findViewById(R.id.tv_genres)
        tvLyricists = findViewById(R.id.tv_lyricists)
        tvComposers = findViewById(R.id.tv_composers)
        tvArrangers = findViewById(R.id.tv_arrangers)
        tvLength = findViewById(R.id.tv_length)
        tvDescription = findViewById(R.id.tv_description)

        fetchSongFromRepository()
        displaySongToView()
    }

    private fun displaySongToView() {
        toolbarLayout.background = getDrawable(song.coverArt)
        tvArtists.text = song.artists.joinToString(", ") { it.name }
        tvAlbum.text =  song.album
        tvGenres.text = song.genres
        tvLyricists.text = song.lyricists
        tvComposers.text = song.composers
        tvArrangers.text = song.arrangers
        tvLength.text = convertToMMSS(song.lengthInSeconds)
        tvDescription.text = song.description
        title = song.title

        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
            setDisplayShowTitleEnabled(true)
        }

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        app_bar.updateLayoutParams { height = displayMetrics.widthPixels }
    }

    private fun convertToMMSS(seconds: Int): String {
        return "${floor(seconds / 60f).toInt()}:${seconds % 60}"
    }

    private fun fetchSongFromRepository() {
        val songId = intent.getIntExtra(EXTRA_SONG_ID, 0)
        val song = SongRepository.findById(songId)

        if (song != null) {
            this.song = song
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return true
    }

    override fun onClick(view: View?) {
        MusicLinkService.open(this, song.musicLink)
    }

    companion object {
        const val EXTRA_SONG_ID = "extra_song_id"
    }
}
