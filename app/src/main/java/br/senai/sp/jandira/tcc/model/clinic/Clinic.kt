package br.senai.sp.jandira.tcc.model.clinic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Clinic {
    var clinica by mutableStateOf(listOf<ClinicResponse>())

}