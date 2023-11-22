package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.chatMesssages.ChatMessagesResponseList
import br.senai.sp.jandira.tcc.model.chatUser.ChatUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChatService {
    @GET("user/one")
    fun getUser(@Query("email")email: String, @Query("usuario") usuario: String): Call<ChatUserResponse>

    @GET("chat/mensagem")
    fun getMessages(@Query("from")from: String, @Query("to") to: String): Call<ChatMessagesResponseList>
}