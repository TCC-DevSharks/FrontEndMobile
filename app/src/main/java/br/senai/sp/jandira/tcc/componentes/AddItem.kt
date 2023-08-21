package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun AddItem(
    navController: NavController,
    rota: String
    ) {

    Row() {

        Image(painter = painterResource(id = R.drawable.baseline_add_circle_65),
            contentDescription = null,
            modifier = Modifier.clickable {
                navController.navigate(rota)
            }
        )
    }
    
}

//@Preview (showBackground = true)
//@Composable
//fun AddItemPreview() {
//    AddItem()
//}