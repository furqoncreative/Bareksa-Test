package com.bareksa.test.ui.fundyield

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.bareksa.test.R
import com.bareksa.test.databinding.FragmentFundYieldBinding
import com.bareksa.test.ui.fundyield.adapter.FunYieldAdapter
import com.bareksa.test.ui.fundyield.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@Suppress("DEPRECATION")
@AndroidEntryPoint
class FundYieldFragment : Fragment() {
    private lateinit var binding: FragmentFundYieldBinding
    private lateinit var adapter: FunYieldAdapter
    private val viewModel: FundYieldViewModel by viewModels()

    private val tabTitles = arrayOf(
        R.string.text_1w,
        R.string.text_1m,
        R.string.text_1y,
        R.string.text_3y,
        R.string.text_5y,
        R.string.text_10y,
        R.string.text_all
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFundYieldBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionsPagerAdapter = SectionsPagerAdapter(requireActivity())
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(tabTitles[position])
            binding.viewPager.setCurrentItem(tab.position, true)
        }.attach()

        setRecyclerView()
    }


    private fun setRecyclerView() {
        adapter = FunYieldAdapter(requireContext())
        val gl = GridLayoutManager(context, 6)
        gl.spanSizeLookup = MySizeLookup()
        binding.rvFund.layoutManager = gl
        binding.rvFund.setHasFixedSize(true)
        binding.rvFund.adapter = adapter
        adapter.setItems(viewModel.getFundList)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FundYieldFragment()
    }
}

class MySizeLookup : SpanSizeLookup() {
    override fun getSpanSize(position: Int): Int {
        return if (position in 0..2) {
            2
        } else if (position == 3 || position == 6) {
            1
        } else {
            2
        }
    }
}