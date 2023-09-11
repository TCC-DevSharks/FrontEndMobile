package br.senai.sp.jandira.tcc.gui.Consultation.AddressFinish

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.SubHeader
import br.senai.sp.jandira.tcc.componentes.TextTitle

@Composable
fun ConsultationAddressFinishScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {
                Image(painter = painterResource(id = R.drawable.arrow_circle_purple_24),
                    contentDescription = null,
                    Modifier
                        .clickable {
                        }
                        .size(40.dp)
                )
            }
            Row(modifier = Modifier.padding(horizontal = 50.dp)) {
                TextTitle(texto = R.string.title_address_finish, fontSize = 20.sp)
            }

        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .padding(start = 32.dp)

        ) {
            Text(text = stringResource(id = R.string.address),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color(182, 182, 246)
            )

        }

        Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.Center
            ) {
            OutlinedTextFieldTodos(texto = R.string.text_field_rua, meuType = KeyboardType.Text, email = "", onValueChange = {})
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextFieldTodos(texto = R.string.text_field_bairro, meuType = KeyboardType.Text, email = "", onValueChange = {})
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextFieldTodos(texto = R.string.text_field_numero, meuType = KeyboardType.Text, email = "", onValueChange = {})
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextFieldTodos(texto = R.string.text_field_cidade, meuType = KeyboardType.Text, email = "", onValueChange = {})

        }

        Spacer(modifier = Modifier.height(50.dp))
        ButtonPurple(navController = navController, texto = R.string.finalize, rota = "", onclick = {}, width = 200.dp, height = 48.dp, sizeText = 15.sp)


    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ConsultationAddressFinishScreenPreview() {
//    ConsultationAddressFinishScreen()
//}