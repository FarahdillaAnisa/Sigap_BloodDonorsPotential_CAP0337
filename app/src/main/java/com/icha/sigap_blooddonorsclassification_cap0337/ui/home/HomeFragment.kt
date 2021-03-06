package com.icha.sigap_blooddonorsclassification_cap0337.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentHomeBinding
import com.icha.sigap_blooddonorsclassification_cap0337.viewModel.ViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    lateinit var barData: BarData
    lateinit var BarChart: BarChart

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
            setChartData()
//            homeBinding.typeAPlus.text = viewModel.getIntPotensial().toString()
//            homeBinding.typeBPlus.text = viewModel.getIntNon().toString()
            setDonor()
        }
    }

    private fun setChartData()  // update data from server
    {
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
        homeBinding.typeAMin.text = "10"
        homeBinding.typeBMin.text = "24"
        homeBinding.typeOMin.text = "15"
        homeBinding.typeAbMin.text = "2"
    }
}