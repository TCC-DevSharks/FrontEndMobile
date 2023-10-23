package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.especiality.EspecialityResponseList
import retrofit2.Call
import retrofit2.http.GET

interface SpecialityService {

    @GET("especialidade")
    fun getEspeciality(): Call<EspecialityResponseList>
}