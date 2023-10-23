package br.senai.sp.jandira.tcc.model.schedule

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ModelSchedule{
    var id by mutableStateOf(0)
    var dia by mutableStateOf("")
    var titulo by mutableStateOf("")
    var lembrete by mutableStateOf(0)
    var descricao by mutableStateOf("")
    var IdGestante by mutableStateOf(0)
}

