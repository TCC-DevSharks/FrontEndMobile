package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.foodCategoryDefault

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import br.senai.sp.jandira.tcc.model.food.ModelFood
import br.senai.sp.jandira.tcc.model.modelDoctor.foodCategory.FoodCategoryResponse
import br.senai.sp.jandira.tcc.model.modelDoctor.foodCategory.FoodCategoryResponseList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response

@Composable
fun FoodCategoryDefault(navController: NavController, modelFood: ModelFood){

    var categorias by remember { mutableStateOf(listOf<FoodCategoryResponse>()) }

    val call = RetrofitFactory().food().getCategories()

    call.enqueue(object : retrofit2.Callback<FoodCategoryResponseList> {
        override fun onResponse(
            call: Call<FoodCategoryResponseList>,
            response: Response<FoodCategoryResponseList>

        ) {
            categorias = response.body()!!.categorias
        }

        override fun onFailure(call: Call<FoodCategoryResponseList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })

    Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Header(titulo = stringResource(id = R.string.header_food),rota ="", navController = navController)

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Selecione a categoria:",
                    color = Color(182, 182, 246),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(categorias){

                        Card(
                            modifier = Modifier
                                .padding(horizontal = 15.dp, vertical = 10.dp)
                                .fillMaxWidth()
                                .clickable {
                                           modelFood.categoria = it.id
                                    navController.navigate("addFood")
                                },
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.5.dp, Color.Black)
                        ) {
                            Row(modifier = Modifier
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
                            }
                        }
                    }
                }
            }
    }
}