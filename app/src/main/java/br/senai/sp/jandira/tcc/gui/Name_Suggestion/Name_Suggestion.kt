package br.senai.sp.jandira.tcc.gui.Name_Suggestion

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun Name_Suggestion() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(titulo = stringResource(id = R.string.name_suggestion))

            SubHeader(
                leftText = stringResource(id = R.string.suggested),
                rightText = stringResource(id = R.string.favorites))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                modifier = Modifier
                    .size(width = 120.dp, height = 60.dp)
                    .padding(vertical = 9.dp, horizontal = 4.dp).align(alignment = Alignment.CenterVertically),
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

        Row(
            modifier = Modifier
                .padding(start = 15.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                modifier = Modifier
                    .size(width = 60.dp, height = 50.dp)
                    .padding(vertical = 9.dp, horizontal = 4.dp),
                colors = CardDefaults.cardColors(Color(182, 182, 246)),
                shape = RoundedCornerShape(50.dp),
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "A",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(5.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .size(width = 350.dp, height = 130.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(20.dp)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_cinza),
                            contentDescription = null
                        )
                    }

                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_cinza),
                            contentDescription = null
                        )

                    }

                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_roxo),
                            contentDescription = null
                        )
                    }

                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_cinza),
                            contentDescription = null
                        )

                    }

                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_cinza),
                            contentDescription = null
                        )
                    }

                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_roxo),
                            contentDescription = null
                        )

                    }

                }

            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier
                .padding(start = 15.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                modifier = Modifier
                    .size(width = 60.dp, height = 50.dp)
                    .padding(vertical = 9.dp, horizontal = 4.dp),
                colors = CardDefaults.cardColors(Color(182, 182, 246)),
                shape = RoundedCornerShape(50.dp),
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "B",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(5.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(width = 350.dp, height = 130.dp).verticalScroll(
                    rememberScrollState()
                ),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(20.dp)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_cinza),
                            contentDescription = null
                        )
                    }

                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_roxo),
                            contentDescription = null
                        )

                    }

                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_roxo),
                            contentDescription = null
                        )
                    }

                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_roxo),
                            contentDescription = null
                        )

                    }

                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_cinza),
                            contentDescription = null
                        )
                    }

                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_cinza),
                            contentDescription = null
                        )

                    }

                }

            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier
                .padding(start = 15.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                modifier = Modifier
                    .size(width = 60.dp, height = 50.dp)
                    .padding(vertical = 9.dp, horizontal = 4.dp),
                colors = CardDefaults.cardColors(Color(182, 182, 246)),
                shape = RoundedCornerShape(50.dp),
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "C",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
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
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_cinza),
                            contentDescription = null
                        )
                    }

                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = "Alessandro",
                            fontSize = 20.sp
                        )
                        Image(
                            modifier = Modifier.padding(top = 3.dp),
                            painter = painterResource(id = R.drawable.coracao_roxo),
                            contentDescription = null
                        )
                    }
                }
            }
        }





    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Name_SuggestionPreview() {
    Name_Suggestion()
}