package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.doctor

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.TextComp
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.clinic.Clinic
import br.senai.sp.jandira.tcc.model.professional.Professional
import coil.compose.AsyncImage

@Composable
fun DoctorScreen(navController: NavController, professional: Professional, pregnant: ModelPregnant, clinic: Clinic) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

         
                Header(
                    titulo = stringResource(id = R.string.header_speciality),
                    rota = "DescriptionClinic",
                    navController = navController
                )


            Spacer(modifier = Modifier.height(13.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(.3.dp)
            ) {}

            Spacer(modifier = Modifier.height(60.dp))

            Row(modifier = Modifier.padding(horizontal = 50.dp, vertical = 2.dp)) {

                Text(
                    text = stringResource(id = R.string.title_doctor) + " " + clinic.razao_social + ", " + stringResource(id = R.string.sub_title_doctor) + " " + clinic.nomeEspecialidade.toLowerCase() + "s",
                    fontSize = 21.sp,
                    fontWeight = FontWeight(400)
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Column(
                modifier = Modifier
                    .padding(bottom = 20.dp)

            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(professional.profissional) {

                            Card(
                                modifier = Modifier
                                    .width(340.dp)
                                    .height(85.dp)
                                    .padding(bottom = 14.dp)
                                    .clickable {
                                        professional.id = it.id
                                        professional.nome = it.nome
                                        professional.crm = it.crm
                                        professional.descricao = it.descricao
                                        professional.especialidade = it.especialidade
                                        professional.cep = it.cep
                                        professional.email = it.email
                                        professional.numero = it.numero
                                        professional.foto = it.foto
                                        professional.telefone = it.telefone
                                        professional.tipo_telefone = it.tipo_telefone
                                        professional.clinica = it.clinica
                                        professional.valor = "R$ 200,00"

                                        navController.navigate("DescriptionDoctor")
                                    },
                                colors = CardDefaults.cardColors(Color(255,255,255)),
                                border = BorderStroke(width = 1.dp, color = Color(182, 182, 246)),

                                shape = RoundedCornerShape(16.dp),
                            ) {
                                Row(
                                    Modifier
                                        .fillMaxSize()
                                        .padding(start = 20.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    AsyncImage(
                                        model = it.foto,
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(45.dp)
                                            .clip(CircleShape)
                                    )

                                    Spacer(modifier = Modifier.width(25.dp))

                                    Column {
                                        Text(
                                            text = it.nome,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Black,
                                            fontSize = 15.sp,
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

//@Preview
//@Composable
//fun ConsultationDoctorScreenPreview() {
//    ConsultationDoctorScreen()
//}