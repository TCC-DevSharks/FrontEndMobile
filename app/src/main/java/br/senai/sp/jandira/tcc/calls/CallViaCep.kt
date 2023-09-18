package br.senai.sp.jandira.tcc.calls

import android.util.Log
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.viaCep.ViaCep
import br.senai.sp.jandira.tcc.service.RetrofitFactoryCep
import retrofit2.Call
import retrofit2.Response

fun GetCep(viewModel: ModelPregnant, cep: String){
    val call = RetrofitFactoryCep().getCep().getCep(cep)

    call.enqueue(object : retrofit2.Callback<ViaCep> {
        override fun onResponse(
            call: Call<ViaCep>,
            response: Response<ViaCep>

        ) {
            Log.i("asdf", "${response}")

            if (response.code() == 200) {
                viewModel.bairro = response.body()!!.bairro
                viewModel.cidade = response.body()!!.localidade
                viewModel.logradouro = response.body()!!.logradouro
                viewModel.estado = response.body()!!.localidade
            }


        }

        override fun onFailure(call: Call<ViaCep>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}