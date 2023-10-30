package br.senai.sp.jandira.tcc.model.birthPlan

import br.senai.sp.jandira.tcc.model.troussea.TrousseauResponse2

data class BirthPlanResponse(

    val id: Int,
    val item: String,
    val checkbox: Int,
    val categoria: String
)
