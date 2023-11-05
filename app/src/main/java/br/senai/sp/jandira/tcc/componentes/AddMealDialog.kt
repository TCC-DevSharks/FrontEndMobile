package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMealDialog(
    openDialog: MutableState<Boolean>,
    nome: String,
    onValueChangeNome: (String) -> Unit,
    onclick: () -> Unit
) {
    if (openDialog.value) {
        Dialog(onDismissRequest = { openDialog.value = false },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Column(modifier = Modifier
                .background(Color.White)
                .width(400.dp)
                .height(250.dp)
                .border(border = BorderStroke(3.dp, Color.Black)),
                verticalArrangement = Arrangement.Center) {
                
                Text(text = "Adicione um nome para a refeição:",
                    modifier =Modifier.padding(start = 30.dp))

                Spacer(modifier = Modifier.height(6.dp))

                Row(modifier =Modifier.fillMaxWidth().padding(start = 30.dp)){
                    OutlinedTextField(
                        value = nome,
                        onValueChange = {
                            onValueChangeNome(it)
                        },
                        label = {},
                        modifier = Modifier
                            .width(300.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(243, 243, 243),
                            focusedIndicatorColor = Color(243, 243, 243),
                            unfocusedIndicatorColor = Color(243, 243, 243)
                        ),
                        singleLine = true
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(modifier =Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Button(onClick ={openDialog.value = false}) {
                        Text(text = "Cancelar")
                    }
                    Button(onClick = onclick) {
                        Text("Criar")
                    }
                }

            }
        }
    }
}