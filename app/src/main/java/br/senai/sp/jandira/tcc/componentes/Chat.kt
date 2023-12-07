package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import coil.compose.AsyncImage

@Composable
fun Chat(

    messageText: String,
    sender: String,
    currentUser: String,
    fotoPregnant: String,
    fotoProfissional: String

) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        if (sender == currentUser){

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 26.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(start = 58.dp, end = 10.dp),
                        horizontalAlignment = Alignment.End
                    ) {

                        Box(
                            modifier = Modifier
                                .background(
                                    Color(182, 182, 246, 98),
                                    RoundedCornerShape(10.dp)
                                ),
                        ) {
                            Text(
                                text = messageText,
                                style = TextStyle(
                                    color = Color.Black,
                                ),
                                modifier = Modifier
                                    .padding(13.dp),
                                textAlign = TextAlign.Start
                            )
                        }
                    }

                    Card(
                        modifier = Modifier
                            .size(40.dp),
                        shape = CircleShape,


                        ) {
                        AsyncImage(
                            model = fotoPregnant,
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                        )

                    }

                }
            }
            Spacer(modifier = Modifier.height(10.dp))

        }else{
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Card(
                    modifier = Modifier
                        .size(40.dp),
                    shape = CircleShape,


                    ) {
                    AsyncImage(
                        model = fotoProfissional,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                    )

                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(start = 20.dp, end = 14.dp),
                ) {

                    Box(
                        modifier = Modifier
                            .background(
                                Color(182, 182, 246),
                                RoundedCornerShape(10.dp)
                            ),
                    ) {
                        Text(
                            text = messageText,
                            style = TextStyle(
                                color = Color.Black,
                            ),
                            modifier = Modifier
                                .padding(13.dp),
                            textAlign = TextAlign.Start
                        )


//
//                        Row(
//                            modifier = Modifier
//                                .padding(horizontal = 12.dp)
//                                .align(Alignment.BottomStart),
//                            horizontalArrangement = Arrangement.Start
//                        ) {
//
//                            Text(
//                                text = "Tue",
//                                fontSize = 14.sp,
//                                color = Color(102, 97, 97, 95)
//                            )
//
//                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}}