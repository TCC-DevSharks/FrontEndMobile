package br.senai.sp.jandira.tcc.model.clinic

data class ClinicSpecialityResponse(
    val id: Int,
    val razao_social: String,
    val foto: String,
    val descricao: String,
    val cep: String
)
