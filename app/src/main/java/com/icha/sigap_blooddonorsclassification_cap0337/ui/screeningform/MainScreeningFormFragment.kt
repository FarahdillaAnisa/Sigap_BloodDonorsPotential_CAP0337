package com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityScreeningFormBinding

class MainScreeningFormFragment : Fragment() {

    companion object
    {
        @StringRes
        private val TAB = intArrayOf(R.string.data_pendonor)
    }

    private lateinit var screeningFormBinding: ActivityScreeningFormBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        screeningFormBinding = ActivityScreeningFormBinding.inflate(inflater, container,
            false)
        return screeningFormBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val screeningListPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = screeningFormBinding.viewPager
        viewPager.adapter = screeningListPagerAdapter
        val tabs: TabLayout = screeningFormBinding.tabs
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB[position])
        }.attach()
    }
}