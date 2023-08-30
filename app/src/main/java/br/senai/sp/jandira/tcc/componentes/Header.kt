package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun Header(
    titulo: String,
//    rota: String,
//    navController: NavController
) {

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
//                    navController.navigate(rota)

                }
                .size(40.dp),
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 23.dp),
            text = titulo,
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            fontWeight = FontWeight(700)
        )
    }

}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun AddSchedulePreview() {
//    AddScheduleScreen()
//}