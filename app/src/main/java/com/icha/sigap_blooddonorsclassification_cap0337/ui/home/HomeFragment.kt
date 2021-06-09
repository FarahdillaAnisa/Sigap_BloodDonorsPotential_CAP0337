package com.icha.sigap_blooddonorsclassification_cap0337.ui.home

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentHomeBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.register.RegisterData

class HomeFragment : Fragment() {

    //private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeBinding: FragmentHomeBinding

    lateinit var barData: BarData
    lateinit var BarChart: BarChart

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setChartData()
        setDonor()
    }

    private fun setChartData()  // update data from server
    {
        //BarChart = view?.findViewById(R.id.b_stock_chart)!!
        BarChart = homeBinding.bStockChart

        val xVal = ArrayList<String>()
        xVal.add("A")
        xVal.add("B")
        xVal.add("O")
        xVal.add("AB")

        val barEntry = ArrayList<BarEntry>()    // put data to chart
        barEntry.add(BarEntry(8721f, 0))
        barEntry.add(BarEntry(9748f, 1))
        barEntry.add(BarEntry(13013f, 2))
        barEntry.add(BarEntry(2678f, 3))

        val barDataSet = BarDataSet(barEntry, "Blood Stock")
        barData = BarData(xVal, barDataSet)
        BarChart.data = barData

        barDataSet.color = resources.getColor(R.color.light_red)
        barDataSet.valueTextSize = 12f
    }

    private fun setDonor()      // update data from server
    {   // put data to total donor people
        homeBinding.typeAPlus.text = "87"
        homeBinding.typeBPlus.text = "97"
        homeBinding.typeOPlus.text = "130"
        homeBinding.typeAbPlus.text = "76"
        homeBinding.typeAMin.text = "11"
        homeBinding.typeBMin.text = "11"
        homeBinding.typeAbMin.text = "19"
        homeBinding.typeOMin.text = "10"
    }
}