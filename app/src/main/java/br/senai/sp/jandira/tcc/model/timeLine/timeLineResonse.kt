package br.senai.sp.jandira.tcc.model.timeLine

data class timeLineResonse(
    val id: Int,
    val semana: Int,
    val imagem: String,
    val comparacao: String,
    val imagemFruta: String,
    val desenvolvimento: String,
    val agenda: String,
    val meses: String
)
