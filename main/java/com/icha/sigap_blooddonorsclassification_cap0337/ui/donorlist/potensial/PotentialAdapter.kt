package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.potensial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ItemDonorsListBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.DonorListData

class PotentialAdapter : RecyclerView.Adapter<PotentialAdapter.PotentialHolder>() {

    private var potentialList = ArrayList<DonorListData>()

    fun setPList(potential : List<DonorListData>?)
    {
        if (potential == null) return
        this.potentialList.clear()
        this.potentialList.addAll(potential)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PotentialHolder {
        val itemsDonorsListBinding = ItemDonorsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PotentialHolder(itemsDonorsListBinding)
    }

    override fun onBindViewHolder(holder: PotentialHolder, position: Int) {
        val pList = potentialList[position]
        holder.bind(pList)
    }

    override fun getItemCount(): Int {
        return potentialList.size
    }

    class PotentialHolder (private val binding : ItemDonorsListBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind (pList : DonorListData)
        {
            with (binding)
            {
                Glide.with(itemView.context).load(pList.donorImage).into(imgPoster)
                tvItemName.text = pList.donorName
                tvItemNik.text = pList.donorNik
                tvItemBloodtype.text = pList.donorBloodType
            }
        }
    }
}