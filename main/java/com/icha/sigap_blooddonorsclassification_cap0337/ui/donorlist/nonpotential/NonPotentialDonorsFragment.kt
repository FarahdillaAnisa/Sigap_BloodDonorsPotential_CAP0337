package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.nonpotential

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentNonpotentialDonorsBinding
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentPotentialDonorsBinding

class NonPotentialDonorsFragment : Fragment() {

    private lateinit var nonpotentialDonorsBinding: FragmentNonpotentialDonorsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        nonpotentialDonorsBinding = FragmentNonpotentialDonorsBinding.inflate(inflater, container,
                false)
        return nonpotentialDonorsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null)
        {
            // set progress bar
            val nonPotentialAdapter = NonPotentialAdapter()
            //nonPotentialAdapter.setNPList()         // put data to rv

            with (nonpotentialDonorsBinding.rvTemporary)
            {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = nonPotentialAdapter
            }
        }
    }
}