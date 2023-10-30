package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowMedicalRecord

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.medicalRecord.ConsultListMedicalRecord
import br.senai.sp.jandira.tcc.model.medicalRecord.ConsultResponseMedicalRecord
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun selectMedicalRecord(professional: Professional, navController: NavController) {

    var pacientes by rememberSaveable {
        mutableStateOf(listOf<ConsultResponseMedicalRecord>())
    }

    var searchText by remember { mutableStateOf("") }

    val pacientesFiltrados = pacientes.filter { it.nome.contains(searchText, ignoreCase = true) }
        .distinctBy { it.idGestante }


    var call = RetrofitFactory().insertConsult().getConsultMedicalRecord(professional.id)

    call.enqueue(object : Callback<ConsultListMedicalRecord> {
        override fun onResponse(
            call: Call<ConsultListMedicalRecord>,
            response: Response<ConsultListMedicalRecord>
        ) {
            pacientes = response.body()!!.pacientes

        }

        override fun onFailure(call: Call<ConsultListMedicalRecord>, t: Throwable) {
            Log.i("paciente", "${t.message}")
        }
    })

    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Header(titulo = stringResource(id = R.string.medical_record))
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                modifier = Modifier
                    .width(355.dp),
                shape = RoundedCornerShape(40.dp),
                label = {
                    Text(stringResource(id = R.string.search_patient))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(243, 243, 243),
                    focusedIndicatorColor = Color(243, 243, 243),
                    unfocusedIndicatorColor = Color(243, 243, 243)
                ),
                singleLine = true
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn {
                items(pacientesFiltrados) { paciente ->
                    Card(
                        modifier = Modifier
                            .width(340.dp)
                            .clickable {
                                navController.navigate("medicalRecordSelectDate/${paciente.idGestante}")
                            }
                            .height(85.dp)
                            .padding(bottom = 14.dp),
                        colors = CardDefaults.cardColors(Color(255, 255, 255)),
                        border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            Modifier
                                .fillMaxSize()
                                .padding(start = 20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = paciente.foto,
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(45.dp)
                                    .clip(CircleShape)
                            )

                            Spacer(modifier = Modifier.width(25.dp))

                            Column {
                                Text(
                                    text = paciente.nome,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 15.sp,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}