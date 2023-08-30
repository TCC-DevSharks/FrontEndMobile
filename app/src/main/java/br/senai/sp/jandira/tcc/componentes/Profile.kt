package br.senai.sp.jandira.tcc.componentes

import android.media.Image
import android.net.Uri
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.tcc.R
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun Profile(
    size: Dp,
    launcher: ManagedActivityResultLauncher<String, Uri?>,
    photoUri: Uri?

//    colors = CardDefaults.cardColors(Color(182, 182, 246, 80))

) {


    // variavel que vai transforma a URI em uma image
    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(photoUri)
            .build()
    )

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
                    painter = if (photoUri == null) {
                        painterResource(id = R.drawable.perfil_bebe)
                    } else {
                        painter
                    },
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                        .clickable { launcher.launch("image/*")
                            var message = "nada"
                            Log.i(
                                "ds2m",
                                "${photoUri?.path ?: message}"
                            ) }
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