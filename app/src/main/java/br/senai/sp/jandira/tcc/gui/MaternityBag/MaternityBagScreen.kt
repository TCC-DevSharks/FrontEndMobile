package br.senai.sp.jandira.tcc.gui.MaternityBag

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.componentes.CardAlong
import br.senai.sp.jandira.tcc.componentes.SubHeader


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaternityBagScreen() {

    Column(modifier = Modifier.fillMaxSize()) {


        var isChecked by remember { mutableStateOf(false) }



        Header(
            titulo = stringResource(id = R.string.header_maternity_bag),
//            rota = "homeUser",
//            navController = navController
        )

        SubHeader(
            leftText = stringResource(id = R.string.suggested),
            rightText = stringResource(id = R.string.my_list)
        )

        Spacer(modifier = Modifier.height(20.dp))

//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
//        ) {
//
//            CardAlong()
//            CardAlong()
//        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp, vertical = 7.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Checkbox(
                    modifier = Modifier.height(30.dp),
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = Color(182, 182, 246),
                        checkedColor = Color(182, 182, 246), // Cor quando marcado
                        uncheckedColor = Color(182, 182, 246) // Cor quando não marcado
                    )
                )
                Spacer(modifier = Modifier.width(15.dp))

                Text(text = "Mamadeiras e Bicos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                )

            }


            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp, vertical = 7.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Checkbox(
                    modifier = Modifier.height(30.dp),
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = Color(182, 182, 246),
                        checkedColor = Color(182, 182, 246), // Cor quando marcado
                        uncheckedColor = Color(182, 182, 246) // Cor quando não marcado
                    )
                )
                Spacer(modifier = Modifier.width(15.dp))

                Text(text = "Mamadeiras e Bicos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                )

            }

        }





    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MaternityBagPreview() {
    MaternityBagScreen()
}