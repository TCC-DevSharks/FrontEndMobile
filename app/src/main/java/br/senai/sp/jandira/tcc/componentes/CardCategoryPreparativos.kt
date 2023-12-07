package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun CardCategoryPreparativos(
    category: String,
    navController: NavController,
    rota: String

) {

    fun String.capitalizeFirstLetter(): String {
        return if (isNotEmpty()) {
            val lowercase = substring(1).toLowerCase()
            this[0].toUpperCase() + lowercase
        } else {
            this
        }
    }


    Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp)
                .padding(horizontal = 30.dp, vertical = 9.dp)
                .clickable {
                    navController.navigate("$rota/$category")

                }
                .background(Color(236, 238, 255), shape = CircleShape),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = category.capitalizeFirstLetter(),
                color = Color(182,182,246),
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.outfit_semibold))

            )


        }



}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun CardCategoryPreparativosPreview() {
//    CardCategoryPreparativos()
//}