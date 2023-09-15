package br.senai.sp.jandira.tcc.gui.Chat.Description

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.tcc.R

@Composable
fun DescriptionContact() {

    Box(modifier = Modifier.fillMaxSize()) {

        Row {

            Image(painter = painterResource(id = R.drawable.arrow_circle_purple_24),
                contentDescription = null,
                Modifier.clickable {
                }.size(40.dp),
            )
        }




    }


}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun DescriptionContactPreview() {
    DescriptionContact()
}