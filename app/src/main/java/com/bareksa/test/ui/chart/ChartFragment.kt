package com.bareksa.test.ui.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bareksa.test.data.resource.DataDummy
import com.bareksa.test.databinding.FragmentChartBinding
import com.bareksa.test.utils.DayAxisValueFormatter
import com.bareksa.test.utils.MyAxisValueFormatter
import com.github.mikephil.charting.components.XAxis

class ChartFragment : Fragment() {
    private lateinit var binding: FragmentChartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chart = binding.chart1
        chart.description.isEnabled = false
        chart.setMaxVisibleValueCount(60)
        chart.setDrawGridBackground(false)
        chart.data = DataDummy.getSampleData(requireContext())
        chart.animateX(3000)
        chart.axisLeft.isEnabled = false

        val xAxisFormatter = DayAxisValueFormatter(chart)
        val xAxis = chart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.granularity = 1f // only intervals of 1 day
        xAxis.labelCount = 7
        xAxis.valueFormatter = xAxisFormatter

        val custom = MyAxisValueFormatter()
        val rightAxis = chart.axisRight
        rightAxis.setLabelCount(8, false)
        rightAxis.valueFormatter = custom
        rightAxis.spaceTop = 15f
        rightAxis.axisMinimum = 0f

        val l = chart.legend
        l.isEnabled = false
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ChartFragment()
    }
}