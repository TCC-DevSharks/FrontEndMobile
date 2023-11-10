package br.senai.sp.jandira.tcc.gui.mobileGestation.login

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
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.clickable
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
import br.senai.sp.jandira.tcc.model.login.LoginDoctorList
import br.senai.sp.jandira.tcc.model.login.ModelLogin
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.service.RetrofitFactory

import retrofit2.Call
import retrofit2.Response

@Composable
fun LoginDoctorScreen(navController: NavController, professional: Professional) {

    var password by rememberSaveable { mutableStateOf("") }

    var email by rememberSaveable { mutableStateOf("") }

//    email = "m@t.com"
//    password = "123"

    var login by remember {
        mutableStateOf(listOf<Login>())
    }
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

            TextDescription(texto = stringResource(id = R.string.description_login_doctor))

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
                texto = stringResource(id = R.string.types_of_users),
                meuType = KeyboardType.Email,
                value = email,
                onValueChange ={
                    email = it
                }
            )

            OutlinedTextFieldSenha(
                texto = R.string.name_password, password
            ) {
                password = it
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

                    var loginDoctor = ModelLogin(
                        email = email,
                        senha = password,
                    )

                    val call = RetrofitFactory().findLogin().insertLoginDoctor(loginDoctor)

                    if (email !== "" && password !== ""){
                        call.enqueue(object : retrofit2.Callback<LoginDoctorList> {
                            override fun onResponse(
                                call: Call<LoginDoctorList>,
                                response: Response<LoginDoctorList>

                            ) {
                                //Duas exclamações significam que pode vir nulo
                                login = response.body()!!.doctor

                                if (login[0].id !== 0) {

                                    login.forEach {
                                        professional.id = it.id
                                    }
                                    navController.navigate("DoctorHome")

                                } else {
                                    visible = true
                                }

                            }

                            override fun onFailure(call: Call<LoginDoctorList>, t: Throwable) {
                                Log.i(
                                    "ds2m",
                                    "onFailure: ${t.message}"
                                )
                                println(t.message + t.cause)
                            }
                        })
                    }

                })
        }
    }
}
