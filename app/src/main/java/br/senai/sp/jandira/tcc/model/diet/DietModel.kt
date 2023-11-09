package br.senai.sp.jandira.tcc.model.diet

data class DietModel(
    val idDieta: Int,
    val profissional: String,
    val gestante: String,
    val refeicao: String,
    val idRefeicao: Int,
    val horario: String
)

data class DietModelAdd(
    val id_consulta: Int
)

data class DietModelAddMeal(
    val id_dieta: Int,
    val id_refeicao: Int,
    val horario: String
)