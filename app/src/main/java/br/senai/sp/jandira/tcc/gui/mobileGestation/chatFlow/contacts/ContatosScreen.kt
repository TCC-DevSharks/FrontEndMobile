package br.senai.sp.jandira.tcc.gui.mobileGestation.chatFlow.contacts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.model.ModelPregnant

@Composable
fun ContatosScreen(navController: NavController, pregnant: ModelPregnant) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp, top = 24.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row() {
                    Box(

                    ) {
                        Card(
                            modifier = Modifier
                                .size(85.dp),
                            shape = CircleShape,
                            border = BorderStroke(4.5.dp, Color(182, 182, 246))

                        ) {
                            Image(
                                painter =
                                painterResource(id = R.drawable.avia),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                    }
                }

                Row() {


                    Box(
                        modifier = Modifier
                            .background(Color(182, 182, 246), CircleShape)
                            .size(40.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.search_branco),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                        )
                    }


                }
            }




            Row(
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 20.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.messages),
                    fontSize = 23.sp,
                    fontWeight = FontWeight(900)

                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {

                Box(
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .size(65.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.5.dp, Color(182, 182, 246))


                    ) {
                        Image(
                            painter =
                            painterResource(id = R.drawable.doctor),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                Box(
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .size(65.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.5.dp, Color(182, 182, 246))


                    ) {
                        Image(
                            painter =
                            painterResource(id = R.drawable.doctor),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                Box(
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .size(65.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.5.dp, Color(182, 182, 246))


                    ) {
                        Image(
                            painter =
                            painterResource(id = R.drawable.doctor),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                Box(
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .size(65.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.5.dp, Color(182, 182, 246))


                    ) {
                        Image(
                            painter =
                            painterResource(id = R.drawable.doctor),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 20.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.All_Messages),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(900)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 25.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Row(modifier = Modifier.padding(vertical = 9.dp)) {

                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .size(390.dp, 80.dp),
                        colors = CardDefaults.cardColors(Color(182, 182, 246, 65)),
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 11.dp),
                            verticalArrangement = Arrangement.Center,
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Card(
                                    modifier = Modifier
                                        .size(58.dp),
                                    shape = CircleShape,
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.doctor),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                    )

                                }

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(vertical = 10.dp)
                                ) {

                                    Row(verticalAlignment = Alignment.CenterVertically) {

                                        Text(
                                            modifier = Modifier.padding(start = 26.dp),
                                            text = "Dr Rebbeka",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold
                                        )

                                        Text(
                                            modifier = Modifier.padding(start = 12.dp),
                                            text = "intermed",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(157, 157, 156),

                                            )
                                    }


                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .padding(vertical = 13.dp)
                                            .fillMaxWidth()
                                    ) {

                                        Text(
                                            modifier = Modifier.padding(start = 26.dp),
                                            text = "You have to be more carefull...",
                                            fontSize = 11.sp,
                                            color = Color(157, 157, 156),
                                            fontWeight = FontWeight.Bold
                                        )

                                        Row (verticalAlignment = Alignment.CenterVertically) {

                                            Box(
                                                modifier = Modifier
                                                    .background(Color(182, 182, 246), CircleShape)
                                                    .size(7.dp),
                                                contentAlignment = Alignment.Center
                                            ) {}
                                            Text(
                                                modifier = Modifier.padding(
                                                    start = 5.dp,
                                                    end = 15.dp
                                                ),
                                                text = "27 Oct",
                                                fontSize = 11.sp,
                                                color = Color(157, 157, 156),
                                                fontWeight = FontWeight.Bold
                                            )
                                        }

                                    }

                                }


                            }


                        }


                    }

                }

                Row(modifier = Modifier.padding(vertical = 9.dp)) {

                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .size(390.dp, 80.dp),
                        colors = CardDefaults.cardColors(Color(182, 182, 246, 65)),
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 11.dp),
                            verticalArrangement = Arrangement.Center,
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Card(
                                    modifier = Modifier
                                        .size(58.dp),
                                    shape = CircleShape,
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.doctor),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                    )

                                }

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(vertical = 10.dp)
                                ) {

                                    Row(verticalAlignment = Alignment.CenterVertically) {

                                        Text(
                                            modifier = Modifier.padding(start = 26.dp),
                                            text = "Dr Rebbeka",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold
                                        )

                                        Text(
                                            modifier = Modifier.padding(start = 12.dp),
                                            text = "intermed",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(157, 157, 156),

                                            )
                                    }


                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .padding(vertical = 13.dp)
                                            .fillMaxWidth()
                                    ) {

                                        Text(
                                            modifier = Modifier.padding(start = 26.dp),
                                            text = "You have to be more carefull...",
                                            fontSize = 11.sp,
                                            color = Color(157, 157, 156),
                                            fontWeight = FontWeight.Bold
                                        )

                                        Row (verticalAlignment = Alignment.CenterVertically) {

                                            Box(
                                                modifier = Modifier
                                                    .background(Color(182, 182, 246), CircleShape)
                                                    .size(7.dp),
                                                contentAlignment = Alignment.Center
                                            ) {}
                                            Text(
                                                modifier = Modifier.padding(
                                                    start = 5.dp,
                                                    end = 15.dp
                                                ),
                                                text = "27 Oct",
                                                fontSize = 11.sp,
                                                color = Color(157, 157, 156),
                                                fontWeight = FontWeight.Bold
                                            )
                                        }

                                    }

                                }


                            }


                        }


                    }

                }

                Row(modifier = Modifier.padding(vertical = 9.dp)) {

                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .size(390.dp, 80.dp),
                        colors = CardDefaults.cardColors(Color(182, 182, 246, 65)),
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 11.dp),
                            verticalArrangement = Arrangement.Center,
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Card(
                                    modifier = Modifier
                                        .size(58.dp),
                                    shape = CircleShape,
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.doctor),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                    )

                                }

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(vertical = 10.dp)
                                ) {

                                    Row(verticalAlignment = Alignment.CenterVertically) {

                                        Text(
                                            modifier = Modifier.padding(start = 26.dp),
                                            text = "Dr Rebbeka",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold
                                        )

                                        Text(
                                            modifier = Modifier.padding(start = 12.dp),
                                            text = "intermed",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(157, 157, 156),

                                            )
                                    }


                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .padding(vertical = 13.dp)
                                            .fillMaxWidth()
                                    ) {

                                        Text(
                                            modifier = Modifier.padding(start = 26.dp),
                                            text = "You have to be more carefull...",
                                            fontSize = 11.sp,
                                            color = Color(157, 157, 156),
                                            fontWeight = FontWeight.Bold
                                        )

                                        Row (verticalAlignment = Alignment.CenterVertically) {

                                            Box(
                                                modifier = Modifier
                                                    .background(Color(182, 182, 246), CircleShape)
                                                    .size(7.dp),
                                                contentAlignment = Alignment.Center
                                            ) {}
                                            Text(
                                                modifier = Modifier.padding(
                                                    start = 5.dp,
                                                    end = 15.dp
                                                ),
                                                text = "27 Oct",
                                                fontSize = 11.sp,
                                                color = Color(157, 157, 156),
                                                fontWeight = FontWeight.Bold
                                            )
                                        }

                                    }

                                }


                            }


                        }


                    }

                }

                Row(modifier = Modifier.padding(vertical = 9.dp)) {

                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .size(390.dp, 80.dp),
                        colors = CardDefaults.cardColors(Color(182, 182, 246, 65)),
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 11.dp),
                            verticalArrangement = Arrangement.Center,
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Card(
                                    modifier = Modifier
                                        .size(58.dp),
                                    shape = CircleShape,
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.doctor),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                    )

                                }

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(vertical = 10.dp)
                                ) {

                                    Row(verticalAlignment = Alignment.CenterVertically) {

                                        Text(
                                            modifier = Modifier.padding(start = 26.dp),
                                            text = "Dr Rebbeka",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold
                                        )

                                        Text(
                                            modifier = Modifier.padding(start = 12.dp),
                                            text = "intermed",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(157, 157, 156),

                                            )
                                    }


                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .padding(vertical = 13.dp)
                                            .fillMaxWidth()
                                    ) {

                                        Text(
                                            modifier = Modifier.padding(start = 26.dp),
                                            text = "You have to be more carefull...",
                                            fontSize = 11.sp,
                                            color = Color(157, 157, 156),
                                            fontWeight = FontWeight.Bold
                                        )

                                        Row (verticalAlignment = Alignment.CenterVertically) {

                                            Box(
                                                modifier = Modifier
                                                    .background(Color(182, 182, 246), CircleShape)
                                                    .size(7.dp),
                                                contentAlignment = Alignment.Center
                                            ) {}
                                            Text(
                                                modifier = Modifier.padding(
                                                    start = 5.dp,
                                                    end = 15.dp
                                                ),
                                                text = "27 Oct",
                                                fontSize = 11.sp,
                                                color = Color(157, 157, 156),
                                                fontWeight = FontWeight.Bold
                                            )
                                        }

                                    }

                                }


                            }


                        }


                    }

                }

                Row(modifier = Modifier.padding(vertical = 9.dp)) {

                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .size(390.dp, 80.dp),
                        colors = CardDefaults.cardColors(Color(182, 182, 246, 65)),
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 11.dp),
                            verticalArrangement = Arrangement.Center,
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Card(
                                    modifier = Modifier
                                        .size(58.dp),
                                    shape = CircleShape,
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.doctor),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                    )

                                }

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(vertical = 10.dp)
                                ) {

                                    Row(verticalAlignment = Alignment.CenterVertically) {

                                        Text(
                                            modifier = Modifier.padding(start = 26.dp),
                                            text = "Dr Rebbeka",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold
                                        )

                                        Text(
                                            modifier = Modifier.padding(start = 12.dp),
                                            text = "intermed",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(157, 157, 156),

                                            )
                                    }


                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .padding(vertical = 13.dp)
                                            .fillMaxWidth()
                                    ) {

                                        Text(
                                            modifier = Modifier.padding(start = 26.dp),
                                            text = "You have to be more carefull...",
                                            fontSize = 11.sp,
                                            color = Color(157, 157, 156),
                                            fontWeight = FontWeight.Bold
                                        )

                                        Row (verticalAlignment = Alignment.CenterVertically) {

                                            Box(
                                                modifier = Modifier
                                                    .background(Color(182, 182, 246), CircleShape)
                                                    .size(7.dp),
                                                contentAlignment = Alignment.Center
                                            ) {}
                                            Text(
                                                modifier = Modifier.padding(
                                                    start = 5.dp,
                                                    end = 15.dp
                                                ),
                                                text = "27 Oct",
                                                fontSize = 11.sp,
                                                color = Color(157, 157, 156),
                                                fontWeight = FontWeight.Bold
                                            )
                                        }

                                    }

                                }


                            }


                        }


                    }

                }


            }


        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .border(
                    .9.dp,
                    Color(182, 182, 246),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
        ) {

            Navigation(navController = navController,pregnant)


        }


    }


}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ContatosScreenPreview() {
//    ContatosScreen()
//}