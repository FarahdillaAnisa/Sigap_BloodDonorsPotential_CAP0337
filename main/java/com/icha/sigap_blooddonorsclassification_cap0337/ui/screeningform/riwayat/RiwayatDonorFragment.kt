package com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.riwayat

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentRiwayatDonorBinding

class RiwayatDonorFragment : Fragment(), View.OnClickListener {

    private lateinit var riwayatDonorBinding: FragmentRiwayatDonorBinding

    private lateinit var riwayatNik : String
    private lateinit var riwayatRecency : String
    private lateinit var riwayatFrequency : String
    private lateinit var riwayatMonetary : String
    private lateinit var riwayatTime : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        riwayatDonorBinding = FragmentRiwayatDonorBinding.inflate(inflater, container,
                false)
        return riwayatDonorBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        riwayatDonorBinding.btnSaveRiwayat.setOnClickListener(this@RiwayatDonorFragment)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_save_riwayat)
        {
            with (riwayatDonorBinding)
            {
                riwayatNik = edtNik.text.toString()
                riwayatRecency = edtRecency.text.toString()
                riwayatFrequency = edtFrequency.text.toString()
                riwayatMonetary = edtMonetary.text.toString()
                riwayatTime = edtTime.text.toString()
            }

            if (riwayatNik.isEmpty() && riwayatRecency.isEmpty()
                    && riwayatFrequency.isEmpty() && riwayatMonetary.isEmpty()
                    && riwayatTime.isEmpty())
            {       // do process here
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Field can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()    // error
                alert.show()
            }
            else if (riwayatNik.isEmpty())
            {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("NIK can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (riwayatRecency.isEmpty())
            {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Recency can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (riwayatFrequency.isEmpty())
            {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Frequency can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (riwayatMonetary.isEmpty())
            {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Monetary can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (riwayatTime.isEmpty())
            {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Time can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (!(riwayatNik.isEmpty() && riwayatRecency.isEmpty()
                            && riwayatFrequency.isEmpty() && riwayatMonetary.isEmpty()
                            && riwayatTime.isEmpty()))
            {
                // save data to cloud

                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Success !")
                builder.setNegativeButton("OK") { dialog, _ ->
                    with (riwayatDonorBinding)
                    {
                        edtNik.text.clear()
                        edtRecency.text.clear()
                        edtFrequency.text.clear()
                        edtMonetary.text.clear()
                        edtTime.text.clear()
                    }

                    dialog.cancel()
                }
                val alert = builder.create()
                alert.show()
            }
        }
    }
}