package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardCategoryPreparativos(
//
) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp)
                .padding(horizontal = 30.dp, vertical = 9.dp)
                .background(Color(236, 238, 255), shape = CircleShape),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = "Antes do parto",
                color = Color(182,182,246),
                fontSize = 16.sp,
                fontWeight = FontWeight(700)
            )


        }



}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CardCategoryPreparativosPreview() {
    CardCategoryPreparativos()
}