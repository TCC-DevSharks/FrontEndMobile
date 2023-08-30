package br.senai.sp.jandira.tcc.gui.MaternityBag

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import br.senai.sp.jandira.tcc.componentes.SubHeader


@Composable
fun MaternityBagScreen() {

    Column(modifier = Modifier.fillMaxSize()) {

        val expanded = remember { mutableStateOf(false) }


        Header(
            titulo = stringResource(id = R.string.header_maternity_bag),
//            rota = "homeUser",
//            navController = navController
        )

        SubHeader(
            leftText = stringResource(id = R.string.my_list),
            rightText = stringResource(id = R.string.all)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()

            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(19.dp)
                        .background(Color.Yellow)
                        .clickable {

                            expanded.value = !expanded.value
                        }

                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Image(painter = painterResource(id = R.drawable.baseline_add_circle_65),
                            contentDescription = null,
                            modifier = Modifier
                                .clickable {
//                                navController.navigate(rota)
                                }
                                .size(35.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Mamadeiras e Bicos",
                            fontSize = 16.8.sp,
                            fontWeight = FontWeight(700),
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(
                                vertical = 5.dp,
                                horizontal = 14.dp
                            )
                    ) {

                        Text(if (expanded.value) "Show lfghdfghdfgdfgdfgdfgdfgdfgdfgdfgdfgdfggggggggggess" else "ffff")

                    }


                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(19.dp)
                        .background(Color.Yellow)
                        .clickable {

                            expanded.value = !expanded.value
                        }

                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Image(painter = painterResource(id = R.drawable.baseline_add_circle_65),
                            contentDescription = null,
                            modifier = Modifier
                                .clickable {
//                                navController.navigate(rota)
                                }
                                .size(35.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Mamadeiras e Bicos",
                            fontSize = 16.8.sp,
                            fontWeight = FontWeight(700),
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(
                                vertical = 5.dp,
                                horizontal = 14.dp
                            )
                    ) {

                        Text(if (expanded.value) "Show lfghdfghdfgdfgdfgdfgdfgdfgdfgdfgdfgdfggggggggggess" else "ffff")

                    }


                }


            }


        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MaternityBagPreview() {
    MaternityBagScreen()
}