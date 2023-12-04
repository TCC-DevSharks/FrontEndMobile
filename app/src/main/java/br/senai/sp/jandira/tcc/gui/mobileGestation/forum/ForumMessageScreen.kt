package br.senai.sp.jandira.tcc.gui.mobileGestation.forum

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import br.senai.sp.jandira.tcc.calls.GetCategorys
import br.senai.sp.jandira.tcc.calls.GetForumTopic
import br.senai.sp.jandira.tcc.calls.PostForumTopic
import br.senai.sp.jandira.tcc.calls.PostMessageForum
import br.senai.sp.jandira.tcc.calls.SendMsg
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.forum.ModelForum
import br.senai.sp.jandira.tcc.model.forum.category.ResponseCategory
import br.senai.sp.jandira.tcc.model.forum.messages.PostMessages
import br.senai.sp.jandira.tcc.model.forum.topic.PostTopic
import br.senai.sp.jandira.tcc.model.forum.topic.ResponseMessage
import br.senai.sp.jandira.tcc.model.forum.topic.ResponseMessageTopic
import br.senai.sp.jandira.tcc.model.forum.topic.ResponseMessageTopicList
import br.senai.sp.jandira.tcc.model.forum.topic.ResponseTopic
import br.senai.sp.jandira.tcc.model.forum.topic.ResponseTopicList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForumMessageScreen(navController: NavController, pregnant: ModelPregnant, forum: ModelForum) {

    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var mensagens by remember { mutableStateOf(listOf<ResponseMessage>()) }
    var textoMensagem by remember { mutableStateOf("") }

    LaunchedEffect(textoMensagem){
        val call = RetrofitFactory().Forum().getMessageTopics(forum.mensagemId)

        call.enqueue(object : retrofit2.Callback<ResponseMessageTopicList> {
            override fun onResponse(
                call: Call<ResponseMessageTopicList>,
                response: Response<ResponseMessageTopicList>

            ) {
                Log.e("forum","${response.body()}")
                if (response.isSuccessful){
                    title = response.body()!!.topic.title
                    text = response.body()!!.topic.text
                    date = response.body()!!.topic.date
                    category = response.body()!!.topic.category
                    mensagens = response.body()!!.topic.messages
                }

            }

            override fun onFailure(call: Call<ResponseMessageTopicList>, t: Throwable) {
                Log.i(
                    "ds2m",
                    "onFailure: ${t.message}"
                )
                println(t.message + t.cause)
            }
        })
    }
    Scaffold(bottomBar = {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            OutlinedTextField(
                value = textoMensagem,
                onValueChange = {textoMensagem = it},
                modifier = Modifier.fillMaxWidth(0.85f)
            )

            Box(
                modifier = Modifier
                    .background(Color(182, 182, 246), CircleShape)
                    .size(45.dp)
                    .fillMaxWidth(0.15f)
                    .clickable {
                        var msg = PostMessages(
                            topic = forum.mensagemId,
                            user = forum._id,
                            date = LocalDateTime
                                .now(ZoneId.of("America/Sao_Paulo"))
                                .toString(),
                            text = textoMensagem
                        )

                        PostMessageForum(msg)
                        textoMensagem = ""
                    },
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.plane2),
                    contentDescription = null,
                    modifier = Modifier
                        .size(19.dp)
                )
            }

        }
    }) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Header(
                    titulo = stringResource(id = R.string.header_forum),
                    rota = "",
                    navController = navController
                )

                Card(
                    modifier = Modifier
                        .width(400.dp)
                        .height(200.dp)
                        .padding(vertical = 8.dp, horizontal = 10.dp),
                    colors = CardDefaults.cardColors(Color(182, 182, 246, 30)),

                    ) {
                    Row(
                        modifier = Modifier.padding(14.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .size(60.dp),
                            shape = CircleShape,
                            border = BorderStroke(1.5.dp, Color.Black),

                            ) {
                        AsyncImage(
                            model = pregnant.foto,
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        }
                        Column {
                            Row(modifier = Modifier.padding(start = 15.dp, top = 2.dp)) {
                                Text(
                                    text = title,
                                    fontSize = 23.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Row(modifier = Modifier.padding(start = 15.dp)) {
                                Text(
                                    text = category,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Column {
                        Row(modifier = Modifier.padding(horizontal = 20.dp)) {
                            Text(text = text)
                        }
                    }
                }

//                Card(
//                    modifier = Modifier
//                        .padding(10.dp),
//                    border = BorderStroke(2.5.dp, Color(182, 182, 246))
//
//                ) {
//                    Column {
//                        Row(
//                            modifier = Modifier
//                                .padding(horizontal = 20.dp, vertical = 10.dp)
//                        ) {
//                            Card(
//                                modifier = Modifier
//                                    .size(65.dp),
//                                shape = CircleShape,
//                                border = BorderStroke(2.5.dp, Color(182, 182, 246))
//
//                            ) {
//                                AsyncImage(
//                                    model = pregnant.foto,
//                                    contentDescription = "",
//                                    contentScale = ContentScale.Crop,
//                                    modifier = Modifier
//                                        .size(65.dp)
//                                        .clip(CircleShape)
//                                )
//                            }
//
//                            Row(modifier = Modifier
//                                .fillMaxWidth()
//                                .heightIn(30.dp, 80.dp)
//                                .verticalScroll(rememberScrollState()),
//                                horizontalArrangement = Arrangement.Center,
//                                verticalAlignment = Alignment.CenterVertically
//                            ) {
//                                Text(text = title,
//                                    fontSize = 20.sp,
//                                    fontWeight = FontWeight.Bold)
//                            }
//                        }
//                        Row(modifier = Modifier
//                            .heightIn(30.dp, 250.dp)
//                            .verticalScroll(rememberScrollState())
//                            .padding(5.dp)
//                        ) {
//                            Text(text = text)
//                        }
//
//                        Row (modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(5.dp),
//                            horizontalArrangement = Arrangement.SpaceBetween
//                        ){
//                            Text(text = category)
//
//                            Text(text = date)
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(10.dp))
//                }

                if (mensagens.isNotEmpty()){
                    LazyColumn{
                        items(mensagens){
                            Card(
                                modifier = Modifier
                                    .fillMaxSize(1f)
                                    .padding(vertical = 8.dp),
                                colors = CardDefaults.cardColors(Color(182, 182, 246, 23)),

                                ) {
                                Row(
                                    modifier = Modifier.padding(14.dp)
                                ){
                                    Card(
                                        modifier = Modifier
                                            .size(55.dp),
                                        shape = CircleShape,
                                        border = BorderStroke(1.5.dp, Color.Black),

                                        ) {
                                        AsyncImage(
                                            model = it.user.foto,
                                            contentDescription = "",
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }

                                    Column(modifier = Modifier.padding(horizontal = 14.dp)) {

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically,
                                        ) {

                                            Text(
                                                text = it.user.username,
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight(800)
                                            )
                                            Text(
                                                text = it.date,
                                                modifier = Modifier.padding(start = 14.dp),
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight(400),
                                                color = Color(209, 209, 214)
                                            )
                                        }

                                        Row(modifier = Modifier.padding(top = 5.5.dp)) {
                                            Text(
                                                text = it.text,
                                                fontSize = 13.5.sp,
                                                fontWeight = FontWeight(300),
                                                lineHeight = 19.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else{
                    Column {}
                }
            }
        }

    }
}