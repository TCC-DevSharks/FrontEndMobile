package br.senai.sp.jandira.tcc.model

import java.time.OffsetDateTime

data class PregnantResponse(
    val id : Int,
    val nome: String,
    val data_nascimento: String,
    val email: String,
    val senha: String,
    val cpf: String,
    val peso: Double,
    val altura: Double,
    val data_parto: String,
    val foto: String,
    val semana_gestacao: Int,
    val telefone: String,

)
