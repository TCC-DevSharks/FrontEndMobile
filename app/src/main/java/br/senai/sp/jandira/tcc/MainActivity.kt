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
import br.senai.sp.jandira.tcc.gui.MobileGestation.RegistrationFlow.Calendar.CalendarScreen
import br.senai.sp.jandira.tcc.gui.MobileGestation.ConsultationFlow.Completed_Registration.Completed_Registration
import br.senai.sp.jandira.tcc.gui.MobileGestation.ConsultationFlow.DescriptionClinic.ConsultationDescriptionClinicScreen
import br.senai.sp.jandira.tcc.gui.MobileGestation.ExercisesFlow.DescriptionExercices.DescriptionExercises
import br.senai.sp.jandira.tcc.gui.MobileGestation.ChatFlow.Contacts.ContatosScreen
import br.senai.sp.jandira.tcc.gui.MobileGestation.ChatFlow.Messages.MessagesGui

import br.senai.sp.jandira.tcc.gui.MobileGestation.FoodFlow.CheckFood.CheckFoodScreen
import br.senai.sp.jandira.tcc.gui.MobileGestation.LoginFlow.ForgotPassword.ForgotPasswordScreen
import br.senai.sp.jandira.tcc.gui.MobileGestation.RegistrationFlow.GestationWeek.GestationWeekScreen
import br.senai.sp.jandira.tcc.ui.theme.TCCTheme
import br.senai.sp.jandira.tcc.gui.MobileGestation.Home.CadastroScren
import br.senai.sp.jandira.tcc.gui.MobileGestation.LoginFlow.Login.LoginScreen
import br.senai.sp.jandira.tcc.gui.MobileGestation.RegistrationFlow.Register.RegisterScreen
import br.senai.sp.jandira.tcc.gui.MobileGestation.RegistrationFlow.RegisterPassword.RegisterPasswordScreen
import br.senai.sp.jandira.tcc.gui.MobileGestation.StartScreen.LoadingScreen
import br.senai.sp.jandira.tcc.gui.MobileGestation.HomeUser.HomeUserScreen
import br.senai.sp.jandira.tcc.gui.MobileGestation.PreparationsFlow.MaternityBag.MaternityBagScreen
import br.senai.sp.jandira.tcc.gui.MobileDoctor.DoctorHome.DoctorHome
import br.senai.sp.jandira.tcc.gui.MobileDoctor.DoctorProfile.DoctorProfile
import br.senai.sp.jandira.tcc.gui.MobileGestation.PreparationsFlow.NameSuggestion.Name_Suggestion
import br.senai.sp.jandira.tcc.gui.MobileGestation.PreparationsFlow.AddTrousseau.AddTrousseau
import br.senai.sp.jandira.tcc.gui.MobileGestation.PreparationsFlow.Trousseau.TrousseauScreen
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

        startDestination = "DoctorProfile",
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

        composable(route = "chat") { MessagesGui() }

            composable(route = "DoctorHome") { DoctorHome() }

        composable(route = "teste") { CheckFoodScreen(navController) }
        composable(route = "DescriptionExercises") { DescriptionExercises() }


        composable(route = "teste") { ContatosScreen(navController) }
        composable(route = "AddTrousseau") { AddTrousseau() }

        composable(route = "DoctorProfile") { DoctorProfile() }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TCCTheme {
        Greeting("Android")
    }
}