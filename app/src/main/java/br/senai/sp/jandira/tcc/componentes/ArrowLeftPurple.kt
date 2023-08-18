package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun ArrowLeftPurple(
    navController: NavController,
    rota: String,
)
{
    Row (modifier = Modifier.fillMaxWidth()
        .padding(start = 26.dp, top = 35.dp),
    ) {

        Image(painter = painterResource(id = R.drawable.arrow_circle_purple_24),
            contentDescription = null,
            Modifier.clickable {
                navController.navigate(rota)
            }.size(40.dp),
        )
    }

}