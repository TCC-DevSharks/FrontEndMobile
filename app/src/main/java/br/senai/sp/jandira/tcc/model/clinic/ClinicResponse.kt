package br.senai.sp.jandira.tcc.model.clinic

data class ClinicResponse(
    val id: String,
    val razao_social: String,
    val foto: String,
    val descricao: String,
    val cep: String
)
