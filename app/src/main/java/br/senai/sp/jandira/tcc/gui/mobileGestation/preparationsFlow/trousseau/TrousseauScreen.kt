package br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.trousseau

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.CardBirthPlan
import br.senai.sp.jandira.tcc.componentes.FavoriteBirthPlan
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.SubHeader
import br.senai.sp.jandira.tcc.model.Trousseau.TrousseauResponse
import br.senai.sp.jandira.tcc.model.Trousseau.TrousseauService
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionResponse

@Composable
fun TrousseauScreen(navController: NavController) {

    var enxoval by rememberSaveable {
        mutableStateOf(listOf<TrousseauResponse>())
    }


    Box(modifier = Modifier.fillMaxSize()) {


        Column(modifier = Modifier.fillMaxSize()) {

            Header(titulo = stringResource(id = R.string.header_trousseau))

            SubHeader(
                leftText = stringResource(id = R.string.suggested),
                rightText = stringResource(id = R.string.my_list)
            )



            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 85.dp, top = 9.dp)
            ) {



          CardBirthPlan()
          CardBirthPlan()

            }
        }






        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .border(
                    .9.dp,
                    Color(182, 182, 246),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
        ) {
            Navigation(navController = navController)
        }

    }

}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun TrousseauPreview() {
//    TrousseauScreen()
//}