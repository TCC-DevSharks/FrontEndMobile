package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.categories.CategoriesResponseList
import br.senai.sp.jandira.tcc.model.exercises.ExerciseResponseList
import br.senai.sp.jandira.tcc.model.exercises.ExercisesResponseList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ExercisesService {
    @GET("exercicios/categorias/{id}")
    fun getExercises(@Path("id") id: Int): Call<ExercisesResponseList>

    @GET("exercicios/{id}")
    fun getExercise(@Path("id") id: Int): Call<ExerciseResponseList>
}