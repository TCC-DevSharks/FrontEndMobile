package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun SubHeader(
    leftText: String,
    rightText: String,
    onColumnSelected: (Int) -> Unit


) {

    var selectedColumn by remember { mutableStateOf(1) }


    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Text(
            text = leftText,
            fontSize = 17.sp,
            fontWeight = FontWeight(500),
            modifier = Modifier.clickable {
                selectedColumn = 1
                onColumnSelected(selectedColumn)

            },
            color = if (selectedColumn == 1) Color(182, 182, 246) else Color.Black


        )
        Text(
            text = rightText,
            fontSize = 17.sp,
            fontWeight = FontWeight(500),
            modifier = Modifier.clickable {
                selectedColumn = 2
                onColumnSelected(selectedColumn)

            },
            color = if (selectedColumn == 2) Color(182, 182, 246) else Color.Black

        )

    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.4.dp)
            .background(Color(209, 209, 214))
    ) {

        Column(
            modifier = Modifier
                .size(200.dp, 2.9.dp)
                .background(
                    if (selectedColumn == 1) Color(182, 182, 246) else Color(
                        209,
                        209,
                        214
                    )
                )
        ) {}

        Column(
            modifier = Modifier
                .size(220.dp, 2.9.dp)
                .background(
                    if (selectedColumn == 2) Color(182, 182, 246) else Color(
                        209,
                        209,
                        214
                    )
                )

        ) {}

    }

}


//@Preview (showBackground = true, showSystemUi = true)
//@Composable
//fun SubHeaderPreview() {
//    SubHeader()
//}