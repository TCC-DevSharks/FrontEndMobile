package br.senai.sp.jandira.tcc.model.medicalRecord

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ModelMedicalRecord {

    var id by mutableStateOf(0)
    var descricao by mutableStateOf("")
    var id_consulta by mutableStateOf(0)
    var dia by mutableStateOf("")
    var hora by mutableStateOf("")
    var id_profissional by mutableStateOf(0)
    var id_gestante by mutableStateOf(0)
    var profissional by mutableStateOf("")
    var gestante by mutableStateOf("")

}