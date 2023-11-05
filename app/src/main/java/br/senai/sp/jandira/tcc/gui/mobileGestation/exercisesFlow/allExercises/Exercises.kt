package br.senai.sp.jandira.tcc.gui.mobileGestation.exercisesFlow.allExercises

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.items
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
import br.senai.sp.jandira.tcc.model.categories.CategoriesResponse
import br.senai.sp.jandira.tcc.model.categories.CategoriesResponseList
import br.senai.sp.jandira.tcc.model.categories.ModelCategories
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Response

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercises(navController: NavController, categories: ModelCategories, pregnant: ModelPregnant) {
    var categoria by remember { mutableStateOf(listOf<CategoriesResponse>()) }

    LaunchedEffect(Unit){
        val call = RetrofitFactory().Categories().getCategories()

        call.enqueue(object : retrofit2.Callback<CategoriesResponseList> {
            override fun onResponse(
                call: Call<CategoriesResponseList>,
                response: Response<CategoriesResponseList>

            ) {
                categoria = response.body()!!.categorias

            }

            override fun onFailure(call: Call<CategoriesResponseList>, t: Throwable) {
                Log.i(
                    "ds2m",
                    "onFailure: ${t.message}"
                )
                println(t.message + t.cause)
            }
        })
    }


    Scaffold(
        topBar = { Header(titulo = "Exercices")}) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.padding(start = 20.dp, top = 20.dp)) {
                    Text(
                        text = stringResource(id = R.string.find_class),
                        fontSize = 20.sp
                    )
                }
                Row(modifier = Modifier.padding(start = 20.dp)) {
                    Text(
                        text = stringResource(id = R.string.find_class2),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Card(
                    modifier = Modifier.size(width = 350.dp, height = 150.dp),
                    colors = CardDefaults.cardColors(Color(182, 182, 246))
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 30.dp), verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {

                            Row(modifier = Modifier.width(150.dp)) {
                                Text(
                                    modifier = Modifier.padding(start = 20.dp),
                                    text = "Today’s activity",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp
                                )
                            }
                            Row(modifier = Modifier.width(150.dp)) {
                                Text(
                                    modifier = Modifier.padding(top = 15.dp, start = 20.dp),
                                    text = "8.00 AM - 1.30 PM",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    color = Color.White
                                )
                            }

                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.pe),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(145.dp)
                                    .padding(20.dp)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.categories),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            //Lazyrow

            LazyRow( modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)){
                items(categoria){

                    Card(
                        modifier = Modifier
                            .size(width = 140.dp, height = 200.dp)
                            .padding(end = 10.dp)
                            .clickable {
                                categories.id = it.id
                                categories.categoria = it.nome
                                categories.imagemCapa = it.imagem
                                navController.navigate("catExercises")
                            },
                        colors = CardDefaults.cardColors(Color(182, 182, 246))
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier.padding(top = 10.dp),
                                text = it.nome,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AsyncImage(model =it.imagem ,
                                contentDescription ="",
                                modifier = Modifier.size(150.dp)

                            )
                        }
                    }
                }
            }
        }
    }

}
