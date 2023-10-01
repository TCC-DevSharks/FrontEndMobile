package br.senai.sp.jandira.tcc.model.payment

data class PaymentResponse(

    val id_gestante: Int,
    val id_clinica: Int,
    val nome: String,
    val email: String,
    val cpf: String,
    val dddPais: String,
    var ddd: String,
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
    val numeroCartao: String,
    val mesVencimento: String,
    val anoVencimento: String,
    val cdd: String,
    val nomeItem:String,
    val quantidadeItem: Int,
    val valorUnitarioItem:String,
    val referenciaCobranca: String,
    val descricaoCobranca: String,

)
