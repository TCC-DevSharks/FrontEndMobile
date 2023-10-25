package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowMedicalRecord

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordDataConsult
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordListDataConsult
import br.senai.sp.jandira.tcc.model.medicalRecord.ModelMedicalRecord
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

@Composable

fun SelectDateMedicalRecord(
    navController: NavController,
    professional: Professional,
    idGestante: Int?,
    modelMedicalRecord: ModelMedicalRecord
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val idGestante = navBackStackEntry?.arguments?.getString("idGestante")?.toIntOrNull()

    Log.i("fdf", "$idGestante")

    var paciente by rememberSaveable {
        mutableStateOf(listOf<MedicalRecordDataConsult>())
    }

    var call = idGestante?.let { RetrofitFactory().insertConsult().getConsultPatient(it) }

    if (call != null) {
        call.enqueue(object : Callback<MedicalRecordListDataConsult> {
            override fun onResponse(
                call: Call<MedicalRecordListDataConsult>,
                response: Response<MedicalRecordListDataConsult>
            ) {

                paciente = response.body()!!.gestante

            }

            override fun onFailure(call: Call<MedicalRecordListDataConsult>, t: Throwable) {
                Log.i("ggdf", "${t.message}")
            }
        })
    }

    Log.i("trest", "${idGestante}")

    Column(modifier = Modifier.fillMaxSize()) {

        Header(titulo = stringResource(id = R.string.medical_record))

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.select_consult),
                fontSize = 17.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(paciente) {

                Card(
                    modifier = Modifier
                        .width(340.dp)
                        .clickable {
                            navController.navigate("medicalRecordAdd")
                        }
                        .height(85.dp)
                        .padding(bottom = 14.dp),
                    colors = CardDefaults.cardColors(Color(255, 255, 255)),
                    border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                    shape = RoundedCornerShape(16.dp),
                ) {

                    Row(
                        modifier = Modifier
                            .padding(start = 18.dp)
                            .fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Row(
                            modifier = Modifier
                                .background(
                                    Color(182, 182, 246),
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {

                            Text(
                                text = it.gestante,
                                color = Color.White,
                                fontSize = 15.sp,
                                fontWeight = FontWeight(700),
                                modifier = Modifier
                                    .background(
                                        Color(182, 182, 246),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(10.dp)
                            )
                        }

                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(start = 17.dp)
                        ) {

                            Text(
                                text = stringResource(id = R.string.date) + " " + it.dia,
                                fontWeight = FontWeight(400),
                                fontSize = 14.5.sp,
                                color = Color.Gray,
                            )

                            Spacer(modifier = Modifier.height(3.dp))

                            Text(
                                text = stringResource(id = R.string.hour) + " " + it.hora,
                                fontWeight = FontWeight(400),
                                fontSize = 14.5.sp,
                                color = Color.Gray
                            )


                        }
                    }
                }

            }


        }
    }
}