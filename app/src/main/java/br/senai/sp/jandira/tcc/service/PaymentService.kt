package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.payment.PaymentResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PaymentService {
    @POST("pagamento")
    fun insertPayment(@Body payment: PaymentResponse): Call<ResponseBody>

}