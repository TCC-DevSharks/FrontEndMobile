package br.senai.sp.jandira.tcc.gui.mobileGestation.registrationFlow.register


import DateField
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeft
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldPhone
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldTodos
import br.senai.sp.jandira.tcc.componentes.Profile
import br.senai.sp.jandira.tcc.componentes.TextDescription
import br.senai.sp.jandira.tcc.componentes.TextComp
import br.senai.sp.jandira.tcc.model.ModelRegister
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun RegisterScreen(navController: NavController, viewModel: ModelRegister) {

    var email by rememberSaveable { mutableStateOf("") }
    var nome by rememberSaveable { mutableStateOf("") }
    var dataNascimento by rememberSaveable { mutableStateOf("") }
    var telefone by rememberSaveable { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }
    var maxCharNome = 150
    var maxCharEmail = 255
    var maxCharPhone = 15

    val storage = Firebase.storage
    val storageRef = storage.reference


    var photoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    // variavel que vai pegar a URI
    var launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        photoUri = uri
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
                viewModel.foto = "${ task.result }"
            } else {
                // Handle failures
                // ...
            }
        }
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {


        Column {

            Row(modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {

                ArrowLeft(navController = navController, rota = "home")

            }


            TextComp(texto = R.string.title_register)

            TextDescription(texto = R.string.description_register)

            Spacer(modifier = Modifier.height(20.dp))

        }

        Profile(size = 24.dp, launcher, photoUri)

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AnimatedVisibility(
                visible = visible,
                modifier = Modifier
                    .fillMaxWidth(),
                enter = fadeIn(
                    initialAlpha = 0.4f
                ),
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 250)
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.empty_fields),
                        color = Color.Red

                    )
                }
            }

            OutlinedTextFieldTodos(
                texto = R.string.text_field_nome,
                meuType = KeyboardType.Text,
                nome
            ) {
                if (it.length <= maxCharNome) nome = it
            }
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextFieldTodos(
                texto = R.string.types_of_users,
                meuType = KeyboardType.Email,
                email
            ) {
                if (it.length <= maxCharEmail) email = it
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextFieldPhone(texto = stringResource(id = R.string.text_field_telefone), meuType = KeyboardType.Phone, data = telefone){
                if (it.length <= maxCharPhone) telefone= it
            }

            Spacer(modifier = Modifier.height(20.dp))

            DateField( texto = R.string.text_field_nascimento, meuType = KeyboardType.Text,dataNascimento)
            { dataNascimento = it}


            Spacer(modifier = Modifier.height(40.dp))

            ButtonPurple(
                navController = navController,
                texto = stringResource(id = R.string.button_next),
                rota = "register_password",
                onclick = {

                    if (nome.isNotEmpty() and email.isNotEmpty() and telefone.isNotEmpty() and dataNascimento.isNotEmpty()) {
                        var date = LocalDate.parse(
                            dataNascimento,
                            DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        ).format(
                            DateTimeFormatter.ISO_LOCAL_DATE
                        )

                        viewModel.nome = nome
                        viewModel.email = email
                        viewModel.telefone = telefone
                        viewModel.data_nascimento = date
                        navController.navigate("register_password")
                    } else {
                        visible = true
                    }
                })
        }

    }
}


private fun formatDate(input: String): String {
    val formattedInput = input.take(8) // Limit the input to 8 characters
    return when (formattedInput.length) {
        1, 2 -> formattedInput // Keep 1 or 2 digits as is
        3 -> "${formattedInput.substring(0, 2)}/${formattedInput[2]}"
        4 -> "${formattedInput.substring(0, 2)}/${formattedInput.substring(2, 4)}"
        5 -> "${formattedInput.substring(0, 2)}/${
            formattedInput.substring(
                2,
                4
            )
        }/${formattedInput[4]}"

        6 -> "${formattedInput.substring(0, 2)}/${
            formattedInput.substring(
                2,
                4
            )
        }/${formattedInput.substring(4, 6)}"

        7 -> "${formattedInput.substring(0, 2)}/${
            formattedInput.substring(
                2,
                4
            )
        }/${formattedInput.substring(4, 7)}"

        8 -> "${formattedInput.substring(0, 2)}/${
            formattedInput.substring(
                2,
                4
            )
        }/${formattedInput.substring(4, 8)}"

        else -> formattedInput.substring(0, 8)
    }
}