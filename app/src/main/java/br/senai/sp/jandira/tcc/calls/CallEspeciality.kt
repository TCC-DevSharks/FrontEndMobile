package br.senai.sp.jandira.tcc.calls

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.senai.sp.jandira.tcc.model.ModelSpeciality
import br.senai.sp.jandira.tcc.model.especiality.EspecialityResponse
import br.senai.sp.jandira.tcc.model.especiality.EspecialityResponseList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response

fun GetEspeciality(speciality: ModelSpeciality){

    val call = RetrofitFactory().getEspeciality().getEspeciality()

    call.enqueue(object : retrofit2.Callback<EspecialityResponseList> {
        override fun onResponse(
            call: Call<EspecialityResponseList>,
            response: Response<EspecialityResponseList>

        ) {

            speciality.especialidade = response.body()!!.especialidades
           Log.i("qwerrt", "${speciality.especialidade}")
        }

        override fun onFailure(call: Call<EspecialityResponseList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}