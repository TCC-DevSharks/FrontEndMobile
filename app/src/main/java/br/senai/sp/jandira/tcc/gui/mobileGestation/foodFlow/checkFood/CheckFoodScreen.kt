package br.senai.sp.jandira.tcc.gui.mobileGestation.foodFlow.checkFood

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.diet.DietResponse
import br.senai.sp.jandira.tcc.model.diet.DietResponseList
import br.senai.sp.jandira.tcc.model.food.ModelFood
import br.senai.sp.jandira.tcc.model.meal.MealResponse
import br.senai.sp.jandira.tcc.model.meal.MealResponseList
import br.senai.sp.jandira.tcc.model.schedule.ScheduleList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CheckFoodScreen(navController: NavController, pregnant: ModelPregnant, food: ModelFood) {

    var diet by remember { mutableStateOf(listOf<DietResponse>()) }

    LaunchedEffect(Unit) {
        val call = RetrofitFactory().findDiet().getDiet(pregnant.id)

        call.enqueue(object : retrofit2.Callback<DietResponseList> {
            override fun onResponse(
                call: Call<DietResponseList>,
                response: Response<DietResponseList>

            ) {

                diet = response.body()!!.dieta
            }


            override fun onFailure(call: Call<DietResponseList>, t: Throwable) {
                Log.i(
                    "ds2",
                    "onFailure: ${t.message}"
                )
                println(t.message + t.cause)
            }
        })
    }

    Box(modifier = Modifier.fillMaxSize()) {

        val currentDate = LocalDate.now()
        val lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth())

        val dates = mutableListOf<LocalDate>()

        var dateToAdd = currentDate

        while (dateToAdd <= lastDayOfMonth) {
            dates.add(dateToAdd)
            dateToAdd = dateToAdd.plusDays(1)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp)
        ) {

            Header(titulo = stringResource(id = R.string.header_food))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(.3.dp)
            ) {}

            Spacer(modifier = Modifier.height(40.dp))


            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                items(dates.size) { index ->
                    val formattedDate = dates[index].format(DateTimeFormatter.ofPattern("dd"))

                    val dayOfWeek = dates[index].dayOfWeek

                    val dayOfWeekName =
                        dayOfWeek.getDisplayName(TextStyle.SHORT, Locale("pt", "BR"))

                    val isCurrentDate = dates[index] == currentDate // Verifica se é a data atual


                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(50.dp, 70.dp)
                            .background(
                                if (isCurrentDate) Color(182, 182, 246) else Color(227, 228, 228),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = dayOfWeekName,
                            color = if (isCurrentDate) Color.White else Color.Black,
                            fontWeight = FontWeight(500),
                            fontSize = 15.sp
                        )

                        Text(
                            text = formattedDate,
                            color = if (isCurrentDate) Color.White else Color.Black,
                            fontWeight = FontWeight(500),
                            fontSize = 15.sp
                        )

                    }


                }
            }

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(diet) {

                    var visible by remember { mutableStateOf(false) }

                    Card(
                        modifier = Modifier
                            .padding(horizontal = 15.dp, vertical = 10.dp)
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(0.dp),
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        Row(modifier = Modifier
                            .fillMaxSize()
                            .clickable { visible = !visible }
                            .padding(horizontal = 15.dp, vertical = 15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = it.refeicao,
                                color = Color(182, 182, 246),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold
                            )

                            Text(text = it.horario)
                        }

                        var meal by remember { mutableStateOf(listOf<MealResponse>()) }

                        val call = RetrofitFactory().findMeal().getMeal(it.idRefeicao)

                        call.enqueue(object : retrofit2.Callback<MealResponseList> {
                            override fun onResponse(
                                call: Call<MealResponseList>,
                                response: Response<MealResponseList>

                            ) {
                                meal = response.body()!!.alimentos
                            }


                            override fun onFailure(call: Call<MealResponseList>, t: Throwable) {
                                Log.i(
                                    "ds2",
                                    "onFailure: ${t.message}"
                                )
                                println(t.message + t.cause)
                            }
                        })

                        AnimatedVisibility(
                            visible = visible,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(bottom = 10.dp),
                            enter = fadeIn(
                                initialAlpha = 0.8f
                            ),
                            exit = fadeOut(
                                animationSpec = tween(durationMillis = 50)
                            )
                        ) {
                         Column(modifier = Modifier.fillMaxSize()) {
                             for (it in meal){
                                 Row(
                                     verticalAlignment = Alignment.CenterVertically,
                                     modifier = Modifier
                                         .fillMaxWidth()
                                         .padding(horizontal = 15.dp),
                                     horizontalArrangement = Arrangement.SpaceBetween
                                 ) {

                                     Row(
                                         verticalAlignment = Alignment.CenterVertically
                                     ) {
                                         Card(
                                             modifier = Modifier
                                                 .size(60.dp),
                                             shape = RoundedCornerShape(12.dp),
                                         ) {

                                             Image(
                                                 painter = painterResource(id = R.drawable.bg),
                                                 contentDescription = null,
                                                 contentScale = ContentScale.Crop,
                                                 modifier = Modifier.fillMaxSize()
                                             )
                                         }

                                         Spacer(modifier = Modifier.width(16.dp))

                                         Column {
                                             Text(
                                                 text = it.nome,
                                                 fontSize = 14.sp,
                                                 fontWeight = FontWeight(800),
                                             )

                                             Spacer(modifier = Modifier.height(5.dp))

                                             Text(
                                                 text = it.peso + "gm",
                                                 fontSize = 14.sp,
                                                 fontWeight = FontWeight(800),
                                             )
                                         }

                                     }

                                     Image(
                                         painter = painterResource(id = R.drawable.icon_arrow),
                                         contentDescription = null,
                                         modifier = Modifier
                                             .size(35.dp)
                                             .clickable {
                                                 food.id = it.idCategoria
                                                 navController.navigate("FoodChange")
                                             }
                                     )
                                 }

                                 Spacer(modifier = Modifier.height(5.dp))
                             }
                         }
                        }
                    }
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

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun CheckFoodScreenPreview() {
//    CheckFoodScreen()
//}