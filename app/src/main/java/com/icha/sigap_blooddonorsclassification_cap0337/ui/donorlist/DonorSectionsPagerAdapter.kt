package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
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