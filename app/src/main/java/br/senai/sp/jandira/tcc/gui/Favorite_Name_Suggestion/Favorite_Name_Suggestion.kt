package br.senai.sp.jandira.tcc.gui.Favorite_Name_Suggestion

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.SubHeader

@Composable
fun Favorite_Name_Suggestion() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(titulo = stringResource(id = R.string.name_suggestion))

            SubHeader(
                leftText = stringResource(id = R.string.suggested),
                rightText = stringResource(id = R.string.favorites)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                modifier = Modifier
                    .size(width = 120.dp, height = 60.dp)
                    .padding(vertical = 9.dp, horizontal = 4.dp)
                    .align(alignment = Alignment.CenterVertically),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(50.dp),
                border = BorderStroke(width = 2.dp , Color(182,182,246))
            ){
                Image(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.gender_baixo),
                    contentDescription = null
                )
            }

            Card(
                modifier = Modifier
                    .size(width = 120.dp, height = 60.dp)
                    .padding(vertical = 9.dp, horizontal = 4.dp),
                colors = CardDefaults.cardColors(Color(182,182,246)),
                shape = RoundedCornerShape(50.dp)
            ){
                Image(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally,),
                    painter = painterResource(id = R.drawable.gender_cima),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(width = 350.dp, height = 60.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(20.dp)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )

                    }
                    var isRed by remember { mutableStateOf(false) }
                    Row( modifier = Modifier.clickable{
                        isRed = !isRed
                    }) {
                        val imageResource = if (isRed) {
                            R.drawable.coracao_roxo
                        } else{
                            R.drawable.coracao_cinza
                        }
                        Image(
                            painter = painterResource(id = imageResource),
                            contentDescription = null,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier.size(width = 350.dp, height = 60.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(20.dp)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )

                    }
                    var isRed by remember { mutableStateOf(false) }
                    Row( modifier = Modifier.clickable{
                        isRed = !isRed
                    }) {
                        val imageResource = if (isRed) {
                            R.drawable.coracao_roxo
                        } else{
                            R.drawable.coracao_cinza
                        }
                        Image(
                            painter = painterResource(id = imageResource),
                            contentDescription = null,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


            Card(
                modifier = Modifier.size(width = 350.dp, height = 60.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(20.dp)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )

                    }
                    var isRed by remember { mutableStateOf(false) }
                    Row( modifier = Modifier.clickable{
                        isRed = !isRed
                    }) {
                        val imageResource = if (isRed) {
                            R.drawable.coracao_roxo
                        } else{
                            R.drawable.coracao_cinza
                        }
                        Image(
                            painter = painterResource(id = imageResource),
                            contentDescription = null,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier.size(width = 350.dp, height = 60.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(20.dp)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )

                    }
                    var isRed by remember { mutableStateOf(false) }
                    Row( modifier = Modifier.clickable{
                        isRed = !isRed
                    }) {
                        val imageResource = if (isRed) {
                            R.drawable.coracao_roxo
                        } else{
                            R.drawable.coracao_cinza
                        }
                        Image(
                            painter = painterResource(id = imageResource),
                            contentDescription = null,
                        )
                    }
                }
            }

            Card(
                modifier = Modifier.size(width = 350.dp, height = 60.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(20.dp)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )

                    }
                    var isRed by remember { mutableStateOf(false) }
                    Row( modifier = Modifier.clickable{
                        isRed = !isRed
                    }) {
                        val imageResource = if (isRed) {
                            R.drawable.coracao_roxo
                        } else{
                            R.drawable.coracao_cinza
                        }
                        Image(
                            painter = painterResource(id = imageResource),
                            contentDescription = null,
                        )
                    }
                }
            }

            Card(
                modifier = Modifier.size(width = 350.dp, height = 60.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(20.dp)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row() {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )

                    }
                    var isRed by remember { mutableStateOf(false) }
                    Row( modifier = Modifier.clickable{
                        isRed = !isRed
                    }) {
                        val imageResource = if (isRed) {
                            R.drawable.coracao_roxo
                        } else{
                            R.drawable.coracao_cinza
                        }
                        Image(
                            painter = painterResource(id = imageResource),
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Favorite_Name_SuggestionPreview() {
    Favorite_Name_Suggestion()
}