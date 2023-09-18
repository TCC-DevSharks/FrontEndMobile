package br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.speciality

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.TextComp

@Composable
fun ConsultationSpecialityScreen() {

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 70.dp)
            ) {

                Header(titulo = stringResource(id = R.string.header_speciality),
                    tintIcon = Color(255, 218, 185)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .height(.3.dp)
                ) {

                }

                Spacer(modifier = Modifier.height(60.dp))

                Row(modifier = Modifier.padding(horizontal = 50.dp, vertical = 2.dp)) {

                    TextComp(
                        texto = R.string.which_specialty,
                        fontSize = 21.sp,
                        fontWeight = FontWeight(400)
                    )

                }

                Spacer(modifier = Modifier.height(35.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Button(
                        onClick =
                        {

                        },
                        modifier = Modifier
                            .width(340.dp)
                            .height(70.dp),
                        colors = ButtonDefaults.buttonColors(Color(182, 182, 246)),

                        shape = RoundedCornerShape(16.dp),

                        ) {
                        Text(
                            text = "Nutricionista",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }










            }




            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .border(
                        .9.dp,
                        Color(182, 182, 246),
                        shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                    )
            ) {

//                Navigation(navController = navController)


            }

        }


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConsultationSpecialityScreenPreview() {
    ConsultationSpecialityScreen()
}