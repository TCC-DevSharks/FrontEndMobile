package br.senai.sp.jandira.tcc.gui.mobileGestation.loginFlow.forgotPassword

import android.util.Log
import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import br.senai.sp.jandira.tcc.model.clinic.ClinicSpecialityResponseList
import br.senai.sp.jandira.tcc.model.resetPassword.SendEmailResponse
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

@Composable
fun ForgotPasswordEmailScreen(navController: NavController) {

    var email by rememberSaveable { mutableStateOf("") }

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

              TextDescription(texto = stringResource(id = R.string.screen_description_forgot_password))

              Spacer(modifier = Modifier.height(20.dp))
          }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            OutlinedTextFieldTodos(
                texto = stringResource(id =R.string.types_of_users ) ,
                meuType = KeyboardType.Email,
                value =  email,
                onValueChange ={
                    email = it
                }
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           ButtonPurple(navController = navController, texto = stringResource(id = R.string.button_confirm), rota = "forgot_password", onclick = {
               if (email.isNotEmpty()){

                   var sendEmail = SendEmailResponse(
                       email = email
                   )

                   val call = RetrofitFactory().Reset().SendEmail(sendEmail)

                   call.enqueue(object : retrofit2.Callback<ResponseBody> {
                       override fun onResponse(
                           call: Call<ResponseBody>,
                           response: Response<ResponseBody>

                       ) {
                           if (response.isSuccessful){
                               navController.navigate("forgot_password")
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
           })
        }


    }

}

//@Preview
//@Composable
//fun ForgotPasswordPreview() {
//    ForgotPasswordScreen()
//}