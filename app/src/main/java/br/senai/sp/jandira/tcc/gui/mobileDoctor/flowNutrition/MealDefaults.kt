package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ButtonAdd
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.NavigationNutritionist
import br.senai.sp.jandira.tcc.model.diet.DietResponse
import br.senai.sp.jandira.tcc.model.meal.MealResponse
import br.senai.sp.jandira.tcc.model.meal.MealResponseList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealDefaults(navController: NavController) {


    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(bottomBar = { ButtonAdd()},
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

                Header(titulo = stringResource(id = R.string.header_food))

                Spacer(modifier = Modifier.height(40.dp))

                Column(modifier = Modifier.fillMaxSize()) {
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 15.dp, vertical = 10.dp)
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(0.dp),
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        Row(modifier = Modifier
                            .padding(horizontal = 15.dp, vertical = 15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "it.refeicao",
                                color = Color(182, 182, 246),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold
                            )

                            Text(text = "it.horario")
                        }
                    }
                }
            }
        }
    }

}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun CheckFoodScreenPreview() {
//    CheckFoodScreen()
//}