package br.senai.sp.jandira.tcc.model.consult

data class ConsultResponseMedicalRecord(
    val idConsulta: Int,
    val idGestante: Int,
    val nome: String,
    val emailGestante: String,
    val semana_gestacao: Int,
    val foto: String,
    val altura: Double,
    val peso: Double,
    val data_nascimento: String,
    val especialidade: String,
    val dia: String,
    val hora: String,
)
