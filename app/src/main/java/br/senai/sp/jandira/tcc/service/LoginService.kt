package br.senai.sp.jandira.tcc.service

import retrofit2.Call
import br.senai.sp.jandira.tcc.model.login.LoginList
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginService {
    @GET("login/gestante")
    fun getLogin(@Query("email") email: String, @Query("senha") senha: String): Call<LoginList>
}