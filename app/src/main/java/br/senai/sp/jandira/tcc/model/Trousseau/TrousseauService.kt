package br.senai.sp.jandira.tcc.model.Trousseau

import android.telecom.Call
import br.senai.sp.jandira.tcc.model.Trousseau.trousseauPost.TrousseauPost
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionList
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import javax.security.auth.callback.Callback

interface TrousseauService {

    @GET("enxoval")
    fun getTrousseau(): retrofit2.Call<TrousseauList>

    @GET("enxoval/categoria")
    fun getTrousseauCategory(@Query("categoria") categoria: String): retrofit2.Call<TrousseauList>

    @GET("enxoval/favorito/{id}")
    fun getTrousseauFavorite(@Path("id") id: Int): retrofit2.Call<TrousseauListFavorite>

    @POST ("enxoval/favorito")
    fun insertTrousseau(@Body trousseauPost: TrousseauPost): retrofit2.Call<TrousseauListFavorite>

    //  Fazer endPoint
    //  @DELETE ("enxoval/favorito")
    //  fun deleteTrousseau(@Body trousseauPost: TrousseauPost): retrofit2.Call<TrousseauListFavorite>

}