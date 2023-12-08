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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.GetChatProfissional
import br.senai.sp.jandira.tcc.calls.GetChatUser
import br.senai.sp.jandira.tcc.calls.GetMsg
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.chatMesssages.ChatModel
import br.senai.sp.jandira.tcc.model.chatUser.ChatUserResponse
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordAll
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordDataConsult
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordListDataConsult
import br.senai.sp.jandira.tcc.model.mongoDb.ChatDbResponse
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionResponse
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
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

    var searchText by remember { mutableStateOf("") }

    val consultFiltrados = consult.filter { it.profissional.contains(searchText, ignoreCase = true) }


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

                    ArrowLeft(navController = navController, rota = "homeUser")
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
                        Text(stringResource(id = R.string.search_doctor))
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


            if (consult.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 25.dp)
                ) {
                    items(consultFiltrados) {
                        Row(modifier = Modifier.padding(vertical = 9.dp)) {

                            Card(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(390.dp, 80.dp)
                                    .clickable {

                                        val call = RetrofitFactory().ChatService().getUser(it.emailProfissional, "Profissional")

                                        call.enqueue(object : retrofit2.Callback<ChatUserResponse> {
                                            override fun onResponse(
                                                call: Call<ChatUserResponse>,
                                                response: Response<ChatUserResponse>

                                            ) {

                                                chatModel.profissional = response.body()!!._id;
                                                Log.e("oi","${chatModel.profissional}")
                                            }

                                            override fun onFailure(call: Call<ChatUserResponse>, t: Throwable) {
                                                Log.i(
                                                    "ds2m",
                                                    "onFailure: ${t.message}"
                                                )
                                                println(t.message + t.cause)
                                            }
                                        })


                                        chatModel.msgs = emptyList()
                                        chatModel.foto = it.foto
                                        chatModel.nomeProfissional = it.profissional


                                        CoroutineScope(Dispatchers.Main).launch{
//                                            delay(800)
                                            navController.navigate("messagesChat")
                                        }

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
                                                .padding(vertical = 10.dp),
                                            verticalArrangement = Arrangement.SpaceBetween
                                        ) {

                                            Column(verticalArrangement = Arrangement.SpaceAround,
                                                modifier = Modifier.fillMaxSize()) {

                                                Text(
                                                    modifier = Modifier.padding(start = 26.dp),
                                                    text = it.profissional,
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold
                                                )

                                                Text(
                                                    modifier = Modifier.padding(start = 26.dp),
                                                    text = it.clinica,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(157, 157, 156),

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
            Log.i("fgfgfg", "${pregnant.consult}")
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