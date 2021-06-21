package com.bareksa.test.data.resource

import android.content.Context
import com.bareksa.test.R
import com.bareksa.test.data.model.fund.Fund
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

object DataDummy {

    fun getSampleData(context: Context): LineData {
        val sets = ArrayList<ILineDataSet>()
        val entry1 = (1..100).map { Entry(it.toFloat(), it * 2f) }.toList()
        val entry2 = (1..100).map { Entry(it.toFloat(), it * 3f) }.toList()
        val entry3 = (1..100).map { Entry(it.toFloat(), it * 4f) }.toList()

        val ds1 = LineDataSet(entry1, "")
        val ds2 = LineDataSet(
            entry2,
            ""
        )
        val ds3 = LineDataSet(
            entry3,
            ""
        )

        ds1.color = context.getColor(R.color.chart_navy)
        ds2.color = context.getColor(R.color.chart_purple)
        ds3.color = context.getColor(R.color.chart_green)
        ds1.setCircleColor(context.getColor(R.color.chart_navy))
        ds2.setCircleColor(context.getColor(R.color.chart_purple))
        ds3.setCircleColor(context.getColor(R.color.chart_green))
        ds1.lineWidth = 2.5f
        ds1.circleRadius = 1f
        ds2.lineWidth = 2.5f
        ds2.circleRadius = 1f
        ds3.lineWidth = 2.5f
        ds3.circleRadius = 1f


        sets.add(ds1)
        sets.add(ds2)
        sets.add(ds3)
        return LineData(sets)
    }


    fun getFundList() =  arrayListOf(
        Fund(
            1,
            "BNI-AM Inspiring Equity Fund",
            R.drawable.ic_bni,
            "Saham",
            "5,50% / 5 thn",
            "3,64 Miliar",
            "1 Juta",
            "5 Tahun",
            "Tinggi",
            "16 Apr 2014"
        ),


        Fund(
            2,
            "Cipta Dana Cash",
            R.drawable.ic_ciptadana,
            "Pasar Uang",
            "6,29% / thn",
            "215,97 Miliar",
            "100 Ribu",
            "1 Tahun",
            "Rendah",
            "14 Jan 2016"
        ),
        Fund(
            3,
            "Ascend Reksa Dana Saham Eq...",
            R.drawable.ic_ascend,
            "Saham",
            "7,17% / 5 thn",
            "3,89 Triliun",
            "100 Ribu",
            "5 Tahun",
            "Tinggi",
            "20 Feb 2007"
        )
    )

}
