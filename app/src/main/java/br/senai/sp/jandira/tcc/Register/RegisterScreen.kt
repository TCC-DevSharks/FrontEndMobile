package br.senai.sp.jandira.tcc.Register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos

@Composable
fun RegisterScreen(navController: NavController) {

    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {

            ArrowLeftPurple(navController = navController, rota = "home")

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp)) {
            Text(
                stringResource(id = R.string.title_register),
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)){
            Text(
                stringResource(id = R.string.description_register),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 18.sp

            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(

            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp),
                    shape = CircleShape,
                    border = BorderStroke(3.5.dp, Color(182, 182, 246))

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.perfil_bebe),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.baseline_add_circle_24),

                    contentDescription = null,
                    modifier = Modifier.align(Alignment.BottomEnd))
                }
            }

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