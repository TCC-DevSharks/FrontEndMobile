package br.senai.sp.jandira.tcc.model.google

data class DistanceMatrix(
    val destination_addresses: List<String>,
    val origin_addresses: List<String>,
    val rows: List<ElementsResponseList>
)
