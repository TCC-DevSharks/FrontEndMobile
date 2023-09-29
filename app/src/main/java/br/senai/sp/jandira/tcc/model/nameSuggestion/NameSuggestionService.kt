package br.senai.sp.jandira.tcc.model.nameSuggestion

import br.senai.sp.jandira.tcc.model.nameSuggestion.NameDelete.NameDelete
import br.senai.sp.jandira.tcc.model.nameSuggestion.NamePost.NamePost
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionFavorite.NameFavoriteList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface NameSuggestionService {

    @GET("sugestao-nome")
    fun getNames(): Call<NameSuggestionList>

    @GET("sugestao-nome/sexo")
    fun getNameSex(@Query("sexo") sexo: String): Call<NameSuggestionList>

    @GET("sugestao-nome/favorito/{id}")
    fun getNameFavorite(@Path("id") id: Int, @Query("sexo") sexo: String): Call<NameFavoriteList>

    @POST("sugestao-nome/favorito")
    fun insertName(@Body namePost: NamePost): Call<NameFavoriteList>

    @DELETE("sugestao-nome/favorito")
    fun deleteName(@Query("idNome") nome: Int, @Query("idGestante") gestante: Int ): Call<NameFavoriteList>
}