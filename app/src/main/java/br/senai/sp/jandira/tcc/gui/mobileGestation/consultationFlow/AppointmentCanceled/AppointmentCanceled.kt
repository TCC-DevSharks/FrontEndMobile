package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.AppointmentCanceled

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.doctor.DataHora

@Composable
fun AppointmentCanceled(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())

        ) {

            Column(modifier = Modifier.fillMaxWidth()) {
                Header(titulo = stringResource(id = R.string.consultation_title))
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp),
                    text = "Por favor, revise os detalhes abaixo:",
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.SansSerif
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column(modifier = Modifier.padding(horizontal = 30.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(width = 0.5.dp, color = Color(229, 229, 229))
                ) {
                    Row(
                        modifier = Modifier.border(
                            .5.dp, color = Color(229, 229, 229), shape = RoundedCornerShape(
                                bottomStart = 15.dp, bottomEnd = 15.dp
                            )
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.consulta_icon),
                                contentDescription = null,
                                tint = Color(187, 187, 249),
                                modifier = Modifier.size(35.dp)
                            )
                            Text(
                                text = "Consulta com nutricionista"
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                    ) {
                        Row() {
                            Text(
                                text = stringResource(id = R.string.client),
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(1.dp))
                        Row() {
                            Text(
                                text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row() {
                            Text(
                                text = stringResource(id = R.string.Email),
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(1.dp))
                        Row() {
                            Text(
                                text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Row() {
                                    Text(
                                        text = stringResource(id = R.string.cpf),
                                        fontWeight = FontWeight.Light,
                                        fontSize = 12.sp
                                    )
                                }
                                Spacer(modifier = Modifier.height(1.dp))
                                Row() {
                                    Text(
                                        text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                                    )
                                }
                            }


                            Column {
                                Row() {
                                    Text(
                                        text = stringResource(id = R.string.phone),
                                        fontWeight = FontWeight.Light,
                                        fontSize = 12.sp
                                    )
                                }
                                Spacer(modifier = Modifier.height(1.dp))
                                Row() {
                                    Text(
                                        text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row() {
                            Text(
                                text = stringResource(id = R.string.address),
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(1.dp))
                        Row() {
                            Text(
                                text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Row() {
                                    Text(
                                        text = stringResource(id = R.string.card),
                                        fontWeight = FontWeight.Light,
                                        fontSize = 12.sp
                                    )
                                }
                                Spacer(modifier = Modifier.height(1.dp))
                                Row() {
                                    Text(
                                        text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                                    )
                                }
                            }


                            Column {
                                Row() {
                                    Text(
                                        text = stringResource(id = R.string.expiration),
                                        fontWeight = FontWeight.Light,
                                        fontSize = 12.sp
                                    )
                                }
                                Spacer(modifier = Modifier.height(1.dp))
                                Row() {
                                    Text(
                                        text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row() {
                            Text(
                                text = stringResource(id = R.string.clinic),
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(1.dp))
                        Row() {
                            Text(
                                text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row() {
                            Text(
                                text = stringResource(id = R.string.address),
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(1.dp))
                        Row() {
                            Text(
                                text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                            )
                        }


                        Spacer(modifier = Modifier.height(10.dp))


                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Row() {
                                    Text(
                                        text = stringResource(id = R.string.professional),
                                        fontWeight = FontWeight.Light,
                                        fontSize = 12.sp
                                    )
                                }
                                Spacer(modifier = Modifier.height(1.dp))
                                Row() {
                                    Text(
                                        text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                                    )
                                }
                            }


                            Column {
                                Row() {
                                    Text(
                                        text = stringResource(id = R.string.specialization),
                                        fontWeight = FontWeight.Light,
                                        fontSize = 12.sp
                                    )
                                }
                                Spacer(modifier = Modifier.height(1.dp))
                                Row() {
                                    Text(
                                        text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row() {
                            Text(
                                text = stringResource(id = R.string.phone_clinic),
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(1.dp))
                        Row() {
                            Text(
                                text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row() {
                            Text(
                                text = stringResource(id = R.string.Charge),
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(1.dp))
                        Row() {
                            Text(
                                text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))


                        Row() {
                            Text(
                                text = stringResource(id = R.string.date),
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(1.dp))
                        Row() {
                            Text(
                                text = DataHora.selectedDate,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row() {
                            Text(
                                text = stringResource(id = R.string.hour),
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(1.dp))
                        Row() {
                            Text(
                                text = DataHora.selectedTime,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row() {
                            Text(
                                text = stringResource(id = R.string.value),
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(1.dp))
                        Row() {
                            Text(
                                text = "", fontWeight = FontWeight.Bold, fontSize = 15.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(70.dp))
                    }
                }
            }
        }
        var isCardVisible by remember { mutableStateOf(false) }
        var isCard2Visible by remember { mutableStateOf(false) }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        ) {
            ButtonPurple(navController = navController, texto = "Cancelar", rota = "", onclick = {
                isCardVisible = true
            })
        }




        if (isCardVisible) {
            // Aplicar um efeito de fundo desfocado usando Modifier.background
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .then(
                        Modifier
                            .background(MaterialTheme.colorScheme.background)
                            .background(color = Color.Black.copy(alpha = 0.5f))
                    )
                    .align(Alignment.Center) // Centralizar a Box
            ) {
                Card(
                    modifier = Modifier
                        .width(290.dp)
                        .height(290.dp)
                        .align(Alignment.Center), // Centralizar o Card
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Deseja cancelar a consulta?",
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        )
                        Spacer(modifier = Modifier.height(30.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cancelar),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .clickable {
                                        isCardVisible = false
                                        navController.popBackStack()
                                    }
                            )

                            Image(
                                painter = painterResource(id = R.drawable.correct),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .clickable {
                                        isCard2Visible = true
                                    }
                            )


                        }
                    }
                }
            }
            if (isCard2Visible) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .then(
                            Modifier
                                .background(MaterialTheme.colorScheme.background)
                                .background(color = Color.Black.copy(alpha = 0.5f))
                        )
                        .align(Alignment.Center) // Centralizar a Box
                ) {
                    Card(
                        modifier = Modifier
                            .width(290.dp)
                            .height(290.dp)
                            .align(Alignment.Center), // Centralizar o Card
                        colors = CardDefaults.cardColors(Color.White)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.correct),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(65.dp)
                            )
                            Spacer(modifier = Modifier.height(30.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {


                                Text(
                                    text = "Sua consulta foi cancelada.",
                                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                )
                            }
                            Spacer(modifier = Modifier.height(25.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {

                                Button(
                                    onClick = {
//                                        isCard2Visible = false
//                                        isCardVisible = false
                                    },
                                    modifier = Modifier
                                        .width(327.dp)
                                        .height(48.dp),
                                    colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),
                                    shape = RoundedCornerShape(16.dp),
                                ) {
                                    Text(
                                        text = "Voltar",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
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


