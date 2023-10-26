package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.consult.ConsultList
import br.senai.sp.jandira.tcc.model.medicalRecord.ConsultListMedicalRecord
import br.senai.sp.jandira.tcc.model.consult.ConsultResponse
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordAllList
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordListDataConsult
import br.senai.sp.jandira.tcc.model.medicalRecord.ProntuarioBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ConsultService {

    @GET("profissional/consulta/{id}")
    fun getConsult(@Path("id") id: Int): Call<ConsultList>

    //Obter pacientes do profissional
    @GET("profissional/gestante/{id}")
    fun getConsultMedicalRecord(@Path("id") id: Int): Call<ConsultListMedicalRecord>

    @POST("consulta")
    fun insertConsult(@Body consult: ConsultResponse): Call<ResponseBody>

    //Obter consulta do paciente pelo ID
    @GET("gestante/consulta/{id}")
    fun getConsultPatient(@Path("id") id: Int): Call<MedicalRecordListDataConsult>

    //Obter todos os pontuarios que existe
    @GET("prontuario")
    fun getMedicalRecord(): Call<MedicalRecordAllList>

    //Obter pontuario pelo ID
    @GET("prontuario/{id}")
    fun getMedicalRecordId(@Path("id") id: Int): Call<MedicalRecordAllList>

    //Criar pontuario
    @POST("prontuario")
    fun insertMedicalRecord (@Body consult: ProntuarioBody): Call<ResponseBody>
}