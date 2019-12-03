package com.framblestd.loonatheapp.models.member

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.framblestd.loonatheapp.R
import de.hdodenhof.circleimageview.CircleImageView

class MemberListItemAdapter(private val members: List<Member>) : RecyclerView.Adapter<MemberListItemAdapter.ListViewHolder>() {

    private lateinit var eventListener: EventListener

    fun setEventListener(eventListener: EventListener) {
        this.eventListener = eventListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_member, parent, false)
        )
    }

    override fun getItemCount(): Int = members.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val member = members[position]

        Glide.with(holder.itemView.context)
            .load(member.picture)
            .apply(RequestOptions().override(
                IMAGE_WIDTH,
                IMAGE_HEIGHT
            ))
            .into(holder.civPicture)

        holder.tvName.text = member.name
        holder.tvSubUnit.text = member.subUnit
        holder.itemView.setOnClickListener { eventListener.onItemClick(member) }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvSubUnit: TextView = itemView.findViewById(R.id.tv_subunit)
        val civPicture: CircleImageView = itemView.findViewById(R.id.civ_picture)
    }

    interface EventListener {
        fun onItemClick(member: Member)
    }

    companion object {
        private const val IMAGE_WIDTH = 64
        private const val IMAGE_HEIGHT = 64
    }

}