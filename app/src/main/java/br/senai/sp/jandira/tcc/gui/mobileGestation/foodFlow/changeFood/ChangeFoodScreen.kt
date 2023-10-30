package br.senai.sp.jandira.tcc.gui.mobileGestation.foodFlow.changeFood

import android.util.Log
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
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
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.food.FoodResponse
import br.senai.sp.jandira.tcc.model.food.FoodResponseList
import br.senai.sp.jandira.tcc.model.food.ModelFood
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response

@Composable
fun ChangeFoodScreen(navController: NavController, modelFood: ModelFood, pregnant: ModelPregnant) {

    var food by remember { mutableStateOf(listOf<FoodResponse>()) }
    val call = RetrofitFactory().findFood().getFood(modelFood.id)

    call.enqueue(object : retrofit2.Callback<FoodResponseList> {
        override fun onResponse(
            call: Call<FoodResponseList>,
            response: Response<FoodResponseList>

        ) {
            food = response.body()!!.categoria
        }


        override fun onFailure(call: Call<FoodResponseList>, t: Throwable) {
            Log.i(
                "ds2",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp)
        ) {

            Header(titulo = if (food.isNotEmpty())food[0].categoria else stringResource(id = R.string.header_food))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(.3.dp)
            ) {}

            Spacer(modifier = Modifier.height(35.dp))

            LazyColumn{
                items(food){
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
            Navigation(navController = navController,pregnant)
        }
    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun ChangeFoodScreenPreview() {
//    ChangeFoodScreen()
//}