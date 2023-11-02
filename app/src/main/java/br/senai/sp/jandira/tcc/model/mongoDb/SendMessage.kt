package br.senai.sp.jandira.tcc.model.mongoDb

import java.time.LocalTime

data class SendMessage(
    var text: String,
    var users: List<String>,
    var sender: String,
    var timestamp: LocalTime
)
