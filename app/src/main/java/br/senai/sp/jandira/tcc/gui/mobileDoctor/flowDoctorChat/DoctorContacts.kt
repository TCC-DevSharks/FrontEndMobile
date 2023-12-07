package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowDoctorChat

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.chatMesssages.ChatModel
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
fun DoctorContactScreen(navController: NavController, pregnant: ModelPregnant, chatModel: ChatModel, professional: Professional) {

    var pacientes by rememberSaveable {
        mutableStateOf(listOf<ConsultResponseMedicalRecord>())
    }

    var searchText by remember { mutableStateOf("") }

    val pacientesFiltrados = pacientes.filter { it.nome.contains(searchText, ignoreCase = true) }
        .distinctBy { it.idGestante }

    var call = RetrofitFactory().consult().getConsultMedicalRecord(professional.id)

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

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row() {

                    ArrowLeft(navController = navController, rota = "DoctorHome")
                }

                Row() {

                    Box(

                    ) {
                        Card(
                            modifier = Modifier
                                .size(85.dp),
                            shape = CircleShape,
                            border = BorderStroke(4.5.dp, Color(182, 182, 246))

                        ) {
                            AsyncImage(
                                model = professional.foto,
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape)
                            )
                        }

                    }


                }
            }

            Row(
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 20.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.messages),
                    fontSize = 23.sp,
                    fontWeight = FontWeight(900)

                )
            }

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
                        containerColor = Color.White,
                        focusedIndicatorColor = Color(182, 182, 246),
                        unfocusedIndicatorColor = Color(182, 182, 246)
                    ),
                    singleLine = true
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(pacientesFiltrados) {

//                        var profissional by remember { mutableStateOf("") }
//
//                        val call = RetrofitFactory().ChatService().getUser(it.emailProfissional, "Profissional")
//
//                        call.enqueue(object : Callback<ChatUserResponse> {
//                            override fun onResponse(
//                                call: Call<ChatUserResponse>,
//                                response: Response<ChatUserResponse>
//
//                            ) {
//
//                                chatModel.profissional = response.body()!!._id;
//                                profissional = response.body()!!._id;
//
//                                Log.i("", "$profissional")
//                            }
//
//                            override fun onFailure(call: Call<ChatUserResponse>, t: Throwable) {
//                                Log.i(
//                                    "ds2m",
//                                    "onFailure: ${t.message}"
//                                )
//                                println(t.message + t.cause)
//                            }
//                        })

                            Card(
                                modifier = Modifier
                                    .width(340.dp)
                                    .clickable {
                                        navController.navigate("DoctorMessage")
                                    }
                                    .height(85.dp)
                                    .padding(bottom = 14.dp),
                                colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
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
                                        model = it.foto,
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(45.dp)
                                            .clip(CircleShape)
                                    )

                                    Spacer(modifier = Modifier.width(25.dp))

                                    Column {
                                        Text(
                                            text = it.nome,
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