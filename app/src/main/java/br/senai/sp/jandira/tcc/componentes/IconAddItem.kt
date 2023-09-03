package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun IconAddItem(
    navController: NavController,
    rota: String,
    size: Dp
    ) {

    Row() {

        Image(painter = painterResource(id = R.drawable.baseline_add_circle_65),
            contentDescription = null,
            modifier = Modifier.clickable {
                navController.navigate(rota)
            }.size(size)
        )
    }
    
}

//@Preview (showBackground = true)
//@Composable
//fun AddItemPreview() {
//    AddItem()
//}