package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.consult.ConsultResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ConsultService {

    @POST("consulta")
    fun insertConsult(@Body consult: ConsultResponse): Call<ResponseBody>
}