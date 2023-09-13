package br.senai.sp.jandira.tcc.gui.Exercises.AllExercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun Exercises() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(start = 20.dp, top = 20.dp)) {
                Text(
                    text = stringResource(id = R.string.find_class),
                    fontSize = 20.sp
                )
            }
            Row(modifier = Modifier.padding(start = 20.dp)) {
                Text(
                    text = stringResource(id = R.string.find_class2),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(width = 350.dp, height = 150.dp),
                colors = CardDefaults.cardColors(Color(182, 182, 246))
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 30.dp), verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {

                        Row(modifier = Modifier.width(150.dp)) {
                            Text(
                                modifier = Modifier.padding(start = 20.dp),
                                text = "Today’s activity",
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp
                            )
                        }
                        Row(modifier = Modifier.width(150.dp)) {
                            Text(
                                modifier = Modifier.padding(top = 15.dp, start = 20.dp),
                                text = "8.00 AM - 1.30 PM",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color.White
                            )
                        }

                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pe),
                            contentDescription = null,
                            modifier = Modifier
                                .size(145.dp)
                                .padding(20.dp)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Recommendation Class",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "See all ",
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                color = Color(27, 26, 26)

            )
        }

        Spacer(modifier = Modifier.height(15.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier.size(width = 350.dp, height = 100.dp),
                colors = CardDefaults.cardColors(Color(255, 218, 185))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Row(modifier = Modifier.size(width = 100.dp, height = 80.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.mulher),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 10.dp)
                            )
                        }

                        Column(
                            verticalArrangement = Arrangement.Center, modifier = Modifier
                                .fillMaxHeight()
                                .padding(start = 5.dp)
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 10.dp),
                                text = "Yoga Class",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                modifier = Modifier.padding(start = 10.dp),
                                text = "With Rachael Wisdom",
                                fontSize = 14.sp,
                                color = Color(0, 77, 102)
                            )
                        }
                    }




                    Card(
                        modifier = Modifier.size(width = 30.dp, height = 30.dp),
                        colors = CardDefaults.cardColors(Color.White)

                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.coracao_roxo),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(100.dp)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Categories",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "See all ",
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                color = Color(27, 26, 26)

            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .horizontalScroll(
                    rememberScrollState()
                ),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Card(
                modifier = Modifier.size(width = 140.dp, height = 200.dp),
                colors = CardDefaults.cardColors(Color(182, 182, 246))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Warm up",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mulher_treinando),
                        contentDescription = null,
                        modifier = Modifier.size(180.dp)


                    )
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Card(
                modifier = Modifier.size(width = 140.dp, height = 200.dp),
                colors = CardDefaults.cardColors(Color(241, 243, 250))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Yoga",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mulher_treinando),
                        contentDescription = null,
                        modifier = Modifier.size(180.dp)


                    )
                }
            }
            Spacer(modifier = Modifier.width(10.dp))

            Card(
                modifier = Modifier.size(width = 140.dp, height = 200.dp),
                colors = CardDefaults.cardColors(Color(182, 182, 246))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Squats",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mulher_treinando),
                        contentDescription = null,
                        modifier = Modifier.size(180.dp)


                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ExercisesPreview() {
    Exercises()
}