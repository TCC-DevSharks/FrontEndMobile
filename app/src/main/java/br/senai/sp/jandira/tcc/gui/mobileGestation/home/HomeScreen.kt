package br.senai.sp.jandira.tcc.gui.mobileGestation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.ButtonHome
import br.senai.sp.jandira.tcc.componentes.SwitchComp
import br.senai.sp.jandira.tcc.componentes.TextComp

@Composable
fun CadastroScren(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(182, 182, 246))
    ) {


        Card(
            modifier = Modifier
                .height(height = 355.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(bottomStart = 195.dp, bottomEnd = 195.dp),

            ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_novo),
                    contentDescription = null,
                    modifier = Modifier.size(260.dp),
                    alignment = Alignment.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(42.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
        ) {

            TextComp(
                texto = R.string.title_home,
                fontSize = 26.4.sp,
                fontWeight = FontWeight.SemiBold,
                corText = Color.White,
                )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .offset(y = (-15).dp)
        ) {

            TextComp(
                texto = R.string.segundo_title_home,
                fontSize = 26.4.sp,
                fontWeight = FontWeight.SemiBold,
                corText = Color.White,
                )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {

            TextComp(
                texto = R.string.description_home,
                corText = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight(300),
            )

        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {

            ButtonHome(
                shape = RoundedCornerShape(bottomStart = 10.dp, topStart = 10.dp),
                text = stringResource(id = R.string.button_register),
                navController,
                rota = "register"
            )

            ButtonHome(
                shape = RoundedCornerShape(bottomEnd = 10.dp, topEnd = 10.dp),
                text = stringResource(id = R.string.button_enter),
                navController,
                rota = "login"
            )


        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 75.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextComp(
                texto = R.string.text_switch,
                fontSize = 13.sp,
                fontWeight = FontWeight(400),
                corText = Color.White
            )

            var switchCheckedState by remember { mutableStateOf(false) }

            Row (modifier = Modifier.padding(top = 13.5.dp)) {

                SwitchComp (switchCheckedState = switchCheckedState, CorFundo = Color.White, onCheckedChange = {
                    switchCheckedState = it
                })
            }
        }
    }

}
