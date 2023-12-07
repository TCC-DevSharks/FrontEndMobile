package br.senai.sp.jandira.tcc.componentes

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import br.senai.sp.jandira.tcc.R

@Composable
fun AlertDialog(openDialog: MutableState<Boolean>, title: String, aviso:String) {
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back button
                openDialog.value = false
            },
            title = {
                Text(text = title,
                    fontFamily = FontFamily(Font(R.font.outfit_medium))
                )
            },
            text = {
                Text(aviso,
                    fontFamily = FontFamily(Font(R.font.outfit_medium))
                )
            },
            confirmButton = {
                Button(onClick = { openDialog.value = false }) {
                    Text("Confirmar",
                        fontFamily = FontFamily(Font(R.font.outfit_medium))
                    )
                }
            }
        )
    }
}