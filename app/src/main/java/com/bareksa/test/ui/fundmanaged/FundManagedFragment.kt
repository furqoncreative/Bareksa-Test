package com.bareksa.test.ui.fundmanaged

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bareksa.test.R

class FundManagedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fund_managed, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FundManagedFragment()
    }
}