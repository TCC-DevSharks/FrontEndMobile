package br.senai.sp.jandira.tcc.gui.mobileDoctor.patientProfile

import android.util.Log
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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


        Log.i("", "${medicalRecord.id_paciente}")

        Header(
            titulo = stringResource(id = R.string.patietent_profile),
            rota = "DoctorSchedule", navController = navController
        )

        Spacer(modifier = Modifier.height(50.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            items(gestante) { gestante ->

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)

                ) {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Card(
                            modifier = Modifier
                                .size(105.dp),
                            shape = CircleShape,

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
                                .fillMaxSize()
                                .padding(top = 10.dp),
                            verticalArrangement = Arrangement.Center,
                        ) {

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    text = gestante.nome,
                                    fontSize = 31.sp,
                                    fontWeight = FontWeight(700),
                                )

                            }

                        }

                    }
                }
                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row() {

                        Text(
                            text = "Peso:",
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = gestante.peso.toString(),
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                    }

                    Row() {

                        Text(
                            text = "Altura:",
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = gestante.altura.toString(),
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                    }

                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row() {

                        Text(
                            text = "Data do parto:",
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = gestante.data_parto,
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row() {

                        Text(
                            text = "Semana de gestação:",
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = gestante.semana_gestacao.toString(),
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                    }

                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row() {

                        Text(
                            text = "Telefone:",
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = gestante.telefone,
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                    }


                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row() {

                        Text(
                            text = "cpf:",
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = gestante.cpf,
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row() {

                        Text(
                            text = "email:",
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = gestante.email,
                            fontSize = 17.sp,
                            fontWeight = FontWeight(700)
                        )

                    }
                }

                Spacer(modifier = Modifier.height(65.dp))

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
    }

}