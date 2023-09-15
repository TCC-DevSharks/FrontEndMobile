package br.senai.sp.jandira.tcc.gui.MobileGestation.ExercisesFlow.StageExercices

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun StageExercises() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            Row(modifier = Modifier.padding(top = 40.dp)) {
                Text(
                    text = stringResource(id = R.string.Warm_up),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold

                )
            }
            Spacer(modifier = Modifier.height(9.dp))
            Row() {
                Text(
                    text = stringResource(id = R.string.description_warm_up),
                    fontSize = 13.sp,
                    color = Color.LightGray
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
        ) {
            Card(
                modifier = Modifier.size(width = 100.dp, height = 30.dp),
                colors = CardDefaults.cardColors(Color(182, 182, 246)),
                shape = RectangleShape,
                border = BorderStroke(0.dp, Color.Transparent)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.padding(top = 3.dp),
                        painter = painterResource(id = R.drawable.baseline_access_time_24),
                        contentDescription = null,
                        tint = Color.White
                    )
                    Text(
                        text = "10.00 mins",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }

            }
            Spacer(modifier = Modifier.width(10.dp))
            Card(
                modifier = Modifier.size(width = 100.dp, height = 30.dp),
                colors = CardDefaults.cardColors(Color(255, 218, 185)),
                shape = RectangleShape,
                border = BorderStroke(0.dp, Color.Transparent)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.padding(top = 3.dp),
                        painter = painterResource(id = R.drawable.ryu_the_runner),
                        contentDescription = null,
                        tint = Color.White
                    )
                    Text(
                        text = "Running",
                        color = Color.White
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            Text(
                text = "Exercises",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )

        }
        Spacer(modifier = Modifier.height(15.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 4.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 9.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .size(60.dp),
                        shape = RoundedCornerShape(12.dp),
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.mulher_alogando),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {


                        Text(
                            text = "Exercise 1",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(800),
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "02.30 Minutes",
                            fontSize = 12.5.sp,
                            color = Color(173, 164, 165),
                            fontWeight = FontWeight(300),
                        )
                    }

                }



                Card(
                    modifier = Modifier.size(width = 50.dp, height = 50.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(Color(191, 190, 244, 90)),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                            contentDescription = null,
                            tint = Color(182, 182, 246),
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                        )
                    }
                }


            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 9.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .size(60.dp),
                        shape = RoundedCornerShape(12.dp),
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.mulher_alogando),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {


                        Text(
                            text = "Exercise 2",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(800),
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "02.00 Minutes",
                            fontSize = 12.5.sp,
                            color = Color(173, 164, 165),
                            fontWeight = FontWeight(300),
                        )
                    }

                }



                Card(
                    modifier = Modifier.size(width = 50.dp, height = 50.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(Color(191, 190, 244, 90)),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                            contentDescription = null,
                            tint = Color(182, 182, 246),
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                        )
                    }
                }

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 9.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .size(60.dp),
                        shape = RoundedCornerShape(12.dp),
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.mulher_alogando),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {


                        Text(
                            text = "Exercise 3",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(800),
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "03.20 Minutes",
                            fontSize = 12.5.sp,
                            color = Color(173, 164, 165),
                            fontWeight = FontWeight(300),
                        )
                    }

                }



                Card(
                    modifier = Modifier.size(width = 50.dp, height = 50.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(Color(191, 190, 244, 90)),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                            contentDescription = null,
                            tint = Color(182, 182, 246),
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                        )
                    }
                }

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 9.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .size(60.dp),
                        shape = RoundedCornerShape(12.dp),
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.mulher_alogando),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {


                        Text(
                            text = "Exercise 4",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(800),
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "02.30 Minutes",
                            fontSize = 12.5.sp,
                            color = Color(173, 164, 165),
                            fontWeight = FontWeight(300),
                        )
                    }

                }


                Card(
                    modifier = Modifier.size(width = 50.dp, height = 50.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(Color(191, 190, 244, 90)),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                            contentDescription = null,
                            tint = Color(182, 182, 246),
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                        )
                    }
                }

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 9.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .size(60.dp),
                        shape = RoundedCornerShape(12.dp),
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.mulher_alogando),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {


                        Text(
                            text = "Exercise 5",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(800),
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "05.30 Minutes",
                            fontSize = 12.5.sp,
                            color = Color(173, 164, 165),
                            fontWeight = FontWeight(300),
                        )
                    }

                }


                Card(
                    modifier = Modifier.size(width = 50.dp, height = 50.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(Color(191, 190, 244, 90)),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                            contentDescription = null,
                            tint = Color(182, 182, 246),
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                        )
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 9.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .size(60.dp),
                        shape = RoundedCornerShape(12.dp),
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.mulher_alogando),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {


                        Text(
                            text = "Exercise 6",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(800),
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "06.10 Minutes",
                            fontSize = 12.5.sp,
                            color = Color(173, 164, 165),
                            fontWeight = FontWeight(300),
                        )
                    }

                }



                Card(
                    modifier = Modifier.size(width = 50.dp, height = 50.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(Color(191, 190, 244, 90)),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                            contentDescription = null,
                            tint = Color(182, 182, 246),
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                        )
                    }
                }

            }


        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StageExercisesPreview() {
    StageExercises()
}