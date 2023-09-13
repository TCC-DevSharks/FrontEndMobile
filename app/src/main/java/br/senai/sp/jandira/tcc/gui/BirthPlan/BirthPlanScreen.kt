package br.senai.sp.jandira.tcc.gui.BirthPlan

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.CardCategoryPreparativos
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation

@Composable
fun BirthPlanScreen(navController: NavController) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp)
        ) {

            Header(titulo = stringResource(id = R.string.header_birth_plan))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(
                        Color(182, 182, 246),
                        shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                    )
                    .padding(vertical = 9.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Row() {

                            Card(
                                modifier = Modifier
                                    .size(85.dp),
                                shape = CircleShape,
                                border = BorderStroke(4.dp, Color.White)

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.avia),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )

                            }
                        }

                        Row(modifier = Modifier.padding(top = 10.dp, start = 25.dp, end = 25.dp)) {

                            Text(
                                text = "Enxoval de Paula",
                                fontWeight = FontWeight(900),
                                fontSize = 27.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )

                        }

                    }



                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Button(
                            onClick =
                            {
//                        onclick(navController)
                            },
                            modifier = Modifier
                                .width(135.dp)
                                .height(35.dp),
                            colors = ButtonDefaults.buttonColors(Color(236, 238, 255)),

                            shape = RoundedCornerShape(16.dp),

                            ) {
                            Text(
                                text = "2 Itens",
                                color = Color(182, 182, 246),
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            CardCategoryPreparativos()
            CardCategoryPreparativos()
            CardCategoryPreparativos()
            CardCategoryPreparativos()
            CardCategoryPreparativos()
            CardCategoryPreparativos()
            CardCategoryPreparativos()
            CardCategoryPreparativos()
            CardCategoryPreparativos()
            CardCategoryPreparativos()
            CardCategoryPreparativos()


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

//@Preview (showSystemUi = true, showBackground = true)
//@Composable
//fun BirthPlanScreenPreview() {
//    BirthPlanScreen()
//
//}