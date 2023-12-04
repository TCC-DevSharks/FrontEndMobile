package br.senai.sp.jandira.tcc.model.professional

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import br.senai.sp.jandira.tcc.model.professional.consult.ProfessionalConsultResponse

class Professional {
    var crm by mutableStateOf("")
    var cpf by mutableStateOf("")
    var descricao by mutableStateOf("")
    var especialidade by mutableStateOf("")
    var nome by mutableStateOf("")
    var id by mutableStateOf(0)
    var profissional by mutableStateOf(listOf<ProfessionalSpecialityResponse>())
    var consulta by mutableStateOf(listOf<ProfessionalConsultResponse>())
    var email by mutableStateOf("")
    var senha by mutableStateOf("")
    var foto by mutableStateOf("")
    var telefone by mutableStateOf("")
    var tipo_telefone by mutableStateOf("")
    var cep by mutableStateOf("")
    var numero by mutableStateOf("")
    var clinica by mutableStateOf("")
    var data_nascimento by mutableStateOf("")
    var inicio_atendimento by mutableStateOf("")
    var fim_atendimento by mutableStateOf("")
    var valor by mutableStateOf("200")
    var sexo by mutableStateOf("")
    var complemento by mutableStateOf("")
    var id_endereco by mutableStateOf(0)
    var id_telefone by mutableStateOf(0)
    var idSexo by mutableStateOf(0)
    var idTipo by mutableStateOf(0)
    var idClinica by mutableStateOf(0)
    var id_gestante by mutableStateOf(0)
    var id_dieta by mutableStateOf(0)
}