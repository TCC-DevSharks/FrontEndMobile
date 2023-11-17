package br.senai.sp.jandira.tcc.calls

import android.util.Log
import br.senai.sp.jandira.tcc.model.chatMesssages.ChatModel
import br.senai.sp.jandira.tcc.model.chatUser.ChatUserResponse
import br.senai.sp.jandira.tcc.model.forum.user.ModelUser
import br.senai.sp.jandira.tcc.model.forum.user.ResponseOneUser
import br.senai.sp.jandira.tcc.model.mongoDb.ChatDbResponseList
import br.senai.sp.jandira.tcc.model.mongoDb.SendMessage
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.time.LocalTime

fun GetForumUser(id: Int, user: ModelUser) {

    val call = RetrofitFactory().Forum().getOneUser(id)

    call.enqueue(object : retrofit2.Callback<ResponseOneUser> {
        override fun onResponse(
            call: Call<ResponseOneUser>,
            response: Response<ResponseOneUser>

        ) {
            Log.e("forum","${response.body()}")
            user._id = response.body()!!._id
            user.foto = response.body()!!.foto
            user.mysql = response.body()!!.mysql
            user.username = response.body()!!.username
        }

        override fun onFailure(call: Call<ResponseOneUser>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}
