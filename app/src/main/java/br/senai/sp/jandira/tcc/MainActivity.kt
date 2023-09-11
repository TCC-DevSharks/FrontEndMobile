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
import br.senai.sp.jandira.tcc.gui.BirthPlan.BirthPlanScreen
import br.senai.sp.jandira.tcc.gui.Calendar.CalendarScreen
import br.senai.sp.jandira.tcc.gui.Consultation.Address.AddressScreen
import br.senai.sp.jandira.tcc.gui.Consultation.AddressFinish.ConsultationAddressFinishScreen
import br.senai.sp.jandira.tcc.gui.Consultation.Completed_Registration.Completed_Registration
import br.senai.sp.jandira.tcc.gui.Consultation.DescriptionClinic.ConsultationDescriptionClinicScreen
import br.senai.sp.jandira.tcc.gui.Favorite_Name_Suggestion.Favorite_Name_Suggestion
import br.senai.sp.jandira.tcc.gui.Consultation.Clinic.ConsultationClinicScreen
import br.senai.sp.jandira.tcc.gui.Consultation.DescriptionDoctor.ConsultationDescriptionDoctorScreen
import br.senai.sp.jandira.tcc.gui.Consultation.Doctor.ConsultationDoctorScreen
import br.senai.sp.jandira.tcc.gui.Consultation.Speciality.ConsultationSpecialityScreen
import br.senai.sp.jandira.tcc.gui.Food.CheckFood.CheckFoodScreen
import br.senai.sp.jandira.tcc.gui.ForgotPassword.ForgotPasswordScreen
import br.senai.sp.jandira.tcc.gui.GestationWeek.GestationWeekScreen
import br.senai.sp.jandira.tcc.ui.theme.TCCTheme
import br.senai.sp.jandira.tcc.gui.Home.CadastroScren
import br.senai.sp.jandira.tcc.gui.Login.LoginScreen
import br.senai.sp.jandira.tcc.gui.Register.RegisterScreen
import br.senai.sp.jandira.tcc.gui.RegisterPassword.RegisterPasswordScreen
import br.senai.sp.jandira.tcc.gui.StartScreen.LoadingScreen
import br.senai.sp.jandira.tcc.gui.HomeUser.HomeUserScreen
import br.senai.sp.jandira.tcc.gui.MaternityBag.MaternityBagScreen
import br.senai.sp.jandira.tcc.gui.Name_Suggestion.Name_Suggestion
import br.senai.sp.jandira.tcc.gui.ProfileData.ProfileData
import br.senai.sp.jandira.tcc.gui.ProfileUser.ProfileUserScreen
import br.senai.sp.jandira.tcc.gui.Trousseau.AddTrousseau.AddTrousseau
import br.senai.sp.jandira.tcc.gui.Trousseau.TrousseauScreen
import br.senai.sp.jandira.tcc.gui.scheduleAdd.ScheduleAdd
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.ModelRegister
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

    AnimatedNavHost(
        navController = navController,
        startDestination = "start",

    )

        {
            composable(route = "home") { CadastroScren (navController) }
            composable(route = "start") { LoadingScreen (navController) }
            composable(route = "login") { LoginScreen (navController, viewModelPregnant) }
            composable(route = "register") { RegisterScreen (navController, viewModel)}
            composable(route = "register_password") { RegisterPasswordScreen (navController, viewModel) }
            composable(route = "forgot_password") { ForgotPasswordScreen (navController) }
            composable(route = "week") { GestationWeekScreen (navController, viewModel) }
            composable(route = "calendar") { CalendarScreen (navController, viewModel) }
            composable(route = "homeUser") { HomeUserScreen (navController, viewModelPregnant) }
            composable(route = "navigation") { Navigation (navController) }
            composable(route = "bag") { MaternityBagScreen (navController) }
            composable(route = "trousseau") { TrousseauScreen (navController) }
            composable(route = "Add") { Name_Suggestion () }
            composable(route = "Completed_Registration") { Completed_Registration(navController) }
            composable(route = "ConsultationDescriptionClinicScreen") { ConsultationDescriptionClinicScreen(navController) }
            composable(route = "teste") { CheckFoodScreen (navController) }
            composable(route = "AddTrousseau") { AddTrousseau() }
            composable(route = "profileUser") { ProfileUserScreen (navController, viewModelPregnant) }
            composable(route = "profileData") { ProfileData (navController, viewModelPregnant) }
            composable(route = "insertEndress") { AddressScreen (navController, viewModelPregnant) }
            composable(route = "consultationEndress") { ConsultationAddressFinishScreen (navController, viewModelPregnant) }




        }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TCCTheme {
        Greeting("Android")
    }
}