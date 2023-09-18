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
import br.senai.sp.jandira.tcc.gui.mobileGestation.registrationFlow.calendar.CalendarScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.completedRegistration.Completed_Registration
import br.senai.sp.jandira.tcc.gui.mobileGestation.consultationFlow.descriptionClinic.ConsultationDescriptionClinicScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.exercisesFlow.descriptionExercices.DescriptionExercises
import br.senai.sp.jandira.tcc.gui.mobileGestation.chatFlow.contacts.ContatosScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.chatFlow.messages.MessagesScreen

import br.senai.sp.jandira.tcc.gui.mobileGestation.foodFlow.checkFood.CheckFoodScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.loginFlow.forgotPassword.ForgotPasswordScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.registrationFlow.gestationWeek.GestationWeekScreen
import br.senai.sp.jandira.tcc.ui.theme.TCCTheme
import br.senai.sp.jandira.tcc.gui.mobileGestation.home.CadastroScren
import br.senai.sp.jandira.tcc.gui.mobileGestation.loginFlow.login.LoginScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.registrationFlow.register.RegisterScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.registrationFlow.registerPassword.RegisterPasswordScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.startScreen.LoadingScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.homeUser.HomeUserScreen
import br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.maternityBag.MaternityBagScreen
import br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorHome.DoctorHome
import br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.nameSuggestion.Name_Suggestion
import br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.addTrousseau.AddTrousseau
import br.senai.sp.jandira.tcc.gui.mobileGestation.preparationsFlow.trousseau.TrousseauScreen
import br.senai.sp.jandira.tcc.gui.mobileDoctor.doctorSchedule.DoctorSchedule
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

        startDestination = "chat",
    )

    {
        composable(route = "home") { CadastroScren(navController) }
        composable(route = "start") { LoadingScreen(navController) }
        composable(route = "login") { LoginScreen(navController, viewModelPregnant) }
        composable(route = "register") { RegisterScreen(navController, viewModel) }
        composable(route = "register_password") { RegisterPasswordScreen(navController, viewModel) }
        composable(route = "forgot_password") { ForgotPasswordScreen(navController) }
        composable(route = "week") { GestationWeekScreen(navController, viewModel) }
        composable(route = "calendar") { CalendarScreen(navController, viewModel) }
        composable(route = "homeUser") { HomeUserScreen(navController, viewModelPregnant) }
        composable(route = "navigation") { Navigation(navController) }
        composable(route = "bag") { MaternityBagScreen(navController) }
        composable(route = "trousseau") { TrousseauScreen(navController) }
        composable(route = "Add") { Name_Suggestion() }
        composable(route = "Completed_Registration") { Completed_Registration(navController) }
        composable(route = "ConsultationDescriptionClinicScreen") {
            ConsultationDescriptionClinicScreen(
                navController
            )
        }

        composable(route = "AddTrousseau") { AddTrousseau() }

        composable(route = "chat") { MessagesScreen() }

            composable(route = "DoctorHome") { DoctorHome() }

        composable(route = "teste") { CheckFoodScreen(navController) }
        composable(route = "DescriptionExercises") { DescriptionExercises() }


        composable(route = "teste") { ContatosScreen(navController) }
        composable(route = "AddTrousseau") { AddTrousseau() }

        composable(route = "DoctorSchedule") { DoctorSchedule() }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TCCTheme {
        Greeting("Android")
    }
}