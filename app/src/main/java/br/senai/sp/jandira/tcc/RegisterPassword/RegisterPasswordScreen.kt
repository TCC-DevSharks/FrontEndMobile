package br.senai.sp.jandira.tcc.RegisterPassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeftPurple
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldSenha
import br.senai.sp.jandira.tcc.componentes.TextDescription
import br.senai.sp.jandira.tcc.componentes.TextTitle

@Composable
fun RegisterPasswordScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {

        Column {

            Row (modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {
                ArrowLeftPurple(navController = navController, rota = "register")

            }


            TextTitle(texto = R.string.title_register_password)

            TextDescription(texto = R.string.description_register_password)

            Spacer(modifier = Modifier.height(20.dp))

        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextFieldSenha(
                texto = R.string.name_password,
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextFieldSenha(
                texto = R.string.confirm_password,
            )
        }

        Spacer(modifier = Modifier.height(45.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            ButtonPurple(navController = navController, texto = R.string.button_next, rota = "week")

        }

    }

}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun RegisterPasswordPreview() {
//    RegisterPasswordScreen()
//}