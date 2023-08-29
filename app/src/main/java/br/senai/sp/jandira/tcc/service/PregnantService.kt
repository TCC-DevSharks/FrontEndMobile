package br.senai.sp.jandira.tcc.service


import br.senai.sp.jandira.tcc.model.Pregnant
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PregnantService {
    @POST("gestante")
    fun insertPregnant(@Body pregnant: Pregnant): Call<ResponseBody>
}