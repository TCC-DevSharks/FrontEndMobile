package br.senai.sp.jandira.tcc.service.defaultMeal

import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.DefaultMealResponseList
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.ModelDefaultMeal
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DietService {
    @GET("refeicao/padrao/profissional/{id}")
    fun getDefaultMeal(@Path("id") id: Int): Call<DefaultMealResponseList>

    @POST("refeicao/padrao")
    fun postDefaultMeal(@Body() meal: ModelDefaultMeal): Call<ResponseBody>

    @DELETE("refeicao/padrao/{idRefeicao}/alimento/{idAlimento}")
    fun deleteDefaultMeal(
        @Path("idRefeicao") idRefeicao: Int,
        @Path("idAlimento") idAlimento: Int): Call<ResponseBody>
    
}