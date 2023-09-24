package br.senai.sp.jandira.tcc.model.clinic

data class ClinicResponse(
    val id: Int,
    val cnpj: String,
    val razao_social: String,
    val descricao: String,
    val email: String,
    val foto: String,
    val telefone: String,
    val tipo_telefone: String,
    val numero: String,
    val cep: String
)
