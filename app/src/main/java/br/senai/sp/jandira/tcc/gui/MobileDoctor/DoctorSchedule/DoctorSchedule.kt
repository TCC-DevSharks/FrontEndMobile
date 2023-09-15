package br.senai.sp.jandira.tcc.gui.MobileDoctor.DoctorSchedule

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun DoctorSchedule() {
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
                img = R.drawable.arrow_circle_orange_24
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
                val monthName = dateRange[index].format(monthFormatter)

                val dayOfWeek = dateRange[index].dayOfWeek
                val dayOfWeekName = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale("pt", "BR"))

                val isCurrentDate = dateRange[index] == currentDate // Verifica se é a data atual

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(135.dp, 40.dp)
                        .background(Color(255, 218, 185), shape = RoundedCornerShape(50.dp)),

                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = monthName,
                        color = if (isCurrentDate) Color.Black else Color.Black,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp
                    )
                }
            }
        }
        Spacer(Modifier.height(40.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
                Card(
                    modifier = Modifier.size(width = 50.dp, height = 50.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(Color(255, 218, 185)),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                      Text(
                          text = "10",
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
                border = BorderStroke(width = 2.dp, Color(255, 218, 185))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "10h - Ana Melo",
                        modifier = Modifier.weight(1f).padding(end = 16.dp)
                    )

                    var isChecked by remember { mutableStateOf(false) }

                    Checkbox(
                        modifier = Modifier.height(30.dp),
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color(255, 218, 185),
                            checkedColor = Color(255, 218, 185), // Cor quando marcado
                            uncheckedColor = Color(255, 218, 185) // Cor quando não marcado
                        )
                    )
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier.size(width = 50.dp, height = 50.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(Color(255, 218, 185)),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "10",
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
                border = BorderStroke(width = 2.dp, Color(255, 218, 185))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "10h - Ana Melo",
                        modifier = Modifier.weight(1f).padding(end = 16.dp)
                    )

                    var isChecked by remember { mutableStateOf(false) }

                    Checkbox(
                        modifier = Modifier.height(30.dp),
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color(255, 218, 185),
                            checkedColor = Color(255, 218, 185), // Cor quando marcado
                            uncheckedColor = Color(255, 218, 185) // Cor quando não marcado
                        )
                    )
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier.size(width = 50.dp, height = 50.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(Color(255, 218, 185)),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "10",
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
                border = BorderStroke(width = 2.dp, Color(255, 218, 185))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "10h - Ana Melo",
                        modifier = Modifier.weight(1f).padding(end = 16.dp)
                    )

                    var isChecked by remember { mutableStateOf(false) }

                    Checkbox(
                        modifier = Modifier.height(30.dp),
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color(255, 218, 185),
                            checkedColor = Color(255, 218, 185), // Cor quando marcado
                            uncheckedColor = Color(255, 218, 185) // Cor quando não marcado
                        )
                    )
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier.size(width = 50.dp, height = 50.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(Color(255, 218, 185)),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "10",
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
                border = BorderStroke(width = 2.dp, Color(255, 218, 185))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "10h - Ana Melo",
                        modifier = Modifier.weight(1f).padding(end = 16.dp)
                    )

                    var isChecked by remember { mutableStateOf(false) }

                    Checkbox(
                        modifier = Modifier.height(30.dp),
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color(255, 218, 185),
                            checkedColor = Color(255, 218, 185), // Cor quando marcado
                            uncheckedColor = Color(255, 218, 185) // Cor quando não marcado
                        )
                    )
                }
            }
        }


        Spacer(Modifier.height(20.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier.size(width = 50.dp, height = 50.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(Color(255, 218, 185)),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "10",
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
                border = BorderStroke(width = 2.dp, Color(255, 218, 185))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "10h - Ana Melo",
                        modifier = Modifier.weight(1f).padding(end = 16.dp)
                    )

                    var isChecked by remember { mutableStateOf(false) }

                    Checkbox(
                        modifier = Modifier.height(30.dp),
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color(255, 218, 185),
                            checkedColor = Color(255, 218, 185), // Cor quando marcado
                            uncheckedColor = Color(255, 218, 185) // Cor quando não marcado
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DoctorSchedulePreview() {
    DoctorSchedule()
}