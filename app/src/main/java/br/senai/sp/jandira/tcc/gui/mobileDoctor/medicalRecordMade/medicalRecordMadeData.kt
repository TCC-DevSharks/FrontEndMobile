package br.senai.sp.jandira.tcc.gui.mobileDoctor.medicalRecordMade

import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordAll
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordAllList
import br.senai.sp.jandira.tcc.model.medicalRecord.ModelMedicalRecord
import br.senai.sp.jandira.tcc.model.medicalRecord.ProntuarioBody
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalRecordMadeDataScreen(
    navController: NavController,
    modelMedicalRecord: ModelMedicalRecord
) {

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(
                titulo = stringResource(id = R.string.medical_record),
                rota = "medicalRecordMade",
                navController = navController
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(.3.dp)
            ) {

            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.date),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = {

                },
                modifier = Modifier
                    .size(118.dp, 43.dp)
                    .padding(start = 4.5.dp),
                colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = modelMedicalRecord.dia.take(5),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(900),
                    color = Color.White
                )
            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.hour),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = {

                },
                modifier = Modifier
                    .size(118.dp, 43.dp)
                    .padding(start = 4.5.dp),
                colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = modelMedicalRecord.hora.take(5),
                    fontSize = 13.5.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(900),
                    color = Color.White
                )
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp)
        ) {
            Text(
                text = stringResource(id = R.string.description),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(10.dp))


        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = modelMedicalRecord.descricao,
                onValueChange = {  },
                singleLine = false, // Permitir várias linhas
                readOnly = true, // Impede a edição
                modifier = Modifier
                    .width(355.dp)
                    .height(300.dp)
                    .border(
                        width = 1.dp,
                        color = Color(182, 182, 246),
                        shape = RoundedCornerShape(10.dp) // Altere para 0.dp para obter um contorno quadrado
                    ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color(243, 243, 243),
                    unfocusedIndicatorColor = Color(243, 243, 243)
                )
            )

        }

        Spacer(modifier = Modifier.height(45.dp))

    }
}