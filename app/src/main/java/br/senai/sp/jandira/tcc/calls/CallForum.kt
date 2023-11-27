package br.senai.sp.jandira.tcc.calls

import android.util.Log
import br.senai.sp.jandira.tcc.model.forum.ModelForum
import br.senai.sp.jandira.tcc.model.forum.category.ResponseCategory
import br.senai.sp.jandira.tcc.model.forum.category.ResponseCategoryList
import br.senai.sp.jandira.tcc.model.forum.messages.PostMessages
import br.senai.sp.jandira.tcc.model.forum.topic.PostTopic
import br.senai.sp.jandira.tcc.model.forum.topic.ResponseTopicList
import br.senai.sp.jandira.tcc.model.forum.user.PostUser
import br.senai.sp.jandira.tcc.model.forum.user.ResponseOneUser
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

fun GetForumUser(id: Int, user: ModelForum) {

    Log.e("forum","123")


    val call = RetrofitFactory().Forum().getOneUser(id)

    call.enqueue(object : retrofit2.Callback<ResponseOneUser> {
        override fun onResponse(
            call: Call<ResponseOneUser>,
            response: Response<ResponseOneUser>

        ) {
            Log.e("forum","${response}")
            user._id = response.body()!!._id
            user.foto = response.body()!!.foto
            user.mysql = response.body()!!.mysql
            user.username = response.body()!!.username
        }

        override fun onFailure(call: Call<ResponseOneUser>, t: Throwable) {
            Log.i(
                "dsm",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

fun PostForumUser(user: PostUser) {

    val call = RetrofitFactory().Forum().postUser(user)

    call.enqueue(object : retrofit2.Callback<ResponseBody> {
        override fun onResponse(
            call: Call<ResponseBody>,
            response: Response<ResponseBody>

        ) {
            Log.e("forum","${response}")
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

fun GetCategorys(forum: ModelForum) {

    val call = RetrofitFactory().Forum().getCategorys()

    call.enqueue(object : retrofit2.Callback<ResponseCategoryList> {
        override fun onResponse(
            call: Call<ResponseCategoryList>,
            response: Response<ResponseCategoryList>

        ) {
            if (response.isSuccessful){
                Log.e("forum","${response.body()}")
                forum.categorias = response.body()!!.categorys
            }


        }

        override fun onFailure(call: Call<ResponseCategoryList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

fun PostForumTopic(topic: PostTopic) {

    val call = RetrofitFactory().Forum().postTopic(topic)

    call.enqueue(object : retrofit2.Callback<ResponseBody> {
        override fun onResponse(
            call: Call<ResponseBody>,
            response: Response<ResponseBody>

        ) {
            Log.e("forum","${response}")
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

fun GetForumTopic(forum: ModelForum) {

    val call = RetrofitFactory().Forum().getTopics()

    call.enqueue(object : retrofit2.Callback<ResponseTopicList> {
        override fun onResponse(
            call: Call<ResponseTopicList>,
            response: Response<ResponseTopicList>

        ) {
            Log.e("forum","${response}")
            forum.topicos = response.body()!!.topics
        }

        override fun onFailure(call: Call<ResponseTopicList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

fun PostMessageForum(msg: PostMessages) {

    val call = RetrofitFactory().Forum().postMessage(msg)

    call.enqueue(object : retrofit2.Callback<ResponseBody> {
        override fun onResponse(
            call: Call<ResponseBody>,
            response: Response<ResponseBody>

        ) {
            Log.e("forum","${response}")
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
