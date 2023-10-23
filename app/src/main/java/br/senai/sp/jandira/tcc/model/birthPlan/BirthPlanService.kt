package br.senai.sp.jandira.tcc.model.birthPlan

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface BirthPlanService {

    @GET("plano-parto")
    fun getBirthPlan(): retrofit2.Call<BirthPlanList>

    @GET("plano-parto/categoria")
    fun getBirthPlanCategory(@Query("categoria") categoria: String): retrofit2.Call<BirthPlanList>

    @GET("plano-parto/favorito/{id}")
    fun getBirthPlanFavorite(@Path("id") id: Int): retrofit2.Call<BirthPlanListFavorite>

    @POST("plano-parto/favorito")
    fun insertBirthPlan(@Body trousseauBody: BirthPlanBody): retrofit2.Call<BirthPlanListFavorite>
    @DELETE("plano-parto/favorito")
    fun deleteBirthPlan(@Query("idPlano") plano: Int, @Query("idGestante") gestante: Int): retrofit2.Call<BirthPlanListFavorite>
}