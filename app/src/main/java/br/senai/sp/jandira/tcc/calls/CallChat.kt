package br.senai.sp.jandira.tcc.calls

import android.util.Log
import br.senai.sp.jandira.tcc.model.chatMesssages.ChatModel
import br.senai.sp.jandira.tcc.model.chatUser.ChatUserResponse
import br.senai.sp.jandira.tcc.model.mongoDb.ChatDbResponseList
import br.senai.sp.jandira.tcc.model.mongoDb.SendMessage
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.time.LocalTime

fun GetChatUser(email: String, chatModel: ChatModel) {

    val call = RetrofitFactory().ChatService().getUser(email, "Gestante")

    call.enqueue(object : retrofit2.Callback<ChatUserResponse> {
        override fun onResponse(
            call: Call<ChatUserResponse>,
            response: Response<ChatUserResponse>

        ) {

            chatModel.user = response.body()!!._id;

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

fun GetChatProfissional(email: String, chatModel: ChatModel) {

    val call = RetrofitFactory().ChatService().getUser(email, "Profissional")

    call.enqueue(object : retrofit2.Callback<ChatUserResponse> {
        override fun onResponse(
            call: Call<ChatUserResponse>,
            response: Response<ChatUserResponse>

        ) {

            chatModel.profissional = response.body()!!._id;

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

fun GetMsg(from: String,to: String, chatModel: ChatModel) {

    val call = RetrofitFactory().MongoService().getMsg(from, to)

    call.enqueue(object : retrofit2.Callback<ChatDbResponseList> {
        override fun onResponse(
            call: Call<ChatDbResponseList>,
            response: Response<ChatDbResponseList>

        ) {
            chatModel.msgs = response.body()!!.conversa
        }

        override fun onFailure(call: Call<ChatDbResponseList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}



fun SendMsg(text: String, users: List<String>, sender: String, timestamp: LocalTime) {

    var sendMessage = SendMessage(
        text = text,
        users = users,
        sender = sender,
        timestamp = timestamp
    )

    val call = RetrofitFactory().MongoService().sendMsg(sendMessage)

    call.enqueue(object : retrofit2.Callback<ResponseBody> {
        override fun onResponse(
            call: Call<ResponseBody>,
            response: Response<ResponseBody>

        ) {
        }

        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}