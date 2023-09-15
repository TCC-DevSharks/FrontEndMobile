package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun ButtonHome(
    shape: RoundedCornerShape,
    text: String,
) {

        Button(
            onClick = {
//                navController.navigate("register")
            },
            modifier = Modifier
                .height(55.dp)
                .width(168.dp)
                .shadow(
                    elevation = 3.dp,
                    shape = shape
                ),
            shape = shape,
            colors = ButtonDefaults.buttonColors(Color.White),
            border = BorderStroke(width = .1.dp, Color.Gray)
        ) {
            Text(
                text = text,
                fontSize = 20.sp,
                fontWeight = FontWeight(800),
                color = Color.Black,
            )

        }


}
