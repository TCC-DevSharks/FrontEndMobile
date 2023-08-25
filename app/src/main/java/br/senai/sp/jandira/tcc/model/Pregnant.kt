package br.senai.sp.jandira.tcc.model

data class Pregnant(
    val id: Int,
    val nome: String,
    val data_nascimento: String,
    val email: String,
    val senha: String,
    val cpf: String,
    val peso: String,
    val altura: String,
    val data_parto: String,
    val foto: String,
    val semana_gestacao: String,
    val telefone: String,
    val tipo_telefone: String

)
