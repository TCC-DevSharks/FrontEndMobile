package br.senai.sp.jandira.tcc.gui.mobileGestation.loginFlow.login

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldSenha
import br.senai.sp.jandira.tcc.componentes.TextDescription
import br.senai.sp.jandira.tcc.model.login.Login
import br.senai.sp.jandira.tcc.model.login.LoginList
import br.senai.sp.jandira.tcc.componentes.TextComp
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.login.ModelLogin
import br.senai.sp.jandira.tcc.service.RetrofitFactory

import retrofit2.Call
import retrofit2.Response


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, viewModel: ModelPregnant) {

    @OptIn(ExperimentalMaterial3Api::class)
    val context = LocalContext.current

    var password by rememberSaveable { mutableStateOf("") }

    var email by rememberSaveable { mutableStateOf("") }


    var login by remember {
        mutableStateOf(listOf<Login>())
    }


    val lineColor = Color(182, 182, 246) // Cor linear
    var visible by remember { mutableStateOf(false) }



    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {

            Row(modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {

                ArrowLeft(navController = navController, rota = "home")

            }

            TextComp(texto = R.string.title_login)

            TextDescription(texto = R.string.description_login)




            AnimatedVisibility(
                visible = visible,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                enter = fadeIn(
                    initialAlpha = 0.4f
                ),
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 250)
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.error_password),
                        color = Color.Red

                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

        }

        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextFieldTodos(
                texto = R.string.types_of_users,
                meuType = KeyboardType.Email,
                email
            ) {
                email = it
            }

            OutlinedTextFieldSenha(
                texto = R.string.name_password, password
            ) {
                password = it
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 10.dp, end = 25.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("forgot_password")
                        },
                    text = stringResource(id = br.senai.sp.jandira.tcc.R.string.forgot_password),
                    fontSize = 15.sp,
                    textAlign = TextAlign.End,
                    color = Color(66, 61, 61)

                )
            }
        }
        Spacer(modifier = Modifier.height(35.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ButtonPurple(
                navController,
                texto = stringResource(id = R.string.button_enter),
                rota = "homeUser",
                onclick = {

                    var loginGestante = ModelLogin(
                        email = email,
                        senha = password,
                    )

                    val call = RetrofitFactory().getLoginService().insertLogin(loginGestante)

                    call.enqueue(object : retrofit2.Callback<LoginList> {
                        override fun onResponse(
                            call: Call<LoginList>,
                            response: Response<LoginList>

                        ) {
                            //Duas exclamações significam que pode vir nulo
                            login = response.body()!!.login

                            if (login[0].id !== 0) {

                                login.forEach {
                                    viewModel.id = it.id
                                }
                                navController.navigate("homeUser")

                            } else {
                                visible = true
                            }

                        }

                        override fun onFailure(call: Call<LoginList>, t: Throwable) {
                            Log.i(
                                "ds2m",
                                "onFailure: ${t.message}"
                            )
                            println(t.message + t.cause)
                        }
                    })
                })



            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(2.dp)
                        .background(lineColor)
                )

                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = stringResource(id = br.senai.sp.jandira.tcc.R.string.enter_the_app),
                    color = Color(66, 61, 61)
                )

                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(2.dp)
                        .background(lineColor)
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

//            Row(
//                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
//            ) {
//                Card(
//                    modifier = Modifier
//                        .padding(horizontal = 10.dp)
//                        .size(40.dp) // Aumentando o tamanho do Card para a imagem ficar mais visível
//                        .align(alignment = Alignment.CenterVertically), // Centralizando verticalmente na Row
//                    shape = CircleShape
//                ) {
//                    Image(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .background(Color.White),
//                        painter = painterResource(id = br.senai.sp.jandira.tcc.R.drawable.facebook),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop
//                    )
//                }
//
//
//                Card(
//                    modifier = Modifier
//                        .padding(horizontal = 10.dp)
//                        .size(40.dp) // Aumentando o tamanho do Card para a imagem ficar mais visível
//                        .align(alignment = Alignment.CenterVertically), // Centralizando verticalmente na Row
//                    shape = CircleShape
//                ) {
//                    Image(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .background(Color.White),
//                        painter = painterResource(id = br.senai.sp.jandira.tcc.R.drawable.facebook),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop
//                    )
//                }
//
//                Card(
//                    modifier = Modifier
//                        .padding(horizontal = 10.dp)
//                        .size(40.dp) // Aumentando o tamanho do Card para a imagem ficar mais visível
//                        .align(alignment = Alignment.CenterVertically), // Centralizando verticalmente na Row
//                    shape = CircleShape
//                ) {
//                    Image(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .background(Color.White),
//                        painter = painterResource(id = br.senai.sp.jandira.tcc.R.drawable.facebook),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop
//                    )
//                }
//
//
//            }


        }
    }
}
