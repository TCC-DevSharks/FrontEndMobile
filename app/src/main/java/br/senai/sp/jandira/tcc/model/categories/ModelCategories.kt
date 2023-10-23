package br.senai.sp.jandira.tcc.model.categories

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ModelCategories {
    var id by mutableStateOf(0)
    var categoria by mutableStateOf("")
    var imagemCapa by mutableStateOf("")
}