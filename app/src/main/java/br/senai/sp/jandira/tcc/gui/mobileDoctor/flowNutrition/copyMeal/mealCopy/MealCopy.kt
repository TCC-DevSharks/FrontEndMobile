package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.copyMeal.mealCopy

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.DeleteDefaultMeal
import br.senai.sp.jandira.tcc.componentes.AddMealDialog
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.food.ModelFood
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.DefaultMealResponse
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.DefaultMealResponseList
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.ModelDefaultMeal
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealCopy(navController: NavController, professional: Professional,food: ModelFood) {

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
            Column(
                modifier = Modifier
                    .fillMaxSize()
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
                                        food.refeicaoPadrao = it.id
                                        food.nomeRefeicao = it.nome
                                        navController.navigate("foodMealCopy")
                                    },
                                colors = CardDefaults.cardColors(containerColor = Color(182,182,246)),
                                shape = RoundedCornerShape(12.dp),
                            ) {
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp, vertical = 15.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = it.nome,
                                        color = Color.White,
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
                                        colorFilter = ColorFilter.tint(Color.White)
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



//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun CheckFoodScreenPreview() {
//    CheckFoodScreen()
//}