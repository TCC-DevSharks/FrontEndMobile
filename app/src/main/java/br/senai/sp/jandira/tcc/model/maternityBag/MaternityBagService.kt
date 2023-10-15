package br.senai.sp.jandira.tcc.model.maternityBag

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MaternityBagService {


    @GET("mala-maternidade")
    fun getMaternityBag (): retrofit2.Call<MaternityBagList>

    @GET("mala-maternidade/favorito/{id}")
    fun getMaternityBagFavorite (@Path("id") id: Int): retrofit2.Call<MaternityBagFavoriteList>

    @POST("mala-maternidade/favorito")
    fun insertMaternityBag (@Body maternityBag: MaternityBagBody): retrofit2.Call<MaternityBagFavoriteList>

     @DELETE("mala-maternidade/favorito")
     fun deleteMaternity(@Query("idMala") mala: Int, @Query("idGestante") gestante: Int): retrofit2.Call<MaternityBagFavoriteList>

}
