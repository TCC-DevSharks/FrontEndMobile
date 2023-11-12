package br.senai.sp.jandira.tcc.model.food

data class FoodResponse(
    val id: Int,
    val idAlimento: Int,
    val nome: String,
    val imagem: String,
    val categoria: String,
    val idCategoria: Int
)
