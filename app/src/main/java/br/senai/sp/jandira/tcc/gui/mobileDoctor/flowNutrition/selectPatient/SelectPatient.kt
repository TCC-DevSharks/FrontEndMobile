package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.selectPatient

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.AddDietDialog
import br.senai.sp.jandira.tcc.componentes.AddMealDialog
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.diet.DietModel
import br.senai.sp.jandira.tcc.model.diet.DietModelAdd
import br.senai.sp.jandira.tcc.model.diet.DietResponseListName
import br.senai.sp.jandira.tcc.model.medicalRecord.ConsultListMedicalRecord
import br.senai.sp.jandira.tcc.model.medicalRecord.ConsultResponseMedicalRecord
import br.senai.sp.jandira.tcc.model.modelDoctor.DefaultMeal.ModelDefaultMeal
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectPatient(professional: Professional, navController: NavController) {

    var pacientes by rememberSaveable {
        mutableStateOf(listOf<ConsultResponseMedicalRecord>())
    }

    var searchText by remember { mutableStateOf("") }

    var effect by remember { mutableStateOf(true)}

    var openDialog = remember { mutableStateOf(false) }
    var consulta by remember { mutableStateOf(0) }


    val pacientesFiltrados = pacientes.filter { it.nome.contains(searchText, ignoreCase = true) }
        .distinctBy { it.idGestante }

    LaunchedEffect(Unit){
        var call = RetrofitFactory().consult().getConsultMedicalRecord(professional.id)

        call.enqueue(object : Callback<ConsultListMedicalRecord> {
            override fun onResponse(
                call: Call<ConsultListMedicalRecord>,
                response: Response<ConsultListMedicalRecord>
            ) {
                pacientes = response.body()!!.pacientes

            }

            override fun onFailure(call: Call<ConsultListMedicalRecord>, t: Throwable) {
                Log.i("paciente", "${t.message}")
            }
        })
    }

    AddDietDialog(
        openDialog = openDialog) {

        var diet  = DietModelAdd(
            id_consulta = consulta
        )

        val call = RetrofitFactory().Diet().addDiet(diet)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>

            ) {
                openDialog.value = false
                effect = !effect

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.i(
                    "ds2m",
                    "onFailure: ${t.message}"
                )
                println(t.message + t.cause)
            }
        })

    }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(titulo = stringResource(id = R.string.select_patient),rota ="", navController = navController)
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier
                        .width(355.dp),
                    shape = RoundedCornerShape(40.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(243, 243, 243, 500),
                        focusedIndicatorColor = Color(243, 243, 243),
                        unfocusedIndicatorColor = Color(243, 243, 243)
                    ),
                    label = {
                        Text(
                            text = stringResource(id = R.string.search_patient),
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = stringResource(id = R.string.all_),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )

            }
            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                items(pacientesFiltrados)      {
                    Card(
                        modifier = Modifier
                            .width(340.dp)
                            .height(85.dp)
                            .padding(bottom = 14.dp)
                            .clickable {
                                var call = RetrofitFactory().Diet().dietValidation(it.idGestante)

                                call.enqueue(object : Callback<DietResponseListName> {
                                    override fun onResponse(
                                        call: Call<DietResponseListName>,
                                        response: Response<DietResponseListName>
                                    ) {
                                        if (response.body()!!.dieta.isEmpty()){
                                            consulta = it.idConsulta
                                            professional.id_gestante = it.idGestante
                                            openDialog.value = true
                                        } else{
                                            professional.id_gestante = it.idGestante
                                            professional.id_dieta = response.body()!!.dieta[0].idDieta
                                            navController.navigate("addDiet")
                                        }


                                    }

                                    override fun onFailure(call: Call<DietResponseListName>, t: Throwable) {
                                        Log.i("paciente", "${t.message}")
                                    }
                                })
                            },
                        colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
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
                                    .size(55.dp)
                                    .clip(CircleShape)
                            )

                            Spacer(modifier = Modifier.width(25.dp))

                            Column {
                                Text(
                                    text = it.nome,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 20.sp,
                                )
                            }
                        }
                    }
                }
            }


        }
    }
}
