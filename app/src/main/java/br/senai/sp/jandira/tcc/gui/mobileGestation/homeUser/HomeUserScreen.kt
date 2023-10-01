package br.senai.sp.jandira.tcc.gui.mobileGestation.homeUser

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.GetEndereco
import br.senai.sp.jandira.tcc.calls.GetPregnant
import br.senai.sp.jandira.tcc.componentes.CardPreparations
import br.senai.sp.jandira.tcc.componentes.MarternalGuide
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.Schedule
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.endressPregnant.EndressPregnant
import br.senai.sp.jandira.tcc.model.endressPregnant.EndressPregnantList
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponse
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponseList
import br.senai.sp.jandira.tcc.model.schedule.Schedule
import br.senai.sp.jandira.tcc.model.schedule.ScheduleList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeUserScreen(navController: NavController, viewModel: ModelPregnant) {

    var agenda by remember {
        mutableStateOf(listOf<Schedule>())
    }
    val callSchedule = RetrofitFactory().getSchedule().getSchedule(viewModel.id)
    LaunchedEffect(Unit) {
        GetPregnant(viewModel)
        GetEndereco(viewModel)
        callSchedule.enqueue(object : retrofit2.Callback<ScheduleList> {
            override fun onResponse(
                call: Call<ScheduleList>,
                response: Response<ScheduleList>

            ) {
                agenda = response.body()!!.evento


            }


            override fun onFailure(call: Call<ScheduleList>, t: Throwable) {
                Log.i(
                    "ds2",
                    "onFailure: ${t.message}"
                )
                println(t.message + t.cause)
            }
        })
    }
    Scaffold(bottomBar = {Navigation(navController = navController)}) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(top = 70.dp, bottom = 105.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(modifier = Modifier.size(360.dp, 250.dp)) {


                        Box(
                            modifier = Modifier

                                .padding(top = 20.dp, end = 48.dp)
                                .align(Alignment.TopEnd)
                                .offset(y = (-68).dp)
                                .zIndex(1f)
                                .border(4.dp, Color(182, 182, 246), CircleShape),
                        ) {

                            AsyncImage(
                                model = viewModel.foto,
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape)
                                    .clickable {
                                        navController.navigate("profileUser")
                                    }
                            )
                        }

                        Card(
                            modifier = Modifier
                                .width(360.dp)
                                .height(250.dp),
                            colors = CardDefaults.cardColors(Color(182, 182, 246, 23)),
                            border = BorderStroke(2.dp, Color(182, 182, 246, 38))

                        ) {

                            if (viewModel.data_parto != "") {
                                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                                val dateString = viewModel.data_parto
                                val date = LocalDate.parse(dateString, formatter)
                                println(date)
                                val currentDate = LocalDate.now()

                                val period = ChronoUnit.DAYS.between(currentDate, date)

                                val dateBirth =
                                    LocalDate.parse(viewModel.data_nascimento, formatter)
                                val idade = ChronoUnit.YEARS.between(dateBirth, currentDate)

                                val weeks = period / 7
                                val days = period % 7

                                viewModel.semana_gestacao = 40 - weeks.toInt()
                                viewModel.idade = idade.toInt()
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 49.dp, start = 22.dp)
                                ) {

                                    Text(
                                        text = "Oi, " + viewModel.nome + "!",
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(182, 182, 246)
                                    )

                                }

                                Spacer(modifier = Modifier.height(6.dp))

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 22.dp)
                                ) {

                                    Text(
                                        text = "Como está se sentindo hoje?",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight(600),
                                        color = Color(182, 182, 246)
                                    )

                                }

                                Spacer(modifier = Modifier.height(31.dp))



                                if (viewModel.data_parto != "") {
                                    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                                    val dateString = viewModel.data_parto
                                    val date = LocalDate.parse(dateString, formatter)
                                    println(date)
                                    val currentDate = LocalDate.now()

                                    val period = ChronoUnit.DAYS.between(currentDate, date)

                                    val weeks = period / 7
                                    val days = period % 7

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 22.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {

                                        Text(
                                            textAlign = TextAlign.Center,
                                            text = "${weeks} semanas e ${days} dias ",
                                            fontSize = 21.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color(182, 182, 246)
                                        )

                                    }
                                    Spacer(modifier = Modifier.height(10.dp))

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 24.dp)
                                            .background(Color.White)
                                    ) {

                                        var size = (320 / 40) * (40 - weeks)
                                        Row(
                                            modifier = Modifier
//                            .fillMaxWidth()
                                                .height(3.2.dp)
                                                .width(size.toInt().dp)
                                                .background(Color(182, 182, 246)),
                                        ) {
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(8.dp))


                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 24.dp),
                                    horizontalArrangement = Arrangement.End
                                ) {

                                    Text(
                                        text = "${viewModel.data_parto}",
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color(182, 182, 246)
                                    )
                                }
                            }
                        }


                    }
                }
                Spacer(modifier = Modifier.height(50.dp))

                Schedule(agenda)

                Spacer(modifier = Modifier.height(50.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 26.dp)
                ) {

                    Text(
                        text = "Espaço Gravidez e Conversa",
                        fontSize = 15.7.sp,
                        fontWeight = FontWeight(300),
                    )
                }

                Spacer(modifier = Modifier.height(13.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Button(
                        modifier = Modifier.size(360.dp, 50.dp),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color(182, 182, 246, 23)),
                        border = BorderStroke(.3.dp, Color(182, 182, 246)),
                        shape = RoundedCornerShape(16.dp)

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.comments),
                                contentDescription = null,
                                modifier = Modifier.size(26.dp)
                            )

                            Text(
                                modifier = Modifier.padding(start = 15.dp),
                                text = "Fórum",
                                fontSize = 16.sp,
                                color = Color(182, 182, 246),
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(50.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 26.dp)
                ) {

                    Text(
                        text = "Guia Materno",
                        fontSize = 15.7.sp,
                        fontWeight = FontWeight(300),
                    )
                }

                Spacer(modifier = Modifier.height(13.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 26.dp),
                    horizontalArrangement = Arrangement.Center
                ) {





                    MarternalGuide()

                    MarternalGuide()
                    //
                }

                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 26.dp)
                ) {

                    Text(
                        text = "Preparativos",
                        fontSize = 15.7.sp,
                        fontWeight = FontWeight(300),
                    )
                }

                Spacer(modifier = Modifier.height(13.dp))



                    LazyRow(modifier = Modifier.padding(horizontal = 28.dp)) {

                        items(listOf("Plano de Parto", "Enxoval", "Mala de Maternidade", "Sugestão de Nomes")) { category ->


                            CardPreparations(category, navController)




                        }
                    }






            }

//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(Alignment.BottomCenter)
//                    .border(
//                        .9.dp,
//                        Color(182, 182, 246),
//                        shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
//                    )
//            ) {
//
//
//
//
//            }

        }
    }

}


