package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.mealDefaults

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.DeleteDefaultMeal
import br.senai.sp.jandira.tcc.calls.GetPregnant
import br.senai.sp.jandira.tcc.componentes.AddMealDialog
import br.senai.sp.jandira.tcc.componentes.ButtonAdd
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.NavigationNutritionist
import br.senai.sp.jandira.tcc.model.WeightHeight
import br.senai.sp.jandira.tcc.model.chatUser.ChatUserResponse
import br.senai.sp.jandira.tcc.model.diet.DietResponse
import br.senai.sp.jandira.tcc.model.food.ModelFood
import br.senai.sp.jandira.tcc.model.meal.MealResponse
import br.senai.sp.jandira.tcc.model.meal.MealResponseList
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.DefaultMealResponse
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.DefaultMealResponseList
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.ModelDefaultMeal
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealDefaults(navController: NavController, professional: Professional,food: ModelFood) {

    var refeicao by remember { mutableStateOf(listOf<DefaultMealResponse>()) }
    var effect by remember { mutableStateOf(true)}

    var openDialog = remember { mutableStateOf(false) }

    var nome by remember { mutableStateOf("") }

    LaunchedEffect(effect){

        val call = RetrofitFactory().Diet().getDefaultMeal(professional.id)

        call.enqueue(object : retrofit2.Callback<DefaultMealResponseList> {
            override fun onResponse(
                call: Call<DefaultMealResponseList>,
                response: Response<DefaultMealResponseList>

            ) {
                refeicao = response.body()!!.refeicao
                println(refeicao)

            }

            override fun onFailure(call: Call<DefaultMealResponseList>, t: Throwable) {
                Log.i(
                    "ds2m",
                    "onFailure: ${t.message}"
                )
                println(t.message + t.cause)
            }
        })
    }


    AddMealDialog(
        openDialog = openDialog,
        nome =nome ,
        onValueChangeNome = {nome = it}) {
            var meal = ModelDefaultMeal(
                nome = nome,
                id_profissional = professional.id
            )

            val call = RetrofitFactory().Diet().postDefaultMeal(meal)

            call.enqueue(object : retrofit2.Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>

                ) {
                    println(response)
                    println(response.body())
                    openDialog.value = false
                   effect = !effect
                    nome = ""

                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.i(
                        "ds2m",
                        "onFailure: ${t.message}"
                    )
                    println(t.message + t.cause)
                }
            })

    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(floatingActionButton = {   Button(
            onClick = {
                openDialog.value = true
            },
            modifier = Modifier.size(70.dp),
            colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),
            border = BorderStroke(width = 2.dp, Color.Black)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "",
                modifier = Modifier.size(35.dp),

                )
        }},
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

                Header(titulo = stringResource(id = R.string.header_food),rota ="", navController = navController)

                Spacer(modifier = Modifier.height(40.dp))

                if (refeicao.isNotEmpty()){
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(refeicao){
                            Card(
                                modifier = Modifier
                                    .padding(horizontal = 15.dp, vertical = 10.dp)
                                    .fillMaxWidth()
                                    .clickable {
                                        food.refeicao = it.id
                                        food.nomeRefeicao = it.nome
                                        navController.navigate("foodMeal")
                                    },
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                shape = RoundedCornerShape(0.dp),
                                border = BorderStroke(1.dp, Color.Black)
                            ) {
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp, vertical = 15.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = it.nome,
                                        color = Color(182, 182, 246),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )

                                    Image(
                                        painter = painterResource(id = R.drawable.trash),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .height(20.dp)
                                            .clickable {
                                                DeleteDefaultMeal(it.id)
                                                effect = !effect
                                            },
                                        colorFilter = ColorFilter.tint(Color(218, 47, 66, 255))
                                    )

                                }
                            }
                        }

                    }
                    
                }else{
                    Text(text = "Não há nenhuma refeicao criada, clique no botão para adicionar.",
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        modifier = Modifier.padding(horizontal = 15.dp))
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