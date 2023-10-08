package br.senai.sp.jandira.tcc.model.food

data class FoodResponse(
    val id: Int,
    val nome: String,
    val imagem: String,
    val peso: String,
    val categoria: String
)
