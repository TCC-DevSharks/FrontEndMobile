package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.speciality

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.GetClinic
import br.senai.sp.jandira.tcc.calls.GetEspeciality
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.TextComp
import br.senai.sp.jandira.tcc.model.ModelSpeciality
import br.senai.sp.jandira.tcc.model.clinic.Clinic
import br.senai.sp.jandira.tcc.model.especiality.EspecialityResponseList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Response

@Composable
fun ConsultationSpecialityScreen(navController: NavController, speciality: ModelSpeciality, clinic: Clinic) {

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            Column(
                modifier = Modifier
                    .padding(bottom = 70.dp)
            ) {

                Header(titulo = stringResource(id = R.string.header_speciality),
                    tintIcon = Color(255, 218, 185)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .height(.3.dp)
                ) {

                }

                Spacer(modifier = Modifier.height(60.dp))

                Row(modifier = Modifier.padding(horizontal = 50.dp, vertical = 2.dp)) {

                    TextComp(
                        texto = R.string.which_specialty,
                        fontSize = 21.sp,
                        fontWeight = FontWeight(400)
                    )

                }

                Spacer(modifier = Modifier.height(35.dp))

                LazyColumn(modifier = Modifier.fillMaxWidth().padding(bottom = 14.dp), horizontalAlignment = Alignment.CenterHorizontally){
                    items(speciality.especialidade){
                        Button(
                            onClick =
                            {
                                GetClinic(it.id, clinic)
                                navController.navigate("ConsultClinic")

                            },
                            modifier = Modifier
                                .width(340.dp)
                                .height(70.dp)
                                .padding(bottom = 15.dp),
                            colors = ButtonDefaults.buttonColors(Color(236, 238, 255)),
                            border = BorderStroke(width = 1.dp, color = Color(182,182,246)),


                            shape = RoundedCornerShape(16.dp),

                            ) {
                            Text(
                                text = it.nome,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }

}
