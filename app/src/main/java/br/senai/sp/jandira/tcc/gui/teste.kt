package br.senai.sp.jandira.tcc.gui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.tcc.componentes.CardPreparations

@Composable
fun teste() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyRow(modifier = Modifier.padding(horizontal = 28.dp)) {

            items(listOf("Plano de Parto", "Enxoval", "Mala de Maternidade", "Sugestão de Nomes")) { category ->


                CardPreparations(category)




            }
        }

    }
}