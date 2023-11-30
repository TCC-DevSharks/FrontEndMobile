package br.senai.sp.jandira.tcc

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.calls.PostForumTopic
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.forum.topic.PostTopic
import br.senai.sp.jandira.tcc.model.forum.topic.ResponseTopicList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun testezinho() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 35.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.arrow_circle),
                    contentDescription = null,
                    tint = Color(182, 182, 246),
                    modifier = Modifier
                        .size(40.dp),
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Fórum",
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    fontWeight = FontWeight(700)
                )
            }
        }

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
//                        AsyncImage(
//                            model = it.user.foto,
//                            contentDescription = "",
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier.fillMaxSize()
//                        )
                }
                Column {
                    Row(modifier = Modifier.padding(start = 15.dp, top = 2.dp)) {
                        Text(
                            text = "Titulo",
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(modifier = Modifier.padding(start = 15.dp)) {
                        Text(
                            text = "categoria: X",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Column {
                Row(modifier = Modifier.padding(horizontal = 20.dp)) {
                    Text(text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. ")
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun testezinhoPreview() {
    testezinho()
}