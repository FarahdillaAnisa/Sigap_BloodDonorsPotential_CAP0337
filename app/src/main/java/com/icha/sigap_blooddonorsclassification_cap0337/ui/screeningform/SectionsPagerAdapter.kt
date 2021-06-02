package com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.nonpotential.NonPotentialDonorsFragment
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.potensial.PotentialDonorsFragment
import com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.riwayat.RiwayatDonorFragment
import com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.screening.ScreeningFormFragment

class SectionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ScreeningFormFragment()
            1 -> RiwayatDonorFragment()
            else -> Fragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}