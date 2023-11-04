package br.senai.sp.jandira.tcc.gui.mobileGestation.chatFlow.contacts

import SocketManager
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.GetChatProfissional
import br.senai.sp.jandira.tcc.calls.GetChatUser
import br.senai.sp.jandira.tcc.calls.GetMsg
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.chatMesssages.ChatModel
import br.senai.sp.jandira.tcc.model.chatUser.ChatUserResponse
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordAll
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordDataConsult
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordListDataConsult
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionResponse
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Response

@Composable
fun ContatosScreen(navController: NavController, pregnant: ModelPregnant, chatModel: ChatModel) {

    LaunchedEffect(Unit) {
        Consult(pregnant)
        GetChatUser(pregnant.email, chatModel)


    }

    var consult by remember { mutableStateOf(listOf<MedicalRecordDataConsult>()) }
    if (pregnant.consult.isNotEmpty()) {
        pregnant.consult.map { pgconsult ->
            if (!consult.any { it.emailProfissional == pgconsult.emailProfissional }) {
                consult = consult + pgconsult
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp, top = 24.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

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
                                model = pregnant.foto,
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape)
                            )
                        }

                    }
                }

                Row() {


                    Box(
                        modifier = Modifier
                            .background(Color(182, 182, 246), CircleShape)
                            .size(40.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.search_branco),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                        )
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
            if (consult.isNotEmpty()) {


                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 25.dp)
                ) {
                    items(consult) {

                        var profissional by remember { mutableStateOf("") }

                        val call = RetrofitFactory().ChatService().getUser(it.emailProfissional, "Profissional")

                        call.enqueue(object : retrofit2.Callback<ChatUserResponse> {
                            override fun onResponse(
                                call: Call<ChatUserResponse>,
                                response: Response<ChatUserResponse>

                            ) {

                                chatModel.profissional = response.body()!!._id;
                                profissional = response.body()!!._id;
                            }

                            override fun onFailure(call: Call<ChatUserResponse>, t: Throwable) {
                                Log.i(
                                    "ds2m",
                                    "onFailure: ${t.message}"
                                )
                                println(t.message + t.cause)
                            }
                        })

                        GetMsg(chatModel.user,profissional, chatModel)

                        Row(modifier = Modifier.padding(vertical = 9.dp)) {

                            Card(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(390.dp, 80.dp)
                                    .clickable {
                                        chatModel.foto = it.foto
                                        chatModel.nomeProfissional = it.profissional
                                        navController.navigate("messagesChat")
                                               },
                                colors = CardDefaults.cardColors(Color(182, 182, 246, 65)),
                            ) {

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(horizontal = 11.dp),
                                    verticalArrangement = Arrangement.Center,
                                ) {

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 10.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Card(
                                            modifier = Modifier
                                                .size(58.dp),
                                            shape = CircleShape,
                                        ) {

                                            AsyncImage(
                                                model = it.foto,
                                                contentDescription = "",
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .size(100.dp)
                                                    .clip(CircleShape)
                                            )

                                        }

                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(vertical = 10.dp)
                                        ) {

                                            Row(verticalAlignment = Alignment.CenterVertically) {

                                                Text(
                                                    modifier = Modifier.padding(start = 26.dp),
                                                    text = it.profissional,
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold
                                                )

                                                Text(
                                                    modifier = Modifier.padding(start = 12.dp),
                                                    text = it.clinica,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(157, 157, 156),

                                                    )
                                            }
//                                            Row(
//                                                verticalAlignment = Alignment.CenterVertically,
//                                                horizontalArrangement = Arrangement.SpaceBetween,
//                                                modifier = Modifier
//                                                    .padding(vertical = 13.dp)
//                                                    .fillMaxWidth()
//                                            ) {
//
//                                                Text(
//                                                    modifier = Modifier.padding(start = 26.dp),
//                                                    text = "You have to be more carefull...",
//                                                    fontSize = 11.sp,
//                                                    color = Color(157, 157, 156),
//                                                    fontWeight = FontWeight.Bold
//                                                )

//                                                Row(verticalAlignment = Alignment.CenterVertically) {
//
//                                                    Box(
//                                                        modifier = Modifier
//                                                            .background(Color(182, 182, 246), CircleShape)
//                                                            .size(7.dp),
//                                                        contentAlignment = Alignment.Center
//                                                    ) {}
//                                                    Text(
//                                                        modifier = Modifier.padding(
//                                                            start = 5.dp,
//                                                            end = 15.dp
//                                                        ),
//                                                        text = "27 Oct",
//                                                        fontSize = 11.sp,
//                                                        color = Color(157, 157, 156),
//                                                        fontWeight = FontWeight.Bold
//                                                    )
//                                                }

//                                            }

                                        }


                                    }


                                }


                            }

                        }
                    }
                }

            }


//
//
//            Row(
//                modifier = Modifier.padding(horizontal = 25.dp, vertical = 20.dp)
//            ) {
//                Text(
//                    text = stringResource(id = R.string.All_Messages),
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight(900)
//                )
//            }

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

            Navigation(navController = navController, pregnant)


        }


    }


}

fun Consult(pregnant: ModelPregnant) {

    val call = RetrofitFactory().consult().getConsultPatient(pregnant.id)

    call.enqueue(object : retrofit2.Callback<MedicalRecordListDataConsult> {
        override fun onResponse(
            call: Call<MedicalRecordListDataConsult>,
            response: Response<MedicalRecordListDataConsult>

        ) {
            pregnant.consult = response.body()!!.gestante
        }

        override fun onFailure(call: Call<MedicalRecordListDataConsult>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

fun FindUserPregnant(pregnant: ModelPregnant, chatModel: ChatModel) {

    val call = RetrofitFactory().ChatService().getUser(pregnant.email, "Gestante")

    call.enqueue(object : retrofit2.Callback<ChatUserResponse> {
        override fun onResponse(
            call: Call<ChatUserResponse>,
            response: Response<ChatUserResponse>

        ) {
            chatModel.user = response.body()!!._id
        }

        override fun onFailure(call: Call<ChatUserResponse>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}