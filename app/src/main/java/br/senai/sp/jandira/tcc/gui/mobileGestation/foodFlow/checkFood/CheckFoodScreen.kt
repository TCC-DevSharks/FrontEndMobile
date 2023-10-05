package br.senai.sp.jandira.tcc.gui.mobileGestation.foodFlow.checkFood

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CheckFoodScreen(navController: NavController) {

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
                            .size(70.dp, 90.dp)
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





            Spacer(modifier = Modifier.height(28.dp))

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .padding(bottom = 40.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize(1f)
                        .padding(horizontal = 34.dp, vertical = 8.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Breakfast",
                            fontSize = 18.5.sp,
                            fontWeight = FontWeight(900),
                        )

                        Row {

                            Text(
                                text = "2 meals ",
                                fontSize = 12.5.sp,
                                color = Color(173, 164, 165),
                                fontWeight = FontWeight(300),
                            )

                            Text(
                                text = "| 230 calories",
                                fontSize = 12.5.sp,
                                color = Color(173, 164, 165),
                                fontWeight = FontWeight(300),
                            )

                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Column (modifier = Modifier.fillMaxSize(1f)) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 9.dp)
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

                                Column(
                                    verticalArrangement = Arrangement.SpaceBetween,
                                ) {


                                    Text(
                                        text = "Honey Pancake",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(800),
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = "07:00am",
                                        fontSize = 12.5.sp,
                                        color = Color(173, 164, 165),
                                        fontWeight = FontWeight(300),
                                    )
                                }

                            }



                            Image(
                                painter = painterResource(id = R.drawable.icon_arrow),
                                contentDescription = null,
                                modifier = Modifier.size(35.dp).clickable {
                                    navController.navigate("FoodChange")
                                }
                            )

                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 9.dp)
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

                                Column(
                                    verticalArrangement = Arrangement.SpaceBetween,
                                ) {


                                    Text(
                                        text = "Honey Pancake",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(800),
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = "07:00am",
                                        fontSize = 12.5.sp,
                                        color = Color(173, 164, 165),
                                        fontWeight = FontWeight(300),
                                    )
                                }

                            }



                            Image(
                                painter = painterResource(id = R.drawable.icon_arrow),
                                contentDescription = null,
                                modifier = Modifier.size(35.dp)
                            )

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