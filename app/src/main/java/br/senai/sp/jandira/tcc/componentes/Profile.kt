package br.senai.sp.jandira.tcc.componentes

import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.tcc.R

@Composable
fun Profile(
    size: Dp
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(

        ) {
            Card(
                modifier = Modifier
                    .size(100.dp),
                shape = CircleShape,
                border = BorderStroke(3.5.dp, Color(182, 182, 246))

            ) {
                Image(
                    painter = painterResource(id = R.drawable.perfil_bebe),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Image(
                painter = painterResource(id = R.drawable.baseline_add_circle_24),

                contentDescription = null,
                modifier = Modifier.align(Alignment.BottomEnd)
                    .size(size)
            )
        }
    }

}

//@Preview (showBackground = true, showSystemUi = true)
//@Composable
//fun ProfilePreviwe() {
//    Profile()
//}