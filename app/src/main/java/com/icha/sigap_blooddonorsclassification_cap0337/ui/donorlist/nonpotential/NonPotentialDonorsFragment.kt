package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.nonpotential

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
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentNonpotentialDonorsBinding
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentPotentialDonorsBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.DonorListViewModel
import com.icha.sigap_blooddonorsclassification_cap0337.viewModel.ViewModelFactory
import com.icha.sigap_blooddonorsclassification_cap0337.vo.Status

class NonPotentialDonorsFragment : Fragment() {

    private lateinit var nonpotentialDonorsBinding: FragmentNonpotentialDonorsBinding
    private lateinit var nonpotentialViewModel : DonorListViewModel
    private lateinit var nonpotentialAdapter : NonPotentialAdapter

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
            val factory = ViewModelFactory.getInstance(requireActivity())
            nonpotentialViewModel = ViewModelProvider(this, factory)[DonorListViewModel::class.java]
            nonpotentialAdapter = NonPotentialAdapter()
            //nonPotentialAdapter.setNPList()         // put data to rv

            nonpotentialViewModel.getDataNon().observe(viewLifecycleOwner, { nonPotentialData ->
                if (nonPotentialData != null) {
                    when(nonPotentialData.status) {
                        Status.LOADING -> nonpotentialDonorsBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS ->  {
                            nonpotentialDonorsBinding.progressBar.visibility = View.GONE
                            nonpotentialAdapter.setNPList(nonPotentialData as List<DataPendonorEntity>)
                            nonpotentialAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            nonpotentialDonorsBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })

            with (nonpotentialDonorsBinding.rvTemporary)
            {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = nonpotentialAdapter
            }
        }
    }
}