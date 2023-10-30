package br.senai.sp.jandira.tcc.gui.mobileGestation.loginFlow.forgotPassword

import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldSenha
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.TextDescription
import br.senai.sp.jandira.tcc.componentes.TextComp
import br.senai.sp.jandira.tcc.model.resetPassword.SendTokenResponse
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

@Composable
fun ForgotPasswordScreen(navController: NavController) {

    var password by rememberSaveable { mutableStateOf("") }
    var passwordConfirmation by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var token by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

          Column () {

              Row (modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {
                  ArrowLeft(navController = navController, rota = "login")

              }

              TextComp(texto = R.string.forgot_password)

              TextDescription(texto = "Enviamos um token para o seu Email")

              Spacer(modifier = Modifier.height(20.dp))
          }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            OutlinedTextFieldTodos(
                texto = stringResource(id = R.string.types_of_users) ,
                meuType = KeyboardType.Email,
                value =  email,
                onValueChange ={
                    email = it
                }
            )

            OutlinedTextFieldTodos(
                texto = "Token",
                meuType = KeyboardType.Number,
                value =  token,
                onValueChange ={
                    token = it
                }
            )

            OutlinedTextFieldSenha(texto = R.string.new_password,password){
                password = it

            }

            OutlinedTextFieldSenha(texto = R.string.confirm_password, passwordConfirmation){
                passwordConfirmation = it
            }

        }

        Spacer(modifier = Modifier.height(35.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           ButtonPurple(navController = navController, texto = stringResource(id = R.string.button_confirm), rota = "home", onclick = {
               if (email.isNotEmpty() &&
                   token.isNotEmpty() &&
                   password.isNotEmpty() &&
                   passwordConfirmation.isNotEmpty()){

                   if (password == passwordConfirmation){

                       var token = SendTokenResponse(
                           email = email,
                           token = token,
                           novaSenha = password
                       )
                       val call = RetrofitFactory().Reset().SendToken(token)

                       call.enqueue(object : retrofit2.Callback<ResponseBody> {
                           override fun onResponse(
                               call: Call<ResponseBody>,
                               response: Response<ResponseBody>

                           ) {
                               if (response.code() == 404){
                                   val backgroundColor = Color.Gray
                                   val contentColor = Color.White

                                   val toast = Toast(context)
                                   toast.setGravity(Gravity.CENTER, 0, 20)
                                   toast.duration = Toast.LENGTH_SHORT

                                   val textView = TextView(context).apply {
                                       text = "Token Inválido"
                                       textSize = 18f // Tamanho da fonte aumentado
                                       setBackgroundColor(backgroundColor.toArgb()) // Converter a cor para ARGB
                                       setTextColor(contentColor.toArgb()) // Converter a cor para ARGB
                                       setPadding(
                                           36,
                                           36,
                                           36,
                                           36
                                       ) // Valores inteiros em pixels para padding
                                   }

                                   toast.view = textView
                                   toast.show()
                               }
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
               }
           })
        }


    }

}

//@Preview
//@Composable
//fun ForgotPasswordPreview() {
//    ForgotPasswordScreen()
//}