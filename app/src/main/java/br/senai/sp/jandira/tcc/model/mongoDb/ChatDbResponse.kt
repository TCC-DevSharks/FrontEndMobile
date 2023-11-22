package br.senai.sp.jandira.tcc.model.mongoDb

import java.time.LocalTime

data class ChatDbResponse(
    val _id: String,
    val text: String,
    val users: List<String>,
    val sender: String,
    val timestamp: LocalTime

)
