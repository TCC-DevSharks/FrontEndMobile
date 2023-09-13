package br.senai.sp.jandira.tcc.componentes

import android.graphics.drawable.PaintDrawable
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun Header(
    titulo: String,
    img: Int = R.drawable.arrow_circle_purple_24
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
            painter = painterResource(id = img),
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