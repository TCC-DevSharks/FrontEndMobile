package br.senai.sp.jandira.tcc.gui.Consultation.Address

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.TextTitle

@Composable
fun AddressScreen() {

//    ArrowLeftPurple(navController = navController, rota = "")

    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 26.dp, top = 35.dp),
        ) {

            Image(
                painter = painterResource(id = R.drawable.arrow_circle_purple_24),
                contentDescription = null,
                Modifier
                    .clickable {

                    }
                    .size(40.dp),
            )
        }

        Row (modifier = Modifier.padding(horizontal = 45.dp, vertical = 10.dp)) {
            TextTitle(texto = R.string.title_address,
                fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(39.dp))

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)) {

            Text(text = stringResource(id = R.string.personal_information),
                fontSize = 16.sp,
                color = Color(182,182,246),
                fontWeight = FontWeight(900)
            )
        }





    }


}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AddressScreenPreview() {
    AddressScreen()
}