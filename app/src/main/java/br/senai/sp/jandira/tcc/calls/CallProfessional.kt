package br.senai.sp.jandira.tcc.calls

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import br.senai.sp.jandira.tcc.model.clinic.Clinic
import br.senai.sp.jandira.tcc.model.clinic.ClinicSpecialityResponseList
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.model.professional.ProfessionalSpecialityResponse
import br.senai.sp.jandira.tcc.model.professional.ProfessionalSpecialityResponseList
import br.senai.sp.jandira.tcc.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun GetProfessionalSpeciality(speciality: Int, professional: Professional, navController: NavController){

        val call = RetrofitFactory().getProfessional().getProfissionalSpeciality(speciality)

        call.enqueue(object : retrofit2.Callback<ProfessionalSpecialityResponseList> {
            override fun onResponse(
                call: Call<ProfessionalSpecialityResponseList>,
                response: Response<ProfessionalSpecialityResponseList>

            ) {
                professional.profissional = response.body()!!.profissionais
                navController.navigate("ConsultDoctor")
            }

            override fun onFailure(call: Call<ProfessionalSpecialityResponseList>, t: Throwable) {
                Log.i(
                    "ds2m",
                    "onFailure: ${t.message}"
                )
                println(t.message + t.cause)
            }
        })
    }

    fun GetProfessional(professional: Professional){

        var call = RetrofitFactory().getProfessional().getProfissional(professional.id)

        call.enqueue(object : Callback<ProfessionalSpecialityResponseList> {
            override fun onResponse(
                call: Call<ProfessionalSpecialityResponseList>,
                response: Response<ProfessionalSpecialityResponseList>
            ) {

                Log.i("fdfd", "${response.body()}")

                response.body()!!.profissionais.map {
                    professional.id = it.id
                    professional.nome = extrairPrimeiroNome( it.nome)
                    professional.cpf = it.cpf
                    professional.crm= it.crm
                    professional.data_nascimento = it.data_nascimento
                    professional.foto = it.foto
                    professional.descricao = it.descricao
                    professional.inicio_atendimento = it.inicio_atendimento
                    professional.fim_atendimento = it.fim_atendimento
                    professional.email = it.email
                    professional.sexo = it.sexo
                    professional.clinica = it.clinica
                    professional.telefone= it.telefone
                    professional.tipo_telefone= it.tipo_telefone
                    professional.numero= it.numero
                    professional.complemento = it.complemento
                    professional.cep= it.cep
                    professional.especialidade = it.especialidade
                    professional.id_endereco= it.idEndereco
                    professional.id_telefone = it.idTelefone
                    professional.idTipo = it.idTipo
                    professional.idSexo = it.idSexo
                    professional.idClinica= it.idClinica
                }

            }

            override fun onFailure(call: Call<ProfessionalSpecialityResponseList>, t: Throwable) {
                Log.i("Profi", "${t.message}")
            }
        })
    }