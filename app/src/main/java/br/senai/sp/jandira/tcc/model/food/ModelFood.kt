package br.senai.sp.jandira.tcc.model.food

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class ModelFood {
    var id by mutableStateOf(0)
    var categoria by mutableStateOf(0)
    var refeicao by mutableStateOf(0)
    var refeicaoPadrao by mutableStateOf(0)
    var nomeRefeicao by mutableStateOf("")


}