package br.senai.sp.jandira.tcc.calls

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import br.senai.sp.jandira.tcc.model.chatMesssages.ChatModel
import br.senai.sp.jandira.tcc.model.chatUser.ChatUserResponse
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response

fun GetChatUser(email: String, chatModel: ChatModel) {

    val call = RetrofitFactory().ChatService().getUser(email, "Gestante")

    call.enqueue(object : retrofit2.Callback<ChatUserResponse> {
        override fun onResponse(
            call: Call<ChatUserResponse>,
            response: Response<ChatUserResponse>

        ) {

//            chatModel.user = response.body()

        }

        override fun onFailure(call: Call<ChatUserResponse>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}