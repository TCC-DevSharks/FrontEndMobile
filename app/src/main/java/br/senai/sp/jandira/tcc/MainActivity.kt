package br.senai.sp.jandira.tcc
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.limpeanapp.home.components.HomeTopBar
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.componentes.NavigationNutritionist
import br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorHome.DoctorHome
import br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorProfile.DoctorProfile
import br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorSchedule.DoctorSchedule
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowMedicalRecord.MedicalRecordAdd
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowMedicalRecord.SelectDateMedicalRecord
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowMedicalRecord.selectMedicalRecord
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.addDiet.AddDiet
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.changeFood.AddFoodToMeal
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.copyMeal.foodMealCopy.FoodMealCopy
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.copyMeal.mealCopy.MealCopy
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.defaultMeal.changeFoodDefault.AddFoodToDefaultMeal
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.foodCategory.FoodCategory
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.defaultMeal.foodCategoryDefault.FoodCategoryDefault
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.foodMeal.FoodMeal
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.defaultMeal.foodMealDefault.FoodMealDefault
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.defaultMeal.mealDefaults.MealDefaults
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.selectDiet.SelectDiet
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.selectPatient.SelectPatient
import br.senai.sp.jandira.tcc.gui.mobileDoctor.medicalRecordMade.MedicalRecordMadeDataScreen
import br.senai.sp.jandira.tcc.gui.mobileDoctor.medicalRecordMade.MedicalRecordMadeScreen
import br.senai.sp.jandira.tcc.gui.mobileDoctor.patientProfile.PatientProfileScreen
import br.senai.sp.jandira.tcc.gui.mobileDoctor.profileDataDoctor.ProfileDataDoctor
import br.senai.sp.jandira.tcc.gui.mobileGestation.chatFlow.contacts.ContatosScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.chatFlow.messages.MessagesScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.AppointmentCanceled.AppointmentCanceled
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.completedRegistration.Completed_Registration
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.descriptionClinic.ConsultationDescriptionClinicScreen

