package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.completedRegistration

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.TextComp

@Composable
fun Completed_Registration(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {
                Image(painter = painterResource(id = R.drawable.arrow_circle),
                    contentDescription = null,
                    Modifier
                        .clickable {
                        }
                        .size(40.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height(100.dp))
        Row(modifier = Modifier.padding(horizontal = 50.dp)) {
            TextComp(texto = R.string.registration, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(width = 250.dp, height = 250.dp),
                colors = CardDefaults.cardColors(Color.LightGray)
            ) {
            }

        }

        Spacer(modifier = Modifier.height(50.dp))

        ButtonPurple(navController = navController, texto = R.string.Continue, rota = "", onclick = {}, width = 300.dp, height = 48.dp, sizeText = 15.sp)

    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun Completed_RegistrationPreview() {
//    Completed_Registration()
//}