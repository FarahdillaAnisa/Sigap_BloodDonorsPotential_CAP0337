package com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.personaldata

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.icha.sigap_blooddonorsclassification_cap0337.R
import com.icha.sigap_blooddonorsclassification_cap0337.databinding.FragmentPersonalFormBinding
import com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.riwayat.RiwayatDonorFragment

class PersonalFormFragment : Fragment(), View.OnClickListener {

    private lateinit var personalFormBinding: FragmentPersonalFormBinding

    lateinit var personalNik : String
    lateinit var personalName : String
    lateinit var personalGender : String
    lateinit var personalBloodType : String
    lateinit var personalRhesus : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        personalFormBinding = FragmentPersonalFormBinding.inflate(inflater, container,
                false)
        return personalFormBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        personalFormBinding.btnNext.setOnClickListener(this@PersonalFormFragment)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_next)
        {

            with (personalFormBinding)
            {
                personalNik = edtNik.text.toString()
                personalName = edtNama.text.toString()
                personalGender = edtJeniskelamin.text.toString()
                personalBloodType = edtGoldarah.text.toString()
                personalRhesus = edtRhesus.text.toString()
            }

            if (personalNik.isEmpty() && personalName.isEmpty() && personalGender.isEmpty() &&
                    personalBloodType.isEmpty() && personalRhesus.isEmpty())
            {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Field can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (personalNik.isEmpty())
            {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("NIK can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (personalName.isEmpty())
            {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Name can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (personalGender.isEmpty())
            {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Gender can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (personalBloodType.isEmpty())
            {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Blood Type can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (personalRhesus.isEmpty())
            {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Rhesus can not be empty !")
                builder.setNegativeButton("OK") { dialog, _ -> dialog.cancel() }
                val alert = builder.create()
                alert.show()
            }
            else if (!(personalNik.isEmpty() && personalName.isEmpty() && personalGender.isEmpty() &&
                    personalBloodType.isEmpty() && personalRhesus.isEmpty()))
            {
                // save data to room
                val mRiwayatDonorFragment = RiwayatDonorFragment()
                val mBundle = Bundle()
                mBundle.putString(RiwayatDonorFragment.EXTRA_NIK, personalNik)
                mBundle.putString(RiwayatDonorFragment.EXTRA_NAMA, personalName)
                mBundle.putString(RiwayatDonorFragment.EXTRA_JK, personalGender)
                mBundle.putString(RiwayatDonorFragment.EXTRA_GOLONGANDARAH, personalBloodType)
                mBundle.putString(RiwayatDonorFragment.EXTRA_RHESUS, personalRhesus)

                Log.d("Data Donor Argument ", mBundle.toString())
                mRiwayatDonorFragment.arguments = mBundle
                val mFragmentManager = fragmentManager
                mFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.frame_container, mRiwayatDonorFragment, RiwayatDonorFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }

//                val builder = AlertDialog.Builder(requireActivity())
//                builder.setTitle("Success !")
//                builder.setNegativeButton("OK") { dialog, _ ->
//                    with (personalFormBinding)
//                    {
//                        edtNik.text.clear()
//                        edtNama.text.clear()
//                        edtJeniskelamin.text.clear()
//                        edtGoldarah.text.clear()
//                        edtRhesus.text.clear()
//                    }
//
//                    dialog.cancel()
//                }
//                val alert = builder.create()
//                alert.show()
            }
        }
    }
}