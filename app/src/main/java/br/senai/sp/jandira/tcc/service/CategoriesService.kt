package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.categories.CategoriesResponseList
import retrofit2.Call
import retrofit2.http.GET

interface CategoriesService {
    @GET("exercicios/categoria/todos")
    fun getCategories(): Call<CategoriesResponseList>
}