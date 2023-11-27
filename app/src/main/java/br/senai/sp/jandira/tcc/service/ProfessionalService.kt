package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.professional.ProfessionalSpecialityResponseList
import br.senai.sp.jandira.tcc.model.professional.ProfissionalBody
import br.senai.sp.jandira.tcc.model.professional.consult.ProfessionalConsultResponseList
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProfessionalService {

    @GET("profissional/especialidade/{id}")
    fun getProfissionalSpeciality(@Path("id") id: Int): Call<ProfessionalSpecialityResponseList>

    @GET("profissional/{id}")
    fun getProfissional(@Path("id") id: Int): Call<ProfessionalSpecialityResponseList>

    @PUT("profissional/{id}")
    fun putProfissional(@Path("id") id: Int, @Body profissionalBody: ProfissionalBody): Call<ProfissionalBody>

    @GET("profissional/consulta/{id}")
    fun getProfissionalConsult(@Path("id") id: Int): Call<ProfessionalConsultResponseList>
}