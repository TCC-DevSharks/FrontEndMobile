package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.clinic

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.GetCep
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.TextComp
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.ModelSpeciality
import br.senai.sp.jandira.tcc.model.clinic.Clinic
import br.senai.sp.jandira.tcc.model.google.DistanceMatrix
import br.senai.sp.jandira.tcc.model.viaCep.ViaCep
import br.senai.sp.jandira.tcc.service.RetrofitFactoryCep
import br.senai.sp.jandira.tcc.service.RetrofitFactoryMaps
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Response

@Composable
fun ConsultationClinicScreen(navController: NavController, clinic: Clinic, viewmodel: ModelPregnant) {

    LaunchedEffect(Unit){
        GetCep(viewmodel,viewmodel.cep)
    }

    Column(modifier = Modifier.fillMaxSize()) {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            Column(
                modifier = Modifier
                    .padding(bottom = 70.dp)
            ) {


                Header(titulo = stringResource(id = R.string.header_clinic),
                    tintIcon = Color(255, 218, 185)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .height(.3.dp)
                ) {

                }

                Spacer(modifier = Modifier.height(60.dp))

                Row(modifier = Modifier.padding(horizontal = 50.dp, vertical = 2.dp)) {

                    TextComp(
                        texto = R.string.title_clinic,
                        fontSize = 21.sp,
                        fontWeight = FontWeight(400)
                    )

                }

                Spacer(modifier = Modifier.height(35.dp))


                LazyColumn(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally){
                    items(clinic.clinica){

                        val call = RetrofitFactoryCep().getCep().getCep(it.cep)

                        var distance by remember { mutableStateOf("Distância") }
                        var duration by remember { mutableStateOf("Duração") }

                        call.enqueue(object : retrofit2.Callback<ViaCep> {
                            override fun onResponse(
                                call: Call<ViaCep>,
                                response: Response<ViaCep>

                            ) {
                                Log.i("asdf", "${response.body()}")
                                val logradouro = response.body()!!.logradouro
                                val cidade = response.body()!!.localidade
                                val bairro = response.body()!!.bairro

                                val destination = "${logradouro}, ${bairro}, ${cidade}, Brazil"
                                val origin = "${viewmodel.logradouro}, ${viewmodel.bairro}, ${viewmodel.cidade}, Brazil"
                                val key = "AIzaSyCLmZ-N0L89OzMsvIm8bcphurXZPSdBlDg"

                                Log.e("qwert","${origin}")

                                if (response.code() == 200) {

                                    val callDistance = RetrofitFactoryMaps().getDistance().getMatrix(
                                        origins = origin,
                                        destinations = destination,
                                        key = key,
                                        mode = "driving"
                                        )

                                    callDistance.enqueue(object : retrofit2.Callback<DistanceMatrix> {
                                        override fun onResponse(
                                            call: Call<DistanceMatrix>,
                                            response: Response<DistanceMatrix>

                                        ) {
                                           distance= "${response.body()!!.rows[0].elements[0].distance.text}"
                                            duration = "${response.body()!!.rows[0].elements[0].duration.text}"
                                        }

                                        override fun onFailure(call: Call<DistanceMatrix>, t: Throwable) {
                                            Log.i(
                                                "dsm",
                                                "onFailure: ${t.message}"
                                            )
                                            println(t.message + t.cause)
                                        }
                                    })
                                }


                            }

                            override fun onFailure(call: Call<ViaCep>, t: Throwable) {
                                Log.i(
                                    "ds2m",
                                    "onFailure: ${t.message}"
                                )
                                println(t.message + t.cause)
                            }
                        })

                        Card(
                            modifier = Modifier
                                .width(340.dp)
                                .height(150.dp)
                                .padding(bottom = 14.dp)
                                .clickable {
                                           navController.navigate("")
                                },
                            colors = CardDefaults.cardColors(Color(236, 238, 255)),
                            border = BorderStroke(width = 1.dp, color = Color(182,182,246)),

                            shape = RoundedCornerShape(16.dp),
                        ) {
                            Row (
                                Modifier
                                    .fillMaxSize(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                AsyncImage(
                                    model = it.foto,
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(70.dp)
                                        .clip(CircleShape)
                                        .clickable {
                                            navController.navigate("profileUser")
                                        }
                                )

                                Spacer(modifier = Modifier.width(10.dp))

                                Column {
                                    Text(
                                        text = it.razao_social,
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 30.sp,
                                    )

                                    Row (verticalAlignment = Alignment.CenterVertically){
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(painter = painterResource(id = R.drawable.baseline_location_on_24),
                                                contentDescription = "",)

                                            Spacer(modifier = Modifier.width(5.dp))

                                            Text(text = distance )
                                        }

                                        Spacer(modifier = Modifier.width(20.dp))

                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(painter = painterResource(id = R.drawable.car_24),
                                                contentDescription = "",)

                                            Spacer(modifier = Modifier.width(5.dp))

                                            Text(text = duration )
                                        }
                                    }
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

                Navigation(navController = navController)


            }

        }


    }

}