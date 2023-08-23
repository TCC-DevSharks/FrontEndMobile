package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.R

@Composable
fun Schedule() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Card(
            modifier = Modifier
                .width(350.dp)
                .height(174.dp),
            colors = CardDefaults.cardColors(Color.White)

            ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(id = R.drawable.calendar),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )

                    Text(
                        text = "Sua agenda",
                        fontSize = 17.sp,
                        modifier = Modifier.padding(start = 16.dp),
                        fontWeight = FontWeight.SemiBold,
//                        textDecoration = TextDecoration.Underline,
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.baseline_add_circle_24),
                    contentDescription = null,
                    alignment = Alignment.BottomEnd,
                    modifier = Modifier.size(32.dp)
                )
            }

            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Checkbox(
                            checked = false,
                            onCheckedChange = {},
                            colors = CheckboxDefaults.colors(Color.Red),
                        )

                        Text(
                            text = "Lorem ipsum dolofdhfghffdfdr",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )

                    }

                    Row(modifier = Modifier.fillMaxWidth()) {

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "30/09",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.End
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Checkbox(
                            checked = false,
                            onCheckedChange = {},
                            colors = CheckboxDefaults.colors(Color.Red),
                        )

                        Text(
                            text = "Lorem ipsum dolofdhfhfgfdfdr",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )

                    }

                    Row(modifier = Modifier.fillMaxWidth()) {

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "30/09",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.End
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Checkbox(
                            checked = false,
                            onCheckedChange = {},
                            colors = CheckboxDefaults.colors(Color.Red),
                        )

                        Text(
                            text = "Lorem ipsum dolofdhfghgfdfdr",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )

                    }

                    Row(modifier = Modifier.fillMaxWidth()) {

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "30/09",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.End
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Checkbox(
                            checked = false,
                            onCheckedChange = {},
                            colors = CheckboxDefaults.colors(Color.Red),
                        )

                        Text(
                            text = "Lorem ipsum dolofdhfghfdfdr",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )

                    }

                    Row(modifier = Modifier.fillMaxWidth()) {

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "30/09",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.End
                        )
                    }
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Checkbox(
                            checked = false,
                            onCheckedChange = {},
                            colors = CheckboxDefaults.colors(Color.Red),
                        )

                        Text(
                            text = "Lorem ipsum dolofdhfghfgdfdr",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )

                    }

                    Row(modifier = Modifier.fillMaxWidth()) {

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "30/09",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.End
                        )
                    }
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Checkbox(
                            checked = false,
                            onCheckedChange = {},
                            colors = CheckboxDefaults.colors(Color.Red),
                        )

                        Text(
                            text = "Lorem ipsum dolofdhfghfghffdr",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )

                    }

                    Row(modifier = Modifier.fillMaxWidth()) {

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "30/09",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.End
                        )
                    }
                }

            }

        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScredulePreview() {
    Schedule()
}