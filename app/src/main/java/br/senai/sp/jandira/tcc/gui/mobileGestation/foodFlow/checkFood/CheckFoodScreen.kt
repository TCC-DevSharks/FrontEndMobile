package br.senai.sp.jandira.tcc.gui.mobileGestation.foodFlow.checkFood

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.diet.DietResponse
import br.senai.sp.jandira.tcc.model.diet.DietResponseList
import br.senai.sp.jandira.tcc.model.food.FoodResponse
import br.senai.sp.jandira.tcc.model.food.FoodResponseList
import br.senai.sp.jandira.tcc.model.food.ModelFood
import br.senai.sp.jandira.tcc.model.meal.MealResponse
import br.senai.sp.jandira.tcc.model.meal.MealResponseList
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.DietResponseListProf
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.DietResponseProf
import br.senai.sp.jandira.tcc.model.schedule.ScheduleList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CheckFoodScreen(navController: NavController, pregnant: ModelPregnant, food: ModelFood) {

    var diet by remember { mutableStateOf(listOf<DietResponseProf>()) }
    val painter = painterResource(id = R.drawable.dieta)


    LaunchedEffect(Unit) {

        val call = RetrofitFactory().Diet().getMealDiet(pregnant.id)

        call.enqueue(object : retrofit2.Callback<DietResponseListProf> {
            override fun onResponse(
                call: Call<DietResponseListProf>,
                response: Response<DietResponseListProf>

            ) {
                println(response)
                println(response.body())

                diet = response.body()!!.dieta
            }

            override fun onFailure(call: Call<DietResponseListProf>, t: Throwable) {
                Log.i(
                    "ds2m",
                    "onFailure: ${t.message}"
                )
                println(t.message + t.cause)
            }
        })
    }

    Box(modifier = Modifier.fillMaxSize()) {


        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Header(
                titulo = stringResource(id = R.string.header_food),
                rota = "homeUser",
                navController = navController
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(.3.dp)
            ) {}

            Spacer(modifier = Modifier.height(40.dp))
            if (diet.isNotEmpty()){
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(diet) {

                        var visible by remember { mutableStateOf(false) }

                        Card(
                            modifier = Modifier
                                .padding(horizontal = 15.dp, vertical = 10.dp)
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(Color(182, 182, 246, 80)),
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color(182, 182, 246))
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
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )

                                Text(text = it.horario,
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.ExtraBold)
                            }

                            var meal by remember { mutableStateOf(listOf<FoodResponse>()) }

                            val call = RetrofitFactory().food().getFoodMeal(it.idRefeicao)

                            call.enqueue(object : retrofit2.Callback<FoodResponseList> {
                                override fun onResponse(
                                    call: Call<FoodResponseList>,
                                    response: Response<FoodResponseList>

                                ) {
                                    meal = response.body()!!.alimentos
                                }


                                override fun onFailure(call: Call<FoodResponseList>, t: Throwable) {
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
                                    .background(Color.White),
                                enter = fadeIn(
                                    initialAlpha = 0.8f
                                ),
                                exit = fadeOut(
                                    animationSpec = tween(durationMillis = 50)
                                )
                            ) {
                                Column(modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color(182, 182, 246, 80))) {
                                    for (it in meal) {

                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 15.dp, vertical = 5.dp),
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

                                                    AsyncImage(
                                                        model = it.imagem,
                                                        contentDescription = "",
                                                        contentScale = ContentScale.Crop,
                                                        modifier = Modifier.fillMaxSize(),
                                                        transform = { state ->
                                                            when (state) {
                                                                is AsyncImagePainter.State.Loading -> {
                                                                    state.copy(painter = painter)
                                                                }
                                                                is AsyncImagePainter.State.Error -> {
                                                                    state.copy(painter = painter)
                                                                }

                                                                else -> state
                                                            }
                                                        }
                                                    )
                                                }

                                                Spacer(modifier = Modifier.width(16.dp))

                                                Column {
                                                    Text(
                                                        text = it.nome,
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
                                                        println(it)
                                                        navController.navigate("FoodChange")
                                                    },
                                                colorFilter = ColorFilter.tint(Color.Black)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }else{
                Column(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp)) {
                    Text(text = "Você não possui nenhuma dieta, marque uma consulta com um(a) nutricionista para definir uma!",
                        color = Color.Red,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                        )
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