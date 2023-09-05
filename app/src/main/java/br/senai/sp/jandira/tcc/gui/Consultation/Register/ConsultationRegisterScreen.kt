package br.senai.sp.jandira.tcc.gui.Consultation.Register

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R

@Composable
fun ConsultationRegisterScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(start = 26.dp, top = 35.dp)) {
                Image(painter = painterResource(id = R.drawable.arrow_circle_purple_24),
                        contentDescription = null,
                        Modifier
                                .clickable {}
                                .size(40.dp))
            }

        }

        Spacer(modifier = Modifier.height(50.dp))
        Column(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 70.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(Modifier.offset(x = 0.dp, y = 75.dp)) {
                Text(
                        textAlign = TextAlign.Center,
                        text = buildAnnotatedString {
                            append("Sua consulta com a ")
                            withStyle(
                                    style = SpanStyle(
                                            color = Color(182, 182, 246),
                                            fontWeight = FontWeight.Bold
                                    )
                            ) {
                                append("Nutricionista Rebekka")
                            }
                            append(" foi agendada!")
                        },
                        fontSize = 20.sp
                )
            }

        }

        Spacer(modifier = Modifier.height(100.dp))

        Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                    modifier = Modifier.size(130.dp),
                    shape = CircleShape,
                    border = BorderStroke(7.dp, Color(182, 182, 246))

            ) {
                Image(
                        painter = painterResource(id = R.drawable.avia),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Row {
                    Text(
                            text = "Dia:",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                    )

                }
                Spacer(modifier = Modifier.width(5.dp))
                Row {
                    Text(
                            text = "14/02/2023",
                            fontSize = 20.sp,
                            color = Color(57, 57, 56)
                            )
                }
            }
            Row {
                Row {
                    Text(
                            text = "Hora:",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                    )

                }
                Spacer(modifier = Modifier.width(5.dp))
                Row {
                    Text(
                            text = "14:00h",
                            fontSize = 20.sp,
                            color = Color(57, 57, 56)
                            )
                }
            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConsultationRegisterScreenPreview() {
    ConsultationRegisterScreen()
}