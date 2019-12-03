package com.framblestd.loonatheapp.models.member

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.framblestd.loonatheapp.R
import com.framblestd.loonatheapp.activities.MemberDetailsActivity

/**
 * A simple [Fragment] subclass.
 */
class MemberListPageFragment : Fragment(),
            MemberListItemAdapter.EventListener {
    private lateinit var recyclerView: RecyclerView
    private val members = MemberRepository.all()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_member_list_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById<RecyclerView>(R.id.rv_members).apply {
            setHasFixedSize(true)
        }

        setupRecyclerView()
    }

    override fun onItemClick(member: Member) {
        activity.apply {
            val intent = Intent(this, MemberDetailsActivity::class.java).apply {
                putExtra(MemberDetailsActivity.EXTRA_MEMBER_ID, member.id)
            }
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        val memberListAdapter = MemberListItemAdapter(members).also {
            it.setEventListener(this)
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = memberListAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment MemberListPageFragment.
         */
        @JvmStatic
        fun newInstance() =
            MemberListPageFragment()
    }
}
