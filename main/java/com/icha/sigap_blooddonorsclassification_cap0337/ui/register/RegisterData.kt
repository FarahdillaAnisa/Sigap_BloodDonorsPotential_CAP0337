package com.icha.sigap_blooddonorsclassification_cap0337.ui.register

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegisterData(
    val rName : String?,
    val rEmail : String?,
    val rPhone : String?,
    val rPassword : String?
) : Parcelable
