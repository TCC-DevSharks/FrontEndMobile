package br.senai.sp.jandira.tcc.gui.Home

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun CadastroScren (navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
                    .background(Color(236, 238, 255)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(300.dp),
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

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.title_home),
                textAlign = TextAlign.Center,
                fontSize = 26.4.sp,
                fontWeight = FontWeight.SemiBold,
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.segundo_title_home),
                textAlign = TextAlign.Center,
                fontSize = 26.4.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {

            Text(
                text = stringResource(id = R.string.description_home) ,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight(300),
                color = Color(70, 68, 68)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {

            Button(
                onClick = {
                    navController.navigate("register")
                },
                modifier = Modifier
                    .height(55.dp)
                    .width(168.dp)
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(bottomStart = 10.dp, topStart = 10.dp)
                    ),
                shape = RoundedCornerShape(bottomStart = 10.dp, topStart = 10.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(width = .1.dp, Color.Gray)
            ) {
                Text(
                    text = stringResource(id = R.string.button_register),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(800),
                    color = Color.Black,
                )

            }

            Button(
                onClick = {
                    navController.navigate("login")
                },
                modifier = Modifier
                    .height(55.dp)
                    .width(168.dp)
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(bottomEnd = 10.dp, topEnd = 10.dp)
                    ),
                shape = RoundedCornerShape(bottomEnd = 10.dp, topEnd = 10.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(width = .1.dp, Color.Gray)
            ) {
                Text(
                    text = stringResource(id = R.string.button_enter) ,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(800),
                    color = Color.Black,
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 75.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.text_switch),
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                fontWeight = FontWeight(300)
            )

            var switchCheckedState by remember { mutableStateOf(false) }

            Switch(
                checked = switchCheckedState,
                onCheckedChange = {
                    switchCheckedState = it

                    if (it) {
                        // Código para quando o Switch estiver ligado
                    } else {
                        // Código para quando o Switch estiver desligado
                    }
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = if (switchCheckedState) Color(182,182,246) else Color(217, 217, 217),
                    checkedTrackColor = Color(182,182,246,51),
                    checkedBorderColor = Color(182,182,246),
                    uncheckedThumbColor = Color(217, 217, 217),
                    uncheckedTrackColor = Color.White,
                    disabledCheckedBorderColor = Color(182,182,246))
            )
        }
    }

}
