package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.consult.ConsultList
import br.senai.sp.jandira.tcc.model.consult.ConsultResponse
import br.senai.sp.jandira.tcc.model.consult.ConsultResponsePaciente
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ConsultService {

    @GET("profissional/consulta/{id}")
    fun GetConsulta(@Path("id") id: Int): Call<ConsultList>

    @POST("consulta")
    fun insertConsult(@Body consult: ConsultResponse): Call<ResponseBody>
}