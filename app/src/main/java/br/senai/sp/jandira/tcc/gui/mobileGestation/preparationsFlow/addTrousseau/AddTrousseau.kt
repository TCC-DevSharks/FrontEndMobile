package br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.addTrousseau

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTrousseau(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Header(titulo = stringResource(id = R.string.header_add_trousseau),
                rota = "",
                navController = navController)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ){
            var descricao by remember { mutableStateOf("") }

            OutlinedTextField(
                    value = descricao,
                    onValueChange = { descricao = it },
                    singleLine = false, // Permitir várias linhas
                    modifier = Modifier
                            .width(355.dp)
                            .height(250.dp)
                            .border(
                                    width = 1.dp,
                                    color = Color(182, 182, 246),
                                    shape = RoundedCornerShape(20.dp)
                            ),
                    label = {
                        Text(
                                text = stringResource(id = R.string.birth_description),
                                color = Color.LightGray
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color(243, 243, 243),
                            unfocusedIndicatorColor = Color(243, 243, 243)
                    )
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 30.dp),
                horizontalAlignment = Alignment.End
        ) {
            Button(
                    onClick =
                    {},
                    modifier = Modifier
                            .width(135.dp)
                            .height(35.dp),
                    colors = ButtonDefaults.buttonColors(Color(236, 238, 255)),

                    shape = RoundedCornerShape(16.dp),

                    ) {
                Text(
                        text = stringResource(id = R.string.to_add),
                        color = Color(182, 182, 246),
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                )
            }

        }
        Spacer(modifier = Modifier.height(40.dp))

        Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(painter = painterResource(id = R.drawable.img_papai_mamae_filhinha),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
                        .align(Alignment.CenterHorizontally)
        )
        }
    }
}