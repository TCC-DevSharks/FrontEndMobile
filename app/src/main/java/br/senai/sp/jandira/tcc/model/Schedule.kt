package br.senai.sp.jandira.tcc.model

import java.util.Date

data class Schedule(
    val id: Int,
    val dia: Date,
    val titulo: String,
    val lembrete: Boolean,
    val descricao: String,
    val IdGestante: Int

    )
