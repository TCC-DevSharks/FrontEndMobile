package br.senai.sp.jandira.tcc.Login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeftPurple
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldSenha


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {

    @OptIn(ExperimentalMaterial3Api::class)
        val context = LocalContext.current


        val lineColor = Color(182, 182, 246) // Cor linear
        val word = "Entre"


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

                ArrowLeftPurple(navController = navController, rota = "home")

            Row(
                modifier = Modifier.padding(top = 25.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = br.senai.sp.jandira.tcc.R.string.title),
                    fontSize = 30.sp,
                    fontWeight = Bold,
                    color = Color(46, 44, 44),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = br.senai.sp.jandira.tcc.R.string.description),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    color = Color(66, 61, 61)


                )
            }
            Spacer(modifier = Modifier.height(18.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
                , horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextFieldTodos(
                    texto = R.string.types_of_users,
                    meuType = KeyboardType.Email
                )

                OutlinedTextFieldSenha(
                    texto = R.string.name_password,
                    )

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
                ButtonPurple(navController ,texto = R.string.button_enter, rota = "home")
                }

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

//@Preview (showSystemUi = true, showBackground = true)
//@Composable
//fun LoginPreview() {
//    LoginScreen()
//}