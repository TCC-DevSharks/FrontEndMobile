package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun CardPreparations(
    category: String,
    navController: NavController
) {


    Column(
        modifier = Modifier.padding(start = 16.dp),
    ) {

        Card(
            modifier = Modifier
                .clickable {
                    navController.navigate(when (category) {
                        "Plano de Parto" -> ("nameSuggestion")
                        "Enxoval" -> ("nameSuggestion")
                        "Mala de Maternidade" -> ("nameSuggestion")
                        "Sugestão de Nomes" -> ("nameSuggestion")
                        else -> ("nameSuggestion") // Default image
                    })
                }
                .size(170.dp, 130.dp),
            colors = CardDefaults.cardColors(Color(236, 236, 255)),
            border = BorderStroke( .3.dp, Color(182, 182, 246)),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    val imageResource = when (category) {
                        "Plano de Parto" -> R.drawable.baby
                        "Enxoval" -> R.drawable.tags
                        "Mala de Maternidade" -> R.drawable.suitcase
                        "Sugestão de Nomes" -> R.drawable.clipboard_list
                        else -> R.drawable.ic_launcher_foreground // Default image
                    }

                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp, 40.dp)
                    )
                }

                Spacer(modifier = Modifier.height(9.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = category,
                        textAlign = TextAlign.Center,
                        fontSize = 17.sp,
                        fontWeight = FontWeight(800),
                        color = Color(182,182,246)
                    )

                }
            }

        }


    }


}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun CardPreparationsPreview() {
//    CardPreparations()
//}