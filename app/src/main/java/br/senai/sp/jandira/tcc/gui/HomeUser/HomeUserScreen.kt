package br.senai.sp.jandira.tcc.gui.HomeUser

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Profile


@Composable
fun HomeUserScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Box(
            modifier = Modifier
                .size(360.dp, 250.dp),
        ) {

            Box(
                modifier = Modifier
                    .padding(top = 20.dp, end = 48.dp)
                    .align(Alignment.TopEnd)
                    .offset(y = (-68).dp)
                    .zIndex(1f)
                    .border(4.dp, Color(182, 182, 246), CircleShape),
            ) {

                Image(
                    painter = painterResource(id = R.drawable.perfil_bebe),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                )
            }

            Card(
                modifier = Modifier
                    .width(360.dp)
                    .height(250.dp),
                colors = CardDefaults.cardColors(Color(182, 182, 246, 23)),
                border = BorderStroke(2.dp, Color(182, 182, 246, 38))
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 49.dp, start = 22.dp)
                ) {

                    Text(
                        text = "Oi, Alvia!",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(182, 182, 246)
                    )

                }

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 22.dp)
                ) {

                    Text(
                        text = "Como está se sentindo hoje?",
                        fontSize = 15.sp,
                        fontWeight = FontWeight(600),
                        color = Color(182, 182, 246)
                    )

                }

                Spacer(modifier = Modifier.height(31.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 22.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Text(
                        textAlign = TextAlign.Center,
                        text = "11 semanas, 2 dias",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(182, 182, 246)
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {

                    Row(
                        modifier = Modifier
//                            .fillMaxWidth()
                            .height(2.5.dp)
                            .width(120.dp)
                            .background(Color(182, 182, 246))
                    ) {



                    }
                }

                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "11 semanas",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(182, 182, 246)
                    )

                    Text(
                        text = "Out 11 Fev",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(182, 182, 246)
                    )
                }


            }


        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeUserPreview() {
    HomeUserScreen()
}