package com.bareksa.test.ui.comparison.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bareksa.test.ui.fundmanaged.FundManagedFragment
import com.bareksa.test.ui.fundyield.FundYieldFragment

class SectionsPagerAdapter(
    fa: FragmentActivity
) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FundYieldFragment.newInstance()
            1 -> FundManagedFragment.newInstance()
            else -> FundYieldFragment.newInstance()
        }
    }

}