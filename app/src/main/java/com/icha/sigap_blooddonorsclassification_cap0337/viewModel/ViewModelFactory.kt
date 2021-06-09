package com.icha.sigap_blooddonorsclassification_cap0337.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.icha.sigap_blooddonorsclassification_cap0337.data.source.remote.DataPendonorRepository
import com.icha.sigap_blooddonorsclassification_cap0337.di.Injection
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donordetails.DonorDetailsViewModel
import com.icha.sigap_blooddonorsclassification_cap0337.ui.donorlist.DonorListViewModel
import com.icha.sigap_blooddonorsclassification_cap0337.ui.home.HomeViewModel
import com.icha.sigap_blooddonorsclassification_cap0337.ui.screeningform.DonorScreeningViewModel

class ViewModelFactory private constructor(private val mDataPendonorRepository: DataPendonorRepository) : ViewModelProvider.NewInstanceFactory(){
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(DonorScreeningViewModel::class.java) -> {
                return DonorScreeningViewModel(mDataPendonorRepository) as T
            }
            modelClass.isAssignableFrom(DonorListViewModel::class.java) -> {
                return DonorListViewModel(mDataPendonorRepository) as T
            }
            modelClass.isAssignableFrom(DonorDetailsViewModel::class.java) -> {
                return DonorDetailsViewModel(mDataPendonorRepository) as T
            }
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                return HomeViewModel(mDataPendonorRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

}