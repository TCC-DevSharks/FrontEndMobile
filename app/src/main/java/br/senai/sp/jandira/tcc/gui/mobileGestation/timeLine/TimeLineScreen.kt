package br.senai.sp.jandira.tcc.gui.mobileGestation.timeLine

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
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
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun TimeLineScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Header(
                titulo = stringResource(id = R.string.timeline),
                rota = "homeUser",
                navController = navController
            )

            Spacer(modifier = Modifier.height(10.dp))

            var selectedItem by remember { mutableStateOf(-1) }

            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(40) { index ->
                    val number = index + 1

                    val isItemSelected = index == selectedItem

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .size(75.dp, 35.dp)
                            .fillMaxSize()
                            .clickable {
                                selectedItem = index
                            }
                            .background(
                                if (isItemSelected) Color(182, 182, 246) else Color(249, 246, 244),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .graphicsLayer(
                                    clip = true,
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "$number",
                                fontWeight = FontWeight(500),
                                fontSize = 17.sp,
                                color = if (isItemSelected) Color.White else Color.Black
                            )
                        }
                    }

                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chat_cinza),
                    contentDescription = null,
                    modifier = Modifier
                        .size(27.dp)
                )
                Text(
                    modifier = Modifier.padding(start = 14.dp),
                    text = "Seu bebê tem o tamanho de uma framboesa",
                    fontSize = 14.5.sp,
                    fontWeight = FontWeight(500),
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Column(modifier = Modifier.padding(horizontal = 20.dp)) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(Color.Transparent)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit,
                        painter = painterResource(id = R.drawable.feto_preview),
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Column(modifier = Modifier.fillMaxSize()) {

                    Card(
                        modifier = Modifier
                            .fillMaxSize(1f),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(Color(182, 182, 246, 40))
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Text(
                                    text = "Desenvolvimento",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(900),
                                    fontSize = 15.sp,
                                    color = Color(182, 182, 246)
                                )
                            }

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Text(
                                    text = "A genitália deixa de ser ambigua e começa a diferenciação do sexo.",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(600),
                                    fontSize = 13.sp,
                                    color = Color.Black,
                                    lineHeight = 15.sp

                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Text(
                                    text = "Agenda",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(900),
                                    fontSize = 15.sp,
                                    color = Color(182, 182, 246)
                                )
                            }

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Text(
                                    text = "Exames de sangue e de urina devem ser realizados para verificar as condições de saúde da mamãe.",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(600),
                                    fontSize = 13.sp,
                                    color = Color.Black,
                                    lineHeight = 15.sp

                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Text(
                                    text = "Quantos meses?",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(900),
                                    fontSize = 15.sp,
                                    color = Color(182, 182, 246)
                                )
                            }

                            Row(modifier = Modifier.fillMaxWidth()) {

                                Text(
                                    text = "8 semanas de gravidez são 2 meses. Com a semana 8 da gravidez, você está na semana final do mês 2 da sua gestação.",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(600),
                                    fontSize = 13.sp,
                                    color = Color.Black,
                                    lineHeight = 15.sp

                                )
                            }
                        }
                    }
                }
            }
        }
    }
}