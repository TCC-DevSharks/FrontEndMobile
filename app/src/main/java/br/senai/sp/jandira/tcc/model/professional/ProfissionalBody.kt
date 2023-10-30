package br.senai.sp.jandira.tcc.model.professional

data class ProfissionalBody(
    var nome : String,
    var crm: String,
    var email: String,
    val cpf: String,
    val data_nascimento: String,
    val foto: String,
    val descricao: String,
    val inicio_atendimento: String,
    val fim_atendimento: String,
    val id_sexo: Int,
    val id_clinica: Int,
    val telefone: String,
    val tipo_telefone: Int,
    val id_telefone: Int,
    val id_endereco: Int,
    val numero: String,
    val complemento: String,
    val cep: String,
)
