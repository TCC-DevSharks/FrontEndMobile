package br.senai.sp.jandira.tcc.gui.Calendar

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeftPurple
import br.senai.sp.jandira.tcc.componentes.ButtonPurple
import br.senai.sp.jandira.tcc.componentes.TextDescription
import br.senai.sp.jandira.tcc.componentes.TextTitle
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.DatePickerDefaults
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate

@Composable
fun CalendarScreen(navController: NavController) {

    val context = LocalContext.current // Obtenha o contexto local

    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }

    val dateDialogState = rememberMaterialDialogState()

    MaterialDialog(
        backgroundColor = Color.White,
        dialogState = dateDialogState,
        buttons = {
            positiveButton(
                text = "Ok",
                textStyle = TextStyle(Color(182, 182, 246))
            ) {
                Toast.makeText(
                    context,
                    "Clicked ok",
                    Toast.LENGTH_LONG
                ).show()
            }
            negativeButton(
                text = "Cancelar",
                textStyle = TextStyle(Color(182, 182, 246))
            )
        }

    ) {
        datepicker(
            initialDate = LocalDate.now(),
            title = "Selecione a data de parto",
            colors = DatePickerDefaults.colors(
                headerBackgroundColor = Color(182, 182, 246), // Cor do Header
                dateActiveBackgroundColor = Color(182, 182, 246), // Cor da data atual
            )

        ) {
            pickedDate = it
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Row (modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {

            ArrowLeftPurple(navController = navController, rota = "week")

        }

        TextTitle(texto = R.string.title_calendar)

        TextDescription(texto = R.string.description_calendar)

        Spacer(modifier = Modifier.height(50.dp))


        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Button(
                onClick = {
                    dateDialogState.show()
                }, modifier = Modifier
                    .width(267.dp)
                    .height(53.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(width = .9.dp, Color(182, 182, 246))

            ) {
                Text(
                    text = "Selecione uma data",
                    color = Color(182, 182, 246),
                    fontSize = 18.sp
                )


            }
            Spacer(modifier = Modifier.height(50.dp))

//            Text(text = formattedDate)

//            Spacer(modifier = Modifier.height(15.dp))

        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Image(
                painter = painterResource(id = R.drawable.gravidinha), contentDescription = null,
                modifier = Modifier.size(190.dp)
            )

        }


        Spacer(modifier = Modifier.height(45.dp))

        ButtonPurple(navController = navController, texto = R.string.button_finish, rota = "homeUser", onclick = {})


    }


}

//@Preview (showSystemUi = true, showBackground = true)
//@Composable
//fun CalendarPreview() {
//    CalendarScreen()
//}