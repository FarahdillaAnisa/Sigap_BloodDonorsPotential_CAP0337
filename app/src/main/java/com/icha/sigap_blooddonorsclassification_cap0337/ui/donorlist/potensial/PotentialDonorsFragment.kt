package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.potensial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.icha.sigap_blooddonorsclassification_cap0337.R

class PotentialDonorsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_potential_donors, container, false)
    }

}