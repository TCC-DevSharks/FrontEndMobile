package br.senai.sp.jandira.tcc.calls

import android.util.Log
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.ModelFoodToDefaultMeal
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

fun DeleteFoodDefaultMeal(idRefeicao: Int, idAlimento: Int) {

    val call = RetrofitFactory().Diet().deleteFoodDefaultMeal(idRefeicao = idRefeicao, idAlimento = idAlimento)

    call.enqueue(object : retrofit2.Callback<ResponseBody> {
        override fun onResponse(
            call: Call<ResponseBody>,
            response: Response<ResponseBody>

        ) {
            println(response)
            println(response.body())
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

fun PostDefaultMeal(idRefeicao: Int, idAlimento: Int) {

    var meal = ModelFoodToDefaultMeal(
        id_alimento = idAlimento,
        id_refeicao = idRefeicao
    )

    val call = RetrofitFactory().Diet().postFoodToMealDefault(meal)

    call.enqueue(object : retrofit2.Callback<ResponseBody> {
        override fun onResponse(
            call: Call<ResponseBody>,
            response: Response<ResponseBody>

        ) {
            println(response)
            println(response.body())
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

fun DeleteDefaultMeal(idRefeicao: Int) {

    val call = RetrofitFactory().Diet().deleteDefaultMeal(idRefeicao)

    call.enqueue(object : retrofit2.Callback<ResponseBody> {
        override fun onResponse(
            call: Call<ResponseBody>,
            response: Response<ResponseBody>

        ) {
            println(response)
            println(response.body())
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

fun DeleteMealDiet(idRefeicao: Int) {

    val call = RetrofitFactory().Diet().deleteMealDiet(idRefeicao)

    call.enqueue(object : retrofit2.Callback<ResponseBody> {
        override fun onResponse(
            call: Call<ResponseBody>,
            response: Response<ResponseBody>

        ) {
            println(response)
            println(response.body())
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

fun PostMeal(idRefeicao: Int, idAlimento: Int) {

    var meal = ModelFoodToDefaultMeal(
        id_alimento = idAlimento,
        id_refeicao = idRefeicao
    )

    val call = RetrofitFactory().Diet().postFoodToMeal(meal)

    call.enqueue(object : retrofit2.Callback<ResponseBody> {
        override fun onResponse(
            call: Call<ResponseBody>,
            response: Response<ResponseBody>

        ) {
            println(response)
            println(response.body())
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

fun DeleteFoodMeal(idRefeicao: Int, idAlimento: Int) {

    val call = RetrofitFactory().Diet().deleteFoodMeal(idRefeicao = idRefeicao, idAlimento = idAlimento)

    call.enqueue(object : retrofit2.Callback<ResponseBody> {
        override fun onResponse(
            call: Call<ResponseBody>,
            response: Response<ResponseBody>

        ) {
            println(response)
            println(response.body())
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

