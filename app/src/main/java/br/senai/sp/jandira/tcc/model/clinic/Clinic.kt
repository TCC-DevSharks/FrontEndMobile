package br.senai.sp.jandira.tcc.model.clinic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Clinic {
    var id by mutableStateOf(0)
    var clinica by mutableStateOf(listOf<ClinicSpecialityResponse>())
    var cnpj by mutableStateOf("")
    var razao_social by mutableStateOf("")
    var descricao by mutableStateOf("")
    var email by mutableStateOf("")
    var foto by mutableStateOf("")
    var telefone by mutableStateOf("")
    var tipo_telefone by mutableStateOf("")
    var cep by mutableStateOf("")
    var numero by mutableStateOf("")
    var especialidade by mutableStateOf(0)
    var nomeEspecialidade by mutableStateOf("")
    var complemento by mutableStateOf("")
    var logradouro by mutableStateOf("")
    var bairro by mutableStateOf("")
    var estado by mutableStateOf("")
    var cidade by mutableStateOf("")

}

class ModelCep {
    var latitude by mutableStateOf(0.0)
    var longitude by mutableStateOf(0.0)
}