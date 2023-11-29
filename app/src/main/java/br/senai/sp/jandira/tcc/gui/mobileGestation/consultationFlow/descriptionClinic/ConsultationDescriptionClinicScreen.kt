package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.descriptionClinic

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.calls.GetProfessionalSpeciality
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.clinic.Clinic
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.model.viaCep.ViaCep
import br.senai.sp.jandira.tcc.service.RetrofitFactoryCep
import coil.compose.AsyncImage
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import retrofit2.Call
import retrofit2.Response
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.os.AsyncTask
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.clinic.ModelCep
import java.io.IOException

@Composable
fun ConsultationDescriptionClinicScreen(
    navController: NavController,
    clinic: Clinic,
    professional: Professional,
    modelCep: ModelCep
) {
    val context = LocalContext.current

    GetCep(clinic.cep, clinic)

    val cep = clinic.cep
    val task = GetLatLongFromCep(context, cep, modelCep = modelCep)
    task.execute()

    Log.e("teste", "${modelCep.latitude}")
    Log.e("teste2", "${modelCep.longitude}")


    var singapore by rememberSaveable {
        mutableStateOf(LatLng(modelCep.latitude, modelCep.longitude))
    }


    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 16f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {

                ArrowLeft(navController = navController, rota = "ConsultClinic")

            }

        }
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(130.dp),
                shape = CircleShape,
                border = BorderStroke(1.dp, Color.Gray)

            ) {

                AsyncImage(
                    model = clinic.foto,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 28.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text(
                    text = clinic.razao_social,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = clinic.descricao,
                    fontSize = 15.sp,
                    color = Color(57, 57, 56),
                    textAlign = TextAlign.Center
                )

            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Row() {
//                Text(
//                    text = stringResource(id = R.string.description),
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }

            Spacer(modifier = Modifier.height(8.dp))

            Column() {


                Column(
                    modifier = Modifier.padding(start = 30.dp)
                ) {


                    GoogleMap(
                        modifier = Modifier
                            .width(300.dp)
                            .height(180.dp),
                        cameraPositionState = cameraPositionState
                    ) {
                        Marker(
                            state = MarkerState(position = singapore),
//                            title = clinic.razao_social,
//                            snippet = clinic.logradouro + ", " + clinic.numero + ", " + clinic.bairro + ", " + clinic.cidade + ", " + clinic.estado + ", Brasil"
                        )
                    }

                }

                Spacer(modifier = Modifier.height(20.dp))


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.letter),
                        contentDescription = null,
                        modifier = Modifier.size(27.dp),
                        colorFilter = ColorFilter.tint(Color(182,182,246))
                    )

                    Spacer(modifier = Modifier.width(13.dp))

                    Text(
                        text = " " + clinic.email,
                        fontSize = 15.sp,
                        color = Color(57, 57, 56),
                        textAlign = TextAlign.Center,
                        lineHeight = 18.sp
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.house_branco),
                        contentDescription = null,
                        modifier = Modifier.size(22.dp),
                        colorFilter = ColorFilter.tint(Color(182,182,246))
                    )

                    Spacer(modifier = Modifier.width(13.dp))

                    Text(
                        text = clinic.logradouro + ", " + clinic.numero + ", " + clinic.bairro + ", " + clinic.cidade + ", " + clinic.estado + ", Brasil," + " " + clinic.cep,
                        fontSize = 15.sp,
                        color = Color(57, 57, 56),
                        textAlign = TextAlign.Start,
                        lineHeight = 18.sp
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = null,
                        modifier = Modifier.size(22.dp),
                        colorFilter = ColorFilter.tint(Color(182,182,246))
                    )

                    Spacer(modifier = Modifier.width(13.dp))

                    Text(
                        text = " " + clinic.telefone,
                        fontSize = 15.sp,
                        color = Color(57, 57, 56),
                        textAlign = TextAlign.Center,
                        lineHeight = 18.sp
                    )
                }


