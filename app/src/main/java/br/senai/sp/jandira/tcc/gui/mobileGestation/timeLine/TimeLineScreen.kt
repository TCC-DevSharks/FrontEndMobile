package br.senai.sp.jandira.tcc.gui.mobileGestation.timeLine

import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.timeLine.timeLineList
import br.senai.sp.jandira.tcc.model.timeLine.timeLineResonse
import br.senai.sp.jandira.tcc.model.timeLine.timeLineSemanaList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun TimeLineScreen(pregnant: ModelPregnant, navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) {

        var timeLine by rememberSaveable {
            mutableStateOf(listOf<timeLineResonse>())
        }

        var timeLineId by rememberSaveable {
            mutableStateOf(listOf<timeLineResonse>())
        }

        var call = RetrofitFactory().getTrousseauService().getTimeLine()
        call.enqueue(object : Callback<timeLineList> {
            override fun onResponse(call: Call<timeLineList>, response: Response<timeLineList>) {
                timeLine = response.body()!!.semanas

                Log.i("", "${response.body()}")
            }

            override fun onFailure(call: Call<timeLineList>, t: Throwable) {
                Log.i("", "T${t.message}: ")
            }
        })



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp)
        ) {

            Header(
                titulo = stringResource(id = R.string.timeline),
                rota = "homeUser",
                navController = navController
            )

            Spacer(modifier = Modifier.height(10.dp))

            var selectedItem by remember { mutableStateOf(pregnant.semana_gestacao) }

            Log.i("fdfdf", "${selectedItem}")

            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(timeLine) { semana ->

                    val isItemSelected = semana.id == selectedItem

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .size(75.dp, 35.dp)
                            .fillMaxSize()
                            .clickable {
                                selectedItem = semana.id
                            }
                            .background(
                                if (isItemSelected) Color(182, 182, 246) else Color(249, 246, 244),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .graphicsLayer(
                                    clip = true,
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "${semana.id}",
                                fontWeight = FontWeight(500),
                                fontSize = 17.sp,
                                color = if (isItemSelected) Color.White else Color.Black
                            )
                        }
                    }
                }
            }



            Spacer(modifier = Modifier.height(24.dp))

            var call = RetrofitFactory().getTrousseauService().getTimeLineID(selectedItem)
            call.enqueue(object : Callback<timeLineSemanaList> {
                override fun onResponse(
                    call: Call<timeLineSemanaList>,
                    response: Response<timeLineSemanaList>
                ) {

                    timeLineId = response.body()!!.semana

                    Log.i("", "${response.body()}")
                }

                override fun onFailure(call: Call<timeLineSemanaList>, t: Throwable) {
                    Log.i("", "T${t.message}: ")
                }
            })

            LazyColumn() {

                items(timeLineId) { semana ->


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AsyncImage(
                            model = semana.imagemFruta,
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp),
                        )
                        Text(
                            modifier = Modifier.padding(start = 14.dp),
                            text = "${semana.comparacao}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Column(modifier = Modifier.padding(horizontal = 20.dp)) {

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(Color.Transparent)
                        ) {
                            AsyncImage(
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Fit,
                                model = semana.imagem,
                                contentDescription = null,
                            )
                        }

                        Spacer(modifier = Modifier.height(30.dp))

                        Column(modifier = Modifier.fillMaxSize()) {

                            Card(
                                modifier = Modifier
                                    .fillMaxSize(1f),
                                shape = RoundedCornerShape(10.dp),
                                colors = CardDefaults.cardColors(Color(182, 182, 246, 40))
                            ) {

                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(16.dp)
                                ) {

                                    Row(modifier = Modifier.fillMaxWidth()) {

                                        Text(
                                            text = stringResource(id = R.string.development),
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center,
                                            fontWeight = FontWeight(900),
                                            fontSize = 15.sp,
                                            color = Color(182, 182, 246)
                                        )
                                    }

                                    Row(modifier = Modifier.fillMaxWidth()) {

                                        Text(
                                            text = "${semana.desenvolvimento}",
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center,
                                            fontWeight = FontWeight(600),
                                            fontSize = 13.sp,
                                            color = Color.Black,
                                            lineHeight = 19.sp

                                        )
                                    }

                                    Spacer(modifier = Modifier.height(20.dp))

                                    Row(modifier = Modifier.fillMaxWidth()) {

                                        Text(
                                            text = stringResource(id = R.string.schedule),
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center,
                                            fontWeight = FontWeight(900),
                                            fontSize = 15.sp,
                                            color = Color(182, 182, 246)
                                        )
                                    }

                                    Row(modifier = Modifier.fillMaxWidth()) {

                                        Text(
                                            text = "${semana.agenda}",
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center,
                                            fontWeight = FontWeight(600),
                                            fontSize = 13.sp,
                                            color = Color.Black,
                                            lineHeight = 19.sp

                                        )
                                    }

                                    Spacer(modifier = Modifier.height(20.dp))

                                    Row(modifier = Modifier.fillMaxWidth()) {

                                        Text(
                                            text = stringResource(id = R.string.how_many_months),
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center,
                                            fontWeight = FontWeight(900),
                                            fontSize = 15.sp,
                                            color = Color(182, 182, 246)
                                        )
                                    }

                                    Row(modifier = Modifier.fillMaxWidth()) {

                                        Text(
                                            text = "${semana.meses}",
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center,
                                            fontWeight = FontWeight(600),
                                            fontSize = 13.sp,
                                            color = Color.Black,
                                            lineHeight = 19.sp

                                        )
                                    }

                                }

                            }
                        }
                    }

                }
            }
        }
    }
}
