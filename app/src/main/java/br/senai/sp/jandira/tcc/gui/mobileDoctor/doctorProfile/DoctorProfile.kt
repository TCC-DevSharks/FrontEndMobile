package br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorProfile

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.PutWeight
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.model.WeightHeight
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.model.professional.ProfissionalBody
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DoctorProfile(professional: Professional, navController: NavController) {

    val storage = Firebase.storage
    val storageRef = storage.reference

    var photoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    var launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        photoUri = uri


        var file = uri

        val photo = storageRef.child("${file}")

        var upload = photo.putFile(file!!)

        val urlTask = upload.continueWithTask { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    throw it
                }
            }
            photo.downloadUrl
        }.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                professional.foto = "${task.result}"

                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

                var ProfissionalBody = ProfissionalBody(
                    nome = professional.nome,
                    crm = professional.crm,
                    email = professional.email,
                    cpf = professional.cpf,
                    data_nascimento = "${LocalDate.parse(professional.data_nascimento, formatter)}",
                    foto = professional.foto,
                    descricao = professional.descricao,
                    inicio_atendimento = professional.inicio_atendimento,
                    fim_atendimento = professional.fim_atendimento,
                    id_sexo = professional.idSexo,
                    id_clinica = professional.idClinica,
                    telefone = professional.telefone,
                    tipo_telefone = professional.idTipo,
                    id_telefone = professional.id_telefone,
                    id_endereco = professional.id_endereco,
                    numero = professional.numero,
                    complemento = professional.complemento,
                    cep = professional.cep,
                )

                println(ProfissionalBody)

                val call = RetrofitFactory().getProfessional().putProfissional(professional.id, ProfissionalBody)

                call.enqueue(object : retrofit2.Callback<ProfissionalBody> {
                    override fun onResponse(
                        call: Call<ProfissionalBody>,
                        response: Response<ProfissionalBody>

                    ) {
                        Log.i("fdfdf", "${response}")
                        if (response.code() == 200) {

                        } else {
                        }

                    }

                    override fun onFailure(call: Call<ProfissionalBody>, t: Throwable) {
                        Log.i(
                            "ds2m",
                            "onFailure: ${t.message}"
                        )
                        println(t.message + t.cause)
                    }
                })

            } else {
                professional.foto
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Header(
                titulo = stringResource(id = R.string.profile),
            )

        }

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box() {
                Card(
                    modifier = Modifier.size(85.dp),
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
                            .clickable { launcher.launch("image/*") }
                    )
                }
            }
            Column {
                Text(
                    text = professional.nome,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 18.dp),

                )

                Text(
                    text = professional.especialidade,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 18.dp, top = 2.dp),
                    color = Color.Gray
                )
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(width = 350.dp, height = 190.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 15.dp),
                        text = stringResource(id = R.string.Account_user),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                        navController.navigate("profileDataDoctor")

                    }
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_outline_24),
                            contentDescription = null,
                            tint = Color(182,182,246)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.data)
                        )

                    }

                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null
                        )

                    }


                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(
                                id = R.drawable.baseline_library_books_24
                            ),
                            contentDescription = null,
                            tint = Color(182,182,246)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.Achievement)
                        )

                    }
                    Row {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null,
                            tint = Color.Gray

                        )

                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(
                                id = R.drawable.graph
                            ),
                            contentDescription = null,
                            tint =  Color(182,182,246)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.Activity_History)
                        )

                    }
                    Row {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null,
                            tint = Color.Gray

                        )

                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(
                                id = R.drawable.baseline_insert_chart_24
                            ),
                            contentDescription = null,
                            tint = Color(182,182,246)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.Workout_Progress)
                        )

                    }
                    Row {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null,
                            tint = Color.Gray

                        )

                    }
                }


            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(width = 350.dp, height = 90.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 15.dp),
                        text = stringResource(id = R.string.notification),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.bell),
                            contentDescription = null,
                            tint =  Color(182,182,246)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.notification_pop)
                        )

                    }

                    var switchCheckedState by remember { mutableStateOf(false) }

                    Switch(
                        modifier = Modifier.padding(bottom = 20.dp),
                        checked = switchCheckedState,
                        onCheckedChange = {
                            switchCheckedState = it

                            if (it) {
                                // Código para quando o Switch estiver ligado
                            } else {
                                // Código para quando o Switch estiver desligado
                            }
                        },

                        colors = SwitchDefaults.colors(
                            checkedThumbColor = if (switchCheckedState)
                                Color.White else  Color(182,182,246),
                            checkedTrackColor = Color(182,182,246),
                            checkedBorderColor =  Color(182,182,246),
                            uncheckedThumbColor =  Color(182,182,246),
                            uncheckedTrackColor = Color.White,
                            disabledCheckedBorderColor = Color(255, 255, 255)
                        )

                    )


                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(width = 350.dp, height = 140.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 15.dp),
                        text = stringResource(id = R.string.others),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.letter),
                            contentDescription = null,
                            tint =  Color(182,182,246)

                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.contact)
                        )

                    }


                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null
                        )

                    }


                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.verification),
                            contentDescription = null,
                            tint =  Color(182,182,246)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.politic)
                        )

                    }

                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null
                        )

                    }

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_settings_24),
                            contentDescription = null,
                            tint =  Color(182,182,246)
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.Settings)
                        )

                    }

                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = null
                        )

                    }

                }


            }
        }

    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun DoctorProfilePreview() {
//    DoctorProfile()
//}