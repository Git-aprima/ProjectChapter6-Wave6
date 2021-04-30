package com.example.batuguntingkertas.ui.play

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.ui.play.fragments.HistoryFragment
import com.example.batuguntingkertas.ui.play.fragments.HomeFragment
import com.example.batuguntingkertas.ui.play.fragments.MemberFragment
import com.example.batuguntingkertas.ui.play.fragments.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class PemainPemainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemain_pemain)

        setUpTabs()
    }

    private fun setUpTabs() {
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        var tabs = findViewById<TabLayout>(R.id.tabs)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(HistoryFragment(), "History")
        adapter.addFragment(MemberFragment(), "Member")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_history_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_card_membership_24)

    }
}