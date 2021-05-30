package com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityBloodDonorsListBinding
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ActivityScreeningFormBinding

class MainScreeningFormFragment : Fragment() {

    private lateinit var screeningFormBinding: ActivityScreeningFormBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        screeningFormBinding = ActivityScreeningFormBinding.inflate(inflater, container,
            false)
        return screeningFormBinding.root
    }
}