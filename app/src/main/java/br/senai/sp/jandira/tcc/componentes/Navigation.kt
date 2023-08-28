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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import br.senai.sp.jandira.tcc.R
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid


@Composable
fun Navigation() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
                .size(400.dp, 80.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth().background(Color.Black),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Box(contentAlignment = Alignment.Center, modifier = Modifier.clickable {

                }) {
                    Image(
                        painter = painterResource(id = R.drawable.dumbbell_branco),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )

                }

                Box(contentAlignment = Alignment.Center, modifier = Modifier.clickable {
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.utensils_branco),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }




                Box(
                    modifier = Modifier
                        .background(Color(182, 182, 246), CircleShape)
                        .size(60.dp), contentAlignment = Alignment.Center
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.house_branco),
                        contentDescription = null,
                        modifier = Modifier.size(33.dp),
                    )
                }



                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.clickable {
                    }) {
                    Image(
                        painter = painterResource(id = R.drawable.chat_branco),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }


                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.clickable {



                }) {

                    Image(
                        painter = painterResource(id = R.drawable.search_branco),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )

                }


            }


        }

    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavigationPreview() {
    Navigation()
}