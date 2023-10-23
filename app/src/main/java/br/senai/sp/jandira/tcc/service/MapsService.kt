package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.google.DistanceMatrix
import br.senai.sp.jandira.tcc.model.login.LoginList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MapsService {

    @GET("json")
    fun getMatrix(@Query("origins") origins: String,
                  @Query("destinations") destinations: String,
                  @Query("key") key: String,
                  @Query("mode") mode: String)
    : Call<DistanceMatrix>
}