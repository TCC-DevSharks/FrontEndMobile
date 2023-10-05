package br.senai.sp.jandira.tcc.model.maternityBag

import br.senai.sp.jandira.tcc.model.troussea.TrousseauList2
import br.senai.sp.jandira.tcc.model.troussea.TrousseauListFavorite2
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MaternityBagResponse {


    @GET("mala-maternidade")
    fun getMaternityBag (): retrofit2.Call<MaternityBagList>

    @GET("mala-maternidade/favorito/")
    fun getMaternityBagFavorite (@Path("id") id: Int): retrofit2.Call<MaternityBagFavoriteList>

    @POST("mala-maternidade/favorito")
    fun insertMaternityBag (@Body maternityBag: MaternityBagBody): retrofit2.Call<MaternityBagList>

    // Verdadeiro EndPoint
    // @DELETE("enxoval/favorito")
    // fun deleteTrousseau(@Query("idNome") nome: Int, @Query("idGestante") gestante: Int): retrofit2.Call<MaternityBagList>

}
