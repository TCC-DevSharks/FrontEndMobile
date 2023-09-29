package br.senai.sp.jandira.tcc.model.payment

data class Payment(
    var nome: String,
    var email: String,
    var cpf: String,
    var ddPais: String,
    var dd: String,
    val telefone: String,
    val numero: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val cidade: String,
    val estado: String,
    val pais: String,
    val cep: String,
    val tipoCartao: String,
    val mesVencimento: String,
    val anoVencimento: String,
    val cdd: String,
)
