package br.senai.sp.jandira.tcc.service

import br.senai.sp.jandira.tcc.model.birthPlan.BirthPlanService
import br.senai.sp.jandira.tcc.model.maternityBag.MaternityBagService
import br.senai.sp.jandira.tcc.model.nameSuggestion.NameSuggestionService
import br.senai.sp.jandira.tcc.model.troussea.TrousseauService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitFactory {
    private val URL_BASE = " http://10.0.2.2:3000/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun findLogin(): LoginService {
        return retrofitFactory.create(LoginService::class.java)
    }

    fun pregnant(): PregnantService {
        return retrofitFactory.create(PregnantService::class.java)
    }

    fun schedule(): ScheduleService {
        return retrofitFactory.create(ScheduleService::class.java)
    }

    fun getNamesService(): NameSuggestionService {
        return retrofitFactory.create(NameSuggestionService::class.java)
    }

    fun getTrousseauService(): TrousseauService {
        return retrofitFactory.create(TrousseauService::class.java)
    }

    fun getBirthPlanService(): BirthPlanService {
        return retrofitFactory.create(BirthPlanService::class.java)
    }
    fun getEspeciality(): SpecialityService {
        return retrofitFactory.create(SpecialityService::class.java)
    }

    fun clinic(): ClinicService {
        return retrofitFactory.create(ClinicService::class.java)
    }


    fun getProfessional(): ProfessionalService {
        return retrofitFactory.create(ProfessionalService::class.java)
    }

    fun insertPayment(): PaymentService{
        return  retrofitFactory.create(PaymentService::class.java)
    }

    fun insertConsult(): ConsultService{
        return  retrofitFactory.create(ConsultService::class.java)
    }
    fun findDiet(): DietService{
        return retrofitFactory.create(DietService::class.java)
    }

    fun findMeal(): MealService{
        return retrofitFactory.create(MealService::class.java)
    }

    fun findFood(): FoodService{
        return retrofitFactory.create(FoodService::class.java)
    }

    fun Categories(): CategoriesService{
        return retrofitFactory.create(CategoriesService::class.java)
    }

    fun Exercises(): ExercisesService{
        return retrofitFactory.create(ExercisesService::class.java)
    }

    fun Reset(): ResetPasswordService{
        return retrofitFactory.create(ResetPasswordService::class.java)
    }

    fun getMaternityBagService(): MaternityBagService {
        return retrofitFactory.create(MaternityBagService::class.java)
    }

    fun ChatService(): ChatService {
        return retrofitFactory.create(ChatService::class.java)
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