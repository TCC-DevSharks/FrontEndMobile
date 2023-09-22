package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.clinic.ClinicResponseList
import br.senai.sp.jandira.tcc.model.login.LoginList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ClinicService {

    @GET("clinica/especialidade/{id}")
    fun getClinic(@Path("id") id: Int): Call<ClinicResponseList>
}