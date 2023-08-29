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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.CardPreparations
import br.senai.sp.jandira.tcc.componentes.MarternalGuide
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.Profile
import br.senai.sp.jandira.tcc.componentes.Schedule
import br.senai.sp.jandira.tcc.componentes.TextDescription


@Composable
fun HomeUserScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 70.dp, bottom = 105.dp)
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
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
                            painter = painterResource(id = R.drawable.avia),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
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
                                .background(Color.White)
                        ) {

                            Row(
                                modifier = Modifier
//                            .fillMaxWidth()
                                    .height(3.2.dp)
                                    .width(120.dp)
                                    .background(Color(182, 182, 246)),
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

            Spacer(modifier = Modifier.height(50.dp))

            Schedule()

            Spacer(modifier = Modifier.height(50.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp)
            ) {

                Text(
                    text = "Espaço Gravidez e Conversa",
                    fontSize = 15.7.sp,
                    fontWeight = FontWeight(300),
                )
            }

            Spacer(modifier = Modifier.height(13.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                Button(
                    modifier = Modifier.size(360.dp, 50.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(182, 182, 246, 23)),
                    border = BorderStroke(.3.dp, Color(182, 182, 246)),
                    shape = RoundedCornerShape(16.dp)

                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.comments),
                            contentDescription = null,
                            modifier = Modifier.size(26.dp)
                        )

                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = "Fórum",
                            fontSize = 16.sp,
                            color = Color(182, 182, 246),


                            )

                    }

                }
            }

            Spacer(modifier = Modifier.height(50.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp)
            ) {

                Text(
                    text = "Guia Materno",
                    fontSize = 15.7.sp,
                    fontWeight = FontWeight(300),
                )
            }

            Spacer(modifier = Modifier.height(13.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                MarternalGuide()

                MarternalGuide()
                //
            }

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp)
            ) {

                Text(
                    text = "Preparativos",
                    fontSize = 15.7.sp,
                    fontWeight = FontWeight(300),
                )
            }

            Spacer(modifier = Modifier.height(13.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp),
            ) {

                CardPreparations()

                CardPreparations()


            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .border(
                    .9.dp,
                    Color(182,182,246),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
        ) {

            Navigation(navController = navController)


        }


    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomeUserPreview() {
//    HomeUserScreen()
//}