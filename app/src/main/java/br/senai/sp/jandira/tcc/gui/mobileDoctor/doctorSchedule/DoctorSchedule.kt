package br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorSchedule

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.consult.ConsultList
import br.senai.sp.jandira.tcc.model.consult.ConsultResponsePaciente
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun DoctorSchedule(professional: Professional, navController: NavController) {

    var selectedMonth by rememberSaveable {
        mutableStateOf(LocalDate.now().monthValue)
    }

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
            Header(
                titulo = stringResource(id = R.string.schedule),
                rota = "DoctorHome",
                navController = navController
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(.3.dp)
            ) {

            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.medical_month),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Obtém o último mês do ano atual
        val lastMonthOfYear = YearMonth.now().plusMonths(11)

// Cria uma lista de datas do mês atual até o último mês do ano
        val dateRange = generateSequence(YearMonth.now()) { it.plusMonths(1) }
            .takeWhile { it <= lastMonthOfYear }
            .map { it.atDay(1) } // Primeiro dia de cada mês
            .toList()





        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
        ) {
            items(dateRange.size) { index ->

                val monthFormatter = DateTimeFormatter.ofPattern("MMMM", Locale("pt", "BR"))
                val monthName = dateRange[index].format(monthFormatter).capitalize()


                Log.i("fdfsdf", "${dateRange[index]}")

                Button(
                    modifier = Modifier
                        .size(135.dp, 40.dp)
                        .padding(start = 4.5.dp),
                    colors = if (dateRange[index].monthValue == selectedMonth) ButtonDefaults.buttonColors(
                        Color(182, 182, 246)
                    ) else ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(20.dp),
                    border = if (dateRange[index].monthValue == selectedMonth) BorderStroke(
                        2.dp,
                        Color.Transparent
                    ) else BorderStroke(2.1.dp, Color(182, 182, 246)),
                    onClick = {
                        selectedMonth =
                            dateRange[index].monthValue // Atualiza o mês selecionado quando o botão é clicado
                    }
                ) {
                    Text(
                        text = monthName,
                        color = if (dateRange[index].monthValue == selectedMonth) Color.White else Color(
                            182,
                            182,
                            246
                        ),
                        fontWeight = FontWeight(900),
                        fontSize = 14.sp
                    )
                }
            }
        }

        Spacer(Modifier.height(40.dp))

        var pacientes by rememberSaveable {
            mutableStateOf(listOf<ConsultResponsePaciente>())
        }

        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        val dataAtual = LocalDate.now()

        LaunchedEffect(Unit) {
            val call = RetrofitFactory().consult().getConsult(professional.id)

            call.enqueue(object : Callback<ConsultList> {
                override fun onResponse(
                    call: Call<ConsultList>,
                    response: Response<ConsultList>
                ) {
                    pacientes = response.body()!!.pacientes
                    println(pacientes)

                }

                override fun onFailure(call: Call<ConsultList>, t: Throwable) {
                    Log.i("hgf", "${pacientes}")
                }
            })
        }

        fun filterConsultsByCurrentMonth(consults: List<ConsultResponsePaciente>): List<ConsultResponsePaciente> {
            val currentMonth = LocalDate.now().monthValue
            return consults.filter { LocalDate.parse(it.dia, formatter).monthValue == selectedMonth }
        }

        val filteredPacientes = filterConsultsByCurrentMonth(pacientes)


        LazyColumn() {
            items(filteredPacientes) { paciente ->


                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Card(
                        modifier = Modifier.size(width = 50.dp, height = 50.dp),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(Color(182, 182, 246)),
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = paciente.dia.take(2),
                                color = Color.White
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(width = 315.dp, height = 50.dp)
                            .padding(horizontal = 4.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(width = 2.dp, Color(182, 182, 246))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${paciente.hora.take(5)}h - ${paciente.nome}",
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 16.dp)
                            )

//                            var isChecked by remember { mutableStateOf(false) }
//
//                            val dataConsulta = LocalDate.parse(paciente.dia, formatter)
//
//                            if (dataAtual != dataConsulta) {
//                                isChecked = true
//                            }
//
//                            Checkbox(
//                                modifier = Modifier.height(30.dp),
//                                checked = isChecked,
//                                onCheckedChange = { isChecked = it },
//                                colors = CheckboxDefaults.colors(
//                                    checkmarkColor = Color(182,182,246),
//                                    checkedColor = Color(182,182,246), // Cor quando marcado
//                                    uncheckedColor = Color(182,182,246) // Cor quando não marcado
//                                )
//                            )
                        }
                    }
                }


            }
        }

    }
}