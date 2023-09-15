package br.senai.sp.jandira.tcc.gui.MobileGestation.ConsultationFlow.Doctor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.TextComp

@Composable
fun ConsultationDoctorScreen(navController: NavController) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            Header(titulo = stringResource(id = R.string.header_speciality),
                tintIcon = Color(255, 218, 185)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(.3.dp)
            ) {}

            Spacer(modifier = Modifier.height(60.dp))

            Row(modifier = Modifier.padding(horizontal = 50.dp, vertical = 2.dp)) {

                TextComp(
                    texto = R.string.title_doctor,
                    fontSize = 21.sp,
                    fontWeight = FontWeight(400)
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Column(modifier = Modifier.verticalScroll(rememberScrollState()).
            padding(bottom = 95.dp)) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .size(390.dp, 80.dp),
//                        border = BorderStroke(2.5.dp, Color(236, 236, 255)),
                        colors = CardDefaults.cardColors(Color(182, 182, 246)),
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

                                    Image(
                                        painter = painterResource(id = R.drawable.gravidinha),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                    )

                                }

                                Text(
                                    modifier = Modifier.padding(start = 16.dp),
                                    text = "Dr Rebbeka",
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold
                                )

                            }


                        }


                    }

                }




            }


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

                Navigation(navController = navController)


        }


    }

}

//@Preview
//@Composable
//fun ConsultationDoctorScreenPreview() {
//    ConsultationDoctorScreen()
//}