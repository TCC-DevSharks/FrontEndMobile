package br.senai.sp.jandira.tcc.model.professional

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Professional {
    var crm by mutableStateOf("")
    var descricao by mutableStateOf("")
    var especialidade by mutableStateOf("")
    var nome by mutableStateOf("")
    var id by mutableStateOf(0)
    var profissional by mutableStateOf(listOf<ProfessionalSpecialityResponse>())
    var email by mutableStateOf("")
    var foto by mutableStateOf("")
    var telefone by mutableStateOf("")
    var tipo_telefone by mutableStateOf("")
    var cep by mutableStateOf("")
    var numero by mutableStateOf("")


}