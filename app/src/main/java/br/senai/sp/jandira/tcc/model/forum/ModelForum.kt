package br.senai.sp.jandira.tcc.model.forum

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import br.senai.sp.jandira.tcc.model.forum.category.ResponseCategory
import br.senai.sp.jandira.tcc.model.forum.topic.ResponseTopic

class ModelForum {
    var _id by  mutableStateOf("")
    var username by  mutableStateOf("")
    var foto by  mutableStateOf("")
    var mysql by  mutableStateOf(0)
    var categorias by mutableStateOf(listOf<ResponseCategory>())
    var topicos by mutableStateOf(listOf<ResponseTopic>())
    var mensagemId by  mutableStateOf("")

}