package br.senai.sp.jandira.tcc.calls

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.model.clinic.Clinic
import br.senai.sp.jandira.tcc.model.clinic.ClinicSpecialityResponseList
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.model.professional.ProfessionalSpecialityResponse
import br.senai.sp.jandira.tcc.model.professional.ProfessionalSpecialityResponseList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
    fun GetProfessionalSpeciality(speciality: Int, professional: Professional, navController: NavController){

        val call = RetrofitFactory().getProfessional().getProfissionalSpeciality(speciality)

        call.enqueue(object : retrofit2.Callback<ProfessionalSpecialityResponseList> {
            override fun onResponse(
                call: Call<ProfessionalSpecialityResponseList>,
                response: Response<ProfessionalSpecialityResponseList>

            ) {
                professional.profissional = response.body()!!.profissionais
                navController.navigate("ConsultDoctor")
            }

            override fun onFailure(call: Call<ProfessionalSpecialityResponseList>, t: Throwable) {
                Log.i(
                    "ds2m",
                    "onFailure: ${t.message}"
                )
                println(t.message + t.cause)
            }
        })
    }

    fun GetProfessional(professional: Professional){

        var call = RetrofitFactory().getProfessional().getProfissional(professional.id)

        call.enqueue(object : Callback<ProfessionalSpecialityResponseList> {
            override fun onResponse(
                call: Call<ProfessionalSpecialityResponseList>,
                response: Response<ProfessionalSpecialityResponseList>
            ) {
                response.body()!!.profissionais.map {
                    professional.id = it.id
                    professional.nome = it.nome
                    professional.cpf = it.cpf
                    professional.crm= it.crm
                }

            }

            override fun onFailure(call: Call<ProfessionalSpecialityResponseList>, t: Throwable) {
                Log.i("Profi", "${t.message}")
            }
        })
    }