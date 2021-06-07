package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.potensial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentPotentialDonorsBinding

class PotentialDonorsFragment : Fragment() {

    private lateinit var potentialDonorsBinding: FragmentPotentialDonorsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        potentialDonorsBinding = FragmentPotentialDonorsBinding.inflate(inflater, container,
                false)
        return potentialDonorsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null)
        {
            // set progress bar
            val potentialAdapter = PotentialAdapter()
            //potentialAdapter.setPList()         // put data to rv

            with (potentialDonorsBinding.rvPotential)
            {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = potentialAdapter
            }
        }
    }
}