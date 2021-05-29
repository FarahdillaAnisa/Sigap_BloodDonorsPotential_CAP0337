package com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.screening

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.icha.sigap_blooddonorsclassification_cap0337.R

class ScreeningFormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screening_form, container, false)
    }
}