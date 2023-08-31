package br.senai.sp.jandira.tcc.gui.ProfileDate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.Header
import br.senai.sp.jandira.tcc.componentes.OutlinedTextFieldSenha


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDate() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header(titulo = stringResource(id = R.string.header_date))

        Spacer(modifier = Modifier.height(5.dp))
        Row() {
            Text(
                text =  stringResource(id = R.string.people_date),
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {

            Row() {
                OutlinedTextField(value = "", onValueChange = {})


            }
            Row {

            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfileDatePreview() {
    ProfileDate()
}