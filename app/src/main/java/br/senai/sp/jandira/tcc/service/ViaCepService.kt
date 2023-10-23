package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.viaCep.ViaCep
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {

    @GET("{cep}/json")
    fun getCep(@Path("cep") cep: String): Call<ViaCep>
}