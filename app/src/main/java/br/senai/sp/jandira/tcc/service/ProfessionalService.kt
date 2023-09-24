package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.professional.ProfessionalSpecialityResponseList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfessionalService {

    @GET("profissional/especialidade/{id}")
    fun getProfissionalSpeciality(@Path("id") id: Int): Call<ProfessionalSpecialityResponseList>
}