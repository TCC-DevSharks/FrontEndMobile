package br.senai.sp.jandira.tcc.model.chatUser

data class ChatMessagesResponse(
    var _id: String,
    var text: String,
    var users: List<String>,
    var sender: String
)
