package br.senai.sp.jandira.limpeanapp.home.components

import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.componentes.BottomNavigation
import br.senai.sp.jandira.tcc.model.ModelPregnant
import kotlinx.coroutines.delay

//Coloque aqui o nav bar
data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Int,
    val modifier: Modifier,
    val route: String,

)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    navController: NavController,
    pregnant: ModelPregnant
){
    val items = listOf(
        BottomNavigationItem(
            title = "Exercícios",
            selectedIcon = R.drawable.dumbbell_cinza,

            route = "Exercises",
            modifier = Modifier.size(24.dp)
        ),
        BottomNavigationItem(
            title = "Dieta",
            selectedIcon =  R.drawable.utensils_cinza,

            route = "Food",
            modifier = Modifier.size(24.dp)
        ),
        BottomNavigationItem(
            title = "Home",
            selectedIcon =  R.drawable.house_branco,

            route = "homeUser",
            modifier = Modifier.size(24.dp)
        ),
        BottomNavigationItem(
            title = "Chat",
            selectedIcon =  R.drawable.chat_cinza,

            route = "contactsChat",
            modifier = Modifier.size(24.dp)
        ),
        BottomNavigationItem(
            title = "Consulta",
            selectedIcon =  R.drawable.doctor,

            route = if (
                pregnant.alergia.isEmpty() ||
                pregnant.medicacao.isEmpty() ||
                pregnant.comorbidades.isEmpty() ||
                pregnant.cpf.isEmpty()
            ) {
                "insertEndress"
            } else {
                "speciality"
            }
            ,
            modifier = Modifier.size(24.dp)

        ),
    )

    val context = LocalContext.current

    // Variável para armazenar a rota atual
    var currentRoute by remember { mutableStateOf("homeUser") }

    // Registro de um callback para interceptar o botão de voltar
    val onBackPressedCallback = rememberUpdatedState(newValue = {
        navController.navigate("homeUser"){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
        }
    })

    DisposableEffect(currentRoute) {
        val currentActivity = (context as? ComponentActivity)

        val callback = object : OnBackPressedCallback(false) {
            override fun handleOnBackPressed() {
                navController.navigate("homeUser") {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                }
            }
        }

        // Adiciona o callback à atividade
        currentActivity?.onBackPressedDispatcher?.addCallback(callback)

        // Remove o callback quando o DisposableEffect for descartado
        onDispose {
            callback.remove()
        }
    }


    Log.e("aaaaaa", "${pregnant.alergia.length}")
    Log.e("mmmmmmm", "${pregnant.medicacao.length}")
    Log.e("cccccc", "${pregnant.comorbidades.length}")
    Log.e("pfpfpfpfpf", "${pregnant.cpf.length}")
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(2)
    }

    NavigationBar(
        containerColor =Color(245,245,245),
        contentColor = MaterialTheme.colorScheme.onBackground
    ) {
        items.forEachIndexed { index,item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    indicatorColor = Color(245,245,245),
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.route)
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.labelSmall,
                    )
                },
                icon = {

                        Image(
                            painter =
                                painterResource(id = item.selectedIcon),
                            contentDescription = item.title,
                            modifier = Modifier.size(24.dp),
                            colorFilter = if (selectedItemIndex == index) ColorFilter.tint(Color(182,182,246))
                            else ColorFilter.tint(Color(209, 209, 214))
                        )
                }
            )
        }
    }
}
