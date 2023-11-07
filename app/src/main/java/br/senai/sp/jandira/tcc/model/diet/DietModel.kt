package br.senai.sp.jandira.tcc.model.diet

data class DietModel(
    val idDieta: Int,
    val profissional: String,
    val gestante: String,
    val refeicao: String,
    val idRefeicao: Int,
    val horario: String
)