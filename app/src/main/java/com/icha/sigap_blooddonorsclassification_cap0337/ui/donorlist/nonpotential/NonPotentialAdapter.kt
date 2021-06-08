package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.nonpotential

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.ItemDonorsListBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donordetails.DonorsDetailActivity
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
        return NonPotentialHolder(itemsDonorsListBinding)
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
                Glide.with(itemView.context)
                    .load(R.drawable.man)
                    .apply(RequestOptions().override(48, 48))
                    .into(imgPoster)
                tvItemName.text = nPList.nama
                tvItemNik.text = nPList.nik
                val text = "${nPList.golonganDarah}  ${nPList.rhesus}"
                tvItemBloodtype.text = text
            }

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DonorsDetailActivity::class.java)
                intent.putExtra(DonorsDetailActivity.EXTRA_NIK, nPList.nik)
                itemView.context.startActivity(intent)
            }
        }
    }
}