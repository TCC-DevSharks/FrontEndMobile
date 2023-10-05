package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.schedule.ScheduleList
import br.senai.sp.jandira.tcc.model.schedule.ScheduleResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ScheduleService {
    @GET("agenda/{id}")
    fun getSchedule(@Path("id") id: Int): Call<ScheduleList>

    @POST("agenda")
    fun postSchedule(@Body schedule:ScheduleResponse): Call<ResponseBody>
}