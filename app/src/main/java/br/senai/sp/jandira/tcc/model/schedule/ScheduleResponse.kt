package br.senai.sp.jandira.tcc.model.schedule

data class ScheduleResponse(
    val dia: String,
    val titulo: String,
    val lembrete: Number,
    val descricao: String,
    val id_gestante: Int
)
