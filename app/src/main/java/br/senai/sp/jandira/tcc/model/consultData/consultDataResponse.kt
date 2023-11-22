package br.senai.sp.jandira.tcc.model.consultData

data class consultDataResponse(
    val gestante: String,
    val email: String,
    val cpf: String,
    val telefone: String,
    val numero: String,
    val complemento: String,
    val cep: String,
    val clinica: String,
    val numeroClinica: String,
    val complementoClinica: String,
    val telefoneClinica: String,
    val cepClinica: String,
    val profissional: String,
    val especialidade: String,
    val dia: String,
    val hora: String

)
