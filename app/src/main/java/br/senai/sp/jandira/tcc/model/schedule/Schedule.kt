package br.senai.sp.jandira.tcc.model.schedule

data class Schedule(
    val id: Int,
    val dia: String,
    val titulo: String,
    val lembrete: Number,
    val descricao: String,
    val id_gestante: Int
)
