package br.senai.sp.jandira.tcc
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.tcc.componentes.Navigation
import br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorHome.DoctorHome
import br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorProfile.DoctorProfile
import br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorSchedule.DoctorSchedule
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowMedicalRecord.SelectDateMedicalRecord
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowMedicalRecord.selectMedicalRecord
import br.senai.sp.jandira.tcc.gui.mobileDoctor.flowNutrition.SelectPatient
import br.senai.sp.jandira.tcc.gui.mobileDoctor.profileDataDoctor.ProfileDataDoctor
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
import br.senai.sp.jandira.tcc.gui.mobileGestation.login.LoginDoctorScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.maternalGuide.MaternalGuideScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.loginFlow.forgotPassword.ForgotPasswordEmailScreen
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
import br.senai.sp.jandira.tcc.model.clinic.Clinic
import br.senai.sp.jandira.tcc.model.exercises.ModelExercises
import br.senai.sp.jandira.tcc.model.food.ModelFood
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


@OptIn(ExperimentalAnimationApi::class)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {




    val navController = rememberAnimatedNavController()
    val viewModel = ModelRegister()
    val viewModelPregnant = ModelPregnant()
    val speciality = ModelSpeciality()
    val clinic = Clinic()
    val professional = Professional()
    val food = ModelFood()
    val modelSchedule = ModelSchedule()
    val categories = ModelCategories()
    val exercises = ModelExercises()

    AnimatedNavHost(
        navController = navController,
        startDestination = "medicalRecordSelectDate",
    )

        {
            composable(route = "home") { CadastroScren (navController) }
            composable(route = "start") { LoadingScreen (navController) }
            composable(route = "login") { LoginScreen (navController, viewModelPregnant)}
            composable(route = "register") { RegisterScreen (navController, viewModel) }
            composable(route = "register_password") { RegisterPasswordScreen (navController, viewModel) }
            composable(route = "forgot_password") { ForgotPasswordScreen (navController) }
            composable(route = "forgot_email") { ForgotPasswordEmailScreen (navController) }
            composable(route = "week") { GestationWeekScreen (navController, viewModel) }
            composable(route = "calendar") { CalendarScreen (navController, viewModel) }
            composable(route = "homeUser") { HomeUserScreen (navController, viewModelPregnant, modelSchedule) }
            composable(route = "navigation") { Navigation (navController) }
            composable(route = "bag") { MaternityBagScreen (navController, viewModelPregnant) }
            composable("trousseau/{category}") { backStackEntry ->
                val category = backStackEntry.arguments?.getString("category")
                TrousseauScreen(navController, category, viewModelPregnant)
            }
            composable("birthPlan/{category}") { backStackEntry ->
                            val category = backStackEntry.arguments?.getString("category")
                            birthPlanScreen (navController, category, viewModelPregnant)
                        }
            composable(route = "trousseauCategory") { trousseauCategorySceen  (navController, viewModelPregnant) }
            composable(route = "birthPlanCategory") { birthPlanCategoryScreen (navController, viewModelPregnant) }
            composable(route = "Completed") { Completed_Registration(navController) }
            composable(route = "speciality") { ConsultationSpecialityScreen(navController, speciality, clinic) }
            composable(route = "nameSuggestion") { Name_Suggestion (navController, viewModelPregnant) }
            composable(route = "AddTrousseau") { AddTrousseau() }
            composable(route = "profileUser") { ProfileUserScreen (navController, viewModelPregnant) }
            composable(route = "profileData") { ProfileData (navController, viewModelPregnant) }
            composable(route = "insertEndress") { AddressScreen (navController, viewModelPregnant) }
            composable(route = "consultationEndress") { ConsultationAddressFinishScreen (navController, viewModelPregnant, speciality) }
            composable(route = "ConsultClinic") { ConsultationClinicScreen (navController,clinic, viewModelPregnant) }
            composable(route = "DescriptionClinic") { ConsultationDescriptionClinicScreen (navController, clinic, professional) }
            composable(route = "ConsultDoctor") { DoctorScreen (navController,professional) }
            composable(route = "DescriptionDoctor") { DescriptionDoctorScreen (navController,professional) }
            composable(route = "ConsultFinish") { ConsultationRegisterScreen (navController,professional) }
            composable(route = "Payment") { PaymentScreen(navController,viewModelPregnant, professional, clinic) }
            composable(route = "Food") { CheckFoodScreen(navController, viewModelPregnant, food) }
            composable(route = "FoodChange") { ChangeFoodScreen(navController, food) }
            composable(route = "Schedule") { ScheduleAdd(navController, modelSchedule, viewModelPregnant) }
            composable(route = "catExercises") { StageExercises(navController,categories, exercises) }
            composable(route = "descExercises") { DescriptionExercises(navController, exercises) }
            composable(route = "Exercises") { Exercises(navController,categories) }
            composable(route = "DoctorHome") { DoctorHome (professional, navController,) }
            composable(route = "guiaMaterno") { MaternalGuideScreen (navController) }
            composable(route = "timeLine") { TimeLineScreen () }
            composable(route = "loginDoctor") { LoginDoctorScreen (navController, professional) }
            composable(route = "profileDoctor") { DoctorProfile (professional, navController) }
            composable(route = "profileDataDoctor") { ProfileDataDoctor (navController,professional) }
            composable(route = "DoctorSchedule") { DoctorSchedule () }
            composable(route = "nutritionSelect") { SelectPatient () }
            composable(route = "medicalRecordSelect") { selectMedicalRecord (professional, navController) }
            composable(route = "medicalRecordSelectDate") { SelectDateMedicalRecord () }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TCCTheme {
        Greeting("Android")
    }
}