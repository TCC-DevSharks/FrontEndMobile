package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.Pregnant
import retrofit2.http.Body
import retrofit2.http.POST

interface PregnantService {
    @POST()
    fun insertPregnant(@Body pregnant: Pregnant): Pregnant
}