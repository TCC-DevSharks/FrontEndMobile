package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextTitle(
    texto: Int,
    fontSize: TextUnit = 30.sp,
    fontWeight: FontWeight = FontWeight.Bold
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp)
    ) {
        Text(
            stringResource(id = texto),
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            fontWeight = fontWeight,
            textAlign = TextAlign.Center,
            fontSize = fontSize,
        )

    }

}

//@Preview (showBackground = true, showSystemUi = true)
//@Composable
//fun TexteTituloPreview() {
//    TextTitulo()
//}