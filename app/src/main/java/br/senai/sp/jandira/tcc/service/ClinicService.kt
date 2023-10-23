package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.clinic.ClinicResponseList
import br.senai.sp.jandira.tcc.model.clinic.ClinicSpecialityResponseList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ClinicService {

    @GET("clinica/especialidade/{id}")
    fun getClinicSpeciality(@Path("id") id: Int): Call<ClinicSpecialityResponseList>

    @GET("clinica/{id}")
    fun getClinic(@Path("id") id: Int): Call<ClinicResponseList>
}