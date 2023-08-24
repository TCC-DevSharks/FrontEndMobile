package br.senai.sp.jandira.tcc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.tcc.Calendar.CalendarScreen
import br.senai.sp.jandira.tcc.ForgotPassword.ForgotPasswordScreen
import br.senai.sp.jandira.tcc.GestationWeek.GestationWeekScreen
import br.senai.sp.jandira.tcc.ui.theme.TCCTheme
import br.senai.sp.jandira.tcc.Home.CadastroScren
import br.senai.sp.jandira.tcc.Login.LoginScreen
import br.senai.sp.jandira.tcc.Register.RegisterScreen
import br.senai.sp.jandira.tcc.RegisterPassword.RegisterPasswordScreen
import br.senai.sp.jandira.tcc.StartScreen.LoadingScreen
import br.senai.sp.jandira.tcc.componentes.Schedule
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

    AnimatedNavHost(
        navController = navController,
        startDestination = "start",
    )

        {
            composable(route = "home") { CadastroScren (navController) }
            composable(route = "start") { LoadingScreen (navController) }
            composable(route = "login") { LoginScreen (navController) }
            composable(route = "register") { RegisterScreen (navController) }
            composable(route = "register_password") { RegisterPasswordScreen (navController) }
            composable(route = "forgot_password") { ForgotPasswordScreen (navController) }
            composable(route = "week") { GestationWeekScreen (navController) }
            composable(route = "calendar") { CalendarScreen (navController) }
            composable(route = "homeUser") { Schedule (navController) }
        }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    TCCTheme {
//        Greeting("Android")
//    }
//}