package br.senai.sp.jandira.tcc.model.birthPlan

data class BirthPlanResponseFavorite(

    var id: Int,
    val item: String,
    val gestante: String,
    val categoria: String
)
