package br.senai.sp.jandira.tcc

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.calls.PostForumTopic
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.forum.topic.PostTopic
import br.senai.sp.jandira.tcc.model.forum.topic.ResponseTopicList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun testezinho() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 35.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.arrow_circle),
                    contentDescription = null,
                    tint = Color(182, 182, 246),
                    modifier = Modifier
                        .size(40.dp),
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(x = (-30).dp),
                    text = "Fórum",
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    fontWeight = FontWeight(700)
                )
            }

        }

        Card(
            modifier = Modifier
                .padding(10.dp)
                .shadow(elevation = 8.dp),
            border = BorderStroke(2.5.dp, Color.White),
            colors = CardDefaults.cardColors(Color.White)

        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .fillMaxWidth(),

                    ) {
                    Card(
                        modifier = Modifier
                            .size(65.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.5.dp, Color(182, 182, 246))

                    ) {
//                        AsyncImage(
//                            model = pregnant.foto,
//                            contentDescription = "",
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier
//                                .size(65.dp)
//                                .clip(CircleShape)
//                        )

                    }

                    Column(modifier = Modifier.padding(horizontal = 35.dp)) {
                        Text(
                            text = "Selecione a categoria do tópico:",
                            color = Color(93, 93, 93),
                            fontSize = 14.sp,
                            )

                        var expanded by remember { mutableStateOf(false) }

                        Spacer(Modifier.height(5.dp))

                        Column {
                            Button(
                                onClick = {
                                    expanded = !expanded
                                },
                                modifier = Modifier
                                    .width(210.dp)
                                    .height(35.dp),
                                colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),

                                shape = RoundedCornerShape(16.dp)
                            ) {
                                Text(
                                    text = "selecione a categoria",
                                    fontSize = 14.sp,
                                )

                            }
                        }
                    }
                }



                Column(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp, bottom = 5.dp)
                ) {

                    Column {

                        var tituloTextFieldValue by remember { mutableStateOf("") }
                        TextField(
                            value = tituloTextFieldValue,
                            onValueChange = { newValue ->
                                tituloTextFieldValue = newValue
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .background(Color.White)
                                .border(1.dp, Color(182, 182, 246), shape = RoundedCornerShape(10.dp)),
                            label = {
                                Text(
                                    "Titulo:",
                                    fontSize = 10.8.sp,
                                    color = Color(182, 182, 246)
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



                        Spacer(modifier = Modifier.height(10.dp))

                        var tituloTextFieldValue2 by remember { mutableStateOf("") }
                        TextField(
                            value = tituloTextFieldValue2,
                            onValueChange = { newValue ->
                                tituloTextFieldValue2 = newValue
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .background(Color.White)
                                .border(1.dp, Color(182, 182, 246), shape = RoundedCornerShape(10.dp)),
                            label = {
                                Text(
                                    "Crie seu tópico {Usuario}:",
                                    fontSize = 10.8.sp,
                                    color = Color(182, 182, 246)

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

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {

                        Button(
                            onClick =
                            {},
                            modifier = Modifier
                                .width(115.dp)
                                .height(35.dp),
                            colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),
                            shape = RoundedCornerShape(16.dp),

                            ) {
                            Text(
                                text = stringResource(id = R.string.publish),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
        Row(modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 15.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Filtrar pela categoria:",
                color = Color(93, 93, 93),
                fontSize = 14.sp,
            )

            var expanded by remember { mutableStateOf(false) }


            Column {
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
//                    categorias.forEach {
//                        DropdownMenuItem(
//                            text = { Text(it.category) },
//                            onClick = {
//                                selectedOptionFilter = it.category
//
//                                val call = RetrofitFactory().Forum().getTopicsCategory(it.category)
//
//                                call.enqueue(object : retrofit2.Callback<ResponseTopicList> {
//                                    override fun onResponse(
//                                        call: Call<ResponseTopicList>,
//                                        response: Response<ResponseTopicList>
//
//                                    ) {
//                                        Log.e("forum","${response}")
//                                        topicos = response.body()!!.topics
//                                    }
//
//                                    override fun onFailure(call: Call<ResponseTopicList>, t: Throwable) {
//                                        Log.i(
//                                            "ds2m",
//                                            "onFailure: ${t.message}"
//                                        )
//                                        println(t.message + t.cause)
//                                    }
//                                })
//                                expanded = false
//                            }
//                        )
//                    }
                }

                Box(
                    modifier = Modifier
                        .width(170.dp)
                        .height(35.dp)
                        .border(1.dp, Color(182, 182, 246), RoundedCornerShape(16.dp))
                ) {
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxSize(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row {
                            Text(
                                text = "Categoria",
                                fontWeight = FontWeight.Bold,
                                color = Color(182, 182, 246)
                            )
                            Spacer(modifier = Modifier.width(0.dp))

                            Icon(
                                painter = painterResource(id = R.drawable.baseline_arrow_downward_24),
                                contentDescription = null,
                                tint = Color(182, 182, 246),
                                modifier = Modifier
                                    .width(24.dp)
                                    .height(24.dp)
                            )
                        }
                    }
                }

            }
        }

        Card(
            modifier = Modifier
                .fillMaxSize(1f)
                .width(50.dp)
                .padding(vertical = 8.dp, horizontal = 10.dp)
                .clickable {
//                    forum.mensagemId = it._id
//                    println(forum.mensagemId)
//                    navController.navigate("forumMessage")
                },
            colors = CardDefaults.cardColors(Color(182, 182, 246, 30)),

            ) {
            Row(
                modifier = Modifier.padding(14.dp)
            ){
                Card(
                    modifier = Modifier
                        .size(55.dp),
                    shape = CircleShape,
                    border = BorderStroke(1.5.dp, Color.Black),

                    ) {
//                    AsyncImage(
//                        model = it.user.foto,
//                        contentDescription = "",
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier.fillMaxSize()
//                    )
                }

                Column(modifier = Modifier.padding(horizontal = 14.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Text(
                            text = "nome",
                            fontSize = 15.sp,
                            fontWeight = FontWeight(800)
                        )
                        Text(
                            text = "data",
                            modifier = Modifier.padding(start = 14.dp),
                            fontSize = 15.sp,
                            fontWeight = FontWeight(400),
                            color = Color(209, 209, 214)
                        )
                    }

                    Row(modifier = Modifier.padding(top = 5.5.dp)) {
                        Text(
                            text = "titulo",
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight(300),
                            lineHeight = 19.sp
                        )
                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 9.5.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Text(text = "categoria",
                            fontSize = 15.sp,
                            fontWeight = FontWeight(400),
                            color = Color(209, 209, 214))
                    }
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun testezinhoPreview() {
    testezinho()
}