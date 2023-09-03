package br.senai.sp.jandira.tcc.service


import br.senai.sp.jandira.tcc.model.Pregnant
import br.senai.sp.jandira.tcc.model.PregnantResponse
import br.senai.sp.jandira.tcc.model.PregnantResponseList
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PregnantService {
    @POST("gestante")
    fun insertPregnant(@Body pregnant: Pregnant): Call<ResponseBody>

    @GET("gestante/{id}")
    fun getPregnant(@Path("id") id: Int): Call<PregnantResponseList>
}