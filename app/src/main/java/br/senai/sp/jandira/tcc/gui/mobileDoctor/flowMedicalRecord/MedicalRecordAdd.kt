package br.senai.sp.jandira.tcc.gui.mobileDoctor.flowMedicalRecord

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.schedule.ScheduleResponse
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalRecordAdd() {

//    navController: NavController
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(
                titulo = stringResource(id = R.string.medical_record),
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
        var date by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                singleLine = false, // Permitir várias linhas
                modifier = Modifier
                    .width(355.dp)
                    .height(50.dp)
                    .border(
                        width = 1.dp,
                        color = Color(182,182,246),
                        shape = RoundedCornerShape(10.dp)
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

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.Specialty),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        var especialidade by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = especialidade,
                onValueChange = { especialidade = it },
                singleLine = false, // Permitir várias linhas
                modifier = Modifier
                    .width(355.dp)
                    .height(50.dp)
                    .border(
                        width = 1.dp,
                        color = Color(182,182,246),
                        shape = RoundedCornerShape(10.dp)
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

        var descricaoAdd by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = descricaoAdd,
                onValueChange = { descricaoAdd = it },
                singleLine = false, // Permitir várias linhas
                modifier = Modifier
                    .width(355.dp)
                    .height(300.dp)
                    .border(
                        width = 1.dp,
                        color = Color(182,182,246),
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


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.End
        ) {
//            Box(
//                modifier = Modifier
//                    .background(Color(182, 182, 246), CircleShape)
//                    .size(60.dp),
//                contentAlignment = Alignment.Center
//            ) {
//
//                Image(
//                    painter = painterResource(id = R.drawable.lixeirinha),
//                    contentDescription = null,
//                    modifier = Modifier.size(27.dp).clickable {
//
//
//
//                    },
//                )
//            }
            Box(
                modifier = Modifier
                    .background(Color(182, 182, 246), CircleShape)
                    .size(60.dp),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.save),
                    contentDescription = null,
                    modifier = Modifier
                        .size(27.dp)
                        .clickable {


                        },
                )
            }
        }




    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MedicalRecordAddPreview() {
    MedicalRecordAdd()
}