package br.senai.sp.jandira.tcc.gui.mobileGestation.exercisesFlow.descriptionExercices

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.YoutubePlayer
import br.senai.sp.jandira.tcc.model.exercises.ExerciseResponseList
import br.senai.sp.jandira.tcc.model.exercises.ExercisesResponse
import br.senai.sp.jandira.tcc.model.exercises.ExercisesResponseList
import br.senai.sp.jandira.tcc.model.exercises.ModelExercises
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun DescriptionExercises(navController: NavController, exercises: ModelExercises) {

    var exercicios by remember { mutableStateOf(listOf<ExercisesResponse>()) }
    LaunchedEffect(key1 = Unit){
        val call = RetrofitFactory().Exercises().getExercise(exercises.id)

        call.enqueue(object : Callback<ExerciseResponseList> {
            override fun onResponse(
                call: Call<ExerciseResponseList>,
                response: Response<ExerciseResponseList>

            ) {
                    exercicios = response.body()!!.exercicio
                println(exercicios)


                    exercicios.map{
                        exercises.id = it.id
                        exercises.nome = it.nome
                        exercises.descricao = it.descricao
                        exercises.video = it.video
                        exercises.categoria = it.categoria


                }
            }

            override fun onFailure(call: Call<ExerciseResponseList>, t: Throwable) {
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
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(Color(182, 182, 246))
            ) {

                if (exercises.video.isNotEmpty()){
                    YoutubePlayer(
                        youtubeVideoId = exercises.video,
                        lifecycleOwner = LocalLifecycleOwner.current
                    )
                }

            }

        }
        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row() {
                Text(
                    text = exercises.nome,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold

                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row() {
                Text(
                    text = "Descriptions",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold

                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row() {
                Text(text = exercises.descricao,
                    color = Color.LightGray,
                    fontSize = 13.sp
                )

            }

        }
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 20.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(
//                text = "How To Do It",
//                fontSize = 15.sp,
//                fontWeight = FontWeight.Bold
//            )
//            Text(
//                text = "4 Steps",
//                fontSize = 15.sp,
//                fontWeight = FontWeight.Light,
//                color = Color(27, 26, 26)
//
//            )
//        }
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//
////            .horizontalScroll(
////            rememberScrollState()
////        ),
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp),
//                // horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "01",
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Light,
//                    color = Color(182, 182, 246)
//                )
//
//                Spacer(modifier = Modifier.width(50.dp))
//
//                Text(
//                    text = "Spread Your Arms",
//                    fontSize = 15.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = Color(27, 26, 26)
//
//                )
//            }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 40.dp),
//                // horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Spacer(modifier = Modifier.width(50.dp))
//
//                Text(
//                    text = "To make the gestures feel more relaxed, stretch your arms as you start this movement. No bending of hands.",
//                    fontSize = 15.sp,
//                    color = Color.LightGray,
//
//
//                    )
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp),
//                // horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "02",
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Light,
//                    color = Color(182, 182, 246)
//                )
//
//                Spacer(modifier = Modifier.width(50.dp))
//
//                Text(
//                    text = "Rest at The Toe",
//                    fontSize = 15.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = Color(27, 26, 26)
//
//                )
//            }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 40.dp),
//                // horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Spacer(modifier = Modifier.width(50.dp))
//
//                Text(
//                    text = "The basis of this movement is jumping. Now, what needs to be considered is that you have to use the tips of your feet",
//                    fontSize = 15.sp,
//                    color = Color.LightGray,
//
//
//                    )
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp),
//                // horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "03",
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Light,
//                    color = Color(182, 182, 246)
//                )
//
//                Spacer(modifier = Modifier.width(50.dp))
//
//                Text(
//                    text = "Adjust Foot Movement",
//                    fontSize = 15.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = Color(27, 26, 26)
//
//                )
//            }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 40.dp),
//                // horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Spacer(modifier = Modifier.width(50.dp))
//
//                Text(
//                    text = "Jumping Jack is not just an ordinary jump. But, you also have to pay close attention to leg movements.",
//                    fontSize = 15.sp,
//                    color = Color.LightGray,
//
//
//                    )
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp),
//                // horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "04",
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Light,
//                    color = Color(182, 182, 246)
//                )
//
//                Spacer(modifier = Modifier.width(50.dp))
//
//                Text(
//                    text = "Clapping Both Hands",
//                    fontSize = 15.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = Color(27, 26, 26)
//
//                )
//            }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 40.dp),
//                // horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Spacer(modifier = Modifier.width(50.dp))
//
//                Text(
//                    text = "This cannot be taken lightly. You see, without realizing it, the clapping of your hands helps you to keep your rhythm while doing the Jumping Jack",
//                    fontSize = 15.sp,
//                    color = Color.LightGray,
//
//
//                    )
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//        }


    }
}
