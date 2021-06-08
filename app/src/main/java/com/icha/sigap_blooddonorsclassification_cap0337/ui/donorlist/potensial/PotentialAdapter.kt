package com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.potensial

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
import com.icha.sigap_blooddonorsclassification_cap0337.vo.Resource

class PotentialAdapter : RecyclerView.Adapter<PotentialAdapter.PotentialHolder>() {

    private var potentialList = ArrayList<DataPendonorEntity>()

    fun setPList(potential : List<DataPendonorEntity>)
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

    inner class PotentialHolder (private val binding : ItemDonorsListBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind (pList : DataPendonorEntity)
        {
            with (binding)
            {
                Glide.with(itemView.context)
                    .load(R.drawable.man)
                    .apply(RequestOptions().override(48,48))
                    .into(imgPoster)

                tvItemName.text = pList.nama
                tvItemNik.text = pList.nik
                val text = "${pList.golonganDarah} ${pList.rhesus}"
                tvItemBloodtype.text = text
            }

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DonorsDetailActivity::class.java)
                intent.putExtra(DonorsDetailActivity.EXTRA_NIK, pList.nik)
                itemView.context.startActivity(intent)
            }
        }
    }
}