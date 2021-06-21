package com.bareksa.test.ui.comparison

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bareksa.test.R
import com.bareksa.test.databinding.ActivityComparisonBinding
import com.bareksa.test.ui.comparison.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComparisonActivity : AppCompatActivity() {
    private val tabTitles = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
    )

    private lateinit var binding: ActivityComparisonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComparisonBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.ivBack.setOnClickListener {
           finish()
       }

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(tabTitles[position])
            binding.viewPager.setCurrentItem(tab.position, true)
        }.attach()


    }
}