package br.senai.sp.jandira.tcc.calls

import android.util.Log
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.Pregnant
import br.senai.sp.jandira.tcc.model.WeightHeight
import br.senai.sp.jandira.tcc.model.endressPregnant.EndressPregnant
import br.senai.sp.jandira.tcc.model.endressPregnant.EndressPregnantList
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponse
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponseList
import br.senai.sp.jandira.tcc.model.historicPregnant.Alergy
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

fun GetPregnant(viewModel: ModelPregnant){
    val call = RetrofitFactory().getPregnant().getPregnant(viewModel.id)
    var gestante: List<PregnantResponse>

    call.enqueue(object : retrofit2.Callback<PregnantResponseList> {
        override fun onResponse(
            call: Call<PregnantResponseList>,
            response: Response<PregnantResponseList>

        ) {
            gestante = response.body()!!.gestante

            gestante.map {
                viewModel.id = it.id
                viewModel.cpf = it.cpf
                viewModel.altura = it.altura
                viewModel.data_nascimento = it.data_nascimento
                viewModel.data_parto = it.data_parto
                viewModel.email = it.email
                viewModel.foto = it.foto
                viewModel.nome = it.nome
                viewModel.peso = it.peso
                viewModel.senha = it.senha
                viewModel.telefone = it.telefone
            }


        }

        override fun onFailure(call: Call<PregnantResponseList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

fun GetEndereco(viewModel: ModelPregnant){
    val call = RetrofitFactory().getEndress().getAndressPregnant(viewModel.id)
    var endereco: List<EndressPregnant>

    call.enqueue(object : retrofit2.Callback<EndressPregnantList> {
        override fun onResponse(
            call: Call<EndressPregnantList>,
            response: Response<EndressPregnantList>

        ) {
            endereco = response.body()!!.endereco

            if (endereco.isNotEmpty()) {

                endereco.forEach {
                    viewModel.cep = it.cep
                    viewModel.numero = it.numero
                    viewModel.complemento = it.complemento
                }
            }

        }

        override fun onFailure(call: Call<EndressPregnantList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

fun PutWeight(viewModel: ModelPregnant, weight: WeightHeight){
    val call = RetrofitFactory().updateWeightPregnant().updateWeightPregnant(viewModel.id, weightHeight = weight)

    call.enqueue(object : retrofit2.Callback<WeightHeight> {
        override fun onResponse(
            call: Call<WeightHeight>,
            response: Response<WeightHeight>

        ) {

        }

        override fun onFailure(call: Call<WeightHeight>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

fun insertALergy(viewModel: ModelPregnant){
    var alergy = Alergy(
        viewModel.id,
        viewModel.alergia
    )
    val  call = RetrofitFactory().insertAlergy().postAlergy(alergy)

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