package br.senai.sp.jandira.tcc.gui.Consultation.DescriptionDoctor

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeftPurple
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.TextTitle
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters

@Composable
fun ConsultationDescriptionDoctorScreen(navController: NavController) {

    val currentDate = LocalDate.now()
    val lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth())

    val dates = mutableListOf<LocalDate>()

    var dateToAdd = currentDate

    while (dateToAdd <= lastDayOfMonth) {
        dates.add(dateToAdd)
        dateToAdd = dateToAdd.plusDays(1)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp)
        ) {



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 21.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ArrowLeftPurple(navController = navController, rota = "")

            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Color(243, 243, 243))
                    .padding(20.dp)
            ) {

                Row(
                    modifier = Modifier.padding(start = 20.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .size(105.dp),
                        shape = CircleShape,

                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.avia),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )


                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 22.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Row() {

                            Text(
                                text = "Dr Rebbeka",
                                fontSize = 23.sp,
                                fontWeight = FontWeight(900),

                                )

                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Row() {

                            Text(
                                text = "Reproductive Psychiatry &\n" +
                                        "Psychiatryfgdfgdfgdfgdfgdfgfdgdfgdfgdfgfdgdfgdfgdfgdfgdfgdfgfgdf",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight(200),
                                lineHeight = 18.sp
                            )

                        }

                    }

                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier.padding(horizontal = 28.dp, vertical = 16.dp),
            ) {

                Row() {

                    Text(
                        text = "About",
                        fontSize = 17.sp,
                        fontWeight = FontWeight(900),
                    )

                }

                Row(modifier = Modifier.padding(top = 5.dp, bottom = 12.dp)) {

                    Text(
                        text = "Dr. Rebbeka is a Clinical Professor of Psychiatry, Obstetrics, Gynecology, and Reproductive Science at the Icahn School of Medicine at Mount Sinai which she first joined in 2007. She is an Attending in Psychiatry at Mount Sinai Medical Center. She also maintains a private practice in New York City.",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight(300),
                        lineHeight = 18.sp
                    )

                }
            }

            Row(
                modifier = Modifier.padding(horizontal = 28.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier.padding(end = 10.dp),
                    text = "Service charge:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(900),
                )

                Text(
                    text = "\$49.00/hours ",
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                )

            }

            Spacer(modifier = Modifier.height(35.dp))

            Row(
                modifier = Modifier.padding(horizontal = 28.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier.padding(end = 10.dp),
                    text = "Selecione uma data:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(900),
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            LazyRow(modifier = Modifier.padding(horizontal = 28.dp)) {
                items(dates.size) { index ->
                    val formattedDate = dates[index].format(DateTimeFormatter.ofPattern("dd/MM"))

                    Button(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .size(92.dp, 43.dp)
                            .padding(start = 4.5.dp),
                        colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = formattedDate,
                            fontSize = 13.5.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight(900)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(100.dp))


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick =
                    {
//                        onclick(navController)
                    },
                    modifier = Modifier
                        .width(320.dp)
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),

                    shape = RoundedCornerShape(16.dp),

                    ) {
                    Text(
                        text = stringResource(R.string.button_finish),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
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

//@Preview
//@Composable
//fun ConsultationDescriptionDoctorScreenPreview() {
//    ConsultationDescriptionDoctorScreen()
//}