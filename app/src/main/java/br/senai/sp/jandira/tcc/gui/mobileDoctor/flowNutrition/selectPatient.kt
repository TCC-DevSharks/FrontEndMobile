package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun selectPatient() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(titulo = stringResource(id = R.string.select_patient))
        }
        Spacer(modifier = Modifier.height(20.dp))
        var date by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = date,
                    onValueChange = { date = it },
                    singleLine = false,
                    modifier = Modifier
                        .width(355.dp)
                        .clip(RoundedCornerShape(60.dp)),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(243, 243, 243, 500),
                        focusedIndicatorColor = Color(243, 243, 243),
                        unfocusedIndicatorColor = Color(243, 243, 243)
                    ),
                    label = {
                        Text(
                            text = stringResource(id = R.string.search_patient),
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                )
            }


            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = stringResource(id = R.string.all_),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )

            }
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Card(
                    modifier = Modifier
                        .width(340.dp)
                        .height(85.dp)
                        .padding(bottom = 14.dp),
                    colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
//                    border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

                    shape = RoundedCornerShape(16.dp),
                ) {
                    Row(
                        Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(id = R.drawable.avia),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(45.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.width(25.dp))

                        Column {
                            Text(
                                text = "ronaldinho",
                                color = Color.Black,
                                fontWeight = FontWeight.Black,
                                fontSize = 15.sp,
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .width(340.dp)
                        .height(85.dp)
                        .padding(bottom = 14.dp),
                    colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
//                    border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

                    shape = RoundedCornerShape(16.dp),
                ) {
                    Row(
                        Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(id = R.drawable.avia),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(45.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.width(25.dp))

                        Column {
                            Text(
                                text = "ronaldinho",
                                color = Color.Black,
                                fontWeight = FontWeight.Black,
                                fontSize = 15.sp,
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .width(340.dp)
                        .height(85.dp)
                        .padding(bottom = 14.dp),
                    colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
//                    border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

                    shape = RoundedCornerShape(16.dp),
                ) {
                    Row(
                        Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(id = R.drawable.avia),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(45.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.width(25.dp))

                        Column {
                            Text(
                                text = "ronaldinho",
                                color = Color.Black,
                                fontWeight = FontWeight.Black,
                                fontSize = 15.sp,
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .width(340.dp)
                        .height(85.dp)
                        .padding(bottom = 14.dp),
                    colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
//                    border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

                    shape = RoundedCornerShape(16.dp),
                ) {
                    Row(
                        Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(id = R.drawable.avia),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(45.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.width(25.dp))

                        Column {
                            Text(
                                text = "ronaldinho",
                                color = Color.Black,
                                fontWeight = FontWeight.Black,
                                fontSize = 15.sp,
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .width(340.dp)
                        .height(85.dp)
                        .padding(bottom = 14.dp),
                    colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
//                    border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

                    shape = RoundedCornerShape(16.dp),
                ) {
                    Row(
                        Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(id = R.drawable.avia),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(45.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.width(25.dp))

                        Column {
                            Text(
                                text = "ronaldinho",
                                color = Color.Black,
                                fontWeight = FontWeight.Black,
                                fontSize = 15.sp,
                            )
                        }
                    }
                }
            }

        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun selectPatientPreview() {
    selectPatient()
}