package br.senai.sp.jandira.tcc.model.nameSuggestion

data class NameSuggestionResponse(

    val id: Int,
    val nome: String,
    val checkbox: Int,
    val sexo: String
)