//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(
//                        text = stringResource(id = R.string.complement),
//                        fontSize = 17.sp,
//                        color = Color(57, 57, 56),
//                        textAlign = TextAlign.Start,
//                        fontWeight = FontWeight.Black,
//                        lineHeight = 18.sp
//                    )
//
//                    Text(
//                        text = " " + clinic.complemento,
//                        fontSize = 15.sp,
//                        color = Color(57, 57, 56),
//                        textAlign = TextAlign.Start,
//                        lineHeight = 18.sp
//                    )
//                }
//
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(
//                        text = stringResource(id = R.string.Cep),
//                        fontSize = 17.sp,
//                        color = Color(57, 57, 56),
//                        textAlign = TextAlign.Start,
//                        fontWeight = FontWeight.Black,
//                        lineHeight = 18.sp
//                    )
//
//                    Text(
//                        text = " " + clinic.cep,
//                        fontSize = 15.sp,
//                        color = Color(57, 57, 56),
//                        textAlign = TextAlign.Start,
//                        lineHeight = 18.sp
//                    )
//                }
//
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(
//                        text = stringResource(id = R.string.phone),
//                        fontSize = 17.sp,
//                        color = Color(57, 57, 56),
//                        textAlign = TextAlign.Center,
//                        fontWeight = FontWeight.Black,
//                        lineHeight = 18.sp
//                    )
//
//                    Text(
//                        text = " " + clinic.telefone,
//                        fontSize = 15.sp,
//                        color = Color(57, 57, 56),
//                        textAlign = TextAlign.Center,
//                        lineHeight = 18.sp
//                    )
//                }


            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Column {
            ButtonPurple(
                navController = navController,
                texto = clinic.nomeEspecialidade + "s " + stringResource(id = R.string.check_nutritionists),
                rota = "",
                onclick = {
                    GetProfessionalSpeciality(clinic.especialidade, professional, navController)
                }, width = 300.dp, height = 48.dp, sizeText = 15.sp
            )

        }


    }

}

class GetLatLongFromCep(
    private val context: Context,
    private val cep: String,
    private val modelCep: ModelCep
) : AsyncTask<Void, Void, Pair<Double, Double>>() {

    override fun doInBackground(vararg params: Void?): Pair<Double, Double>? {
        return getLatLongFromCep()
    }

    override fun onPostExecute(result: Pair<Double, Double>?) {
        super.onPostExecute(result)
        if (result != null) {
            modelCep.latitude = result.first
            modelCep.longitude = result.second
        } else {
            Log.e("LatLng", "Não foi possível obter a latitude e longitude.")
        }
    }

    private fun getLatLongFromCep(): Pair<Double, Double>? {
        val geocoder = Geocoder(context)
        try {
            val addresses: MutableList<Address>? = geocoder.getFromLocationName(cep, 1)
            if (addresses != null) {
                if (addresses.isNotEmpty()) {
                    val latitude = addresses[0].latitude
                    val longitude = addresses[0].longitude
                    modelCep.latitude = latitude
                    modelCep.longitude = longitude
                    return Pair(latitude, longitude)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}


fun GetCep(cep: String, clinic: Clinic) {
    val call = RetrofitFactoryCep().getCep().getCep(cep)

    call.enqueue(object : retrofit2.Callback<ViaCep> {
        override fun onResponse(
            call: Call<ViaCep>,
            response: Response<ViaCep>

        ) {
            Log.i("asdf", "${response}")

            if (response.code() == 200) {
                clinic.estado = response.body()!!.uf
                clinic.cidade = response.body()!!.localidade
                clinic.logradouro = response.body()!!.logradouro
                clinic.bairro = response.body()!!.bairro

            }


        }

        override fun onFailure(call: Call<ViaCep>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ConsultationDescriptionClinicScreenPreview() {
//    ConsultationDescriptionClinicScreen()
//}