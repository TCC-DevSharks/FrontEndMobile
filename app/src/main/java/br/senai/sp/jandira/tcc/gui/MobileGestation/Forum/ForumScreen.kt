package br.senai.sp.jandira.tcc.gui.MobileGestation.Forum

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForumScreen(navController: NavController) {

    val expanded = remember { mutableStateOf(false) }

    val expanded2 = remember { mutableStateOf(false) }

    val expanded3 = remember { mutableStateOf(false) }



    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp)
        ) {

            Header(titulo = stringResource(id = R.string.header_forum))


            Row(modifier = Modifier.padding(20.dp)) {

                Column() {

                    Card(
                        modifier = Modifier
                            .size(65.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.5.dp, Color(182, 182, 246))

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.avia),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                    }
                }


                Column(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                ) {

                    Column() {

                        OutlinedTextField(
                            value = "",
                            onValueChange = {
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            label = {
                                Text(
                                    "Alicia, o que você gostaria de compartilhar?",
                                    fontSize = 10.8.sp,
                                    color = Color(209, 209, 214)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            singleLine = true
                        )

                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            Column(modifier = Modifier.padding(horizontal = 5.dp)) {

                                Image(
                                    painter = painterResource(id = R.drawable.home_cinza),
                                    contentDescription = null,
                                    modifier = Modifier.size(28.dp)
                                )
                            }

                            Column(modifier = Modifier.padding(horizontal = 5.dp)) {

                                Image(
                                    painter = painterResource(id = R.drawable.home_cinza),
                                    contentDescription = null,
                                    modifier = Modifier.size(28.dp)
                                )
                            }


                        }

                        Row() {

                            Button(
                                onClick =
                                {
//                        onclick(navController)
                                },
                                modifier = Modifier
                                    .width(115.dp)
                                    .height(35.dp),
                                colors = ButtonDefaults.buttonColors(Color(211, 211, 250)),

                                shape = RoundedCornerShape(16.dp),

                                ) {
                                Text(
                                    text = "Publicar",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                            }

                        }

                    }

                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(.3.dp)
            ) {}

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp),
            ) {

                Card(
                    modifier = Modifier.fillMaxSize(1f)
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(Color(182, 182, 246, 23)),

                ) {

                    Row(
                        modifier = Modifier.padding(14.dp)
                    ) {

                        Card(
                            modifier = Modifier
                                .size(55.dp),
                            shape = CircleShape,
                            border = BorderStroke(1.5.dp, Color.Black),

                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.doctor),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )

                        }

                        Column(modifier = Modifier.padding(horizontal = 14.dp)) {

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {

                                Text(
                                    text = "Clara Souza",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(800)
                                )
                                Text(
                                    text = "2h",
                                    modifier = Modifier.padding(start = 14.dp),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(209, 209, 214)

                                )

                            }

                            Row(modifier = Modifier.padding(top = 5.5.dp)) {
                                Text(
                                    text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. ",
                                    fontSize = 13.5.sp,
                                    fontWeight = FontWeight(300),
                                    lineHeight = 19.sp


                                )

                            }



                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 9.5.dp),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {

                                Column(modifier = Modifier.padding(horizontal = 5.dp)) {

                                    Image(
                                        painter = painterResource(id = R.drawable.home_cinza),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(23.dp)
                                            .clickable {

                                                expanded.value = !expanded.value
                                            }
                                    )
                                }

                                Column(modifier = Modifier.padding(horizontal = 5.dp)) {

                                    Image(
                                        painter = painterResource(id = R.drawable.home_cinza),
                                        contentDescription = null,
                                        modifier = Modifier.size(23.dp)
                                    )
                                }


                            }




                        }


                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Gray)
                            .height(.2.dp)
                    ) {}
                    

                    if (expanded.value) {

                        Spacer(modifier = Modifier.height(14.dp))


                        Row(
                            modifier = Modifier
                                .padding(horizontal = 29.dp)
                                .padding(bottom = 19.dp)
                        ) {

                            Card(
                                modifier = Modifier
                                    .size(45.dp),
                                shape = CircleShape,
                                border = BorderStroke(1.5.dp, Color.Black),


                                ) {
                                Image(
                                    painter = painterResource(id = R.drawable.doctor),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )

                            }

                            Column(modifier = Modifier.padding(horizontal = 22.dp)) {

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {

                                    Text(
                                        text = "Clara Souza",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight(800)
                                    )
                                    Text(
                                        text = "2h",
                                        modifier = Modifier.padding(start = 14.dp),
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight(400),
                                        color = Color(209, 209, 214)

                                    )

                                }

                                Row(modifier = Modifier.padding(top = 5.5.dp)) {
                                    Text(
                                        text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. ",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(300),
                                        lineHeight = 19.sp

                                    )

                                }

                            }

                        }


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Gray)
                                .height(.2.dp)
                        ) {}

                        Spacer(modifier = Modifier.height(14.dp))


                        Row(
                            modifier = Modifier
                                .padding(horizontal = 29.dp)
                                .padding(bottom = 19.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            Card(
                                modifier = Modifier
                                    .size(45.dp),
                                shape = CircleShape,
                                border = BorderStroke(1.5.dp, Color.Black),

                                ) {
                                Image(
                                    painter = painterResource(id = R.drawable.avia),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )

                            }

                            Column(modifier = Modifier.padding(start = 11.dp, bottom = 8.dp), verticalArrangement = Arrangement.Center) {

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {

                                    OutlinedTextField(
                                        value = "",
                                        onValueChange = {
                                        },
                                        modifier = Modifier
                                            .size(262.dp, 65.dp),
                                        shape = RoundedCornerShape(20.dp),
                                        label = {
                                            Text(
                                                "Comente sua resposta!",
                                                fontSize = 12.8.sp,
                                                color = Color(209, 209, 214)
                                            )
                                        },
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Next
                                        ),
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent
                                        ),
                                        singleLine = true
                                    )



                                }


                            }

                        }




                    }


                }

                Card(
                    modifier = Modifier.fillMaxSize(1f)
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(Color(182, 182, 246, 23)),

                    ) {

                    Row(
                        modifier = Modifier.padding(14.dp)
                    ) {

                        Card(
                            modifier = Modifier
                                .size(55.dp),
                            shape = CircleShape,
                            border = BorderStroke(1.5.dp, Color.Black),

                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.doctor),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )

                        }

                        Column(modifier = Modifier.padding(horizontal = 14.dp)) {

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {

                                Text(
                                    text = "Clara Souza",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(800)
                                )
                                Text(
                                    text = "2h",
                                    modifier = Modifier.padding(start = 14.dp),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(209, 209, 214)

                                )

                            }

                            Row(modifier = Modifier.padding(top = 5.5.dp)) {
                                Text(
                                    text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. ",
                                    fontSize = 13.5.sp,
                                    fontWeight = FontWeight(300),
                                    lineHeight = 19.sp


                                )

                            }



                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 9.5.dp),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {

                                Column(modifier = Modifier.padding(horizontal = 5.dp)) {

                                    Image(
                                        painter = painterResource(id = R.drawable.home_cinza),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(23.dp)
                                            .clickable {

                                                expanded2.value = !expanded2.value
                                            }
                                    )
                                }

                                Column(modifier = Modifier.padding(horizontal = 5.dp)) {

                                    Image(
                                        painter = painterResource(id = R.drawable.home_cinza),
                                        contentDescription = null,
                                        modifier = Modifier.size(23.dp)
                                    )
                                }


                            }




                        }


                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Gray)
                            .height(.2.dp)
                    ) {}


                    if (expanded2.value) {

                        Spacer(modifier = Modifier.height(14.dp))


                        Row(
                            modifier = Modifier
                                .padding(horizontal = 29.dp)
                                .padding(bottom = 19.dp)
                        ) {

                            Card(
                                modifier = Modifier
                                    .size(45.dp),
                                shape = CircleShape,
                                border = BorderStroke(1.5.dp, Color.Black),


                                ) {
                                Image(
                                    painter = painterResource(id = R.drawable.doctor),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )

                            }

                            Column(modifier = Modifier.padding(horizontal = 22.dp)) {

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {

                                    Text(
                                        text = "Clara Souza",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight(800)
                                    )
                                    Text(
                                        text = "2h",
                                        modifier = Modifier.padding(start = 14.dp),
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight(400),
                                        color = Color(209, 209, 214)

                                    )

                                }

                                Row(modifier = Modifier.padding(top = 5.5.dp)) {
                                    Text(
                                        text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. ",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(300),
                                        lineHeight = 19.sp

                                    )

                                }

                            }

                        }


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Gray)
                                .height(.2.dp)
                        ) {}

                        Spacer(modifier = Modifier.height(14.dp))


                        Row(
                            modifier = Modifier
                                .padding(horizontal = 29.dp)
                                .padding(bottom = 19.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            Card(
                                modifier = Modifier
                                    .size(45.dp),
                                shape = CircleShape,
                                border = BorderStroke(1.5.dp, Color.Black),

                                ) {
                                Image(
                                    painter = painterResource(id = R.drawable.avia),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )

                            }

                            Column(modifier = Modifier.padding(start = 11.dp, bottom = 8.dp), verticalArrangement = Arrangement.Center) {

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {

                                    OutlinedTextField(
                                        value = "",
                                        onValueChange = {
                                        },
                                        modifier = Modifier
                                            .size(262.dp, 65.dp),
                                        shape = RoundedCornerShape(20.dp),
                                        label = {
                                            Text(
                                                "Comente sua resposta!",
                                                fontSize = 12.8.sp,
                                                color = Color(209, 209, 214)
                                            )
                                        },
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Next
                                        ),
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent
                                        ),
                                        singleLine = true
                                    )



                                }


                            }

                        }




                    }


                }

                Card(
                    modifier = Modifier.fillMaxSize(1f)
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(Color(182, 182, 246, 23)),

                    ) {

                    Row(
                        modifier = Modifier.padding(14.dp)
                    ) {

                        Card(
                            modifier = Modifier
                                .size(55.dp),
                            shape = CircleShape,
                            border = BorderStroke(1.5.dp, Color.Black),

                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.doctor),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )

                        }

                        Column(modifier = Modifier.padding(horizontal = 14.dp)) {

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {

                                Text(
                                    text = "Clara Souza",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(800)
                                )
                                Text(
                                    text = "2h",
                                    modifier = Modifier.padding(start = 14.dp),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(209, 209, 214)

                                )

                            }

                            Row(modifier = Modifier.padding(top = 5.5.dp)) {
                                Text(
                                    text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. ",
                                    fontSize = 13.5.sp,
                                    fontWeight = FontWeight(300),
                                    lineHeight = 19.sp


                                )

                            }



                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 9.5.dp),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {

                                Column(modifier = Modifier.padding(horizontal = 5.dp)) {

                                    Image(
                                        painter = painterResource(id = R.drawable.home_cinza),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(23.dp)
                                            .clickable {

                                                expanded3.value = !expanded3.value
                                            }
                                    )
                                }

                                Column(modifier = Modifier.padding(horizontal = 5.dp)) {

                                    Image(
                                        painter = painterResource(id = R.drawable.home_cinza),
                                        contentDescription = null,
                                        modifier = Modifier.size(23.dp)
                                    )
                                }


                            }




                        }


                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Gray)
                            .height(.2.dp)
                    ) {}


                    if (expanded3.value) {

                        Spacer(modifier = Modifier.height(14.dp))


                        Row(
                            modifier = Modifier
                                .padding(horizontal = 29.dp)
                                .padding(bottom = 19.dp)
                        ) {

                            Card(
                                modifier = Modifier
                                    .size(45.dp),
                                shape = CircleShape,
                                border = BorderStroke(1.5.dp, Color.Black),


                                ) {
                                Image(
                                    painter = painterResource(id = R.drawable.doctor),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )

                            }

                            Column(modifier = Modifier.padding(horizontal = 22.dp)) {

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {

                                    Text(
                                        text = "Clara Souza",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight(800)
                                    )
                                    Text(
                                        text = "2h",
                                        modifier = Modifier.padding(start = 14.dp),
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight(400),
                                        color = Color(209, 209, 214)

                                    )

                                }

                                Row(modifier = Modifier.padding(top = 5.5.dp)) {
                                    Text(
                                        text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. ",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(300),
                                        lineHeight = 19.sp

                                    )

                                }

                            }

                        }


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Gray)
                                .height(.2.dp)
                        ) {}

                        Spacer(modifier = Modifier.height(14.dp))


                        Row(
                            modifier = Modifier
                                .padding(horizontal = 29.dp)
                                .padding(bottom = 19.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            Card(
                                modifier = Modifier
                                    .size(45.dp),
                                shape = CircleShape,
                                border = BorderStroke(1.5.dp, Color.Black),

                                ) {
                                Image(
                                    painter = painterResource(id = R.drawable.avia),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )

                            }

                            Column(modifier = Modifier.padding(start = 11.dp, bottom = 8.dp), verticalArrangement = Arrangement.Center) {

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {

                                    OutlinedTextField(
                                        value = "",
                                        onValueChange = {
                                        },
                                        modifier = Modifier
                                            .size(262.dp, 65.dp),
                                        shape = RoundedCornerShape(20.dp),
                                        label = {
                                            Text(
                                                "Comente sua resposta!",
                                                fontSize = 12.8.sp,
                                                color = Color(209, 209, 214)
                                            )
                                        },
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Next
                                        ),
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent
                                        ),
                                        singleLine = true
                                    )



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

            Navigation(navController = navController)


        }


    }


}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun ForumPreview() {
//    ForumScreen()
//}