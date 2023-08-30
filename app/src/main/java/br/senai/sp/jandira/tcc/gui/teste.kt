package br.senai.sp.jandira.tcc.gui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.componentes.SubHeader


@Composable
fun teste(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {


        Header(
            titulo = stringResource(id = R.string.header_maternity_bag),
            rota = "homeUser",
            navController = navController
        )

        SubHeader(
            leftText = stringResource(id = R.string.my_list),
            rightText = stringResource(id = R.string.all)
        )



    }


}