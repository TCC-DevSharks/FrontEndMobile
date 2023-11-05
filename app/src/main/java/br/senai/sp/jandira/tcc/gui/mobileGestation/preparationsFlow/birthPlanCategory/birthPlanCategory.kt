package br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.birthPlanCategory

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.CardCategoryPreparativos
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.birthPlan.BirthPlanList
import br.senai.sp.jandira.tcc.model.birthPlan.BirthPlanListFavorite
import br.senai.sp.jandira.tcc.model.birthPlan.BirthPlanResponse
import br.senai.sp.jandira.tcc.model.birthPlan.BirthPlanResponseFavorite
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun birthPlanCategoryScreen(navController: NavController, pregnant: ModelPregnant) {

    var planoParto by rememberSaveable {
        mutableStateOf(listOf<BirthPlanResponse>())
    }

    var planoPartoFavorito by rememberSaveable {
        mutableStateOf(listOf<BirthPlanResponse>())
    }

    var favorite by rememberSaveable {
        mutableStateOf(listOf<BirthPlanResponseFavorite>())
    }

    var favoritoIds = favorite.map { it.item }


    val callFavorrite = RetrofitFactory().getBirthPlanService()
        .getBirthPlanFavorite(pregnant.id)

    callFavorrite.enqueue(object : Callback<BirthPlanListFavorite> {
        override fun onResponse(
            call: Call<BirthPlanListFavorite>,
            response: Response<BirthPlanListFavorite>
        ) {
            favorite = response.body()!!.favoritos

            Log.i("BirthPlan", "onResponse: $favorite")
            if (response.isSuccessful) {

                planoPartoFavorito = emptyList()

                planoParto.map {
                    if (favoritoIds.contains(it.item)) {
                        planoPartoFavorito = planoPartoFavorito + it
                        println(it.item)
                    }
                }
            }
        }

        override fun onFailure(call: Call<BirthPlanListFavorite>, t: Throwable) {
            Log.i("ds3m", "onFailure: ${t.message}")
        }
    })


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp)
        ) {

            Header(titulo = stringResource(id = R.string.header_birth_plan))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(
                        Color(182, 182, 246),
                        shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                    )
                    .padding(vertical = 9.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Row() {

                            Card(
                                modifier = Modifier
                                    .size(85.dp),
                                shape = CircleShape,
                                border = BorderStroke(4.dp, Color.White)

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.avia),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )

                            }
                        }

                        Row(modifier = Modifier.padding(top = 10.dp, start = 25.dp, end = 25.dp)) {

                            Text(
                                text = stringResource(id = R.string.header_birth_plan) + " ${pregnant.nome}",
                                fontWeight = FontWeight(900),
                                fontSize = 27.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )

                        }

                    }



                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Button(
                            onClick =
                            {
//                        onclick(navController)
                            },
                            modifier = Modifier
                                .width(135.dp)
                                .height(35.dp),
                            colors = ButtonDefaults.buttonColors(Color(236, 238, 255)),

                            shape = RoundedCornerShape(16.dp),

                            ) {
                            Text(
                                text = "${planoPartoFavorito.size} itens",
                                color = Color(182, 182, 246),
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            val categoriasExibidas = mutableSetOf<String>()


            val call = RetrofitFactory().getBirthPlanService().getBirthPlan()

            call.enqueue(object : Callback<BirthPlanList> {

                override fun onResponse(
                    call: Call<BirthPlanList>,
                    response: Response<BirthPlanList>
                ) {

                    planoParto = response.body()!!.planos

                    Log.e("Gui", "onResponse: ${planoParto}", )
                }

                override fun onFailure(call: Call<BirthPlanList>, t: Throwable) {
                    Log.i("Erro", "onFailure: ${t.message}")
                }

            })

            LazyColumn(  modifier = Modifier
                .fillMaxSize()
                .padding(top = 9.dp)
            ) {

                items(planoParto) { item->

                    if (!categoriasExibidas.contains(item.categoria)) {
                        CardCategoryPreparativos(category = item.categoria, rota = "birthPlan", navController = navController)
                        categoriasExibidas.add(item.categoria)
                    }
                }
            }
        }
    }

}