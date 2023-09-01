package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.ScheduleList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ScheduleService {
    @GET("agenda/{id}")
    fun getSchedule(@Path("id") id: Int): Call<ScheduleList>
}