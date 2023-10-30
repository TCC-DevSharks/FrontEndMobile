package br.senai.sp.jandira.tcc.model.google

data class ElementsResponseList(
    val elements: List<Element>
)


data class Element(
    val distance: Distance,
    val duration: Duration,
    val status: String
)

data class Distance(
    val text: String,
    val value: Int
)

data class Duration(
    val text: String,
    val value: Int
)
