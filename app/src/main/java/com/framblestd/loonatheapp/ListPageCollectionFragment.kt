package com.framblestd.loonatheapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass.
 */
class ListPageCollectionFragment : Fragment() {

    private lateinit var listPageCollectionPagerAdapter: ListPageCollectionPagerAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_page_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listPageCollectionPagerAdapter = ListPageCollectionPagerAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.view_pager)
        viewPager.adapter = listPageCollectionPagerAdapter

        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }
}
