package br.senai.sp.jandira.tcc.gui.AddSchedule

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun AddScheduleScreen(
//    rota: String,
//    navController: NavController
) {

    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.arrow_circle_purple_24),
                contentDescription = null,
                Modifier
                    .clickable {
//                        navController.navigate(rota)

                    }
                    .size(40.dp),
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Plano de Parto",
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                fontWeight = FontWeight(700)
            )
        }

        Column() {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Text(text =" Sugeridos",
                    fontSize = 17.sp,
                    fontWeight = FontWeight(500)

                )
                Text(text =" Minha lista",
                    fontSize = 17.sp,
                    fontWeight = FontWeight(500)

                )

            }


        }




    }


}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AddSchedulePreview() {
    AddScheduleScreen()
}