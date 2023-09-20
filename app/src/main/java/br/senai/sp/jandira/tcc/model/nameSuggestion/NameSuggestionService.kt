package br.senai.sp.jandira.tcc.model.nameSuggestion

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NameSuggestionService {

    @GET("sugestao-nome")
    fun getNames(): Call<NameSuggestionList>

    @GET("sugestao-nome/sexo")
    fun getNameSex(@Query("sexo") sexo: String): Call<NameSuggestionList>
}