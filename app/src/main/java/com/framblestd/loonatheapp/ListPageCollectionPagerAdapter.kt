package com.framblestd.loonatheapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.framblestd.loonatheapp.models.discography.SongListPageFragment
import com.framblestd.loonatheapp.models.member.MemberListPageFragment

class ListPageCollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> MemberListPageFragment.newInstance()
        1 -> SongListPageFragment.newInstance()
        else -> MemberListPageFragment.newInstance()
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> "MEMBERS"
        1 -> "SONGS"
        else -> "OBJECT ${(position + 1)}"
    }
}
