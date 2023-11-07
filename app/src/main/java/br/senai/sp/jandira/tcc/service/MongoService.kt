package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.mongoDb.ChatDbResponse
import br.senai.sp.jandira.tcc.model.mongoDb.ChatDbResponseList
import br.senai.sp.jandira.tcc.model.mongoDb.SendMessage
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
interface MongoService {
    @POST("chat")
    fun sendMsg(@Body msg: SendMessage): Call<ResponseBody>

    @GET("chat/mensagem")
    fun getMsg(@Query("from") from: String, @Query("to") to: String): Call<ChatDbResponseList>
}