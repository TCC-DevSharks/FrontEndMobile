package br.senai.sp.jandira.tcc.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import br.senai.sp.jandira.tcc.model.especiality.EspecialityResponse

class ModelSpeciality {

    var especialidade by mutableStateOf(listOf<EspecialityResponse>())
    var idEspecialidade by mutableStateOf(0)
}