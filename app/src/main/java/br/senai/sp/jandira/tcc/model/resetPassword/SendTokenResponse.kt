package br.senai.sp.jandira.tcc.model.resetPassword

data class SendTokenResponse(
    val email: String,
    val token: String,
    val novaSenha: String
)
