package br.senai.sp.jandira.tcc.gui.ProfileData

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.endressPregnant.EndressPregnant
import br.senai.sp.jandira.tcc.model.endressPregnant.EndressPregnantList
import br.senai.sp.jandira.tcc.model.viaCep.ViaCep
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import br.senai.sp.jandira.tcc.service.RetrofitFactoryCep
import retrofit2.Call
import retrofit2.Response


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

    var viaCep by remember {
        mutableStateOf(listOf<ViaCep>())
    }

    val call = RetrofitFactoryCep().getCep().getCep(viewModel.cep)

    call.enqueue(object : retrofit2.Callback<ViaCep> {
        override fun onResponse(
            call: Call<ViaCep>,
            response: Response<ViaCep>

        ) {
            Log.i("asdf", "${response.body()}")
            Log.i("asdf", "${response}")

            if (response.code() == 200){
                bairro = response.body()!!.bairro
                cidade = response.body()!!.localidade
                logradouro = response.body()!!.logradouro
                numero = viewModel.numero
                complemento = viewModel.complemento
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



    Column(
        modifier = Modifier
            .fillMaxSize()
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
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp)
        ) {

                    OutlinedTextField(
                        value = if (viewModel.nome == "")nome else viewModel.nome,
                        onValueChange = {if (viewModel.nome == "")nome = it else viewModel.nome = it},
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
                        value = if (viewModel.cpf == "")cpf else viewModel.cpf,
                        onValueChange = { newCpf ->
                            if (viewModel.cpf == ""){
                            cpf = newCpf.filter { it.isDigit() }.take(11)
                            } else{
                                viewModel.cpf = newCpf.filter { it.isDigit() }.take(11)
                            }


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
                        value = if (viewModel.data_nascimento == "")dataNascimento else viewModel.data_nascimento,
                        onValueChange = {if (viewModel.data_nascimento == "")dataNascimento = it else viewModel.data_nascimento = it},
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
                value = if (viewModel.telefone == "")telefone else viewModel.telefone,
                onValueChange = {if (viewModel.telefone == "")telefone = it else viewModel.telefone = it},
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
                        value = if (viewModel.email == "")email else viewModel.email,
                        onValueChange = { if (viewModel.email == "")email = it else viewModel.email = it},
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
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
                        value = if (viewModel.data_parto == "")dataParto else viewModel.data_parto,
                        onValueChange = {if (viewModel.data_parto == "")dataParto = it else viewModel.data_parto = it},
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
                        onValueChange = { semanaGestacao = it },
                        modifier = Modifier
                            .width(370.dp)
                            .height(60.dp),
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
                        value = if (viewModel.cep == "")cep else viewModel.cep,
                        onValueChange = {if (viewModel.cep == "")cep = it
                        else viewModel.cep = it

                            if (cep.length == 8){
                                val call = RetrofitFactoryCep().getCep().getCep(cep)

                                call.enqueue(object : retrofit2.Callback<ViaCep> {
                                    override fun onResponse(
                                        call: Call<ViaCep>,
                                        response: Response<ViaCep>

                                    ) {
                                        Log.i("asdf", "${response.body()}")
                                        Log.i("asdf", "${response}")

                                        if (response.code() == 200){
                                            bairro = response.body()!!.bairro
                                            cidade = response.body()!!.localidade
                                            logradouro = response.body()!!.logradouro
                                            numero = viewModel.numero
                                            complemento = viewModel.complemento
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
                            println(viewModel.cep.length)
                            if (viewModel.cep.length == 8){
                                val call = RetrofitFactoryCep().getCep().getCep(viewModel.cep)

                                call.enqueue(object : retrofit2.Callback<ViaCep> {
                                    override fun onResponse(
                                        call: Call<ViaCep>,
                                        response: Response<ViaCep>

                                    ) {
                                        Log.i("asdf", "${response.body()}")
                                        Log.i("asdf", "${response}")

                                        if (response.code() == 200){
                                            bairro = response.body()!!.bairro
                                            cidade = response.body()!!.localidade
                                            logradouro = response.body()!!.logradouro
                                            numero = viewModel.numero
                                            complemento = viewModel.complemento
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
                            }},
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
                        onValueChange = {logradouro = it},
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
                        value =if (viewModel.numero == "") numero else viewModel.numero,
                        onValueChange = {if (viewModel.numero == "") numero = it else viewModel.numero = it},
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
                value =if (viewModel.complemento == "") complemento else viewModel.complemento,
                onValueChange = {if (viewModel.complemento == "") complemento =it else viewModel.complemento = it},
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
                        onValueChange = {bairro = it},
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
                        onValueChange = {cidade = it},
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
