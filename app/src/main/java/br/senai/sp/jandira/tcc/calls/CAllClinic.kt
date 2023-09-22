package br.senai.sp.jandira.tcc.calls

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.senai.sp.jandira.tcc.model.ModelSpeciality
import br.senai.sp.jandira.tcc.model.clinic.Clinic
import br.senai.sp.jandira.tcc.model.clinic.ClinicResponseList
import br.senai.sp.jandira.tcc.model.especiality.EspecialityResponse
import br.senai.sp.jandira.tcc.model.especiality.EspecialityResponseList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response

fun GetClinic(speciality: Int, clinic: Clinic){

    val call = RetrofitFactory().getClinic().getClinic(speciality)

    call.enqueue(object : retrofit2.Callback<ClinicResponseList> {
        override fun onResponse(
            call: Call<ClinicResponseList>,
            response: Response<ClinicResponseList>

        ) {
            clinic.clinica = response.body()!!.clinicas
            Log.e("qwer", "${clinic.clinica}")
        }

        override fun onFailure(call: Call<ClinicResponseList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}