package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.forum.category.ResponseCategoryList
import br.senai.sp.jandira.tcc.model.forum.messages.PostMessages
import br.senai.sp.jandira.tcc.model.forum.topic.PostTopic
import br.senai.sp.jandira.tcc.model.forum.topic.ResponseMessageTopicList
import br.senai.sp.jandira.tcc.model.forum.topic.ResponseTopicList
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

    @GET("forum/categoria")
    fun getCategorys(): Call<ResponseCategoryList>

    @POST("forum/topico")
    fun postTopic(@Body topic: PostTopic): Call<ResponseBody>

    @GET("forum/topico")
    fun getTopics(): Call<ResponseTopicList>

    @GET("forum/topico/{id}")
    fun getMessageTopics(@Path("id")id: String): Call<ResponseMessageTopicList>

    @POST("forum/mensagem")
    fun postMessage(@Body message: PostMessages): Call<ResponseBody>

    @GET("forum/topico/categoria/{id}")
    fun getTopicsCategory(@Path("id")id: String): Call<ResponseTopicList>
}
