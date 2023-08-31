package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R


@Composable
fun Navigation(navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 7.7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Box(contentAlignment = Alignment.Center, modifier = Modifier
                .clickable {
//                    navController.navigate("home")

                }) {
                Image(
                    painter = painterResource(id = R.drawable.dumbbell_cinza),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )

            }

            Box(contentAlignment = Alignment.Center, modifier = Modifier.clickable {
//                    navController.navigate("calendar")

            }) {
                Image(
                    painter = painterResource(id = R.drawable.utensils_cinza),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )
            }




            Box(
                modifier = Modifier
                    .background(Color(182, 182, 246), CircleShape)
                    .size(60.dp)
                    .clickable {
//                            navController.navigate("week")
                    }, contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.house_branco),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp),
                )
            }



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
//                        navController.navigate("forgot_password")

                }) {

                Image(
                    painter = painterResource(id = R.drawable.search_cinza),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )

            }


        }


    }


}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun NavigationPreview() {
//    Navigation()
//}