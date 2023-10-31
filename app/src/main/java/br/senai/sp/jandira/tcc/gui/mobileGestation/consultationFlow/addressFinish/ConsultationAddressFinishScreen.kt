package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.addressFinish

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.GetEspeciality
import br.senai.sp.jandira.tcc.calls.PutWeight
import br.senai.sp.jandira.tcc.calls.insertALergy
import br.senai.sp.jandira.tcc.calls.insertComorbidity
import br.senai.sp.jandira.tcc.calls.insertMedication
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.TextComp
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.ModelSpeciality
import br.senai.sp.jandira.tcc.model.Pregnant
import br.senai.sp.jandira.tcc.model.WeightHeight
import br.senai.sp.jandira.tcc.model.viaCep.ViaCep
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import br.senai.sp.jandira.tcc.service.RetrofitFactoryCep
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ConsultationAddressFinishScreen(navController: NavController, pregnant: ModelPregnant, speciality: ModelSpeciality) {

    var logradouro by remember { mutableStateOf("") }
    var complemento by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var bairro by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        complemento = pregnant.complemento
        cep = pregnant.cep
        numero = pregnant.numero

        val call = RetrofitFactoryCep().getCep().getCep(pregnant.cep)

        if (pregnant.cep.length == 8) {
            call.enqueue(object : Callback<ViaCep> {
                override fun onResponse(
                    call: Call<ViaCep>,
                    response: Response<ViaCep>

                ) {
                    Log.i("asdf", "${response}")

                    if (response.code() == 200) {
                        bairro = response.body()!!.bairro
                        cidade = response.body()!!.localidade
                        logradouro = response.body()!!.logradouro
                        estado = response.body()!!.uf
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
    }


    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {

                ArrowLeft(navController = navController, rota = "insertEndress")

            }
            Row(modifier = Modifier.padding(horizontal = 50.dp)) {
                TextComp(texto = R.string.title_address_finish, fontSize = 20.sp)
            }

        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .padding(start = 32.dp)

        ) {
            Text(
                text = stringResource(id = R.string.address),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color(182, 182, 246)
            )

        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextFieldTodos(
                texto = stringResource(id = R.string.example_cep),
                meuType = KeyboardType.Text,
                value = cep,
                onValueChange = {
                    cep = it
                    if (cep.length == 8) {
                        val call = RetrofitFactoryCep().getCep().getCep(cep)

                        call.enqueue(object : Callback<ViaCep> {
                            override fun onResponse(
                                call: Call<ViaCep>,
                                response: Response<ViaCep>

                            ) {
                                Log.i("asdf", "${response}")

                                if (response.code() == 200) {
                                    bairro = response.body()!!.bairro
                                    cidade = response.body()!!.localidade
                                    logradouro = response.body()!!.logradouro
                                    estado = response.body()!!.uf
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
                })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = stringResource(id = R.string.text_field_rua),
                meuType = KeyboardType.Text,
                value = logradouro,
                onValueChange = { logradouro = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = stringResource(id = R.string.text_field_numero),
                meuType = KeyboardType.Text,
                value = numero,
                onValueChange = { numero = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = stringResource(id = R.string.example_complement),
                meuType = KeyboardType.Text,
                value = complemento,
                onValueChange = { complemento = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = stringResource(id = R.string.text_field_bairro),
                meuType = KeyboardType.Text,
                value = bairro,
                onValueChange = { bairro = it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = stringResource(id = R.string.text_field_cidade),
                meuType = KeyboardType.Text,
                value = cidade,
                onValueChange = { cidade == it })

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextFieldTodos(
                texto = stringResource(id = R.string.text_field_cidade),
                meuType = KeyboardType.Text,
                value = estado,
                onValueChange = { estado == it })

        }

        Spacer(modifier = Modifier.height(50.dp))
        ButtonPurple(
            navController = navController,
            texto = stringResource(id = R.string.finalize),
            rota = "",
            width = 200.dp,
            height = 48.dp,
            sizeText = 15.sp,
            onclick = {
                if(cep.isNotEmpty() && numero.isNotEmpty()){
                    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

                    var Pregnant = Pregnant(
                        nome = pregnant.nome,
                        altura = pregnant.altura,
                        peso = pregnant.peso,
                        cpf = pregnant.cpf,
                        telefone = pregnant.telefone,
                        complemento = complemento,
                        numero = numero,
                        cep = cep,
                        semana_gestacao = pregnant.semana_gestacao,
                        foto = pregnant.foto,
                        data_parto = "${LocalDate.parse(pregnant.data_parto,formatter)}",
                        data_nascimento = "${LocalDate.parse(pregnant.data_nascimento,formatter)}",
                        email = pregnant.email,
                        senha = pregnant.senha
                    )

                    var weightHeight = WeightHeight(
                        altura = pregnant.altura,
                        peso = pregnant.peso,
                        foto = pregnant.foto
                    )

                    println(Pregnant)
                    val call = RetrofitFactory().pregnant().updatePregnant(pregnant.id, Pregnant )

                    call.enqueue(object : retrofit2.Callback<Pregnant> {
                        override fun onResponse(
                            call: Call<Pregnant>,
                            response: Response<Pregnant>

                        ) {
                            println(response)
                            if (response.code() == 200){
                                pregnant.numero = numero
                                pregnant.complemento = complemento
                                pregnant.cep = cep

                                navController.navigate("Completed")
                            }
                        }

                        override fun onFailure(call: Call<Pregnant>, t: Throwable) {
                            Log.i(
                                "ds2m",
                                "onFailure: ${t.message}"
                            )
                            println(t.message + t.cause)
                        }
                    })

                    PutWeight(pregnant, weightHeight)
                    insertALergy(pregnant)
                    insertComorbidity(pregnant)
                    insertMedication(pregnant)
                    GetEspeciality(speciality)
                }
            }
        )


    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ConsultationAddressFinishScreenPreview() {
//    ConsultationAddressFinishScreen()
//}