package br.senai.sp.jandira.tcc.service


import br.senai.sp.jandira.tcc.model.endressPregnant.EndressPregnantList
import br.senai.sp.jandira.tcc.model.Pregnant
import br.senai.sp.jandira.tcc.model.WeightHeight
import br.senai.sp.jandira.tcc.model.getPregnant.PregnantResponseList
import br.senai.sp.jandira.tcc.model.historicPregnant.Alergy
import br.senai.sp.jandira.tcc.model.historicPregnant.Comorbidity
import br.senai.sp.jandira.tcc.model.historicPregnant.Deficiency
import br.senai.sp.jandira.tcc.model.historicPregnant.Medication
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PregnantService {
    @POST("gestante")
    fun insertPregnant(@Body pregnant: Pregnant): Call<ResponseBody>

    @GET("gestante/{id}")
    fun getPregnant(@Path("id") id: Int): Call<PregnantResponseList>

    @GET("gestante/endereco/{id}")
    fun getAndressPregnant(@Path("id") id: Int): Call<EndressPregnantList>

    @PUT("gestante/{id}")
    fun updatePregnant(@Path("id") id: Int, @Body pregnant: Pregnant): Call<Pregnant>

    @PUT("gestante/peso/{id}")
    fun updateWeightPregnant(@Path("id") id: Int, @Body weightHeight: WeightHeight): Call<WeightHeight>

    @POST("alergia")
    fun postAlergy(@Body alergy: Alergy): Call<ResponseBody>

    @POST("comorbidade")
    fun postComorbidity(@Body comorbidity: Comorbidity): Call<ResponseBody>

    @POST("deficiencia")
    fun postDeficiency(@Body deficiency: Deficiency): Call<ResponseBody>

    @POST("medicacao")
    fun postMedication(@Body medication: Medication): Call<ResponseBody>

}