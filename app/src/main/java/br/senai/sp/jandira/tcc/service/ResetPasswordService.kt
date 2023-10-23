package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.resetPassword.SendEmailResponse
import br.senai.sp.jandira.tcc.model.resetPassword.SendTokenResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ResetPasswordService {
    @POST("redefinir-senha/gestante/solicitar")
    fun SendEmail(@Body email: SendEmailResponse): Call<ResponseBody>

    @POST("redefinir-senha/gestante/confirmar")
    fun SendToken(@Body token: SendTokenResponse): Call<ResponseBody>
}