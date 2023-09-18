package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun ArrowLeft(
    navController: NavController,
    rota: String,
    tint: Color = Color(182,182,246),
    size: Dp = 40.dp,
//    start = 26.dp, top = 35.dp)
)

{

    // Valor padrão do Padding

//    Row (modifier = Modifier.fillMaxWidth()
//        .padding(start = 26.dp, top = 35.dp),
//    ) {}

        Icon(painter = painterResource(id = R.drawable.arrow_circle),
            tint = tint,
            contentDescription = null,
            modifier = Modifier.clickable {
//                navController.navigate(rota)
            }.size(size),
        )

}