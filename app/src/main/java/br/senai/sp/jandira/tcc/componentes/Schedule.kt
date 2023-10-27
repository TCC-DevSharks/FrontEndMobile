package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.model.schedule.ModelSchedule
import br.senai.sp.jandira.tcc.model.schedule.Schedule
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun Schedule(agenda: List<Schedule>, navController: NavController, modelSchedule: ModelSchedule) {



    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Card(
            modifier = Modifier
                .width(360.dp)
                .height(184.dp),
            colors = CardDefaults.cardColors(Color.White),
            border = BorderStroke(2.dp, Color(182, 182, 246, 38))
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.calendar),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )

                    Column(
                        modifier = Modifier.padding(start = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = "Sua agenda",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.clickable {
                                modelSchedule.id = 0
                                modelSchedule.dia = ""
                                modelSchedule.titulo = ""
                                modelSchedule.descricao = ""
                                navController.navigate("Schedule")
                            }
                        )

                        Column(
                            modifier = Modifier
                                .width(90.dp)
                                .height(3.2.dp)
                                .background(
                                    Color(182, 182, 246),
                                    shape = RoundedCornerShape(
                                        topStart = 2.dp,
                                        topEnd = 2.dp,
                                        bottomStart = 2.dp,
                                        bottomEnd = 2.dp
                                    )
                                )
                        ) {}
                    }
                }
            }
            LazyColumn() {
                items(agenda) {
                    var isChecked by remember { mutableStateOf(false) }
                    var dataAtual = LocalDate.now()
                    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    val date = LocalDate.parse(it.dia, formatter)

                    if (dataAtual.isAfter(date))
                        isChecked = true

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 19.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {


                            Checkbox(
                                modifier = Modifier.height(30.dp),
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = Color(182, 182, 246),
                                    checkedColor = Color(182, 182, 246), // Cor quando marcado
                                    uncheckedColor = Color(182, 182, 246) // Cor quando não marcado
                                )
                            )

                           LimitedText(text = it.titulo , maxLength =25 ){
                               modelSchedule.id = it.id
                               modelSchedule.dia = it.dia
                               modelSchedule.titulo = it.titulo
                               modelSchedule.descricao = it.descricao
                               modelSchedule.IdGestante = it.id_gestante
                               navController.navigate("Schedule")
                           }

                        }

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "${it.dia.take(5)}",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )
                        }

                    }
                }
            }
        }

    }

}

@Composable
fun LimitedText(text: String, maxLength: Int, onclick: () -> Unit) {
    Text(text = if (text.length > maxLength) text.substring(0, maxLength) else text,
        fontSize = 15.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.clickable(onClick = onclick)
        )
}