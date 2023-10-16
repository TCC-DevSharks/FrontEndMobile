package br.senai.sp.jandira.tcc.gui.mobileGestation.exercisesFlow.stageExercices

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.model.categories.CategoriesResponse
import br.senai.sp.jandira.tcc.model.categories.CategoriesResponseList
import br.senai.sp.jandira.tcc.model.categories.ModelCategories
import br.senai.sp.jandira.tcc.model.exercises.ExercisesResponse
import br.senai.sp.jandira.tcc.model.exercises.ExercisesResponseList
import br.senai.sp.jandira.tcc.model.exercises.ModelExercises
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun StageExercises(navController: NavController, categories: ModelCategories, exercises: ModelExercises) {
    var categoria by remember { mutableStateOf(listOf<ExercisesResponse>()) }

    LaunchedEffect(Unit){
        val call = RetrofitFactory().Exercises().getExercises(categories.id)

        call.enqueue(object : Callback<ExercisesResponseList> {
            override fun onResponse(
                call: Call<ExercisesResponseList>,
                response: Response<ExercisesResponseList>

            ) {
                categoria = response.body()!!.exercicios
            }

            override fun onFailure(call: Call<ExercisesResponseList>, t: Throwable) {
                Log.i(
                    "ds2m",
                    "onFailure: ${t.message}"
                )
                println(t.message + t.cause)
            }
        })
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            Row(modifier = Modifier.padding(top = 40.dp)) {
                Text(
                    text = categories.categoria,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold

                )
            }
            Spacer(modifier = Modifier.height(9.dp))
            Row() {
                Text(
                    text = stringResource(id = R.string.description_warm_up),
                    fontSize = 13.sp,
                    color = Color.LightGray
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            Text(
                text = stringResource(id = R.string.exercises),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )

        }
        Spacer(modifier = Modifier.height(15.dp))


        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 4.dp)
        ){
            items(categoria){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
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

                            AsyncImage(model = categories.imagemCapa,
                                contentDescription ="",
                                contentScale = ContentScale.Crop)
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Column (Modifier.width(230.dp)){
                            Text(
                                text = it.nome,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(800),
                            )

                            Text(
                                text = it.descricao,
                                fontSize = 10.sp,
                                fontWeight = FontWeight(500),
                                lineHeight = 10.sp
                            )
                        }


                    }



                    Card(
                        modifier = Modifier.size(width = 50.dp, height = 50.dp),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(Color(191, 190, 244, 90)),
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                                contentDescription = null,
                                tint = Color(182, 182, 246),
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(CircleShape)
                                    .clickable {
                                        exercises.id = it.id
                                        navController.navigate("descExercises")
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}