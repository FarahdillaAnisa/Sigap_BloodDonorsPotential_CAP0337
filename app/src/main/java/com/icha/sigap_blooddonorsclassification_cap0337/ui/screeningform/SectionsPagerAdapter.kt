package com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.riwayat.RiwayatDonorFragment
import com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.personaldata.PersonalFormFragment

class SectionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PersonalFormFragment()
//            1 -> RiwayatDonorFragment()
            else -> Fragment()
        }
    }

    override fun getItemCount(): Int {
        return 1
    }
}