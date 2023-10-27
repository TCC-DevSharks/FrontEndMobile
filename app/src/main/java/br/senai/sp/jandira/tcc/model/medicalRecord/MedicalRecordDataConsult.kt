package br.senai.sp.jandira.tcc.model.medicalRecord

data class MedicalRecordDataConsult(

    var id: Int,
    val dia: String,
    val hora: String,
    var id_profissional: Int,
    var id_gestante: Int,
    val profissional: String,
    val gestante: String,
    val clinica: String,
)
