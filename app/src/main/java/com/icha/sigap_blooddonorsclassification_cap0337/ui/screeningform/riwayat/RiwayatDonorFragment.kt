package com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.riwayat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.local.entity.DataPendonorEntity
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentRiwayatDonorBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ml.Test
import com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.DonorScreeningViewModel
import com.icha.sigap_blooddonorsclassification_cap0337.viewModel.ViewModelFactory
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

class RiwayatDonorFragment : Fragment(), View.OnClickListener {

    private lateinit var riwayatDonorBinding: FragmentRiwayatDonorBinding
    private lateinit var viewModel: DonorScreeningViewModel

    private lateinit var riwayatRecency : String
    private lateinit var riwayatFrequency : String
    private lateinit var riwayatMonetary : String
    private lateinit var riwayatTime : String
    private lateinit var hasilPrediksi : String
    private lateinit var nomorPrediksi : String

    companion object {
        var EXTRA_NIK = "extra_nik"
        var EXTRA_NAMA = "extra_nama"
        var EXTRA_JK = "extra_jk"
        var EXTRA_GOLONGANDARAH = "extra_golongandarah"
        var EXTRA_RHESUS = "extra_rhesus"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        riwayatDonorBinding = FragmentRiwayatDonorBinding.inflate(inflater, container,
                false)
        return riwayatDonorBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataNik = arguments?.getString(EXTRA_NIK)
        riwayatDonorBinding.edtNik.setText(dataNik)

        //Prediksi
        riwayatDonorBinding.btnPredict.setOnClickListener {
            val recency : Int = riwayatDonorBinding.edtRecency.text.toString().toInt()
            val frequency : Int = riwayatDonorBinding.edtFrequency.text.toString().toInt()
            val monetary : Int = riwayatDonorBinding.edtMonetary.text.toString().toInt()
            val time : Int = riwayatDonorBinding.edtTime.text.toString().toInt()

            var byteBuffer : ByteBuffer = ByteBuffer.allocateDirect(4*4)
            byteBuffer.putInt(recency)
            byteBuffer.putInt(frequency)
            byteBuffer.putInt(monetary)
            byteBuffer.putInt(time)

            val model = Test.newInstance(requireContext())
            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 4)
                , DataType.FLOAT32)
            inputFeature0.loadBuffer(byteBuffer)

            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer.intArray

            if (outputFeature0[0] == 0) {
                hasilPrediksi = "Berpotensi"
                nomorPrediksi = "1"
                riwayatDonorBinding.edtPrediksi.setText(hasilPrediksi)
            } else {
                hasilPrediksi = "Tidak Berpotensi"
                nomorPrediksi = "0"
                riwayatDonorBinding.edtPrediksi.setText(hasilPrediksi)
            }

            model.close()
        }

        val factory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, factory)[DonorScreeningViewModel::class.java]

        riwayatDonorBinding.btnSaveRiwayat.setOnClickListener(this@RiwayatDonorFragment)
    }

    override fun onClick(v: View?) {
        val dataNik = arguments?.getString(EXTRA_NIK)
        val dataNama = arguments?.getString(EXTRA_NAMA)
        val dataJk = arguments?.getString(EXTRA_JK)
        val dataGolonganDarah = arguments?.getString(EXTRA_GOLONGANDARAH)
        val dataRhesus = arguments?.getString(EXTRA_RHESUS)

        if (v?.id == R.id.btn_save_riwayat)
        {
            with (riwayatDonorBinding)
            {
                riwayatRecency = edtRecency.text.toString()
                riwayatFrequency = edtFrequency.text.toString()
                riwayatMonetary = edtMonetary.text.toString()
                riwayatTime = edtTime.text.toString()
            }

            if (dataNik!!.isEmpty() && riwayatRecency.isEmpty()
                    && riwayatFrequency.isEmpty() && riwayatMonetary.isEmpty()
                    && riwayatTime.isEmpty())
            {       // do process here
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Field can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()    // error
                alert.show()
            }
            else if (dataNik.isEmpty())
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
            else if (!(dataNik.isEmpty() && riwayatRecency.isEmpty()
                            && riwayatFrequency.isEmpty() && riwayatMonetary.isEmpty()
                            && riwayatTime.isEmpty()))
            {
                // save data to room
                val dataDonor = DataPendonorEntity (
                    dataNik,
                    dataNama,
                    dataJk,
                    dataGolonganDarah,
                    dataRhesus,
                    riwayatRecency.toInt(),
                    riwayatFrequency.toInt(),
                    riwayatMonetary.toInt(),
                    riwayatTime.toInt(),
                    hasilPrediksi,
                    nomorPrediksi.toInt()

                )
                Log.d("Data Donor ", dataDonor.toString())

                viewModel.insertData(dataDonor)

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