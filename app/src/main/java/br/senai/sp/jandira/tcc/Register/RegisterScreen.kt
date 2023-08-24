package br.senai.sp.jandira.tcc.Register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeftPurple
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.Profile
import br.senai.sp.jandira.tcc.componentes.TextDescription
import br.senai.sp.jandira.tcc.componentes.TextTitle

@Composable
fun RegisterScreen(navController: NavController) {

    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {


        Column {

            Row (modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {

                ArrowLeftPurple(navController = navController, rota = "home")

            }


            TextTitle(texto = R.string.title_register)

            TextDescription(texto = R.string.description_register)

            Spacer(modifier = Modifier.height(20.dp))

        }

        Profile(size = 24.dp)

        Spacer(modifier = Modifier.height(20.dp))

        Column (modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {


            OutlinedTextFieldTodos(texto = R.string.text_field_nome, meuType = KeyboardType.Text)
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextFieldTodos(texto = R.string.types_of_users, meuType = KeyboardType.Email)

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextFieldTodos(texto = R.string.text_field_telefone, meuType = KeyboardType.Phone)

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextFieldTodos(texto = R.string.text_field_nascimento, meuType = KeyboardType.Number)

            Spacer(modifier = Modifier.height(40.dp))

            ButtonPurple(navController = navController, texto = R.string.button_next, rota = "register_password",)
        }

        }

    }

//@Preview (showSystemUi = true, showBackground = true)
//@Composable
//fun RegisterPreview() {
//    RegisterScreen()
//}