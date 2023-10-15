package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun CardAlong(
    textTitle: String,
    textDescription: String,
    onclick: () -> Unit,

    ) {

    val expanded = remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(vertical = 10.dp, horizontal = 29.dp)
//                    .background(Color.Yellow)
            .clickable {

                expanded.value = !expanded.value
            }

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Image(painter = painterResource(id = R.drawable.baseline_add_circle_65),
                contentDescription = null,
                modifier = Modifier
                    .clickable(onClick = onclick)
                    .size(30.dp)
            )

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = textTitle,
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(
                    vertical = 5.dp,
                    horizontal = 14.dp
                )
        ) {

            if (expanded.value) {
                Text(
                    text = textDescription,
                    fontSize = 14.sp, // Reduced font size
                    fontWeight = FontWeight.Normal, // Use FontWeight.Normal enum
                    color = Color.Gray
                )
            }

        }


    }
}