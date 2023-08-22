package br.senai.sp.jandira.tcc.Calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeftPurple
import br.senai.sp.jandira.tcc.componentes.TextDescription
import br.senai.sp.jandira.tcc.componentes.TextTitulo

@Composable
fun CalendarScreen() {

    Column (modifier = Modifier.fillMaxSize()) {


        //    ArrowLeftPurple(navController = navController, rota = "ffegfgf")

        TextTitulo(texto = R.string.title_calendar)

        TextDescription(texto = R.string.description_calendar)
    }
    


}

@Preview (showSystemUi = true, showBackground = true)
@Composable
fun CalendarPreview() {
    CalendarScreen()
}