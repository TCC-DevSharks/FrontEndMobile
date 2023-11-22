package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.forum.user.PostUser
import br.senai.sp.jandira.tcc.model.forum.user.ResponseOneUser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ForumService {

    @POST("forum/user")
    fun postUser(@Body user: PostUser): Call<ResponseBody>

    @GET("forum/user/{id}")
    fun getOneUser(@Path("id")id: Int): Call<ResponseOneUser>

}