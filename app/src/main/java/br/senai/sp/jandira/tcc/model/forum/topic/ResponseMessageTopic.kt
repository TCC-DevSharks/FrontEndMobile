package br.senai.sp.jandira.tcc.model.forum.topic

data class ResponseMessageTopic(
    val _id: String,
    val category: String,
    val title: String,
    val text: String,
    val user: ResponseUserTopic,
    val date: String,
    val messages: List<ResponseMessage>
)

data class ResponseMessageUserTopic(
    val _id: String,
    val username: String,
    val foto: String,
    val mysql: String,
    val age: String,
)

data class ResponseMessage(
    val _id: String,
    val topic: String,
    val user: ResponseMessageUserTopic,
    val text: String,
    val date: String,
)