import br.senai.sp.jandira.tcc.gui.mobileGestation.foodFlow.checkFood.CheckFoodScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.loginFlow.forgotPassword.ForgotPasswordScreen
import br.senai.sp.jandira.tcc.ui.theme.TCCTheme
import br.senai.sp.jandira.tcc.gui.mobileGestation.home.CadastroScren
import br.senai.sp.jandira.tcc.gui.mobileGestation.loginFlow.login.LoginScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.startScreen.LoadingScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.homeUser.HomeUserScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.maternityBag.MaternityBagScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.nameSuggestion.Name_Suggestion
import br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.addTrousseau.AddTrousseau
import br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.trousseau.TrousseauScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.address.AddressScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.addressFinish.ConsultationAddressFinishScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.checkQuery.checkQuery
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.clinic.ConsultationClinicScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.descriptionDoctor.DescriptionDoctorScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.doctor.DoctorScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.payment.PaymentScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.register.ConsultationRegisterScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.speciality.ConsultationSpecialityScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.exercisesFlow.allExercises.Exercises
import br.senai.sp.jandira.tcc.gui.mobileGestation.exercisesFlow.descriptionExercices.DescriptionExercises
import br.senai.sp.jandira.tcc.gui.mobileGestation.exercisesFlow.stageExercices.StageExercises
import br.senai.sp.jandira.tcc.gui.mobileGestation.foodFlow.changeFood.ChangeFoodScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.forum.ForumScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.login.LoginDoctorScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.maternalGuide.MaternalGuideScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.loginFlow.forgotPassword.ForgotPasswordEmailScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.maps.MapFragment
import br.senai.sp.jandira.tcc.gui.mobileGestation.maps.MapsScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.birthPlan.birthPlanScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.birthPlanCategory.birthPlanCategoryScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.trousseauCategory.trousseauCategorySceen
import br.senai.sp.jandira.tcc.gui.mobileGestation.profileFlow.profileData.ProfileData
import br.senai.sp.jandira.tcc.gui.mobileGestation.profileFlow.profileUser.ProfileUserScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.registrationFlow.calendar.CalendarScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.registrationFlow.gestationWeek.GestationWeekScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.registrationFlow.register.RegisterScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.registrationFlow.registerPassword.RegisterPasswordScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.scheduleAdd.ScheduleAdd
import br.senai.sp.jandira.tcc.gui.mobileGestation.timeLine.TimeLineScreen
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.ModelRegister
import br.senai.sp.jandira.tcc.model.ModelSpeciality
import br.senai.sp.jandira.tcc.model.categories.ModelCategories
import br.senai.sp.jandira.tcc.model.chatMesssages.ChatModel
import br.senai.sp.jandira.tcc.model.clinic.Clinic
import br.senai.sp.jandira.tcc.model.clinic.ModelCep
import br.senai.sp.jandira.tcc.model.exercises.ModelExercises
import br.senai.sp.jandira.tcc.model.food.ModelFood
import br.senai.sp.jandira.tcc.model.forum.user.ModelUser
import br.senai.sp.jandira.tcc.model.medicalRecord.ModelMedicalRecord
import br.senai.sp.jandira.tcc.model.professional.Professional
import br.senai.sp.jandira.tcc.model.schedule.ModelSchedule
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TCCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")

                }
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val navController = rememberAnimatedNavController()
    val viewModel = ModelRegister()
    val pregnant = ModelPregnant()
    val speciality = ModelSpeciality()
    val clinic = Clinic()
    val professional = Professional()
    val food = ModelFood()
    val modelSchedule = ModelSchedule()
    val categories = ModelCategories()
    val exercises = ModelExercises()
    val modelMedicalRecord = ModelMedicalRecord()
    val chatModel = ChatModel()
    val forum = ModelUser()
    val modelCep = ModelCep()

    val currentRoute = remember { mutableStateOf("start") }

    navController.addOnDestinationChangedListener { _, destination, _ ->
        currentRoute.value = destination.route ?: "route1"
    }


    Scaffold(
        bottomBar = {
            when (currentRoute.value){
                "home" -> {
//                    HomeTopBar(navController = navController, pregnant)
                    }
                "start" -> {}
                "login" -> {}
                "register" -> {}
                "register_password" -> {}
                "forgot_password" -> {}
                "forgot_email" -> {}
                "week" -> {}
                "calendar" -> {}
                "loginDoctor" -> {}
                "profileDoctor" -> NavigationNutritionist(navController = navController, professional =professional, pregnant )
                "DoctorHome" -> NavigationNutritionist(navController = navController, professional =professional, pregnant )
                "profileDataDoctor" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "DoctorSchedule" -> NavigationNutritionist(navController = navController, professional =professional, pregnant )
                "dietSelect" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "medicalRecordSelect" -> NavigationNutritionist(navController = navController, professional =professional, pregnant )
                "medicalRecordAdd" -> NavigationNutritionist(navController = navController, professional =professional, pregnant )
                "nutritionSelect" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "mealSelect" -> NavigationNutritionist(navController = navController, professional =professional, pregnant )
                "medicalRecordSelectDate" -> NavigationNutritionist(navController = navController, professional =professional, pregnant )
                "foodCategory" -> NavigationNutritionist(navController = navController, professional =professional, pregnant )
                "addFood" -> NavigationNutritionist(navController = navController, professional =professional, pregnant )
                "foodMeal" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "patientProfile" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "medicalRecordMade" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "medicalRecordMadeData" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)


                "foodCategoryPatient" -> NavigationNutritionist(navController = navController, professional =professional, pregnant )
                "addFoodPatient" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "foodMealPatient" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "foodCategory" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "addFood" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "foodMeal" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "addDiet" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "mealCopy" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)
                "foodMealCopy" -> NavigationNutritionist(navController = navController, professional =professional , pregnant)

                else -> HomeTopBar(navController,pregnant)
            }
        }
    ) {
        AnimatedNavHost(
            navController = navController,
            startDestination = "start",
            Modifier.padding(it)
        ) {
            composable(route = "home") { CadastroScren (navController) }
            composable(route = "start") { LoadingScreen (navController) }
            composable(route = "login") { LoginScreen (navController, pregnant)}
            composable(route = "register") { RegisterScreen (navController, viewModel) }
            composable(route = "register_password") { RegisterPasswordScreen (navController, viewModel) }
            composable(route = "forgot_password") { ForgotPasswordScreen (navController) }
            composable(route = "forgot_email") { ForgotPasswordEmailScreen (navController) }
            composable(route = "week") { GestationWeekScreen (navController, viewModel) }
            composable(route = "calendar") { CalendarScreen (navController, viewModel) }
            composable(route = "homeUser") { HomeUserScreen (navController, pregnant, modelSchedule, forum) }
            composable(route = "navigation") { Navigation (navController, pregnant) }
            composable(route = "bag") { MaternityBagScreen (navController, pregnant) }
            composable("trousseau/{category}") { backStackEntry ->
                val category = backStackEntry.arguments?.getString("category")
                TrousseauScreen(navController, category, pregnant)
            }
            composable("birthPlan/{category}") { backStackEntry ->
                val category = backStackEntry.arguments?.getString("category")
                birthPlanScreen (navController, category, pregnant)
            }
            composable(route = "trousseauCategory") { trousseauCategorySceen  (navController, pregnant) }
            composable(route = "birthPlanCategory") { birthPlanCategoryScreen (navController, pregnant) }
            composable(route = "Completed") { Completed_Registration(navController) }
            composable(route = "speciality") { ConsultationSpecialityScreen(navController, speciality, clinic) }
            composable(route = "nameSuggestion") { Name_Suggestion (navController, pregnant) }
            composable(route = "AddTrousseau") { AddTrousseau(navController) }
            composable(route = "profileUser") { ProfileUserScreen (navController, pregnant) }
            composable(route = "profileData") { ProfileData (navController, pregnant) }
            composable(route = "insertEndress") { AddressScreen (navController, pregnant) }
            composable(route = "consultationEndress") { ConsultationAddressFinishScreen (navController, pregnant, speciality) }
            composable(route = "ConsultClinic") { ConsultationClinicScreen (navController,clinic, pregnant, modelCep) }
            composable(route = "DescriptionClinic") { ConsultationDescriptionClinicScreen (navController, clinic, professional, modelCep) }
            composable(route = "ConsultDoctor") { DoctorScreen (navController,professional,pregnant, clinic) }
            composable(route = "DescriptionDoctor") { DescriptionDoctorScreen (navController,professional) }
            composable(route = "ConsultFinish") { ConsultationRegisterScreen (navController,professional,pregnant) }
            composable(route = "Payment") { PaymentScreen(navController,pregnant, professional, clinic) }
            composable(route = "Food") { CheckFoodScreen(navController, pregnant, food) }
            composable(route = "FoodChange") { ChangeFoodScreen(navController, food, pregnant) }
            composable(route = "Schedule") { ScheduleAdd(navController, modelSchedule, pregnant) }
            composable(route = "catExercises") { StageExercises(navController,categories, exercises) }
            composable(route = "descExercises") { DescriptionExercises(navController, exercises) }
            composable(route = "Exercises") { Exercises(navController,categories, pregnant) }
            composable(route = "DoctorHome") { DoctorHome (professional, navController, modelMedicalRecord) }
            composable(route = "guiaMaterno") { MaternalGuideScreen (navController, pregnant) }
            composable(route = "timeLine") { TimeLineScreen (pregnant,navController) }
            composable(route = "loginDoctor") { LoginDoctorScreen (navController, professional) }
            composable(route = "profileDoctor") { DoctorProfile (professional, navController) }
            composable(route = "profileDataDoctor") { ProfileDataDoctor (navController,professional) }
            composable(route = "DoctorSchedule") { DoctorSchedule (professional, navController, modelMedicalRecord) }
            composable(route = "nutritionSelect") { SelectPatient (professional, navController) }
            composable(route = "medicalRecordSelect") { selectMedicalRecord (professional, navController, modelMedicalRecord) }
            composable(route = "medicalRecordSelectDate") { SelectDateMedicalRecord (navController, professional ,modelMedicalRecord) }
            composable(route = "medicalRecordAdd") { MedicalRecordAdd (navController, modelMedicalRecord) }
            composable(route = "AppointmentCanceled") { AppointmentCanceled(navController, pregnant, professional, clinic,modelMedicalRecord) }
            composable(route = "contactsChat") { ContatosScreen(navController, pregnant, chatModel) }
            composable(route = "messagesChat") { MessagesScreen(navController,pregnant, chatModel) }
            composable(route = "query") { checkQuery (navController, pregnant, modelMedicalRecord ) }
            composable(route = "dietSelect") { SelectDiet (professional, navController) }
            composable(route = "medicalRecordSelect") { selectMedicalRecord (professional, navController, modelMedicalRecord) }
            composable(route = "medicalRecordSelectDate") { SelectDateMedicalRecord (navController, professional, modelMedicalRecord) }
            composable(route = "medicalRecordAdd") { MedicalRecordAdd (navController, modelMedicalRecord) }
//            composable(route = "AppointmentCanceled") { AppointmentCanceled(navController) }
            composable(route = "contactsChat") { ContatosScreen(navController, pregnant, chatModel) }
            composable(route = "messagesChat") { MessagesScreen(navController, pregnant, chatModel) }
            composable(route = "nutritionSelect") { SelectPatient (professional, navController) }
            composable(route = "mealSelect") { MealDefaults (navController, professional, food) }
            composable(route = "patientProfile") { PatientProfileScreen (navController,modelMedicalRecord) }
            composable(route = "medicalRecordMade") { MedicalRecordMadeScreen (professional,modelMedicalRecord,modelMedicalRecord,navController) }
            composable(route = "medicalRecordMadeData") { MedicalRecordMadeDataScreen (navController, modelMedicalRecord ) }
            composable(route = "foodCategory") { FoodCategoryDefault (navController, food) }
            composable(route = "addFood") { AddFoodToDefaultMeal (navController, food) }
            composable(route = "foodMeal") { FoodMealDefault (navController, food) }
            composable(route = "addDiet") { AddDiet (navController,professional, food) }
            composable(route = "foodCategoryPatient") { FoodCategory (navController, food)}
            composable(route = "addFoodPatient") { AddFoodToMeal (navController, food)}
            composable(route = "foodMealPatient") { FoodMeal (navController, food)}
            composable(route = "mealCopy") { MealCopy (navController,professional, food) }
            composable(route = "foodMealCopy") { FoodMealCopy (navController, food) }
            composable(route = "forum") { ForumScreen (navController, pregnant) }
            composable(route = "maps") { MapsScreen () }


        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TCCTheme {
        Greeting("Android")
    }
}