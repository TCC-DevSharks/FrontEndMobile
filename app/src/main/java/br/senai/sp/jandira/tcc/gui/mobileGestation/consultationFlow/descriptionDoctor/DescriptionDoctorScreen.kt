package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.descriptionDoctor

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.doctor.DataHora
import br.senai.sp.jandira.tcc.model.professional.Professional
import coil.compose.AsyncImage
import java.lang.Math.ceil
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun DescriptionDoctorScreen(
    navController: NavController, professional: Professional,
) {

    val context = LocalContext.current


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
                    .padding(start = 26.dp, top = 35.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ArrowLeft(navController = navController, rota = "")

            }

            Spacer(modifier = Modifier.height(18.dp))


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
                        AsyncImage(
                            model = professional.foto,
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(105.dp)
                                .clip(CircleShape)
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
                                text = professional.nome,
                                fontSize = 23.sp,
                                fontWeight = FontWeight(900),

                                )

                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Row() {

                            Text(
                                text = professional.especialidade,
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
<<<<<<< HEAD
                        text = stringResource(id = R.string.description),
=======
                        text = "Sobre",
>>>>>>> b8f2cb924fc89590cbdda1d42bd89a809f9124ae
                        fontSize = 17.sp,
                        fontWeight = FontWeight(900),
                    )

                }

                Row(modifier = Modifier.padding(top = 5.dp, bottom = 12.dp)) {

                    Text(
                        text = professional.descricao,
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
<<<<<<< HEAD
                    text = stringResource(id = R.string.Service_charge),
=======
                    text = "Valor:",
>>>>>>> b8f2cb924fc89590cbdda1d42bd89a809f9124ae
                    fontSize = 16.sp,
                    fontWeight = FontWeight(900),
                )

                Text(
                    text = "R$: 200,00",
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
                    text = stringResource(id = R.string.Select_a_date),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(900),
                )
            }

            Spacer(modifier = Modifier.height(10.dp))


            var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

            var selectedTime by remember { mutableStateOf<LocalTime?>(null) }


            val currentDate = LocalDate.now().plusMonths(1)
            val lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth())

            val dates = mutableListOf<LocalDate>()

            var dateToAdd = LocalDate.now()

            while (dateToAdd <= lastDayOfMonth) {
                dates.add(dateToAdd)
                dateToAdd = dateToAdd.plusDays(1)
            }

            LazyColumn(modifier = Modifier.padding(start = 28.dp, end = 28.dp, bottom = 30.dp)) {
                item {
                    LazyRow() {
                        items(dates.size) { index ->
                            val date = dates[index]

                            val isSelectedDate = date == selectedDate


                            Button(
                                onClick = {


                                    var newData =
                                        date.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"))

                                    Log.i("Click", "DescriptionDoctorScreen: ${newData}")
                                    DataHora.selectedDate = newData.toString()

                                    // Se a data já estiver selecionada, deseleciona
                                    if (selectedDate == date) {
                                        selectedDate = null
                                    } else {
                                        selectedDate = date
                                    }
                                },
                                modifier = Modifier
                                    .size(92.dp, 43.dp)
                                    .padding(start = 4.5.dp),
                                colors = if (isSelectedDate) ButtonDefaults.buttonColors(
                                    Color(243, 243, 243)
                                ) else ButtonDefaults.buttonColors(Color(182, 182, 246)),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(
                                    text = date.format(DateTimeFormatter.ofPattern("dd/MM")),
                                    fontSize = 13.5.sp,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(900),
                                    color = if (isSelectedDate)
                                        Color.Black
                                    else Color.White

                                )
                            }
                        }
                    }
                }

                if (selectedDate != null) {
                    item {
                        Spacer(modifier = Modifier.height(30.dp))

                        val startTime = LocalTime.of(10, 0) // Horário inicial
                        val endTime = LocalTime.of(18, 0) // Horário final
                        val interval = Duration.ofMinutes(30) // Intervalo de 30 minutos

                        // Lista de horários
                        val times = mutableListOf<LocalTime>()
                        var currentTime = startTime

                        while (currentTime <= endTime) {
                            times.add(currentTime)
                            currentTime = currentTime.plus(interval)
                        }

                        val columnCount = 3
                        val wordsPerColumn = ceil(times.size / columnCount.toDouble()).toInt()

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            for (i in 0 until columnCount) {
                                Column(
                                    modifier = Modifier
                                        .height(140.dp)
                                        .verticalScroll(rememberScrollState()),
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {
                                    for (j in 0 until wordsPerColumn) {
                                        val index = i * wordsPerColumn + j
                                        if (index < times.size) {

                                            val time = times[index]
                                            val isSelected = time == selectedTime
                                            Text(
                                                text = "${times[index]}",
                                                modifier = Modifier.clickable {
                                                    selectedTime = time
                                                    DataHora.selectedTime = time.toString()
                                                },
                                                color = if (isSelected) Color(182, 182, 246)
                                                else Color(0, 0, 0)
                                            )
                                        }
                                    }
                                }
                            }
                        }
//                        LazyColumn() {
//                            items(times.size) { index ->
//                                val time = times[index]
//
//                                val isSelected = time == selectedTime
//
//
//                                Button(
//                                    onClick = {
//                                        selectedTime = time
//                                        DataHora.selectedTime = time.toString()
//
//                                    },
//                                    modifier = Modifier
//                                        .size(92.dp, 43.dp)
//                                        .padding(start = 4.5.dp),
//                                    colors = if (isSelected) ButtonDefaults.buttonColors(
//                                        Color(243, 243, 243)
//                                    ) else ButtonDefaults.buttonColors(Color(182,182,246)),
//                                    shape = RoundedCornerShape(10.dp)
//                                ) {
//                                    Text(
//                                        text = time.format(DateTimeFormatter.ofPattern("HH:mm")),
//                                        color = if (isSelected)
//                                            Color.Black
//                                        else Color.White,
//                                        fontSize = 13.5.sp,
//                                        textAlign = TextAlign.Center,
//                                        fontWeight = FontWeight(900)
//                                    )
//
//                                }
//                            }
//                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick =
                    {


                        if (selectedDate != null && selectedTime != null) {
                            navController.navigate("Payment")

//                            // Criar um Toast personalizado com um layout personalizado
//                            val backgroundColor = Color.Gray
//                            val contentColor = Color.White
//
//                            val toast = Toast(context)
//                            toast.setGravity(Gravity.CENTER, 0, 20)
//                            toast.duration = Toast.LENGTH_SHORT
//
//                            val textView = TextView(context).apply {
//                                text = "Consulta marcada com sucesso"
//                                textSize = 18f // Tamanho da fonte aumentado
//                                setBackgroundColor(backgroundColor.toArgb()) // Converter a cor para ARGB
//                                setTextColor(contentColor.toArgb()) // Converter a cor para ARGB
//                                setPadding(
//                                    36,
//                                    36,
//                                    36,
//                                    36
//                                ) // Valores inteiros em pixels para padding
//                            }
//
//                            toast.view = textView
//                            toast.show()

                        } else {

                            // Criar um Toast personalizado com um layout personalizado
                            val backgroundColor = Color.Gray
                            val contentColor = Color.White

                            val toast = Toast(context)
                            toast.setGravity(Gravity.CENTER, 0, 20)
                            toast.duration = Toast.LENGTH_SHORT

                            val textView = TextView(context).apply {
                                text = "Por favor, selecione data e hora"
                                textSize = 18f // Tamanho da fonte aumentado
                                setBackgroundColor(backgroundColor.toArgb()) // Converter a cor para ARGB
                                setTextColor(contentColor.toArgb()) // Converter a cor para ARGB
                                setPadding(
                                    36,
                                    36,
                                    36,
                                    36
                                ) // Valores inteiros em pixels para padding
                            }

                            toast.view = textView
                            toast.show()
                        }
                    },
                    modifier = Modifier
                        .width(320.dp)
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),

                    shape = RoundedCornerShape(16.dp),

                    ) {
                    Text(
                        text = stringResource(id = R.string.pag),
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
//                    .align(Alignment.BottomCenter)
                .border(
                    .9.dp,
                    Color(182, 182, 246),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
        ) {
//            Navigation(navController = navController)
        }
    }

}


//@Preview
//@Composable
//fun ConsultationDescriptionDoctorScreenPreview() {
//    ConsultationDescriptionDoctorScreen()
//}