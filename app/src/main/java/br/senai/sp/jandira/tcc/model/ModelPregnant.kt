package br.senai.sp.jandira.tcc.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ModelPregnant {
    var id by mutableStateOf(0)
    var nome by mutableStateOf("")
    var data_nascimento by mutableStateOf("")
    var email by mutableStateOf("")
    var senha by mutableStateOf("")
    var cpf by mutableStateOf("")
    var peso by mutableStateOf(0.0)
    var altura by mutableStateOf(0.0)
    var data_parto by mutableStateOf("")
    var foto by mutableStateOf("")
    var semana_gestacao by mutableStateOf(0)
    var telefone by mutableStateOf("")
    var cep by mutableStateOf("")
    var complemento by mutableStateOf("")
    var numero by mutableStateOf("")
    var idade by mutableStateOf(0)
    var alergia by mutableStateOf("")
    var comorbidades by mutableStateOf("")
    var medicacao by mutableStateOf("")
    var logradouro by mutableStateOf("")
    var bairro by mutableStateOf("")
    var cidade by mutableStateOf("")
    var estado by mutableStateOf("")

}