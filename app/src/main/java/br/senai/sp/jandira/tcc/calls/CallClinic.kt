package br.senai.sp.jandira.tcc.calls

import android.util.Log
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.model.clinic.Clinic
import br.senai.sp.jandira.tcc.model.clinic.ClinicResponseList
import br.senai.sp.jandira.tcc.model.clinic.ClinicSpecialityResponseList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

fun GetClinicSpeciality(speciality: Int, clinic: Clinic){

    val call = RetrofitFactory().clinic().getClinicSpeciality(speciality)

    call.enqueue(object : retrofit2.Callback<ClinicSpecialityResponseList> {
        override fun onResponse(
            call: Call<ClinicSpecialityResponseList>,
            response: Response<ClinicSpecialityResponseList>

        ) {
            clinic.clinica = response.body()!!.clinicas
            Log.e("qwer", "${clinic.clinica}")
        }

        override fun onFailure(call: Call<ClinicSpecialityResponseList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}

fun obterLatitudeLongitudePorCEP(cep: String): Pair<Double, Double>? {
    val apiKey = "AIzaSyAJLO-6hLv6ao_hbBwZ4aCiu2v2HmxhxOo"
    val client = OkHttpClient()
    val url = "https://maps.googleapis.com/maps/api/geocode/json?address=$cep&key=$apiKey"

    val request = Request.Builder()
        .url(url)
        .build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) {
            // Tratar erro na chamada da API
            return null
        }

        val responseBody = response.body?.string()
        val json = JSONObject(responseBody)

        val results = json.getJSONArray("results")

        if (results.length() > 0) {
            val location = results.getJSONObject(0).getJSONObject("geometry").getJSONObject("location")
            val latitude = location.getDouble("lat")
            val longitude = location.getDouble("lng")
            return Pair(latitude, longitude)
        } else {
            // Tratar caso não haja resultados para o CEP
            return null
        }
    }
}

fun GetClinic(id: Int, clinic: Clinic, navController: NavController,){

    val call = RetrofitFactory().clinic().getClinic(id)

    call.enqueue(object : retrofit2.Callback<ClinicResponseList> {
        override fun onResponse(
            call: Call<ClinicResponseList>,
            response: Response<ClinicResponseList>

        ) {


            if (response.code() == 200){
                response.body()!!.clinica.map {
                    clinic.id = it.id
                    clinic.cnpj = it.cnpj
                    clinic.razao_social = it.razao_social
                    clinic.descricao = it.descricao
                    clinic.email = it.email
                    clinic.foto = it.foto
                    clinic.telefone = it.telefone
                    clinic.tipo_telefone = it.tipo_telefone
                    clinic.numero = it.numero
                    clinic.cep = it.cep
                }


//                navController.navigate("DescriptionClinic")

            }
        }

        override fun onFailure(call: Call<ClinicResponseList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message}"
            )
            println(t.message + t.cause)
        }
    })
}