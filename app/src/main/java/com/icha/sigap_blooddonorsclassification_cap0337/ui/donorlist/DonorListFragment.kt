package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityBloodDonorsListBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.ScreeningFormActivity

class DonorListFragment : Fragment() {

    companion object
    {
        @StringRes
        private val TAB = intArrayOf(R.string.potensial, R.string.tidak_potensial)
    }

    private lateinit var donorsListBinding: ActivityBloodDonorsListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        donorsListBinding = ActivityBloodDonorsListBinding.inflate(inflater, container,
            false)
        return donorsListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val donorListPagerAdapter = donorListPagerAdapter(context?.applicationContext!!,
                childFragmentManager)
        donorsListBinding.framePager.adapter = donorListPagerAdapter
        donorsListBinding.frameTab.setupWithViewPager(donorsListBinding.framePager)*/

        val donorListPagerAdapter = DonorSectionsPagerAdapter(this)
        val viewPager: ViewPager2 = donorsListBinding.viewPager
        viewPager.adapter = donorListPagerAdapter
        val tabs: TabLayout = donorsListBinding.tabs
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB[position])
        }.attach()
    }
}