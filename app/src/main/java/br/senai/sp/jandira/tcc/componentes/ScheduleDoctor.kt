package br.senai.sp.jandira.tcc.componentes

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.model.consult.ConsultList
import br.senai.sp.jandira.tcc.model.consult.ConsultResponsePaciente
import br.senai.sp.jandira.tcc.model.medicalRecord.ModelMedicalRecord
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ScheduleDoctor(professional: Professional, navController: NavController, medicalRecord: ModelMedicalRecord) {

    var pacientes by rememberSaveable {
        mutableStateOf(listOf<ConsultResponsePaciente>())
    }

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dataAtual = LocalDate.now()

    LaunchedEffect(Unit) {
        val call = RetrofitFactory().consult().getConsult(professional.id)

        call.enqueue(object : Callback<ConsultList> {
            override fun onResponse(
                call: Call<ConsultList>,
                response: Response<ConsultList>
            ) {
                pacientes = response.body()!!.pacientes
                println(pacientes)

            }

            override fun onFailure(call: Call<ConsultList>, t: Throwable) {
                Log.i("hgf", "${pacientes}")
            }
        })
    }



    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Card(
            modifier = Modifier
                .width(360.dp)
                .height(184.dp),
            colors = CardDefaults.cardColors(Color.White),
            border = BorderStroke(2.dp, Color(182, 182, 246, 38))
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = stringResource(id = R.string.your_consultations),
                        fontSize = 17.sp,
                        modifier = Modifier.padding(start = 18.dp),
                        fontWeight = FontWeight.SemiBold,
                    )

                }
            }
            LazyColumn() {
                items(pacientes.filter { paciente ->

                    val dataConsulta = LocalDate.parse(paciente.dia, formatter)
                    dataAtual == dataConsulta
                }) { paciente ->

                    var isChecked by remember { mutableStateOf(false) }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 19.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                modifier = Modifier.height(30.dp),
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = Color(182, 182, 246),
                                    checkedColor = Color(182, 182, 246),
                                    uncheckedColor = Color(182, 182, 246)
                                )
                            )

                            LimitedText(text = paciente.nome, maxLength = 25) {
                                medicalRecord.id_paciente = paciente.idGestante
                                navController.navigate("patientProfile")                            }
                        }

                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "${paciente.hora.take(5)}h",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )
                        }
                    }
                }
            }

        }

    }
}