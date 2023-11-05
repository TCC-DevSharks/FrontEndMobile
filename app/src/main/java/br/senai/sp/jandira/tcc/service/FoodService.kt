package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.diet.DietResponse
import br.senai.sp.jandira.tcc.model.diet.DietResponseList
import br.senai.sp.jandira.tcc.model.food.FoodResponse
import br.senai.sp.jandira.tcc.model.food.FoodResponseList
import br.senai.sp.jandira.tcc.model.modelDoctor.foodCategory.FoodCategoryResponseList
import br.senai.sp.jandira.tcc.model.schedule.ScheduleList
import br.senai.sp.jandira.tcc.model.schedule.ScheduleResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FoodService {
    @GET("refeicao/categoria/alimento/{id}")
    fun getFood(@Path("id") id: Int): Call<FoodResponseList>

    @GET("refeicao/lista/categoria")
    fun getCategories(): Call<FoodCategoryResponseList>

    @GET("refeicao/padrao/alimento/{id}")
    fun getFoodMeal(@Path("id") id: Int): Call<FoodResponseList>

}