package br.senai.sp.jandira.tcc.ForgotPassword

import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeftPurple
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldSenha
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.TextDescription
import br.senai.sp.jandira.tcc.componentes.TextTitulo

@Composable
fun ForgotPasswordScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

          Column () {

              ArrowLeftPurple(navController = navController, rota = "login")

              TextTitulo(texto = R.string.forgot_password)

              TextDescription(texto = R.string.screen_description_forgot_password)

              Spacer(modifier = Modifier.height(20.dp))
          }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            OutlinedTextFieldTodos(texto = R.string.types_of_users, meuType = KeyboardType.Email)

            OutlinedTextFieldSenha(texto = R.string.new_password)

            OutlinedTextFieldSenha(texto = R.string.confirm_password)

        }

        Spacer(modifier = Modifier.height(35.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           ButtonPurple(navController = navController, texto = R.string.button_confirm, rota = "home")
        }


    }

}

//@Preview
//@Composable
//fun ForgotPasswordPreview() {
//    ForgotPasswordScreen()
//}