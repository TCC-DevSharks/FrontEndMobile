package br.senai.sp.jandira.tcc.model.exercises

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ModelExercises {
    var id by mutableStateOf(0)
    var descricao by mutableStateOf("")
    var video by mutableStateOf("")
    var nome by mutableStateOf("")
    var categoria by mutableStateOf("")
}