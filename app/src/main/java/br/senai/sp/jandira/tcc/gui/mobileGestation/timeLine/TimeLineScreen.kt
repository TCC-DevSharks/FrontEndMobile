package br.senai.sp.jandira.tcc.gui.mobileGestation.timeLine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun TimeLineScreen() {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp)
        ) {

            Header(titulo = stringResource(id = R.string.timeline))

            Spacer(modifier = Modifier.height(10.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                items(40) { index ->
                    val number = index + 1

                    Column(
                        modifier = Modifier
                            .padding(5.dp)
                            .size(75.dp, 35.dp)
//                            .background(
//                                if (isCurrentDate) Color(182, 182, 246) else Color(227, 228, 228),
//                                shape = RoundedCornerShape(10.dp)
//                            )
                            .background(
                                Color(182, 182, 246),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "$number",
//                            color = if (isCurrentDate) Color.White else Color.Black
                            fontWeight = FontWeight(500),
                            fontSize = 17.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chat_cinza),
                    contentDescription = null,
                    modifier = Modifier
                        .size(27.dp)
                )
                Text(
                    modifier = Modifier.padding(start = 14.dp),
                    text = "Seu bebê tem o tamanho de uma framboesa",
                    fontSize = 14.5.sp,
                    fontWeight = FontWeight(500)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Column(modifier = Modifier.padding(horizontal = 20.dp)) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.gravidinha_card),
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Column (modifier = Modifier.fillMaxSize()) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize(1f),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(Color(182,182,246, 95))
                    ) {

                    }

                }

            }

        }

    }


}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TimeLinePreview() {
    TimeLineScreen()
}