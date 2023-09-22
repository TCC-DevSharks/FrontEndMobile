package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.especiality.EspecialityResponseList
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponseList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EspecialityService {

    @GET("especialidade")
    fun getEspeciality(): Call<EspecialityResponseList>
}