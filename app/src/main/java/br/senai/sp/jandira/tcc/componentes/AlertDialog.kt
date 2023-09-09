package br.senai.sp.jandira.tcc.componentes

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun AlertDialog(openDialog: MutableState<Boolean>, title: String, aviso:String) {
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back button
                openDialog.value = false
            },
            title = {
                Text(text = title)
            },
            text = {
                Text(aviso)
            },
            confirmButton = {
                Button(onClick = { openDialog.value = false }) {
                    Text("Confirmar")
                }
            }
        )
    }
}