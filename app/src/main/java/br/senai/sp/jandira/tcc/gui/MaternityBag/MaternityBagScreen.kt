package br.senai.sp.jandira.tcc.gui.MaternityBag

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.CardAlong
import br.senai.sp.jandira.tcc.componentes.FavoriteItensAlong
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.SubHeader


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaternityBagScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column (modifier = Modifier.fillMaxSize()) {

            var isChecked by remember { mutableStateOf(false) }



            Header(
                titulo = stringResource(id = R.string.header_maternity_bag),
//            rota = "homeUser",
//            navController = navController
            )

            SubHeader(
                leftText = stringResource(id = R.string.suggested),
                rightText = stringResource(id = R.string.my_list),
            )

            Spacer(modifier = Modifier.height(20.dp))


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 85.dp)
            ) {

                CardAlong()
                CardAlong()
                CardAlong()
                CardAlong()
                CardAlong()
                CardAlong()
                CardAlong()
                CardAlong()
                CardAlong()
                CardAlong()
                CardAlong()


            }

        }




        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .border(
                    .9.dp,
                    Color(182,182,246),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
        ) {

            Navigation(navController = navController)


        }

    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun MaternityBagPreview() {
//    MaternityBagScreen()
//}