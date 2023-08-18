package br.senai.sp.jandira.tcc.GestationWeek

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ArrowLeftPurple

@Composable
fun GestationWeekScreen() {

    Column (modifier = Modifier.fillMaxSize()) {

//        ArrowLeftPurple(navController = nav, rota = )


        Row (modifier = Modifier.fillMaxWidth()){

            Text(text = stringResource(id = R.string.description_register_password),
                textAlign = TextAlign.Center


            )

        }

    }

}




@Preview (showSystemUi = true, showBackground = true)
@Composable
fun GestationWeekPreview() {
    GestationWeekScreen()
}