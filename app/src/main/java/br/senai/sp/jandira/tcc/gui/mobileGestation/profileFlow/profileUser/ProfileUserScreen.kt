package br.senai.sp.jandira.tcc.gui.mobileGestation.profileFlow.profileUser

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.componentes.Comp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.GetPregnant
import br.senai.sp.jandira.tcc.calls.PutWeight
import br.senai.sp.jandira.tcc.componentes.ShowDialog
import br.senai.sp.jandira.tcc.model.endressPregnant.EndressPregnant
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.WeightHeight
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import retrofit2.Call
import retrofit2.Response


@Composable
fun ProfileUserScreen(navController: NavController, viewModel: ModelPregnant) {

    val storage = Firebase.storage
    val storageRef = storage.reference

    var endereco by remember {
        mutableStateOf(listOf<EndressPregnant>())
    }

    var photoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    // variavel que vai pegar a URI
    var launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        photoUri = uri


        var file = uri

        val photo = storageRef.child("${file!!.lastPathSegment}")

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
                viewModel.foto = "${task.result}"

                var weight = WeightHeight(
                    peso = viewModel.peso,
                    altura = viewModel.altura,
                    foto = viewModel.foto
                )

                PutWeight(viewModel, weight)
            } else {
                // Handle failures
                // ...
            }
        }
    }
    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(photoUri)
            .build()
    )

    var openDialog = remember { mutableStateOf(false) }

    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        peso = "${viewModel.peso}"
        altura = "${viewModel.altura}"

    }

    ShowDialog(
        openDialog = openDialog,
        peso = peso,
        altura = altura,
        onValueChangeAltura = { altura = it },
        onValueChangePeso = { peso = it },
        onclick = {

            var weight = WeightHeight(
                peso = peso.toDouble(),
                altura = altura.toDouble(),
                foto = viewModel.foto
            )
            val call = RetrofitFactory().pregnant().updateWeightPregnant(viewModel.id, weightHeight = weight)

            call.enqueue(object : retrofit2.Callback<WeightHeight> {
                override fun onResponse(
                    call: Call<WeightHeight>,
                    response: Response<WeightHeight>

                ) {
                    openDialog.value = false

                    GetPregnant(viewModel)
                }

                override fun onFailure(call: Call<WeightHeight>, t: Throwable) {
                    Log.i(
                        "ds2m",
                        "onFailure: ${t.message}"
                    )
                    println(t.message + t.cause)
                }
            })
        }
    )




    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    stringResource(id = R.string.profile),
                    fontSize = 20.sp,
                    textAlign = TextAlign.End,
                    color = Color(66, 61, 61),
                    fontWeight = FontWeight.ExtraBold
                )

            }
        }

        Spacer(modifier = Modifier.height(15.dp))
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
                        model = viewModel.foto,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .clickable { launcher.launch("image/*") }
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.baseline_add_circle_24),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )

            }

        }

        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = viewModel.nome
                )
            }
        }



        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Comp(textoHeader = "${viewModel.altura}", textoMain = stringResource(id = R.string.height), onclick = {
                openDialog.value = true
            })

            Comp(textoHeader = "${viewModel.peso}", textoMain = stringResource(id = R.string.weight), onclick = {
                openDialog.value = true
            })

            Comp(textoHeader = "${viewModel.idade}", textoMain = stringResource(id = R.string.age), onclick = {})

        }
        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(width = 350.dp, height = 120.dp),
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
                Row(modifier = Modifier.clickable {

                            navController.navigate("profileData")

            }) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row() {

                            Image(
                                painter = painterResource(id = R.drawable.baseline_person_outline_24),
                                contentDescription = null
                            )
                            Text(
                                modifier = Modifier.padding(start = 15.dp),
                                text = stringResource(id = R.string.data)
                            )

                        }

                        Row {

                            Image(
                                painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                                contentDescription = null,
                            )

                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {

                        Image(
                            painter = painterResource(id = R.drawable.graph),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.historic_query)
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

                        Image(
                            painter = painterResource(id = R.drawable.bell),
                            contentDescription = null
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
                                Color(182, 182, 246) else Color(217, 217, 217),
                            checkedTrackColor = Color(182, 182, 246, 51),
                            checkedBorderColor = Color(182, 182, 246),
                            uncheckedThumbColor = Color(217, 217, 217),
                            uncheckedTrackColor = Color.White,
                            disabledCheckedBorderColor = Color(182, 182, 246)
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

                        Image(
                            painter = painterResource(id = R.drawable.letter),
                            contentDescription = null
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

                        Image(
                            painter = painterResource(id = R.drawable.verification),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = stringResource(id = R.string.politic)
                        )

                    }

                }


            }
        }


    }
}
