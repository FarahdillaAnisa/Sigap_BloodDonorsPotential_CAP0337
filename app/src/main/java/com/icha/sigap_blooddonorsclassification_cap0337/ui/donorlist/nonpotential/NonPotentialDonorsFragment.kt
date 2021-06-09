package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.nonpotential

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentNonpotentialDonorsBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.DonorListViewModel
import com.icha.sigap_blooddonorsclassification_cap0337.viewModel.ViewModelFactory

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

            nonpotentialDonorsBinding.progressBar.visibility = View.VISIBLE
            nonpotentialViewModel.getDataNon().observe(viewLifecycleOwner, { nonPotentialData ->
                if (nonPotentialData != null) {
                    nonpotentialDonorsBinding.progressBar.visibility = View.GONE
                    nonpotentialAdapter.setNPList(nonPotentialData)
                    nonpotentialAdapter.notifyDataSetChanged()
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