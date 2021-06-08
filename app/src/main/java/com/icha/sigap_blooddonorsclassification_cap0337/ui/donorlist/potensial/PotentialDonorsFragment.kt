package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.potensial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentPotentialDonorsBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.DonorListViewModel
import com.icha.sigap_blooddonorsclassification_cap0337.viewModel.ViewModelFactory
import com.icha.sigap_blooddonorsclassification_cap0337.vo.Status

class PotentialDonorsFragment : Fragment() {

    private lateinit var potentialDonorsBinding: FragmentPotentialDonorsBinding
    private lateinit var potensialViewModel : DonorListViewModel
    private lateinit var potensialAdapter : PotentialAdapter

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
            val factory = ViewModelFactory.getInstance(requireActivity())
            potensialViewModel = ViewModelProvider(this, factory)[DonorListViewModel::class.java]
            potensialAdapter = PotentialAdapter()
            //potentialAdapter.setPList()         // put data to rv

            potentialDonorsBinding.progressBar.visibility = View.VISIBLE
            potensialViewModel.getDataPotensial().observe(viewLifecycleOwner, { potensialData ->
                if (potensialData != null) {
                    potentialDonorsBinding.progressBar.visibility = View.GONE
                    potensialAdapter.setPList(potensialData)
                    potensialAdapter.notifyDataSetChanged()
                }
            })

            with (potentialDonorsBinding.rvPotential)
            {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = potensialAdapter
            }
        }
    }
}