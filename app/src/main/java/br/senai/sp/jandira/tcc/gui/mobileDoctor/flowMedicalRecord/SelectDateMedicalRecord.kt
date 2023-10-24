package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowMedicalRecord

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.professional.Professional
import coil.compose.AsyncImage

@Composable
fun SelectDateMedicalRecord(navController: NavController, professional: Professional, idGestante: Int?) {

    Column(modifier = Modifier.fillMaxSize()) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val idGestante = navBackStackEntry?.arguments?.getInt("idGestante")

        Log.i("gestante", "$idGestante")


        Header(titulo = stringResource(id = R.string.medical_record))

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.select_consult),
                fontSize = 17.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Card(
                modifier = Modifier
                    .width(340.dp)
                    .clickable {
//                        navController.navigate("")
                    }
                    .height(85.dp)
                    .padding(bottom = 14.dp),
                colors = CardDefaults.cardColors(Color(255, 255, 255)),
                border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                shape = RoundedCornerShape(16.dp),
            ) {

                Row(
                    modifier = Modifier
                        .padding(start = 18.dp)
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Row (modifier = Modifier
                            .background(Color(182, 182, 246),
                        shape = RoundedCornerShape(10.dp)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center) {

                        Text(
                            text = "Ingrid yty",
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .background(
                                    Color(182, 182, 246),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(10.dp)
                        )
                    }

                    Column (verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(start = 17.dp)) {

                        Text(text = stringResource(id = R.string.date) + " " + "06/10/2023",
                            fontWeight = FontWeight(400),
                            fontSize = 14.5.sp,
                            color = Color.Gray,
                            )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = stringResource(id = R.string.hour) + " " + "17:30",
                            fontWeight = FontWeight(400),
                            fontSize = 14.5.sp,
                            color = Color.Gray)


                    }
                }
            }
        }
    }
}