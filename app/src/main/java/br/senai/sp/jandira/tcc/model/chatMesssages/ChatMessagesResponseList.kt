package br.senai.sp.jandira.tcc.model.chatMesssages

import br.senai.sp.jandira.tcc.model.chatUser.ChatMessagesResponse

data class ChatMessagesResponseList(
    var conversa: List<ChatMessagesResponse>
)
