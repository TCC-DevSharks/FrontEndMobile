package br.senai.sp.jandira.tcc.gui.mobileGestation.chatFlow.messages

import SocketManager
import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.GetMsg
import br.senai.sp.jandira.tcc.calls.SendMsg
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.componentes.Chat
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.chatMesssages.ChatModel
import br.senai.sp.jandira.tcc.model.mongoDb.ChatDbResponse
import coil.compose.AsyncImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalTime


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessagesScreen(navController: NavController, pregnant: ModelPregnant, chatModel: ChatModel){
    val socketManager = SocketManager()
    var user = chatModel.user
    var profissional = chatModel.profissional
    var effect by remember { mutableStateOf(true) }
    val scrollState = rememberLazyListState()

    socketManager.handleMsgReceive {
        GetMsg(user, profissional, chatModel)
    }

    var msg by remember { mutableStateOf(listOf<ChatDbResponse>()) }
    msg =  chatModel.msgs

    LaunchedEffect(msg) {
        val lastIndex = msg.size.toFloat() * 200
        if (lastIndex >= 0) {
            scrollState.animateScrollBy(lastIndex, tween(5000))
        }
    }

    LaunchedEffect(Unit){
        GetMsg(user, profissional, chatModel)
        socketManager.connect()
        socketManager.addUser(user)
    }

    LaunchedEffect(effect){
        delay(500)
        GetMsg(user, profissional, chatModel)
    }



    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom = 70.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp, top = 27.dp),
                verticalAlignment = CenterVertically
            ) {

                ArrowLeft(navController = navController, rota = "contactsChat")


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 49.dp),
                    verticalAlignment = CenterVertically,
                ) {

                    Card(
                        modifier = Modifier
                            .size(45.dp),
                        shape = CircleShape,
                        border = BorderStroke(1.5.dp, Color(182, 182, 246)),


                        ) {
                        AsyncImage(
                            model = chatModel.foto,
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                        )

                    }

                    Text(
                        text = chatModel.nomeProfissional,
                        fontSize = 19.sp,
                        fontWeight = FontWeight(900),
                        modifier = Modifier.padding(start = 12.dp)
                    )
                }

            }


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 10.dp),
                state = scrollState
            ) {
                items(msg){
                    Chat(messageText = it.text, sender = it.sender, currentUser = chatModel.user, fotoPregnant = pregnant.foto, fotoProfissional = chatModel.foto)
                }
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 28.dp, vertical = 10.dp),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            var message by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                value = message,
                onValueChange = {
                    message = it
                },
                modifier = Modifier
                    .size(280.dp, 60.dp),
                shape = RoundedCornerShape(10.dp),
                label = {
                    Text(
                        text = "",
                        fontSize = 14.sp,
                        color = Color(102, 97, 97, 95)
                    )
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

            Box(
                modifier = Modifier
                    .background(Color(182, 182, 246), CircleShape)
                    .size(38.dp)
                    .clickable {
                        CoroutineScope(Dispatchers.IO).launch {
                            socketManager.connect()
                            socketManager.sendMsg(profissional, message)
                            SendMsg(text = message, users = listOf(user, profissional), sender = user, timestamp = LocalTime.now() )
                            effect = !effect

                            Log.e("", "$msg")
                            message = ""

                        }
                    }, contentAlignment = Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.plane2),
                    contentDescription = null,
                    modifier = Modifier
                        .size(19.dp)
                        .padding(end = 2.5.dp),
                )
            }
        }

    }

}