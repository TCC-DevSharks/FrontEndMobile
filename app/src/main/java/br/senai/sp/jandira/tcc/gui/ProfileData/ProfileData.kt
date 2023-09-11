package br.senai.sp.jandira.tcc.gui.ProfileData

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.AlertDialog
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.Pregnant
import br.senai.sp.jandira.tcc.model.viaCep.ViaCep
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import br.senai.sp.jandira.tcc.service.RetrofitFactoryCep
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileData(navController: NavController, viewModel: ModelPregnant) {
    var cpf by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var dataNascimento by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var dataParto by remember { mutableStateOf("") }
    var semanaGestacao by remember { mutableStateOf(viewModel.semana_gestacao.toString()) }
    var logradouro by remember { mutableStateOf("") }
    var complemento by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var bairro by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }

    val openDialogSucess = remember { mutableStateOf(false) }
    val openDialogFail = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {

        nome = viewModel.nome
        cpf = viewModel.cpf
        email = viewModel.email
        dataParto = viewModel.data_parto
        dataNascimento = viewModel.data_nascimento
        telefone = viewModel.telefone
        complemento = viewModel.complemento
        cep = viewModel.cep
        numero = viewModel.numero
        semanaGestacao = "${viewModel.semana_gestacao}"

        val call = RetrofitFactoryCep().getCep().getCep(viewModel.cep)

        if (viewModel.cep.length == 8) {
            call.enqueue(object : retrofit2.Callback<ViaCep> {
                override fun onResponse(
                    call: Call<ViaCep>,
                    response: Response<ViaCep>

                ) {
                    Log.i("asdf", "${response}")

                    if (response.code() == 200) {
                        bairro = response.body()!!.bairro
                        cidade = response.body()!!.localidade
                        logradouro = response.body()!!.logradouro
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

    var visible by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
            ) {
                Header(titulo = stringResource(id = R.string.header_date))

                Spacer(modifier = Modifier.height(5.dp))
                Row() {

                    Text(
                        text = stringResource(id = R.string.people_date),
                        fontSize = 15.sp,
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp)
                ) {

                    OutlinedTextField(
                        value = nome,
                        onValueChange = {
                            nome = it
                            visible = true
                        },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.example_name),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = cpf,
                        onValueChange = { newCpf ->
                            cpf = newCpf.filter { it.isDigit() }.take(11)
                            visible = true


                        },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.example_cpf),
                                fontSize = 15.sp,
                                color = Color.Black,
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Number,
                        ),
                        singleLine = true,
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        },
                        visualTransformation = VisualTransformation.None
                    )

                    Spacer(modifier = Modifier.height(10.dp))


                    OutlinedTextField(
                        value = dataNascimento,
                        onValueChange = {
                            dataNascimento = it
                            visible = true
                        },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.date_of_birth),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )



                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = telefone,
                        onValueChange = {
                            telefone = it
                            visible = true
                        },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.telephone),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )



                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        enabled = false,
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.email),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta

                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )



                    Spacer(modifier = Modifier.height(10.dp))




                    OutlinedTextField(
                        value = dataParto,
                        onValueChange = {
                            dataParto = it
                            visible = true
                        },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.date_childbirth),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta

                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))


                    OutlinedTextField(
                        value = semanaGestacao,
                        onValueChange = {
                            semanaGestacao = it
                            visible = true
                        },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        enabled = false,
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.gestation_week),
                                fontSize = 15.sp,
                                color = Color.Black,

                                )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Number,
                        ),
                        singleLine = true,
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        },
                        visualTransformation = VisualTransformation.None
                    )





                    Spacer(modifier = Modifier.height(10.dp))
                    Row() {
                        Text(
                            text = stringResource(id = R.string.address),
                            fontSize = 15.sp,
                            fontFamily = FontFamily.SansSerif,
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))


                    OutlinedTextField(
                        value = cep,
                        onValueChange = {
                            cep = it
                            if (cep.length == 8) {
                                val call = RetrofitFactoryCep().getCep().getCep(cep)

                                call.enqueue(object : retrofit2.Callback<ViaCep> {
                                    override fun onResponse(
                                        call: Call<ViaCep>,
                                        response: Response<ViaCep>

                                    ) {
                                        Log.i("Segundo", "${response}")

                                        if (response.code() == 200) {
                                            bairro = response.body()!!.bairro
                                            cidade = response.body()!!.localidade
                                            logradouro = response.body()!!.logradouro

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
                            visible = true
                        },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.example_cep),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))


                    OutlinedTextField(
                        value = logradouro,
                        onValueChange = {
                            logradouro = it
                        },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        enabled = false,
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.example_street),
                                fontSize = 15.sp,
                                color = Color.Black,
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Number,
                        ),
                        singleLine = true,
                        visualTransformation = VisualTransformation.None
                    )




                    Spacer(modifier = Modifier.height(10.dp))




                    OutlinedTextField(
                        value = numero,
                        onValueChange = {
                            numero = it
                            visible = true
                        },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.number),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta

                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )



                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = complemento,
                        onValueChange = {
                            complemento = it
                            visible = true
                        },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.example_complement),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta

                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,

                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.editor_outlined),
                                contentDescription = "",
                                tint = Color(182, 182, 246)
                            )

                        }
                    )



                    Spacer(modifier = Modifier.height(10.dp))


                    OutlinedTextField(
                        value = bairro,
                        onValueChange = {
                            bairro = it
                        },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        enabled = false,
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.example_Neighborhood),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta

                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,
                    )



                    Spacer(modifier = Modifier.height(10.dp))


                    OutlinedTextField(
                        value = cidade,
                        onValueChange = { cidade = it },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
                        enabled = false,
                        shape = RoundedCornerShape(16.dp),
                        label = {
                            Text(
                                text = stringResource(id = R.string.example_city),
                                fontSize = 15.sp,
                                color = Color.Black, // Defina a cor do texto como preta
                            )
                        },
                        colors = TextFieldDefaults
                            .outlinedTextFieldColors(
                                focusedBorderColor = Color(148, 112, 214),
                                unfocusedBorderColor = Color(182, 182, 246)
                            ),
                        singleLine = true,
                    )
                }
            }
        }

        AnimatedVisibility(
            visible = visible,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .align(Alignment.BottomCenter),
            enter = fadeIn(
                initialAlpha = 0.4f
            ),
            exit = fadeOut(
                animationSpec = tween(durationMillis = 250)
            )
        ) {
            ButtonPurple(
                navController = navController,
                texto = "Salvar alterações",
                rota = "",
                onclick = {
                    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

                    var Pregnant = Pregnant(
                        nome = nome,
                        altura = viewModel.altura,
                        peso = viewModel.peso,
                        cpf = cpf,
                        telefone = telefone,
                        complemento = complemento,
                        numero = numero,
                        cep = cep,
                        semana_gestacao = semanaGestacao.toInt(),
                        foto = viewModel.foto,
                        data_parto = "${LocalDate.parse(dataParto,formatter)}",
                        data_nascimento = "${LocalDate.parse(dataNascimento,formatter)}",
                        email = viewModel.email,
                        senha = viewModel.senha
                    )
                    val call = RetrofitFactory().updatePregnant().updatePregnant(viewModel.id, Pregnant )

                    call.enqueue(object : retrofit2.Callback<Pregnant> {
                        override fun onResponse(
                            call: Call<Pregnant>,
                            response: Response<Pregnant>

                        ) {
                            if (response.code() == 200){
                                viewModel.semana_gestacao = semanaGestacao.toInt()
                                viewModel.nome = nome
                                viewModel.numero = numero
                                viewModel.complemento = complemento
                                viewModel.cpf = cpf
                                viewModel.cep = cep
                                viewModel.telefone = telefone
                                viewModel.data_parto = dataParto
                                viewModel.data_nascimento = dataNascimento
                                viewModel.email = email

                                openDialogSucess.value = true
                            }else{
                                openDialogFail.value = true
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

                }
            )

            AlertDialog(openDialog = openDialogSucess, title = "Sucesso", aviso = "Alterações efetuadas com sucesso")
            AlertDialog(openDialog = openDialogFail, title = "Erro", aviso = "Por favor, tente novamente mais tarde")

        }

    }
}
