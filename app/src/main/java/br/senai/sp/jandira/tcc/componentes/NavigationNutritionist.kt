package br.senai.sp.jandira.tcc.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.limpeanapp.home.components.BottomNavigationItem
import br.senai.sp.jandira.tcc.R
import br.senai.sp.jandira.tcc.model.ModelPregnant
import br.senai.sp.jandira.tcc.model.professional.Professional

//data class BottomNavigation(
//    val title: String,
//    val selectedIcon: Int,
//    val modifier: Modifier,
//    val route: () -> Unit,
//)

@Composable
fun NavigationNutritionist(
    navController: NavController,
    professional: Professional,
    pregnant: ModelPregnant
) {

//    val items = listOf(
//        BottomNavigationItem(
//            title = "Dieta",
//            selectedIcon = R.drawable.utensils_cinza,
//
//            route = "dietSelect",
//            modifier = Modifier.size(24.dp)
//        ),
//        BottomNavigationItem(
//            title = "Chat",
//            selectedIcon = R.drawable.chat_cinza,
//
//            route = "DoctorHome",
//            modifier = Modifier.size(24.dp)
//        ),
//        BottomNavigationItem(
//            title = "Home",
//            selectedIcon = R.drawable.home_cinza,
//
//            route = "DoctorHome",
//            modifier = Modifier.size(24.dp)
//        ),
//        BottomNavigationItem(
//            title = "Prontuario",
//            selectedIcon = R.drawable.clipboard_doctor,
//
//            route = "medicalRecordSelect",
//            modifier = Modifier.size(24.dp)
//        ),
//        BottomNavigationItem(
//            title = "Agenda",
//            selectedIcon = R.drawable.calendar_doctor,
//
//            route = "doctorSchedule",
//            modifier = Modifier.size(24.dp)
//        ),
//
//        )
//
//    var selectedItemIndex by rememberSaveable {
//        mutableStateOf(2)
//    }
//
//    NavigationBar(
//        containerColor =Color(245,245,245),
//        contentColor = MaterialTheme.colorScheme.onBackground
//    ) {
//        items.forEachIndexed { index,item ->
//            NavigationBarItem(
//                colors = NavigationBarItemDefaults.colors(
//                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
//                    indicatorColor = Color(245,245,245),
//                    selectedTextColor = MaterialTheme.colorScheme.primary,
//                    unselectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer
//                ),
//                selected = selectedItemIndex == index,
//                onClick = {
//                    selectedItemIndex = index
//                    navController.navigate(item.route)
//                },
//                label = {
//                    Text(
//                        text = item.title,
//                        style = MaterialTheme.typography.labelSmall,
//                    )
//                },
//                icon = {
//
//                    Image(
//                        painter =
//                        painterResource(id = item.selectedIcon),
//                        contentDescription = item.title,
//                        modifier = Modifier.size(24.dp),
//                        colorFilter = if (selectedItemIndex == index) ColorFilter.tint(Color(182,182,246))
//                        else ColorFilter.tint(Color(209, 209, 214))
//                    )
//
//                }
//            )
//        }
//    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(70.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 7.7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            if (professional.especialidade == "Nutricionista") {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.clickable {
                    navController.navigate("dietSelect")

                }) {
                    Image(
                        painter = painterResource(id = R.drawable.utensils_cinza),
                        contentDescription = null,
                        modifier = Modifier.size(27.dp)
                    )
                }
            }




            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clickable {
//                        navController.navigate("register")

                }) {
                Image(
                    painter = painterResource(id = R.drawable.chat_cinza),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )
            }

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clickable {
                    navController.navigate("DoctorHome")

                }) {
                Image(
                    painter = painterResource(id = R.drawable.home_cinza),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )
            }

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clickable {
                    navController.navigate("medicalRecordSelect")

                }) {
                Image(
                    painter = painterResource(id = R.drawable.clipboard_doctor),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )
            }


            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clickable {
                    navController.navigate("doctorSchedule")

                }) {

                Image(
                    painter = painterResource(id = R.drawable.calendar_doctor),
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )

            }


        }


    }

}