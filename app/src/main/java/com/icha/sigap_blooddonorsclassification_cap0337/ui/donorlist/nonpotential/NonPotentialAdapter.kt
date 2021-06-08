package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.nonpotential

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ItemDonorsListBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.DonorListData

class NonPotentialAdapter : RecyclerView.Adapter<NonPotentialAdapter.NonPotentialHolder>() {

    private var nonPotentialList = ArrayList<DataPendonorEntity>()

    fun setNPList(nonPotential : List<DataPendonorEntity>?)
    {
        if (nonPotential == null) return
        this.nonPotentialList.clear()
        this.nonPotentialList.addAll(nonPotential)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NonPotentialHolder {
        val itemsDonorsListBinding = ItemDonorsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NonPotentialAdapter.NonPotentialHolder(itemsDonorsListBinding)
    }

    override fun onBindViewHolder(holder: NonPotentialHolder, position: Int) {
        val nPList = nonPotentialList[position]
        holder.bind(nPList)
    }

    override fun getItemCount(): Int {
        return nonPotentialList.size
    }

    class NonPotentialHolder (private val binding : ItemDonorsListBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind (nPList : DataPendonorEntity)
        {
            with (binding)
            {
                Glide.with(itemView.context).load(R.drawable.profile_user).into(imgPoster)
                tvItemName.text = nPList.nama
                tvItemNik.text = nPList.nik
                tvItemBloodtype.text = nPList.golonganDarah
            }
        }
    }
}