package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.consult.ConsultList
import br.senai.sp.jandira.tcc.model.medicalRecord.ConsultListMedicalRecord
import br.senai.sp.jandira.tcc.model.consult.ConsultResponse
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordListDataConsult
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
}