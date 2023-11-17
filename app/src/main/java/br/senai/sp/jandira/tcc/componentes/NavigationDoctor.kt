package br.senai.sp.jandira.limpeanapp.home.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.model.ModelPregnant

//Coloque aqui o nav bar
data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Int,
    val modifier: Modifier,
    val route : String
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
            title = "Médico",
            selectedIcon =  R.drawable.doctor,

            route = "speciality",
            modifier = Modifier.size(24.dp)
        ),
    )
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