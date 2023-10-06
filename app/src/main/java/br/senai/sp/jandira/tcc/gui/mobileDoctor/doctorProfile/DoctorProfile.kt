package br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorProfile

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header

@Composable
fun DoctorProfile() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(
                titulo = stringResource(id = R.string.profile),
                tintIcon = Color(255, 218, 185)
            )

        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box() {
                Card(
                    modifier = Modifier.size(100.dp),
                    shape = CircleShape,
                    border = BorderStroke(3.5.dp, Color(255, 218, 185))

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avia),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Column {
                Text(
                    text = "Masi Ramezanzade",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Lose a Fat Program",
                    fontWeight = FontWeight.Normal

                )
            }

            Card(
                modifier = Modifier.size(width = 100.dp, height = 30.dp),
                colors = CardDefaults.cardColors(Color(255, 218, 185)),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(0.dp, Color.Transparent)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.edit),
                        color = Color.White
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(width = 350.dp, height = 190.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 15.dp),
                        text = stringResource(id = R.string.Account_user),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_outline_24),
                            contentDescription = null,
                            tint = Color(242, 187, 137)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.data)
                        )

                    }

                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null
                        )

                    }


                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(
                                id = R.drawable.baseline_library_books_24
                            ),
                            contentDescription = null,
                            tint = Color(242, 187, 137)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.Achievement)
                        )

                    }
                    Row {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null,
                            tint = Color.Gray

                        )

                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(
                                id = R.drawable.graph
                            ),
                            contentDescription = null,
                            tint = Color(242, 187, 137)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.Activity_History)
                        )

                    }
                    Row {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null,
                            tint = Color.Gray

                        )

                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(
                                id = R.drawable.baseline_insert_chart_24
                            ),
                            contentDescription = null,
                            tint = Color(242, 187, 137)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.Workout_Progress)
                        )

                    }
                    Row {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null,
                            tint = Color.Gray

                        )

                    }
                }


            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(width = 350.dp, height = 90.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 15.dp),
                        text = stringResource(id = R.string.notification),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.bell),
                            contentDescription = null,
                            tint = Color(242, 187, 137)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.notification_pop)
                        )

                    }

                    var switchCheckedState by remember { mutableStateOf(false) }

                    Switch(
                        modifier = Modifier.padding(bottom = 20.dp),
                        checked = switchCheckedState,
                        onCheckedChange = {
                            switchCheckedState = it

                            if (it) {
                                // Código para quando o Switch estiver ligado
                            } else {
                                // Código para quando o Switch estiver desligado
                            }
                        },

                        colors = SwitchDefaults.colors(
                            checkedThumbColor = if (switchCheckedState)
                                Color.White else Color(242, 187, 137),
                            checkedTrackColor = Color(242, 187, 137),
                            checkedBorderColor = Color(242, 187, 137),
                            uncheckedThumbColor = Color(217, 217, 217),
                            uncheckedTrackColor = Color.White,
                            disabledCheckedBorderColor = Color(255, 255, 255)
                        )

                    )


                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(width = 350.dp, height = 140.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 15.dp),
                        text = stringResource(id = R.string.others),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.letter),
                            contentDescription = null,
                            tint = Color(242, 187, 137)

                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.contact)
                        )

                    }


                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null
                        )

                    }


                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.verification),
                            contentDescription = null,
                            tint = Color(242, 187, 137)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.politic)
                        )

                    }

                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null
                        )

                    }

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_settings_24),
                            contentDescription = null,
                            tint = Color(242, 187, 137)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.Settings)
                        )

                    }

                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null
                        )

                    }

                }


            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DoctorProfilePreview() {
    DoctorProfile()
}