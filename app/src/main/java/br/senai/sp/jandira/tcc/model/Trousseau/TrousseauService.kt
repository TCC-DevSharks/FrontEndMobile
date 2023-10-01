package br.senai.sp.jandira.tcc.model.Trousseau

import android.telecom.Call
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionList
import retrofit2.http.GET
import retrofit2.http.Query

interface TrousseauService {

    @GET("enxoval")
    fun getTrousseau(): retrofit2.Call<TrousseauList>

    @GET("enxoval/categoria")
    fun getTrousseauCategory(@Query("categoria") categoria: String): retrofit2.Call<TrousseauList>
}