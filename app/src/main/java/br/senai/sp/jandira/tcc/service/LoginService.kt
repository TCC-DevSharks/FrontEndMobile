package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.login.LoginDoctorList
import retrofit2.Call
import br.senai.sp.jandira.tcc.model.login.LoginList
import br.senai.sp.jandira.tcc.model.login.ModelLogin
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("login/gestante")
    fun insertLogin(@Body loginGestante: ModelLogin): Call<LoginList>

    @POST("login/profissional")
    fun insertLoginDoctor(@Body loginDoctor: ModelLogin): Call<LoginDoctorList>

}