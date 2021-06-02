package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist

import android.content.Context
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.nonpotential.NonPotentialDonorsFragment
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.potensial.PotentialDonorsFragment

class DonorSectionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PotentialDonorsFragment()
            1 -> NonPotentialDonorsFragment()
            else -> Fragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}