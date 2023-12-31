package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonPurple(
    navController: NavController,
    texto: String,
    rota: String,
    cor: Color = Color(182, 182, 246),
    onclick: (NavController) -> Unit,
    width: Dp = (327.dp),
    height: Dp = (48.dp),
    sizeText: TextUnit = 22.sp

) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick =
            {
               onclick(navController)
            }
            ,
            modifier = Modifier
                .width(width)
                .height(height),
            colors = ButtonDefaults.buttonColors(cor),

            shape = RoundedCornerShape(16.dp),

            ) {
            Text(
                text = texto,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = sizeText,
                fontFamily = FontFamily(Font(R.font.outfit_bold))
            )
        }
    }
}
