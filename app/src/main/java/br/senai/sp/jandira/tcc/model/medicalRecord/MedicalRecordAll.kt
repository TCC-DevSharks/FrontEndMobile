package br.senai.sp.jandira.tcc.model.medicalRecord
data class MedicalRecordAll(

    var id: Int,
    var descricao: String,
    var id_consulta: Int,
    val dia: String,
    val hora: String,
    var id_profissional: Int,
    var id_gestante: Int,
    val profissional: String,
    val gestante: String,
)