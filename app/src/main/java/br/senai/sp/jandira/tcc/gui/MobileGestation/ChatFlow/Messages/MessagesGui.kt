package br.senai.sp.jandira.tcc.gui.MobileGestation.ChatFlow.Messages

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessagesGui() {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp, top = 27.dp),
                verticalAlignment = CenterVertically
            ) {

                Row {
//                ArrowLeftPurple(navController = , rota = )
                    Image(painter = painterResource(id = R.drawable.arrow_circle),
                        contentDescription = null,
                        Modifier
                            .clickable {

                            }
                            .size(40.dp))
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 49.dp),
                    verticalAlignment = CenterVertically,
                ) {

                    Card(
                        modifier = Modifier
                            .size(45.dp),
                        shape = CircleShape,
                        border = BorderStroke(1.5.dp, Color(182, 182, 246)),


                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.doctor),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                    }

                    Text(
                        text = "Dr Rafsan jani",
                        fontSize = 19.sp,
                        fontWeight = FontWeight(900),
                        modifier = Modifier.padding(start = 12.dp)
                    )
                }

            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {

                Column(modifier = Modifier.fillMaxWidth(1f)
                    .padding(vertical = 6.dp)) {

                    Spacer(modifier = Modifier.height(23.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 26.dp),
                        verticalAlignment = CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {

                        Card(
                            modifier = Modifier
                                .size(40.dp),
                            shape = CircleShape,


                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.doctor),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
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
                                        Color(255, 218, 185),
                                        RoundedCornerShape(10.dp)
                                    ),
                            ) {
                                Text(
                                    text = "Her",
                                    style = TextStyle(
                                        color = Color.Black,
                                    ),
                                    modifier = Modifier.padding(13.dp)
                                        .padding(bottom = 9.dp),
                                    textAlign = TextAlign.Start
                                )



                                Row(
                                    modifier = Modifier
                                        .padding(horizontal = 12.dp,)
                                        .align(BottomStart),
                                    horizontalArrangement = Arrangement.Start
                                ) {

                                    Text(
                                        text = "Tue",
                                        fontSize = 14.sp,
                                        color = Color(102, 97, 97, 95)
                                    )

                                    Text(
                                        text = "12.30",
                                        fontSize = 14.sp,
                                        modifier = Modifier.padding(start = 7.dp),
                                        color = Color(102, 97, 97, 95)
                                    )

                                }
                            }
                        }


                    }

                }


                Column(modifier = Modifier.fillMaxWidth(1f)
                    .padding(vertical = 6.dp)) {


                    Spacer(modifier = Modifier.height(9.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 26.dp),
                        verticalAlignment = CenterVertically,
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
                                        Color(182,182,246,98),
                                        RoundedCornerShape(10.dp)
                                    ),
                            ) {
                                Text(
                                    text = "Heytytfr3 ggghg hgjhghghg gvv gvgv gvgv  gvvgvh hgv gvvv  huj hbhb hbjjn nbnj bl3jfr3fr",
                                    style = TextStyle(
                                        color = Color.Black,
                                    ),
                                    modifier = Modifier.padding(13.dp)
                                        .padding(bottom = 9.dp),
                                    textAlign = TextAlign.Start
                                )



                                Row(
                                    modifier = Modifier
                                        .padding(horizontal = 12.dp,)
                                        .align(BottomEnd),
                                    horizontalArrangement = Arrangement.End
                                ) {

                                    Text(
                                        text = "Tue",
                                        fontSize = 14.sp,
                                        color = Color(102, 97, 97, 95)
                                    )

                                    Text(
                                        text = "12.30",
                                        fontSize = 14.sp,
                                        modifier = Modifier.padding(start = 7.dp),
                                        color = Color(102, 97, 97, 95)
                                    )

                                }
                            }
                        }

                        Card(
                            modifier = Modifier
                                .size(40.dp),
                            shape = CircleShape,


                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.doctor),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )

                        }

                    }





                }


            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 28.dp, vertical = 20.dp),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            OutlinedTextField(
                value = "",
                onValueChange = {
                },
                modifier = Modifier
                    .size(280.dp, 50.dp),
                shape = RoundedCornerShape(10.dp),
                label = {
                    Text(
                        text = "Digite seus problemas",
                        fontSize = 14.sp,
                        color = Color(102, 97, 97, 95)
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(243, 243, 243),
                    focusedIndicatorColor = Color(243, 243, 243),
                    unfocusedIndicatorColor = Color(243, 243, 243)
                ),
                singleLine = true
            )

            Box(
                modifier = Modifier
                    .background(Color(182, 182, 246), CircleShape)
                    .size(38.dp)
                    .clickable {
//                            navController.navigate("week")
                    }, contentAlignment = Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.plane2),
                    contentDescription = null,
                    modifier = Modifier
                        .size(19.dp)
                        .padding(end = 2.5.dp),
                )
            }
        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MessagesGuiPreview() {
    MessagesGui()
}