package br.senai.sp.jandira.tcc.model.diet

data class DietResponse(
    val idDieta: Int,
    val profissional: String,
    val gestante: String,
    val refeicao: String,
    val idRefeicao: Int,
    val horario: String
)

data class DietResponseName(
    val idDieta: Int,
    val gestante: String,
)


