package br.senai.sp.jandira.tcc.model.chatMesssages

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import br.senai.sp.jandira.tcc.model.chatUser.ChatUserResponse
import br.senai.sp.jandira.tcc.model.mongoDb.ChatDbResponse
import br.senai.sp.jandira.tcc.model.mongoDb.ChatDbResponseList

class ChatModel {
    var user by mutableStateOf("")
    var profissional by mutableStateOf("")
    var foto by mutableStateOf("")
    var nomeProfissional by mutableStateOf("")
    var msgs by mutableStateOf(listOf<ChatDbResponse>())
}
