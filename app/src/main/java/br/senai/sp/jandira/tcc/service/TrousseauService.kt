package br.senai.sp.jandira.tcc.model.troussea

import br.senai.sp.jandira.tcc.model.troussea.trousseauBody.TrousseauBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TrousseauService {

    @GET("enxoval")
    fun getTrousseau(): retrofit2.Call<TrousseauList2>

    @GET("enxoval/categoria")
    fun getTrousseauCategory(@Query("categoria") categoria: String): retrofit2.Call<TrousseauList2>

    @GET("enxoval/favorito/{id}")
    fun getTrousseauFavorite(@Path("id") id: Int): retrofit2.Call<TrousseauListFavorite2>

    @POST("enxoval/favorito")
    fun insertTrousseau(@Body trousseauBody: TrousseauBody): retrofit2.Call<TrousseauListFavorite2>
    @DELETE("enxoval/favorito")
    fun deleteTrousseau(@Query("idEnxoval") enxoval: Int, @Query("idGestante") gestante: Int): retrofit2.Call<TrousseauListFavorite2>

}