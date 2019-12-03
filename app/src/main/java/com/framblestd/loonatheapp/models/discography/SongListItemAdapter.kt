package com.framblestd.loonatheapp.models.discography

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.framblestd.loonatheapp.R
import kotlinx.android.synthetic.main.item_row_song.view.*
import java.time.Duration
import kotlin.math.floor

class SongListItemAdapter(private val songs: List<Song>) : RecyclerView.Adapter<SongListItemAdapter.ListViewHolder>() {

    private lateinit var eventListener: EventListener

    fun setEventListener(eventListener: EventListener) {
        this.eventListener = eventListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_song, parent, false)
        )
    }

    override fun getItemCount(): Int = songs.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val song = songs[position]
        val artistsInString = song.artists.map { it.name }.joinToString(", ")
        val duration = convertToMMSS(song.lengthInSeconds)

        Glide.with(holder.itemView.context)
            .load(song.coverArt)
            .apply(RequestOptions().override(IMAGE_WIDTH, IMAGE_HEIGHT))
            .into(holder.ivCoverArt)

        holder.tvTitle.text = song.title
        holder.tvArtistsAndDuration.text = "$artistsInString · $duration"

        holder.itemView.setOnClickListener { eventListener.onItemClick(song) }
        holder.ibMusicLink.setOnClickListener { eventListener.onMusicLinkButtonClick(song.musicLink) }
    }

    private fun convertToMMSS(seconds: Int): String {
        return "${floor(seconds / 60f).toInt()}:${seconds % 60}"
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCoverArt: ImageView = itemView.findViewById(R.id.iv_cover_art)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvArtistsAndDuration: TextView = itemView.findViewById(R.id.tv_artists_and_duration)
        val ibMusicLink: ImageButton = itemView.findViewById(R.id.ib_music_link)
    }

    interface EventListener {
        fun onItemClick(song: Song)
        fun onMusicLinkButtonClick(musicLink: String)
    }

    companion object {
        private const val IMAGE_WIDTH = 64
        private const val IMAGE_HEIGHT = 64
    }
}