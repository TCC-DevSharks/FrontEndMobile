package br.senai.sp.jandira.tcc.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitFactory {
    private val URL_BASE = " http://10.0.2.2:3000/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLoginService(): LoginService {
        return retrofitFactory.create(LoginService::class.java)
    }

    fun insertPregnant(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun getPregnant(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun getSchedule(): ScheduleService {
        return retrofitFactory.create(ScheduleService::class.java)
    }

    fun getEndress(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun updatePregnant(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun updateWeightPregnant(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun insertAlergy(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun insertComorbidity(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun insertDeficiency(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun insertMedication(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun getAlergy(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun getComorbidity(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun getDeficiency(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun getMedication(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun getEspeciality(): EspecialityService {
        return retrofitFactory.create(EspecialityService::class.java)
    }

    fun getClinicSpeciality(): ClinicService {
        return retrofitFactory.create(ClinicService::class.java)
    }

    fun getClinic(): ClinicService {
        return retrofitFactory.create(ClinicService::class.java)
    }

    fun getProfessional(): ProfessionalService {
        return retrofitFactory.create(ProfessionalService::class.java)
    }


}

class RetrofitFactoryCep {
    private val URL_BASE = " https://viacep.com.br/ws/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCep(): ViaCepService {
        return retrofitFactory.create(ViaCepService::class.java)
    }
}

class RetrofitFactoryMaps {
    private val URL_BASE = "https://maps.googleapis.com/maps/api/distancematrix/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getDistance(): MapsService {
        return retrofitFactory.create(MapsService::class.java)
    }
}