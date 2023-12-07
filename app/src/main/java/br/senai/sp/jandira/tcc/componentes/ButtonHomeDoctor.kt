package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun ButtonHomeDoctor(
    navController: NavController
) {

    Button(
        onClick = {
            navController.navigate("loginDoctor")
        },
        modifier = Modifier
            .height(55.dp)
            .width(230.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(10.dp)
            ),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        border = BorderStroke(width = .1.dp, Color.Gray)
    ) {
        Text(
            text = stringResource(id = R.string.button_enter),
            fontSize = 20.sp,
            fontWeight = FontWeight(800),
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.outfit_semibold))

        )

    }
}