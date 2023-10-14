package br.senai.sp.jandira.tcc.model.exercises

data class ExercisesResponse(
    val id: Int,
    val nome: String,
    val descricao: String,
    val video:String,
    val categoria: String
)
