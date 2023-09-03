package br.senai.sp.jandira.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun comp(
    textoHeader: String,
    textoMain: String

) {

    Card(
        modifier = Modifier
            .size(width = 120.dp, height = 80.dp)
            .padding(vertical = 9.dp, horizontal = 4.dp),
        colors = CardDefaults.cardColors(Color.White),


    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        ) {
            Text(text = textoHeader, modifier = Modifier.padding(start = 20.dp))
            Image(
                painter = painterResource(id = R.drawable.baseline_edit_note_24),
                contentDescription = null,
                modifier = Modifier.padding(start = 20.dp, bottom = 2.dp),
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = textoMain,
                fontSize = 13.sp,
                color = Color(182, 182, 246),
                modifier = Modifier.padding(start = 25.dp)
            )
        }
    }

}

//@Preview
//@Composable
//fun compPre() {
//    comp()
//}