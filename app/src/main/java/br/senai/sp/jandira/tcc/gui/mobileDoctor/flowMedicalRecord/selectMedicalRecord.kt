package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowMedicalRecord

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header

@Composable
fun selectMedicalRecord() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(titulo = stringResource(id = R.string.medical_record))
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = stringResource(id = R.string.select_one_patients),
                style = TextStyle(
                    fontSize = 17.sp,
                )
            )

        }

        Spacer(modifier = Modifier.height(35.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                    colors = CardDefaults.cardColors(Color(255,255,255)),
                    border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

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
                    colors = CardDefaults.cardColors(Color(255,255,255)),
                    border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

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
                    colors = CardDefaults.cardColors(Color(255,255,255)),
                    border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

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
                    colors = CardDefaults.cardColors(Color(255,255,255)),
                    border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

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
                    colors = CardDefaults.cardColors(Color(255,255,255)),
                    border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

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
fun selectMedicalRecordPreview() {
    selectMedicalRecord()
}