package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun NavigationDoctor(navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(70.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 7.7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clickable {
//                        navController.navigate("register")

                }) {
                Image(
                    painter = painterResource(id = R.drawable.chat_cinza),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )
            }


            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clickable {
                        navController.navigate("medicalRecordSelect")

                }) {
                Image(
                    painter = painterResource(id = R.drawable.clipboard_doctor),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )
            }


            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clickable {
                    navController.navigate("git")

                }) {

                Image(
                    painter = painterResource(id = R.drawable.calendar_doctor),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )

            }


        }


    }

}