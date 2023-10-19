package br.senai.sp.jandira.tcc.model.consult

data class ConsultResponsePaciente(
    var idConsulta: Int,
    var especialidade: String,
    var nome: String,
    var dia: String,
    var hora: String
)
