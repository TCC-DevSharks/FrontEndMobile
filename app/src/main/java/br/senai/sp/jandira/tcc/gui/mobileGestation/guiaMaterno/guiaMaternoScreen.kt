package br.senai.sp.jandira.tcc.gui.mobileGestation.guiaMaterno

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header

@Composable
fun guiaMaternoScreen() {

    Column(modifier = Modifier.fillMaxSize()) {

        Header(titulo = "Notícias")

        Spacer(modifier = Modifier.height(40.dp))

        Row(modifier = Modifier.padding(start = 26.dp)) {
            Text(
                text = "Author",
                fontWeight = FontWeight(900),
                fontSize = 16.sp
            )
        }

        Row(
            modifier = Modifier.padding(start = 26.dp, top = 3.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.day),
                fontWeight = FontWeight(300),
                fontSize = 14.5.sp

            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "16/10/2023",
                fontWeight = FontWeight(300),
                fontSize = 14.5.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.padding(horizontal = 26.dp)) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(Color(182, 182, 246))
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.gravidinha_card),
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


        Column(modifier = Modifier.padding(horizontal = 26.dp)) {
            Row (modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = "6 Habits of Highly Healthy",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 22.sp,
                    fontWeight = FontWeight(900),
                    color = Color(182, 182, 246),
                    textAlign = TextAlign.Center
                )
            }
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun guiaMaternoPreview() {
    guiaMaternoScreen()
}