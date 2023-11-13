package br.senai.sp.jandira.tcc.calls

import android.util.Log
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.WeightHeight
import br.senai.sp.jandira.tcc.model.endressPregnant.EndressPregnant
import br.senai.sp.jandira.tcc.model.endressPregnant.EndressPregnantList
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponse
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponseList
import br.senai.sp.jandira.tcc.model.historicPregnant.Alergy
import br.senai.sp.jandira.tcc.model.historicPregnant.AlergyResponseList
import br.senai.sp.jandira.tcc.model.historicPregnant.Comorbidity
import br.senai.sp.jandira.tcc.model.historicPregnant.ComorbidityResponseList
import br.senai.sp.jandira.tcc.model.historicPregnant.Deficiency
import br.senai.sp.jandira.tcc.model.historicPregnant.DeficiencyResponseList
import br.senai.sp.jandira.tcc.model.historicPregnant.Medication
import br.senai.sp.jandira.tcc.model.historicPregnant.MedicationResponseList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

fun extrairPrimeiroNome(nomeCompleto: String): String {
    return nomeCompleto.split(" ").firstOrNull() ?: ""
}
fun GetPregnant(viewModel: ModelPregnant){
    val call = RetrofitFactory().pregnant().getPregnant(viewModel.id)
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
                viewModel.nome = extrairPrimeiroNome(it.nome)
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
    val call = RetrofitFactory().pregnant().getAndressPregnant(viewModel.id)
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
    val call = RetrofitFactory().pregnant().updateWeightPregnant(viewModel.id, weightHeight = weight)

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
        if (viewModel.alergia.length == 0)" " else viewModel.alergia
    )
    val  call = RetrofitFactory().pregnant().postAlergy(alergy)

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

fun insertComorbidity(viewModel: ModelPregnant){
    var comorbidity = Comorbidity(
        viewModel.id,
        if (viewModel.comorbidades.length == 0)" " else viewModel.comorbidades
    )
    val  call = RetrofitFactory().pregnant().postComorbidity(comorbidity)

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

fun insertDeficiency(viewModel: ModelPregnant){
    var deficiency = Deficiency(
        viewModel.id,
        if (viewModel.deficiencia.length == 0)"  " else viewModel.deficiencia
    )
    val  call = RetrofitFactory().pregnant().postDeficiency(deficiency)

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

fun insertMedication(viewModel: ModelPregnant){
    var medication = Medication(
        viewModel.id,
        if (viewModel.medicacao.length == 0)"  " else viewModel.medicacao
    )
    val  call = RetrofitFactory().pregnant().postMedication(medication)

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

fun GetAlergy(pregnant: ModelPregnant){
    val call = RetrofitFactory().pregnant().getAlergy(pregnant.id)

    call.enqueue(object : retrofit2.Callback<AlergyResponseList> {
        override fun onResponse(
            call: Call<AlergyResponseList>,
            response: Response<AlergyResponseList>

        ) {
            if (response.body()!!.alergia.isNotEmpty()){

                pregnant.alergia = response.body()!!.alergia[0].alergia
            }

        }

        override fun onFailure(call: Call<AlergyResponseList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

fun GetComorbidity(pregnant: ModelPregnant){
    val call = RetrofitFactory().pregnant().getComorbidity(pregnant.id)

    call.enqueue(object : retrofit2.Callback<ComorbidityResponseList> {
        override fun onResponse(
            call: Call<ComorbidityResponseList>,
            response: Response<ComorbidityResponseList>

        ) {
            if (response.body()!!.comorbidade.isNotEmpty()){

                pregnant.comorbidades = response.body()!!.comorbidade[0].comorbidade
            }

        }

        override fun onFailure(call: Call<ComorbidityResponseList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

fun GetDeficiency(pregnant: ModelPregnant){
    val call = RetrofitFactory().pregnant().getDeficiency(pregnant.id)

    call.enqueue(object : retrofit2.Callback<DeficiencyResponseList> {
        override fun onResponse(
            call: Call<DeficiencyResponseList>,
            response: Response<DeficiencyResponseList>

        ) {
            if (response.body()!!.deficiencia.isNotEmpty()){

                pregnant.deficiencia = response.body()!!.deficiencia[0].deficiencia
            }

        }

        override fun onFailure(call: Call<DeficiencyResponseList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

fun GetMedication(pregnant: ModelPregnant){
    val call = RetrofitFactory().pregnant().getMedication(pregnant.id)

    call.enqueue(object : retrofit2.Callback<MedicationResponseList> {
        override fun onResponse(
            call: Call<MedicationResponseList>,
            response: Response<MedicationResponseList>

        ) {
            println(response.body())
                pregnant.medicacao = response.body()!!.medicacao[0].medicacao

        }

        override fun onFailure(call: Call<MedicationResponseList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}