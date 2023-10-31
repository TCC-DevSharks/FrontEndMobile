package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.checkQuery

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header

@Composable
fun checkQuery(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Header(
                titulo = stringResource(id = R.string.consultation_title),
                rota = "",
                navController = navController
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = stringResource(id = R.string.scheduled),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .width(360.dp)
                    .clickable {
//                        navController.navigate("")
                    }
                    .height(85.dp)
                    .padding(bottom = 14.dp),
                colors = CardDefaults.cardColors(Color(255, 255, 255)),
                border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                shape = RoundedCornerShape(16.dp),
            ) {

                Row(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.consulta_icon),
                            contentDescription = null,
                            tint = Color(187, 187, 249),
                            modifier = Modifier
                                .size(35.dp)
                        )


                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(start = 17.dp)
                        ) {

                            Text(
                                text = stringResource(id = R.string.consultation_with) + " " + "Ginecologista",
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                color = Color.Gray,
                            )

                            Text(
                                text = stringResource(id = R.string.date) + " " + "06/10/2023",
                                fontWeight = FontWeight(400),
                                fontSize = 10.5.sp,
                                color = Color.Gray,
                            )

                            Text(
                                text = stringResource(id = R.string.hour) + " " + "17:30",
                                fontWeight = FontWeight(400),
                                fontSize = 10.5.sp,
                                color = Color.Gray
                            )


                        }
                    }

                    Column(
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "R\$200,00",
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Card(
                            modifier = Modifier
                                .width(80.dp)
                                .clickable {
                                }
                                .height(35.dp)
                                .padding(bottom = 14.dp),
                            colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
//                            border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                            shape = RoundedCornerShape(5.dp),
                        )
                        {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = stringResource(id = R.string.details),
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp
                                    ),
                                    color = Color.White
                                )
                            }

                        }

                    }


                }
            }

            Card(
                modifier = Modifier
                    .width(360.dp)
                    .clickable {
//                        navController.navigate("")
                    }
                    .height(85.dp)
                    .padding(bottom = 14.dp),
                colors = CardDefaults.cardColors(Color(255, 255, 255)),
                border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                shape = RoundedCornerShape(16.dp),
            ) {

                Row(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.consulta_icon),
                            contentDescription = null,
                            tint = Color(187, 187, 249),
                            modifier = Modifier
                                .size(35.dp)
                        )


                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(start = 17.dp)
                        ) {

                            Text(
                                text = stringResource(id = R.string.consultation_with) + " " + "Ginecologista",
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                color = Color.Gray,
                            )

                            Text(
                                text = stringResource(id = R.string.date) + " " + "06/10/2023",
                                fontWeight = FontWeight(400),
                                fontSize = 10.5.sp,
                                color = Color.Gray,
                            )

                            Text(
                                text = stringResource(id = R.string.hour) + " " + "17:30",
                                fontWeight = FontWeight(400),
                                fontSize = 10.5.sp,
                                color = Color.Gray
                            )


                        }
                    }

                    Column(
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "R\$200,00",
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Card(
                            modifier = Modifier
                                .width(80.dp)
                                .clickable {
                                }
                                .height(35.dp)
                                .padding(bottom = 14.dp),
                            colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
//                            border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                            shape = RoundedCornerShape(5.dp),
                        )
                        {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = stringResource(id = R.string.details),
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp
                                    ),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = stringResource(id = R.string.performed),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .width(360.dp)
                    .clickable {
//                        navController.navigate("")
                    }
                    .height(85.dp)
                    .padding(bottom = 14.dp),
                colors = CardDefaults.cardColors(Color(255, 255, 255)),
                border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                shape = RoundedCornerShape(16.dp),
            ) {

                Row(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.consulta_icon),
                            contentDescription = null,
                            tint = Color(187, 187, 249),
                            modifier = Modifier
                                .size(35.dp)
                        )


                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(start = 17.dp)
                        ) {

                            Text(
                                text = stringResource(id = R.string.consultation_with) + " " + "Ginecologista",
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                color = Color.Gray,
                            )

                            Text(
                                text = stringResource(id = R.string.date) + " " + "06/10/2023",
                                fontWeight = FontWeight(400),
                                fontSize = 10.5.sp,
                                color = Color.Gray,
                            )

                            Text(
                                text = stringResource(id = R.string.hour) + " " + "17:30",
                                fontWeight = FontWeight(400),
                                fontSize = 10.5.sp,
                                color = Color.Gray
                            )


                        }
                    }

                    Column(
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "R\$200,00",
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Card(
                            modifier = Modifier
                                .width(80.dp)
                                .clickable {
                                }
                                .height(35.dp)
                                .padding(bottom = 14.dp),
                            colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
//                            border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                            shape = RoundedCornerShape(5.dp),
                        )
                        {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = stringResource(id = R.string.details),
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp
                                    ),
                                    color = Color.White
                                )
                            }

                        }

                    }


                }
            }

            Card(
                modifier = Modifier
                    .width(360.dp)
                    .clickable {
//                        navController.navigate("")
                    }
                    .height(85.dp)
                    .padding(bottom = 14.dp),
                colors = CardDefaults.cardColors(Color(255, 255, 255)),
                border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                shape = RoundedCornerShape(16.dp),
            ) {

                Row(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.consulta_icon),
                            contentDescription = null,
                            tint = Color(187, 187, 249),
                            modifier = Modifier
                                .size(35.dp)
                        )


                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(start = 17.dp)
                        ) {

                            Text(
                                text = stringResource(id = R.string.consultation_with) + " " + "Ginecologista",
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                color = Color.Gray,
                            )

                            Text(
                                text = stringResource(id = R.string.date) + " " + "06/10/2023",
                                fontWeight = FontWeight(400),
                                fontSize = 10.5.sp,
                                color = Color.Gray,
                            )

                            Text(
                                text = stringResource(id = R.string.hour) + " " + "17:30",
                                fontWeight = FontWeight(400),
                                fontSize = 10.5.sp,
                                color = Color.Gray
                            )


                        }
                    }

                    Column(
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "R\$200,00",
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Card(
                            modifier = Modifier
                                .width(80.dp)
                                .clickable {
                                }
                                .height(35.dp)
                                .padding(bottom = 14.dp),
                            colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
//                            border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                            shape = RoundedCornerShape(5.dp),
                        )
                        {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = stringResource(id = R.string.details),
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp
                                    ),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
            Card(
                modifier = Modifier
                    .width(360.dp)
                    .clickable {
//                        navController.navigate("")
                    }
                    .height(85.dp)
                    .padding(bottom = 14.dp),
                colors = CardDefaults.cardColors(Color(255, 255, 255)),
                border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                shape = RoundedCornerShape(16.dp),
            ) {

                Row(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.consulta_icon),
                            contentDescription = null,
                            tint = Color(187, 187, 249),
                            modifier = Modifier
                                .size(35.dp)
                        )


                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(start = 17.dp)
                        ) {

                            Text(
                                text = stringResource(id = R.string.consultation_with) + " " + "Ginecologista",
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                color = Color.Gray,
                            )

                            Text(
                                text = stringResource(id = R.string.date) + " " + "06/10/2023",
                                fontWeight = FontWeight(400),
                                fontSize = 10.5.sp,
                                color = Color.Gray,
                            )

                            Text(
                                text = stringResource(id = R.string.hour) + " " + "17:30",
                                fontWeight = FontWeight(400),
                                fontSize = 10.5.sp,
                                color = Color.Gray
                            )


                        }
                    }

                    Column(
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "R\$200,00",
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Card(
                            modifier = Modifier
                                .width(80.dp)
                                .clickable {
                                }
                                .height(35.dp)
                                .padding(bottom = 14.dp),
                            colors = CardDefaults.cardColors(Color(182, 182, 246, 100)),
//                            border = BorderStroke(width = .4.dp, color = Color(182, 182, 246)),
                            shape = RoundedCornerShape(5.dp),
                        )
                        {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = stringResource(id = R.string.details),
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp
                                    ),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}