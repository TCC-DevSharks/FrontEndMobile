package br.senai.sp.jandira.tcc.gui.mobileDoctor.patientProfile

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponse
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponseList
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordDataConsult
import br.senai.sp.jandira.tcc.model.medicalRecord.ModelMedicalRecord
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun PatientProfileScreen(
    navController: NavController,
    medicalRecord: ModelMedicalRecord

) {

    Column(modifier = Modifier.fillMaxSize()) {

        var gestante by rememberSaveable {
            mutableStateOf(listOf<PregnantResponse>())
        }

        var call = RetrofitFactory().pregnant().getPregnant(medicalRecord.id_paciente)

        call.enqueue(object : Callback<PregnantResponseList> {
            override fun onResponse(
                call: Call<PregnantResponseList>,
                response: Response<PregnantResponseList>
            ) {
                gestante = response.body()!!.gestante
            }

            override fun onFailure(call: Call<PregnantResponseList>, t: Throwable) {
                Log.i("Erro", "${t.message}")
            }
        })

        Header(titulo = stringResource(id = R.string.patietent_profile), rota = "DoctorHome", navController = navController)

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn() {

            items(gestante) { gestante ->

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                        Spacer(modifier = Modifier.height(15.dp))

                        Card(
                            modifier = Modifier
                                .size(110.dp),
                            shape = CircleShape,
                            border = BorderStroke(3.5.dp, Color(182, 182, 246))

                        ) {
                            AsyncImage(
                                model = gestante.foto,
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(105.dp)
                                    .clip(CircleShape)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .padding(top = 15.dp),
                            verticalArrangement = Arrangement.Center,
                        ) {

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    text = gestante.nome,
                                    fontSize = 28.sp,
                                    fontWeight = FontWeight(600),
                                )

                            }

                        }
                }

                Spacer(modifier = Modifier.height(15.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                        Card(
                            modifier = Modifier
                                .size(width = 120.dp, height = 80.dp)
                                .padding(vertical = 9.dp, horizontal = 4.dp),
                            colors = CardDefaults.cardColors(Color.White),
                            border = BorderStroke(.1.dp, Color.Gray)

                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(9.dp)
                            ) {
                                Text(
                                    text = gestante.altura.toString(),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 4.dp),
                                    textAlign = TextAlign.Center,
                                    color = Color(182, 182, 246),
                                    fontSize = 15.5.sp,
                                    fontWeight = FontWeight(800)

                                )
                                Text(
                                    text = "Altura",
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(500)

                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(10.dp))


                        Card(
                            modifier = Modifier
                                .size(width = 120.dp, height = 80.dp)
                                .padding(vertical = 9.dp, horizontal = 4.dp),
                            colors = CardDefaults.cardColors(Color.White),
                            border = BorderStroke(.1.dp, Color.Gray)

                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(9.dp)
                            ) {
                                Text(
                                    text = gestante.peso.toString(),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 4.dp),
                                    textAlign = TextAlign.Center,
                                    color = Color(182, 182, 246),
                                    fontSize = 15.5.sp,
                                    fontWeight = FontWeight(800)


                                )
                                Text(
                                    text = "Peso",
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(500)

                                )
                            }
                        }

                }
                Spacer(modifier = Modifier.height(15.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                        Card(
                            modifier = Modifier
                                .size(width = 350.dp, height = 205.dp)
                                .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp)),
                            colors = CardDefaults.cardColors(Color.White),
                        ) {
                            Column(modifier = Modifier.padding(13.dp)) {

                                Row() {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(bottom = 10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Row(verticalAlignment = Alignment.CenterVertically) {

                                            Image(
                                                painter = painterResource(id = R.drawable.baseline_person_outline_24),
                                                contentDescription = null
                                            )

                                            Text(
                                                modifier = Modifier.padding(start = 15.dp),
                                                text = stringResource(id = R.string.date_childbirth) + ":"
                                            )

                                            Text(
                                                modifier = Modifier.padding(start = 7.dp),
                                                text = gestante.data_parto
                                            )

                                        }

                                    }
                                }

                                Row() {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(bottom = 10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Row(verticalAlignment = Alignment.CenterVertically) {

                                            Image(
                                                painter = painterResource(id = R.drawable.baseline_person_outline_24),
                                                contentDescription = null
                                            )

                                            Text(
                                                modifier = Modifier.padding(start = 15.dp),
                                                text = stringResource(id = R.string.gestation_week) + ":"
                                            )

                                            Text(
                                                modifier = Modifier.padding(start = 7.dp),
                                                text = gestante.semana_gestacao.toString()
                                            )

                                        }

                                    }
                                }

                                Row() {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(bottom = 10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Row(verticalAlignment = Alignment.CenterVertically) {

                                            Image(
                                                painter = painterResource(id = R.drawable.baseline_person_outline_24),
                                                contentDescription = null
                                            )

                                            Text(
                                                modifier = Modifier.padding(start = 15.dp),
                                                text = stringResource(id = R.string.telephone) + ":"
                                            )

                                            Text(
                                                modifier = Modifier.padding(start = 7.dp),
                                                text = gestante.telefone
                                            )

                                        }

                                    }
                                }

                                Row() {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(bottom = 10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Row(verticalAlignment = Alignment.CenterVertically) {

                                            Image(
                                                painter = painterResource(id = R.drawable.baseline_person_outline_24),
                                                contentDescription = null
                                            )

                                            Text(
                                                modifier = Modifier.padding(start = 15.dp),
                                                text = stringResource(id = R.string.cpf)
                                            )

                                            Text(
                                                modifier = Modifier.padding(start = 7.dp),
                                                text = gestante.cpf
                                            )

                                        }

                                    }
                                }

                                Row() {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(bottom = 10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Row(verticalAlignment = Alignment.CenterVertically) {

                                            Image(
                                                painter = painterResource(id = R.drawable.baseline_person_outline_24),
                                                contentDescription = null
                                            )

                                            Text(
                                                modifier = Modifier.padding(start = 15.dp),
                                                text = stringResource(id = R.string.email) + ":"
                                            )

                                            Text(
                                                modifier = Modifier.padding(start = 7.dp),
                                                text = gestante.email
                                            )

                                        }

                                    }
                                }
                            }
                        }

                }

            }
        }

        Spacer(modifier = Modifier.height(30.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            horizontalArrangement = Arrangement.End
        ) {

            Box(
                modifier = Modifier
                    .background(Color(182, 182, 246), CircleShape)
                    .size(60.dp)
                    .clickable {
                        navController.navigate("medicalRecordMade")
                    }, contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.clipboard_branco),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                )
            }
        }
    }

}