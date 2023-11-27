package br.senai.sp.jandira.tcc.model.forum.topic

data class ResponseTopic(
    val _id: String,
    val category: String,
    val title: String,
    val text: String,
    val user: ResponseUserTopic,
    val date: String
)

data class ResponseUserTopic(
    val _id: String,
    val username: String,
    val foto: String,
    val mysql: String,
    val age: String,
)
