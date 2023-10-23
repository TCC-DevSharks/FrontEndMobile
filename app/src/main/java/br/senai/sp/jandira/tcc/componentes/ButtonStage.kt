package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonStage(
    corButton: Color = Color(182, 182, 246),
    corLetra: Color = Color.White,
    texto: String,
    width: Dp,
    height: Dp


) {


        Button(modifier = Modifier.size(width, height),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(corButton),
            border = BorderStroke(1.dp, Color(182,182,246)),
            onClick = { /*TODO*/ }) {

            Text(text = texto,
                fontSize = 14.sp,
                fontWeight = FontWeight(900),
                color = corLetra,
                textAlign = TextAlign.Center
                )

        }

}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ButtonStagePreview() {
//    ButtonStage()
//}