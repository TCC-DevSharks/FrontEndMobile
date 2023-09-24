package br.senai.sp.jandira.tcc.model.professional

data class ProfessionalSpecialityResponse(

    val id: Int,
    val nome: String,
    val cpf: String,
    val crm: String,
    val data_nascimento: String,
    val foto: String,
    val inicio_atendimento: String,
    val fim_atendimento: String,
    val email: String,
    val sexo: String,
    val clinica: String,
    val telefone: String,
    val tipo_telefone: String,
    val numero: String,
    val complemento: String,
    val cep: String,
    val especialidade: String,
)
