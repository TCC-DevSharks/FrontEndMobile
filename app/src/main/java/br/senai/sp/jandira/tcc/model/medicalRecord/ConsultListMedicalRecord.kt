package br.senai.sp.jandira.tcc.model.medicalRecord

import br.senai.sp.jandira.tcc.model.medicalRecord.ConsultResponseMedicalRecord

data class ConsultListMedicalRecord(
    var pacientes: List<ConsultResponseMedicalRecord>
)
