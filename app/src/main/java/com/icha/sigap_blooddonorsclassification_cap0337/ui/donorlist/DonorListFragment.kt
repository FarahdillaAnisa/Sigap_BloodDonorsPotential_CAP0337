package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityBloodDonorsListBinding
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentHomeBinding

class DonorListFragment : Fragment() {

    private lateinit var donorsListBinding: ActivityBloodDonorsListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        donorsListBinding = ActivityBloodDonorsListBinding.inflate(inflater, container,
            false)
        return donorsListBinding.root
    }
}