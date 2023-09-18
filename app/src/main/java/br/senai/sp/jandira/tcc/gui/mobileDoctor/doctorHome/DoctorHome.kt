package br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorHome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun DoctorHome() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(290.dp),
                shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
                colors = CardDefaults.cardColors(Color(255, 181, 115, 50))
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier.padding(top = 30.dp)) {
                        Text(
                            text = "Bem-Vinda,",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold

                        )
                    }
                    Row() {
                        Text(
                            text = "Dr. Alvia Oliveira",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(242, 187, 137)

                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box() {
                            Card(
                                modifier = Modifier.size(100.dp),
                                shape = CircleShape,
                                border = BorderStroke(3.5.dp, Color(255, 218, 185))

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.avia),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row() {
                        Text(
                            text = "Clinica Amil, Nutricionista",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Row() {
                        Text(
                            text = "123.567.09",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .width(160.dp)
                    .height(3.2.dp)
                    .background(
                        Color(255, 218, 185),
                        shape = RoundedCornerShape(
                            topStart = 2.dp,
                            topEnd = 2.dp,
                            bottomStart = 2.dp,
                            bottomEnd = 2.dp
                        )

                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {}
        }

        Spacer(modifier = Modifier.height(50.dp))


        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Card(
                modifier = Modifier
                    .width(360.dp)
                    .height(240.dp),
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(2.dp, Color(182, 182, 246, 38))
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

//                        Image(
//                            painter = painterResource(id = R.drawable.calendar),
//                            contentDescription = null,
//                            modifier = Modifier.size(30.dp)
//                        )

                        Column(
                            modifier = Modifier.padding(start = 5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Text(
                                text = "Suas consultas da semana:",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )



                        }

                    }

//               AddItem(navController = navController, rota = "", size = 30.dp)
                }
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 19.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            var isChecked by remember { mutableStateOf(false) }

                            Checkbox(
                                modifier = Modifier.height(30.dp),
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = Color(255, 218, 185,),
                                    checkedColor = Color(255, 218, 185,), // Cor quando marcado
                                    uncheckedColor = Color(255, 218, 185,) // Cor quando não marcado
                                )
                            )

                            Text(
                                text = "Lorem ipsum dolor",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium
                            )

                        }

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "30/09",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )
                        }

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 19.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            var isChecked by remember { mutableStateOf(false) }

                            Checkbox(
                                modifier = Modifier.height(30.dp),
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = Color(255, 218, 185,),
                                    checkedColor = Color(255, 218, 185,), // Cor quando marcado
                                    uncheckedColor = Color(255, 218, 185,) // Cor quando não marcado
                                )
                            )

                            Text(
                                text = "Lorem ipsum dolor",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium
                            )

                        }

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "30/09",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )
                        }

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 19.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            var isChecked by remember { mutableStateOf(false) }

                            Checkbox(
                                modifier = Modifier.height(30.dp),
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = Color(255, 218, 185,),
                                    checkedColor = Color(255, 218, 185,), // Cor quando marcado
                                    uncheckedColor = Color(255, 218, 185,) // Cor quando não marcado
                                )
                            )

                            Text(
                                text = "Lorem ipsum dolor",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium
                            )

                        }

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "30/09",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )
                        }

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 19.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            var isChecked by remember { mutableStateOf(false) }

                            Checkbox(
                                modifier = Modifier.height(30.dp),
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = Color(255, 218, 185,),
                                    checkedColor = Color(255, 218, 185,), // Cor quando marcado
                                    uncheckedColor = Color(255, 218, 185,) // Cor quando não marcado
                                )
                            )

                            Text(
                                text = "Lorem ipsum dolor",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium
                            )

                        }

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "30/09",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )
                        }

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 19.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            var isChecked by remember { mutableStateOf(false) }

                            Checkbox(
                                modifier = Modifier.height(30.dp),
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = Color(255, 218, 185,),
                                    checkedColor = Color(255, 218, 185,), // Cor quando marcado
                                    uncheckedColor = Color(255, 218, 185,) // Cor quando não marcado
                                )
                            )

                            Text(
                                text = "Lorem ipsum dolor",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium
                            )

                        }

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "30/09",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )
                        }

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 19.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            var isChecked by remember { mutableStateOf(false) }

                            Checkbox(
                                modifier = Modifier.height(30.dp),
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = Color(255, 218, 185,),
                                    checkedColor = Color(255, 218, 185,), // Cor quando marcado
                                    uncheckedColor = Color(255, 218, 185,) // Cor quando não marcado
                                )
                            )

                            Text(
                                text = "Lorem ipsum dolor",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium
                            )

                        }

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "30/09",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.End
                            )
                        }

                    }

                }

            }
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DoctorHomePreview() {
    DoctorHome()
}