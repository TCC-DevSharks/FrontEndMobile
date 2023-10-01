package br.senai.sp.jandira.tcc.model.consult

data class ConsultResponse(
    val dia: String,
    val hora: String,
    val id_profissional: Int,
    val id_gestante: Int
)
