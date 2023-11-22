package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R


@Composable
fun ButtonAdd(navController: NavController) {
        Button(
            onClick = {
//                navController.navigate("foodCategory")
            },
            modifier = Modifier.size(70.dp),
            colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),
            border = BorderStroke(width = 2.dp, Color.Black)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "",
                modifier = Modifier.size(35.dp),

                )
        }

}
