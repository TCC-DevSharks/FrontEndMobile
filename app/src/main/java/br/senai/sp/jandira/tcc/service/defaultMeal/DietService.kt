package br.senai.sp.jandira.tcc.service.defaultMeal

import br.senai.sp.jandira.tcc.model.diet.DietModelAdd
import br.senai.sp.jandira.tcc.model.diet.DietModelAddMeal
import br.senai.sp.jandira.tcc.model.diet.DietResponseListName
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.DefaultMealResponseList
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.DietResponseListProf
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.ModelDefaultMeal
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.ModelFoodToDefaultMeal
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
    fun deleteFoodDefaultMeal(
        @Path("idRefeicao") idRefeicao: Int,
        @Path("idAlimento") idAlimento: Int
    ): Call<ResponseBody>

    @POST("refeicao/padrao/alimento")
    fun postFoodToMealDefault(@Body() meal: ModelFoodToDefaultMeal): Call<ResponseBody>

    @DELETE("refeicao/padrao/{id}")
    fun deleteDefaultMeal(
        @Path("id") idRefeicao: Int): Call<ResponseBody>

    @POST("dieta")
    fun addDiet(@Body() diet: DietModelAdd): Call<ResponseBody>

    @GET("dieta/{id}")
    fun dietValidation(@Path("id") id: Int): Call<DietResponseListName>

    @POST("dieta/refeicao")
    fun addMealToDiet(@Body() diet: DietModelAddMeal): Call<ResponseBody>

    @GET("dieta/refeicao/{id}")
    fun getMealDiet(@Path("id") id: Int): Call<DietResponseListProf>

    @DELETE("dieta/refeicao/{id}")
    fun deleteMealDiet(
        @Path("id") idRefeicao: Int): Call<ResponseBody>

    @POST("refeicao/alimento")
    fun postFoodToMeal(@Body() meal: ModelFoodToDefaultMeal): Call<ResponseBody>

    @DELETE("refeicao/{idRefeicao}/alimento/{idAlimento}")
    fun deleteFoodMeal(
        @Path("idRefeicao") idRefeicao: Int,
        @Path("idAlimento") idAlimento: Int
    ): Call<ResponseBody>
}