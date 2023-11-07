package br.senai.sp.jandira.tcc.gui.mobileDoctor.medicalRecord

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalRecord() {
    val currentDate = LocalDate.now()
    val lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth())

    val dates = mutableListOf<LocalDate>()

    var dateToAdd = currentDate

    while (dateToAdd <= lastDayOfMonth) {
        dates.add(dateToAdd)
        dateToAdd = dateToAdd.plusDays(1)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
//            Header(
//                titulo = stringResource(id = R.string.medical_record),
//                tintIcon = Color(255,218,185))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(.3.dp)
            ) {

            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.date),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
        ) {
            items(dates.size) { index ->
                val formattedDate = dates[index].format(DateTimeFormatter.ofPattern("dd/MM"))

                val dayOfWeek = dates[index].dayOfWeek

                val dayOfWeekName =
                    dayOfWeek.getDisplayName(TextStyle.SHORT, Locale("pt", "BR"))

                val isCurrentDate = dates[index] == currentDate // Verifica se é a data atual


                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(75.dp, 35.dp)
                        .background(
                            if (isCurrentDate) Color(255, 218, 185) else Color(229, 226, 224, 50),
                            shape = RoundedCornerShape(10.dp)
                        ),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = formattedDate,
                        color = if (isCurrentDate) Color.Black else Color.Black,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp
                    )

                }


            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.Specialty),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(5.dp))


        Row(Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(75.dp, 35.dp)
                    .background(
                        Color(229, 226, 224, 50),
                        shape = RoundedCornerShape(10.dp)
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {

                Text(
                    text = "Nutrição",
                    color = Color.Black,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp
                )

            }

            Spacer(modifier = Modifier.width(10.dp))

            Row(
                modifier = Modifier
                    .size(75.dp, 35.dp)
                    .background(
                        Color(229, 226, 224, 50),
                        shape = RoundedCornerShape(10.dp)
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {

                Text(
                    text = "Obstetrícia",
                    color = Color.Black,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp
                )

            }

            Spacer(modifier = Modifier.width(10.dp))


            Row(
                modifier = Modifier
                    .size(75.dp, 35.dp)
                    .background(
                        Color(255, 218, 185),
                        shape = RoundedCornerShape(10.dp)
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {

                Text(
                    text = "Clínico",
                    color = Color.Black,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp
                )

            }

            Spacer(modifier = Modifier.width(10.dp))


            Row(
                modifier = Modifier
                    .size(105.dp, 35.dp)
                    .background(
                        Color(229, 226, 224, 50),
                        shape = RoundedCornerShape(10.dp)
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {

                Text(
                    text = "Fisioterapia",
                    color = Color.Black,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp
                )

            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp)
        ) {
            Text(
                text = stringResource(id = R.string.description),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        var descricao by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = descricao,
                onValueChange = { descricao = it },
                singleLine = false, // Permitir várias linhas
                modifier = Modifier
                    .width(355.dp)
                    .height(300.dp)
                    .border(
                        width = 1.dp,
                        color = Color(255, 218, 185),
                        shape = RoundedCornerShape(0.dp) // Altere para 0.dp para obter um contorno quadrado
                    ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color(243, 243, 243),
                    unfocusedIndicatorColor = Color(243, 243, 243)
                )
            )

        }
//        Spacer(modifier = Modifier.height(10.dp))
//        Row(Modifier.fillMaxWidth().padding(horizontal = 26.dp, vertical = 15.dp), horizontalArrangement = Arrangement.End) {
//            IconAddItem(navController = navController, rota = "", size = 60.dp,
//                cor = Color(255, 218, 185))
//        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MedicalRecordPreview() {
    MedicalRecord()
}