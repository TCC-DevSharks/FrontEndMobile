package br.senai.sp.jandira.tcc.gui.Register

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeftPurple
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldDate
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.Profile
import br.senai.sp.jandira.tcc.componentes.TextDescription
import br.senai.sp.jandira.tcc.componentes.TextTitle
import br.senai.sp.jandira.tcc.model.ModelRegister
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun RegisterScreen(navController: NavController, viewModel: ModelRegister) {

    var email by rememberSaveable { mutableStateOf("") }
    var nome by rememberSaveable { mutableStateOf("") }
    var dataNascimento by rememberSaveable { mutableStateOf("") }
    var telefone by rememberSaveable { mutableStateOf("") }

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


            OutlinedTextFieldTodos(
                texto = R.string.text_field_nome,
                meuType = KeyboardType.Text,
                nome
            ){
                nome = it
            }
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextFieldTodos(
                texto = R.string.types_of_users,
                meuType = KeyboardType.Email,
                email
            ){
                email = it
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextFieldTodos(
                texto = R.string.text_field_telefone,
                meuType = KeyboardType.Phone,
                telefone,

            ){
                telefone = it
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextFieldDate(
                texto = R.string.text_field_nascimento,
                meuType = KeyboardType.Text,
                dataNascimento
            ){
                dataNascimento = it
            }

            Spacer(modifier = Modifier.height(40.dp))

            ButtonPurple(navController = navController, texto = R.string.button_next, rota = "register_password", onclick = {

                if (nome.isNotEmpty() and email.isNotEmpty() and telefone.isNotEmpty() and dataNascimento.isNotEmpty()){
                    var date = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")).format(
                        DateTimeFormatter.ISO_LOCAL_DATE)

                    viewModel.nome = nome
                    viewModel.email = email
                    viewModel.telefone = telefone
                    viewModel.data_nascimento = date
                    Log.i("rty", "${date}")
                    navController.navigate("register_password")
                }else{
                    Log.i("erro", "todos os campos devem ser preenchidas")
                }



            })
        }

        }

    }

//@Preview (showSystemUi = true, showBackground = true)
//@Composable
//fun RegisterPreview() {
//    RegisterScreen()
//}