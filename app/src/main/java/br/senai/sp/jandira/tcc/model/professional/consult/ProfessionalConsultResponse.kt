package br.senai.sp.jandira.tcc.model.professional.consult

data class ProfessionalConsultResponse(

    var idConsulta: Int,
    var especialidade: String,
    var idGestante: Int,
    var nome: String,
    var dia: String,
    var hora: String

)
