package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun MarternalGuide(
    //textTitle: String
    //textDescription: String

) {

    Column (modifier = Modifier.padding(start = 16.dp)) {

        Card(
            modifier = Modifier.size(250.dp, 215.dp),
            colors = CardDefaults.cardColors(Color(182, 182, 246, 23)),
            border = BorderStroke( .3.dp, Color(182, 182, 246))

        ) {

            Column(modifier = Modifier.size(250.dp, 115.dp)) {

                Image(
                    painter = painterResource(id = R.drawable.gravidinha_card),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )


            }
            Spacer(modifier = Modifier.height(5.dp))

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 7.dp)) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.5.dp)) {

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "6 Habits of Highly Healthy Brains",
                        color = Color(182, 182, 246),
                        fontSize = 15.9.sp,
                        fontWeight = FontWeight(900),
                        lineHeight = 15.5.sp, // Ajuste a altura das linhas conforme necessário

                    )

                }

                Spacer(modifier = Modifier.height(7.dp))

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.5.dp)) {

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Key lifestyle habits that can help keep your brain healthy.",
                        fontSize = 10.sp,
                        color = Color(102,97,97),
                        fontWeight = FontWeight(300),
                        lineHeight = 12.sp, // Ajuste a altura das linhas conforme necessário
                    )

                }

            }

        }

    }




}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MarternalGuidePreview() {

    MarternalGuide()
}