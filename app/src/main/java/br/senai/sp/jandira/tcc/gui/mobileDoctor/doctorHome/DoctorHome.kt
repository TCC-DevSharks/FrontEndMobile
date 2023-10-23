package br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorHome

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.GetProfessional
import br.senai.sp.jandira.tcc.componentes.NavigationDoctor
import br.senai.sp.jandira.tcc.componentes.NavigationNutritionist
import br.senai.sp.jandira.tcc.componentes.ScheduleDoctor
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.model.professional.ProfessionalSpecialityResponse
import br.senai.sp.jandira.tcc.model.professional.ProfessionalSpecialityResponseList
import br.senai.sp.jandira.tcc.model.schedule.ModelSchedule
import br.senai.sp.jandira.tcc.model.schedule.Schedule
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun DoctorHome(
    professional: Professional,
    navController: NavController,
) {

    LaunchedEffect(Unit) {
        GetProfessional(professional)
    }


    var agenda by remember {
        mutableStateOf(listOf<Schedule>())
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(modifier = Modifier.fillMaxSize().padding(bottom = 90.dp)) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(325.dp),
                    shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
                    colors = CardDefaults.cardColors(Color(182, 182, 246, 50))
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Row(modifier = Modifier.padding(top = 38.dp)) {
                            Text(
                                text = stringResource(id = R.string.Welcome),
                                fontSize = 20.5.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center

                            )
                        }

                        Spacer(modifier = Modifier.height(5.dp))
                        Row() {
                            Text(
                                text = professional.nome,
                                fontSize = 29.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(182, 182, 246),
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center

                            )
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Box() {
                                Card(
                                    modifier = Modifier.size(100.dp),
                                    shape = CircleShape,
                                    border = BorderStroke(3.5.dp, Color(182, 182, 246))

                                ) {
                                    AsyncImage(
                                        model = professional.foto,
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clip(CircleShape)
                                            .clickable {
                                                navController.navigate("profileDoctor")
                                            }
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Row() {
                            Text(
                                text = professional.clinica,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                        Spacer(modifier = Modifier.height(5.5.dp))

                        Row() {
                            Text(
                                text = professional.especialidade,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(182, 182, 246),
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                        Spacer(modifier = Modifier.height(5.5.dp))

                        Row() {
                            Text(
                                text = professional.crm,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Gray,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(50.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .width(160.dp)
                        .height(3.2.dp)
                        .background(
                            Color(182, 182, 246),
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

            ScheduleDoctor(professional)

            Spacer(modifier = Modifier.height(50.dp))


        }

        if (professional.especialidade == "Nutricionista") {

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

                NavigationNutritionist(navController = navController)
            }

        } else {

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

                NavigationDoctor(navController = navController)
            }

        }

    }

}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun DoctorHomePreview() {
//    DoctorHome(professional = )
//}