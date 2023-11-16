package br.senai.sp.jandira.tcc.model.forum.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class ModelUser {
    var _id by  mutableStateOf("")
    var username by  mutableStateOf("")
    var foto by  mutableStateOf("")
    var mysql by  mutableStateOf(0)
}