package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.descriptionClinic

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ButtonPurple

@Composable
fun ConsultationDescriptionClinicScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {
                Image(painter = painterResource(id = R.drawable.arrow_circle),
                        contentDescription = null,
                        Modifier
                                .clickable {}
                                .size(40.dp))
            }

        }
        Spacer(modifier = Modifier.height(20.dp))

        Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                    modifier = Modifier.size(130.dp),
                    shape = CircleShape,
                    border = BorderStroke(1.dp, Color.Gray)

            ) {
                Image(
                        painter = painterResource(id = R.drawable.avia),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text(
                        text = "Clinica Amil",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row() {
                Text(
                        text = "Reproductive Psychiatry & Psychiatry",
                        fontSize = 15.sp,
                        color = Color(57, 57, 56)
                )
            }

        }

        Spacer(modifier = Modifier.height(50.dp))
        Column(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text(
                        text = "About",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row() {
                Text(
                        text = "RDr. Rebbeka is a Clinical Professor of Psychiatry," +
                                " Obstetrics, Gynecology," +
                                " and Reproductive Science at the Icahn School of Medicine at Mount Sinai which she first joined in 2007." +
                                " She is an Attending in Psychiatry at Mount Sinai Medical Center. " +
                                "She also maintains a private practice in New York City.",
                        fontSize = 13.sp,
                        color = Color(57, 57, 56),
                        textAlign = TextAlign.Center,
                        lineHeight = 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Column {
            ButtonPurple(navController = navController, texto = R.string.check_nutritionists, rota = "", onclick = {}, width = 300.dp, height = 48.dp, sizeText = 15.sp)

        }


    }


}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ConsultationDescriptionClinicScreenPreview() {
//    ConsultationDescriptionClinicScreen()
//}